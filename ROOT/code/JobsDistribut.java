import java.io.*;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;  

import com.dbCon.MySQLDBCon;

public class JobsDistribut extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection conn = null; 

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try
		{
			String jobsString = request.getParameter("jobs");
			String areaString = request.getParameter("area");
			
			conn = MySQLDBCon.getCon(); 
			String jobs = searchJobs(conn, jobsString, areaString); 
			
			out.println(jobs);
			conn.close();
		}
		catch(SQLException se) 
		{
			se.printStackTrace();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}

	protected String searchJobs(Connection conn, String jobsString, String areaString) throws ServletException, SQLException, JSONException
	{
		Statement stmt = null;
		stmt = conn.createStatement();
		String[] jobsArr = jobsString.split(","); 

		JSONArray jsonArray_jobs_count = new JSONArray(); //存所有职位的数据
		for (int j = 0; j < jobsArr.length; j++) 
		{	
			String job = jobsArr[j];
			String sql_sel_job = " SELECT * FROM job WHERE area=\'" + areaString + "\' AND job=\'" + job + "\'" ;

			ResultSet rs = stmt.executeQuery(sql_sel_job);			
			
			if (!rs.next()) //如果在job没有查询到任何数据
			{
				writeLog("job中没有查到" + job + "的数据,现在查下jobname表");	
				//去jobname看看有没有这个记录，没有就插入
				String sql_sel_jobname = " SELECT *  FROM jobname WHERE jobname=\'" + job + "\'";
				ResultSet rs_sql_sel_jobname = stmt.executeQuery(sql_sel_jobname);
				if (!rs_sql_sel_jobname.next())
				{
					String sql_ins_jobname = "insert into jobname set jobname=\'" + job + "\'";
					writeLog("jobname中没有查到" + job + "的数据,现在写jobname表，" + sql_ins_jobname);		
					PreparedStatement ps = conn.prepareStatement( "INSERT INTO jobname (jobname) VALUES (?)" );
					ps.setString(1, job);
					ps.executeUpdate();
				}
				
				try 
				{
					String shell_cmd = "scrapy crawl jobs -a action=updateone -a parea=" + areaString + " -a pjob=" + job ;
					writeLog(shell_cmd);
					String shell_path = "/usr/local/python/jobs";
					Process process = Runtime.getRuntime().exec( shell_cmd, null, new File(shell_path) );
					int exitValue = process.waitFor();
					if (0 != exitValue) 
					{
						writeLog("执行cmd后结果：" + exitValue);
					}
				} 
				catch (Throwable e) 
				{
					writeLog("call shell failed. " + e);
				}				
			}
			
			JSONObject jsonObj_job = new JSONObject(); //存一个职位的数据
			
			String sql = " SELECT count FROM job WHERE area=\'" + areaString + "\' AND job=\'" + job + "\' ORDER BY salarysorder " ;

			ResultSet rs_job = stmt.executeQuery(sql);			
			
			jsonObj_job.put("name", job);
			JSONArray JsonArray_count = new JSONArray();		
			while(rs_job.next())
			{							 
				JsonArray_count.put(rs_job.getInt("count"));					
			}				
			jsonObj_job.put("data", JsonArray_count);
			
			
			jsonArray_jobs_count.put(jsonObj_job);			
		} 
		writeLog("查到的所有职位jsonArray_jobs_count:" + jsonArray_jobs_count);
			
		//待遇区间
		String sql_salarys = " SELECT DISTINCT concat(salarys,'元/月') AS salarys FROM job ORDER BY salarysorder " ;

		ResultSet rs_sal = stmt.executeQuery(sql_salarys);
		JSONArray jsonArray_salarys = new JSONArray();		
		while(rs_sal.next())
		{							 
			jsonArray_salarys.put(rs_sal.getString("salarys"));					
		}				
		
		JSONObject jsonObj_jobs_all_info = new JSONObject();
		jsonObj_jobs_all_info.put("SalaryRange", jsonArray_salarys);
		jsonObj_jobs_all_info.put("Jobs", jsonArray_jobs_count);
		jsonObj_jobs_all_info.put("Area", areaString);
		
		stmt.close();
		
		return jsonObj_jobs_all_info.toString();	
	}
	
	public static void writeLog(String msg)
	{		 
		FileWriter writer;
		try
		{
			writer = new FileWriter("/home/lgx/javalog.txt");
			writer.write(msg);
			writer.flush();
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}

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

public class GetAreasList extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection conn = null; 

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try
		{
			conn = MySQLDBCon.getCon(); 
			String areas = searchAreas(conn); 
			
			out.println(areas);
			conn.close();
		}
		catch(SQLException se) 
		{
			// 处理 JDBC 错误
			se.printStackTrace();
		} 
		catch(Exception e) 
		{
			// 处理 Class.forName 错误
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

	protected String searchAreas(Connection conn) throws ServletException, SQLException, JSONException
	{
		// 执行 SQL 查询
		Statement stmt = null;
		stmt = conn.createStatement();

		String sql = " SELECT DISTINCT area FROM area WHERE status=1 " ;

		ResultSet rs = stmt.executeQuery(sql);
		JSONArray jsonArray_areas = new JSONArray();		
		while(rs.next())
		{							 
			jsonArray_areas.put(rs.getString("area"));					
		}				
		
		JSONObject jsonObj_all_info = new JSONObject();
		jsonObj_all_info.put("AreasList", jsonArray_areas);
		
		stmt.close();
		
		return jsonObj_all_info.toString();	
	}
}

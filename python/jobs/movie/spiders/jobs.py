# -*- coding: utf-8 -*-
import sys  
reload(sys)  
sys.setdefaultencoding('utf8')
import scrapy
import MySQLdb

from movie.items import MovieItem

class MeijuSpider(scrapy.Spider):
	
    name = 'jobs'
    salarys =    [
			'0-4000',
			'4001-8000',
			'8001-12000',
			'12000-16000',
			'16000-20000',
			'20001-24000',
			'24001-28000',
			'28001-32000',
			'32001-36000',
			'36001-40000'
		 ]
    
    def __init__(self, action=None, parea=None, pjob=None):
	    print action
	    print parea
	    print pjob
	    allowed_domains = ['jobstt.com']
	    url_prefix = 'http://sou.zhaopin.com/jobs/searchresult.ashx'


	    # 打开数据库连接
	    db = MySQLdb.connect(host="localhost", user="root", passwd="123456", db="job", charset="utf8")
	    # 使用cursor()方法获取操作游标 
	    cursor = db.cursor()

	    if action == "updateall":
		sql = "DELETE FROM job"	
		try:
		    cursor.execute(sql)
		    db.commit()
		except:
		    db.rollback()		
	        sql = "SELECT DISTINCT area FROM area WHERE status=1"
		cursor.execute(sql)
		rows = cursor.fetchall()
		areas = []
		for row in rows:
		    areas.append(row[0])
	        sql = "SELECT DISTINCT jobname FROM jobname"
		cursor.execute(sql)
		rows = cursor.fetchall()
		jobs = []
		for row in rows:
		    jobs.append(row[0])
	    
	    if action == "updateone":
		print 'jpdatenoe'
		areas = [parea]
		jobs = [pjob]
	    # 关闭数据库连接
	    db.close()
	    self.start_urls = []
	   
	    print areas 
	    for area in areas:
		    for job in jobs:
			    for salary in self.salarys:
				    salary_list = salary.split('-')
				    salary_key = 'sf=' + salary_list[0] + '&' + 'st=' + salary_list[1] 
				    self.start_urls.append(url_prefix + '?jl=' + area + '&kw=' + job + '&' + salary_key ) 

    def parse(self, response):
	item = MovieItem()
	res_name = response.css('input[name="KeyWord"]::attr(value)').extract()[0] 
	res_area = response.css('input[name="JobLocation"]::attr(value)').extract()[0] 
	res_salary_list = str(response.url).strip().split("sf=")[-1].split("&st=")
	res_salary = res_salary_list[0] + '-' + res_salary_list[1]
	res_count = response.xpath('//span[@class="search_yx_tj"]//em/text()').extract()[0]
	item['job'] = 	res_name 
	item['area'] = 	res_area
	item['salary'] = res_salary 
	item['count'] =	res_count 
	item['salarys'] = self.salarys 
	yield item

# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import MySQLdb

class MoviePipeline(object):
	def process_item(self, item, spider):
		db = MySQLdb.connect(host="localhost", user="root", passwd="123456", db="job", charset="utf8") 
		cursor = db.cursor()
		salarysorder = item['salarys'].index(item['salary'])
		sql = " SELECT COUNT(*) FROM job WHERE job='%s' AND area='%s' AND salarys='%s' " % (item['job'], item['area'], item['salary'])
		cursor.execute(sql)
   		results = cursor.fetchone()
		if results[0] == 0 :
			sql = " INSERT INTO job (job,area,salarys,count,createtime,salarysorder) VALUES ('%s', '%s', '%s', %s, %s, %d) " % (item['job'], item['area'], item['salary'], item['count'], 'now()', salarysorder)
			try:
				cursor.execute(sql)
				db.commit()
			except:
				db.rollback()
			db.close()

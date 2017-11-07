# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class MovieItem(scrapy.Item):
    # define the fields for your item here like:
    job = scrapy.Field()
    area = scrapy.Field()
    salary = scrapy.Field()
    count = scrapy.Field()
    salarys = scrapy.Field()

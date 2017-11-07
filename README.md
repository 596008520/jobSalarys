# 网络爬虫--岗位需求与待遇分布

## 预览图
![Screenshot](https://raw.githubusercontent.com/596008520/jobSalarys/master/preview.png)

## 项目功能：
用户输入任何想要查询的多个岗位，选择查询地区，即可知道该地区，岗位的需求数量和待遇分布情况 [项目演示地址](http://182.61.27.134:8080/view/index.html)

## 技术说明：
* 基于Bootstrap，Highcharts 构建的前端交互界面;<br>
* 基于JAVA Servlet 框架的 RESTful API  后台数据接口;<br>
* 基于python scrapy 的爬虫从网络中采集数据;<br>
* 采用Mysql数据库;<br>

## 技术细节：
* 用户提交查询岗位名称和地区，给到后台java接口，java程序查询数据库，有数据直接返回<br>
* 如果java程序从MySQL中没有查询到，就同时shell命令发起一个爬虫任务，让python程序去网络中抓取，并保存到数据库，然后java程序拿到数据后返回给用户<br>
* java程序会把用户查询的岗位名称保存到MySQL中，python爬虫定时执行，按周期去更新MySQL数据表，这样，既保证了查询的快速响应，也保证了数据的准确实时<br>

## 目录介绍：
```php
├── job.sql #数据库SQL
├── python #python scrapy 爬虫
│   └── jobs 
│       ├── movie 
│       │   ├── __init__.py 
│       │   ├── __init__.pyc 
│       │   ├── items.py #数据模型
│       │   ├── items.pyc 
│       │   ├── middlewares.py 
│       │   ├── pipelines.py #保存数据到MySQL
│       │   ├── pipelines.pyc 
│       │   ├── settings.py 
│       │   ├── settings.pyc 
│       │   └── spiders 
│       │       ├── __init__.py 
│       │       ├── __init__.pyc 
│       │       ├── jobs.py #爬取数据
│       │       └── jobs.pyc 
│       └── scrapy.cfg 
├── pythonJob #cron爬虫定时任务
├── README.md 
└── ROOT #tomcat根目录
    ├── code #java Servlet RESTful 接口源码
    │   ├── GetAreasList.java #获取地区
    │   ├── JobsDistribut.java #获取某地区多个岗位的数量和待遇分布
    │   └── MySQLDBCon.java #访问数据库的公共文件
    ├── view #视图文件
    │   ├── highcharts #图表插件
    │   ├── Bootstrap #前端视图框架
    │   ├── index.html #前端入口
    │   ├── jobCharts.js #当前页面JS
    │   └── test.html 
    └── WEB-INF #java编译后的文件和路由配置
        ├── classes 
        │   ├── com 
        │   │   └── dbCon 
        │   │       └── MySQLDBCon.class 
        │   ├── GetAreasList.class 
        │   └── JobsDistribut.class 
        └── web.xml #路由配置
```

###树
>数据结构 >>树 >>>二叉树 >>>>平衡二叉树 >>>>>满二叉树




tqq a
tqq asf-logo-wide.svg
tqq bg-button.png
tqq bg-middle.png
tqq bg-nav-item.png
tqq bg-nav.png
tqq bg-upper.png
tqq code
x   tqq GetAreasList.class
x   tqq GetAreasList.java
x   tqq JobsDistribut.class
x   tqq JobsDistribut.java
x   tqq MySQLDBCon.class
x   mqq MySQLDBCon.java
tqq favicon.ico
tqq index.jsp
tqq RELEASE-NOTES.txt
tqq tomcat.css
tqq tomcat.gif
tqq tomcat.png
tqq tomcat-power.gif
tqq tomcat.svg
tqq view
x   tqq highcharts
x   x   tqq css
x   x   x   tqq highcharts.css
x   x   x   tqq highcharts.scss
x   x   x   mqq js
x   x   x       tqq highcharts-3d.js
x   x   x       tqq highcharts-3d.src.js
x   x   x       tqq highcharts.js
x   x   x       tqq highcharts-more.js
x   x   x       tqq highcharts-more.src.js
x   x   x       tqq highcharts.src.js
x   x   x       tqq modules
x   x   x       x   tqq accessibility.js
x   x   x       x   tqq accessibility.src.js
x   x   x       x   tqq annotations.js
x   x   x       x   tqq annotations.src.js
x   x   x       x   tqq boost-canvas.js
x   x   x       x   tqq boost-canvas.src.js
x   x   x       x   tqq boost.js
x   x   x       x   tqq boost.src.js
x   x   x       x   tqq broken-axis.js
x   x   x       x   tqq broken-axis.src.js
x   x   x       x   tqq bullet.js
x   x   x       x   tqq bullet.src.js
x   x   x       x   tqq data.js
x   x   x       x   tqq data.src.js
x   x   x       x   tqq drag-panes.js
x   x   x       x   tqq drag-panes.src.js
x   x   x       x   tqq drilldown.js
x   x   x       x   tqq drilldown.src.js
x   x   x       x   tqq export-data.js
x   x   x       x   tqq export-data.src.js
x   x   x       x   tqq exporting.js
x   x   x       x   tqq exporting.src.js
x   x   x       x   tqq funnel.js
x   x   x       x   tqq funnel.src.js
x   x   x       x   tqq gantt.js
x   x   x       x   tqq gantt.src.js
x   x   x       x   tqq grid-axis.js
x   x   x       x   tqq grid-axis.src.js
x   x   x       x   tqq heatmap.js
x   x   x       x   tqq heatmap.src.js
x   x   x       x   tqq histogram-bellcurve.js
x   x   x       x   tqq histogram-bellcurve.src.js
x   x   x       x   tqq item-series.js
x   x   x       x   tqq item-series.src.js
x   x   x       x   tqq no-data-to-display.js
x   x   x       x   tqq no-data-to-display.src.js
x   x   x       x   tqq offline-exporting.js
x   x   x       x   tqq offline-exporting.src.js
x   x   x       x   tqq oldie.js
x   x   x       x   tqq oldie.src.js
x   x   x       x   tqq overlapping-datalabels.js
x   x   x       x   tqq overlapping-datalabels.src.js
x   x   x       x   tqq parallel-coordinates.js
x   x   x       x   tqq parallel-coordinates.src.js
x   x   x       x   tqq pareto.js
x   x   x       x   tqq pareto.src.js
x   x   x       x   tqq sankey.js
x   x   x       x   tqq sankey.src.js
x   x   x       x   tqq series-label.js
x   x   x       x   tqq series-label.src.js
x   x   x       x   tqq solid-gauge.js
x   x   x       x   tqq solid-gauge.src.js
x   x   x       x   tqq static-scale.js
x   x   x       x   tqq static-scale.src.js
x   x   x       x   tqq stock.js
x   x   x       x   tqq stock.src.js
x   x   x       x   tqq streamgraph.js
x   x   x       x   tqq streamgraph.src.js
x   x   x       x   tqq sunburst.js
x   x   x       x   tqq sunburst.src.js
x   x   x       x   tqq tilemap.js
x   x   x       x   tqq tilemap.src.js
x   x   x       x   tqq treemap.js
x   x   x       x   tqq treemap.src.js
x   x   x       x   tqq variable-pie.js
x   x   x       x   tqq variable-pie.src.js
x   x   x       x   tqq variwide.js
x   x   x       x   tqq variwide.src.js
x   x   x       x   tqq vector.js
x   x   x       x   tqq vector.src.js
x   x   x       x   tqq windbarb.js
x   x   x       x   tqq windbarb.src.js
x   x   x       x   tqq wordcloud.js
x   x   x       x   tqq wordcloud.src.js
x   x   x       x   tqq xrange.js
x   x   x       x   mqq xrange.src.js
x   x   x       mqq themes
x   x   x           tqq avocado.js
x   x   x           tqq avocado.src.js
x   x   x           tqq dark-blue.js
x   x   x           tqq dark-blue.src.js
x   x   x           tqq dark-green.js
x   x   x           tqq dark-green.src.js
x   x   x           tqq dark-unica.js
x   x   x           tqq dark-unica.src.js
x   x   x           tqq gray.js
x   x   x           tqq gray.src.js
x   x   x           tqq grid.js
x   x   x           tqq grid-light.js
x   x   x           tqq grid-light.src.js
x   x   x           tqq grid.src.js
x   x   x           tqq sand-signika.js
x   x   x           tqq sand-signika.src.js
x   x   x           tqq skies.js
x   x   x           tqq skies.src.js
x   x   x           tqq sunset.js
x   x   x           mqq sunset.src.js
x   x   tqq highcharts-3d.js
x   x   tqq highcharts-3d.src.js
x   x   tqq highcharts.js
x   x   tqq highcharts-more.js
x   x   tqq highcharts-more.src.js
x   x   tqq highcharts.src.js
x   x   tqq lib
x   x   x   tqq canvg.js
x   x   x   tqq canvg.src.js
x   x   x   tqq jspdf.js
x   x   x   tqq jspdf.src.js
x   x   x   tqq rgbcolor.js
x   x   x   tqq rgbcolor.src.js
x   x   x   tqq svg2pdf.js
x   x   x   mqq svg2pdf.src.js
x   x   tqq modules
x   x   x   tqq accessibility.js
x   x   x   tqq accessibility.src.js
x   x   x   tqq annotations.js
x   x   x   tqq annotations.src.js
x   x   x   tqq boost-canvas.js
x   x   x   tqq boost-canvas.src.js
x   x   x   tqq boost.js
x   x   x   tqq boost.src.js
x   x   x   tqq broken-axis.js
x   x   x   tqq broken-axis.src.js
x   x   x   tqq bullet.js
x   x   x   tqq bullet.src.js
x   x   x   tqq data.js
x   x   x   tqq data.src.js
x   x   x   tqq drag-panes.js
x   x   x   tqq drag-panes.src.js
x   x   x   tqq drilldown.js
x   x   x   tqq drilldown.src.js
x   x   x   tqq export-data.js
x   x   x   tqq export-data.src.js
x   x   x   tqq exporting.js
x   x   x   tqq exporting.src.js
x   x   x   tqq funnel.js
x   x   x   tqq funnel.src.js
x   x   x   tqq gantt.js
x   x   x   tqq gantt.src.js
x   x   x   tqq grid-axis.js
x   x   x   tqq grid-axis.src.js
x   x   x   tqq heatmap.js
x   x   x   tqq heatmap.src.js
x   x   x   tqq histogram-bellcurve.js
x   x   x   tqq histogram-bellcurve.src.js
x   x   x   tqq item-series.js
x   x   x   tqq item-series.src.js
x   x   x   tqq no-data-to-display.js
x   x   x   tqq no-data-to-display.src.js
x   x   x   tqq offline-exporting.js
x   x   x   tqq offline-exporting.src.js
x   x   x   tqq oldie.js
x   x   x   tqq oldie.src.js
x   x   x   tqq overlapping-datalabels.js
x   x   x   tqq overlapping-datalabels.src.js
x   x   x   tqq parallel-coordinates.js
x   x   x   tqq parallel-coordinates.src.js
x   x   x   tqq pareto.js
x   x   x   tqq pareto.src.js
x   x   x   tqq sankey.js
x   x   x   tqq sankey.src.js
x   x   x   tqq series-label.js
x   x   x   tqq series-label.src.js
x   x   x   tqq solid-gauge.js
x   x   x   tqq solid-gauge.src.js
x   x   x   tqq static-scale.js
x   x   x   tqq static-scale.src.js
x   x   x   tqq stock.js
x   x   x   tqq stock.src.js
x   x   x   tqq streamgraph.js
x   x   x   tqq streamgraph.src.js
x   x   x   tqq sunburst.js
x   x   x   tqq sunburst.src.js
x   x   x   tqq tilemap.js
x   x   x   tqq tilemap.src.js
x   x   x   tqq treemap.js
x   x   x   tqq treemap.src.js
x   x   x   tqq variable-pie.js
x   x   x   tqq variable-pie.src.js
x   x   x   tqq variwide.js
x   x   x   tqq variwide.src.js
x   x   x   tqq vector.js
x   x   x   tqq vector.src.js
x   x   x   tqq windbarb.js
x   x   x   tqq windbarb.src.js
x   x   x   tqq wordcloud.js
x   x   x   tqq wordcloud.src.js
x   x   x   tqq xrange.js
x   x   x   mqq xrange.src.js
x   x   tqq readme.txt
x   x   mqq themes
x   x       tqq avocado.js
x   x       tqq avocado.src.js
x   x       tqq dark-blue.js
x   x       tqq dark-blue.src.js
x   x       tqq dark-green.js
x   x       tqq dark-green.src.js
x   x       tqq dark-unica.js
x   x       tqq dark-unica.src.js
x   x       tqq gray.js
x   x       tqq gray.src.js
x   x       tqq grid.js
x   x       tqq grid-light.js
x   x       tqq grid-light.src.js
x   x       tqq grid.src.js
x   x       tqq sand-signika.js
x   x       tqq sand-signika.src.js
x   x       tqq skies.js
x   x       tqq skies.src.js
x   x       tqq sunset.js
x   x       mqq sunset.src.js
x   tqq index.html
x   tqq jobCharts.js
x   mqq test.html
mqq WEB-INF
    tqq classes
    x   tqq com
    x   x   mqq dbCon
    x   x       mqq MySQLDBCon.class
    x   tqq GetAreasList.class
    x   mqq JobsDistribut.class
    mqq web.xml

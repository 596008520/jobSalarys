# 网络爬虫--岗位需求与待遇分布


## 项目功能：
用户输入任何想要查询的多个岗位，选择查询地区，即可知道该地区，岗位的需求数量和待遇分布情况[项目演示地址](http://182.61.27.134:8080/view/index.html)

## 预览图
![Screenshot](https://raw.githubusercontent.com/596008520/jobSalarys/master/preview.png)

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

├── job.sql /*数据库*/<br>
├── python /*数据爬虫*/<br>
│   ├── jobs<br>
│   │   ├── movie<br>
│   │   │   ├── __init__.py<br>
│   │   │   ├── __init__.pyc<br>
│   │   │   ├── items.py<br>
│   │   │   ├── items.pyc<br>
│   │   │   ├── middlewares.py<br>
│   │   │   ├── pipelines.py<br>
│   │   │   ├── pipelines.pyc<br>
│   │   │   ├── settings.py<br>
│   │   │   ├── settings.pyc<br>
│   │   │   └── spiders<br>
│   │   │       ├── __init__.py<br>
│   │   │       ├── __init__.pyc<br>
│   │   │       ├── jobs.py<br>
│   │   │       └── jobs.pyc<br>
│   │   └── scrapy.cfg<br>
│   └── jobSalarys<br>
│       ├── LICENSE<br>
│       └── README.md<br>
├── pythonJob /*启动爬虫的定时任务*/<br>
└── ROOT /*tomcat根目录*/<br>
    ├── code /*java RESTful Web源代码*/<br>
    │   ├── GetAreasList.java<br>
    │   ├── JobsDistribut.java<br>
    │   └── MySQLDBCon.java<br>
    ├── view /*视图文件*/<br>
    │   ├── highcharts /*图表插件*/<br>
    │   ├── index.html<br>
    │   ├── jobCharts.js<br>
    │   └── test.html<br>
    └── WEB-INF<br>
        ├── classes<br>
        │   ├── com<br>
        │   │   └── dbCon<br>
        │   │       └── MySQLDBCon.class<br>
        │   ├── GetAreasList.class<br>
        │   └── JobsDistribut.class<br>
        └── web.xml<br>





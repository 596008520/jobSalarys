## 网络爬虫--岗位需求与待遇分布

### 项目功能：
用户输入任何想要查询的多个岗位，选择查询地区，即可知道该地区，岗位的需求数量和待遇分布情况

### 技术说明：
基于Bootstrap，Highcharts 构建的前端交互界面;
基于JAVA Servlet 框架的 RESTful API  后台数据接口;
基于python scrapy 的爬虫从网络中采集数据;
采用Mysql数据库;


### 技术细节：


### 目录介绍：

├── job.sql /*数据库*/
├── python /*数据爬虫*/
│   ├── jobs
│   │   ├── movie
│   │   │   ├── __init__.py
│   │   │   ├── __init__.pyc
│   │   │   ├── items.py
│   │   │   ├── items.pyc
│   │   │   ├── middlewares.py
│   │   │   ├── pipelines.py
│   │   │   ├── pipelines.pyc
│   │   │   ├── settings.py
│   │   │   ├── settings.pyc
│   │   │   └── spiders
│   │   │       ├── __init__.py
│   │   │       ├── __init__.pyc
│   │   │       ├── jobs.py
│   │   │       └── jobs.pyc
│   │   └── scrapy.cfg
│   └── jobSalarys
│       ├── LICENSE
│       └── README.md
├── pythonJob /*启动爬虫的定时任务*/
└── ROOT /*tomcat根目录*/
    ├── code /*java RESTful Web源代码*/
    │   ├── GetAreasList.java
    │   ├── JobsDistribut.java
    │   └── MySQLDBCon.java
    ├── view /*视图文件*/
    │   ├── highcharts /*图表插件*/
    │   ├── index.html  
    │   ├── jobCharts.js
    │   └── test.html
    └── WEB-INF
        ├── classes
        │   ├── com
        │   │   └── dbCon
        │   │       └── MySQLDBCon.class
        │   ├── GetAreasList.class
        │   └── JobsDistribut.class
        └── web.xml





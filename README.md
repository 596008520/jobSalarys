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

├── job.sql `数据库SQL`<br>
├── python `python scrapy 爬虫`<br>
│   └── jobs <br>
│       ├── movie <br>
│       │   ├── __init__.py <br>
│       │   ├── __init__.pyc <br>
│       │   ├── items.py `数据模型`<br>
│       │   ├── items.pyc <br>
│       │   ├── middlewares.py <br>
│       │   ├── pipelines.py `保存数据到MySQL`<br>
│       │   ├── pipelines.pyc <br>
│       │   ├── settings.py <br>
│       │   ├── settings.pyc <br>
│       │   └── spiders <br>
│       │       ├── __init__.py <br>
│       │       ├── __init__.pyc <br>
│       │       ├── jobs.py `爬取数据`<br>
│       │       └── jobs.pyc <br>
│       └── scrapy.cfg <br>
├── pythonJob `cron爬虫定时任务`<br>
├── README.md <br>
└── ROOT `tomcat根目录`<br>
    ├── code `java Servlet RESTful 接口源码`<br>
    │   ├── GetAreasList.java `获取地区`<br>
    │   ├── JobsDistribut.java `获取某地区多个岗位的数量和待遇分布`<br>
    │   └── MySQLDBCon.java `访问数据库的公共文件`<br>
    ├── view `视图文件`<br>
    │   ├── highcharts `图表插件`<br>
    │   ├── Bootstrap `前端视图框架`<br>
    │   ├── index.html `前端入口`<br>
    │   ├── jobCharts.js `当前页面JS`<br>
    │   └── test.html <br>
    └── WEB-INF `java编译后的文件和路由配置`<br>
        ├── classes <br>
        │   ├── com <br>
        │   │   └── dbCon <br>
        │   │       └── MySQLDBCon.class <br>
        │   ├── GetAreasList.class <br>
        │   └── JobsDistribut.class <br>
        └── web.xml `路由配置`<br>

```


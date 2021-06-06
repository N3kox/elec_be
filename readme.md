## elec_proj be

### TODO List:
- [x] CURD接口
- [x] 反射 - Neo4j Node Update
- [x] Query Neo 4j by Example
- [x] 术语解析接口
- [x] Runtime Process 调用 Python 接口
- [x] csv结构化数据上传

### 1. 部署
- IDEA导入源码，maven自动安装依赖
- 配置config/Static.java
```
baseDir : 与static.py下dir配置相同
anacondaPython : 本机虚拟运行环境下Python的Bash文件位置
pythonRuntimeProcessLocation : Python脚本根目录位置
```
- 配置resources/application.properties
```
spring.neo4j.uri : 填写neo4j的bolt或http地址
spring.neo4j.authentication.username : 填写neo4j登录用户名
spring.neo4j.authentication.password : 填写neo4j登录密码
```
- build启动, Tomcat默认端口8080

### 2.运行
- 配合Python脚本与Vue前端共同使用
- [elec_py](https://github.com/N3kox/elec_py)
- [elec_fe](https://github.com/N3kox/elec_fe)

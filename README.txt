1.Download zip file from git.
https://github.com/Sachin2929/ICF-CRUD-DEMO

2.Run sql script in MySql workbench which i have attached in mail employee.sql.example 

3.After downloading maven project from git, expand it and please navigate to src/main/resources/application.properties file. Here u need to give MySql server port number in url as
mine port number for sql is 3306, and also please given MySql username and password.

4.In POM.xml please check java version, I have given java version as 1.8, Please change java version according youbjdk version.

5.Once you run project for first time log file will be generated automatically under Project class path i.e project-folder/logs/app.log. 
I have attached sample log file in mail. Please check it.

Log file format: Date, PathDirectory, Method, Browser Details.

How to run project.
6. To run project expand project folder, navigate to src/main/java and expand it, expand  com.luv2code.springboot.thymeleafdemo package inside it you will find ThymeleafdemoApplication.java run this project as java application or trigger ctrl+f10 to run application. After running the java code(i.e ThymeleafdemoApplication.java) enter url in browser http://localhost:portnumber(eg:http://localhost:8080) portnumber will be apache tomcat server port number. 

Note:Please add tomcat apache application to eclipse to run project in server.

Please react out to me for any issues.





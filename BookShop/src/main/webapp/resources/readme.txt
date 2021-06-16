源代码配置：mysql5.7端口号3306,用户root,密码yxf1204mr1010;驱动包mysql-connector-java-5.1.18.jar
		  tomcat8.5端口号8087
		  jdk1.8.0_261.jdk
		  Eclipce javaEE 4.19.0
		  
		  
		  
需修改配置的地方：1.BookShop/src/main/java/config.properties    api.url
			   2.BookShop/src/main/java/generatorConfig.xml  修改<jdbcConnection/>属性值
			   3.BookShop/src/main/java/jdbc.properties	   	 database.username;database.password
			     P.S. 如果当前电脑为mysql8.0+请更换对应的驱动包，再修改database.driverClassName以及database.url
			     e.g. 
						database.url=jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC
						database.username=root
						database.password=123456
						database.driverClassName=com.mysql.cj.jdbc.Driver
			   
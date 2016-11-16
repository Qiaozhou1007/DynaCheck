package project.dc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//创建一个用于数据库链接的工具类，方便后面的数据库查询操作
public class DBUtil {
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String URLS="jdbc:mysql://localhost:3306/CheckSystem";
	private static String URLB="jdbc:mysql://localhost:3306/CheckSystem";
	private static String USER="root";
	private static String PASSWORD="123456";
	private static Connection connection = null;
	
	//应用于巡检系统的数据库链接
	public static Connection getConnectionS(){
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URLS,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//应用于巡检业务的数据库链接
	public static Connection getConnectionB(){
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URLB,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}

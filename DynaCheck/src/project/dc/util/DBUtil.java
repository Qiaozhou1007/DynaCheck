package project.dc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//创建一个用于数据库链接的工具类，方便后面的数据库查询操作
public class DBUtil {
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String URLS="jdbc:mysql://localhost:3306/CheckSystem";
	private static String USER="root";
	private static String PASSWORD="123456";
	private static Connection connection = null;
	
	//应用于巡检操作的数据库连接工具类
	public static Connection getConnection(){
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
}

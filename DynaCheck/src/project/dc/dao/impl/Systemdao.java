package project.dc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.dc.dao.SystemdaoIn;
import project.dc.system.bean.AppSource;
import project.dc.system.bean.DataSource;
import project.dc.util.DBUtil;

public class Systemdao implements SystemdaoIn{
	
	List<AppSource> appSourceList = new ArrayList<>();
	List<DataSource> dataSourcesList = new ArrayList<>();
	private static String sql="select * from appSource";
	private static String sql2="select * from dataSource";
	Connection connection = DBUtil.getConnectionS();
	
	@Override
	public List<AppSource> getAppSource() {
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				AppSource appSource = new AppSource();
				appSource.setCpuname(rs.getString("columnname"));
				System.out.println("dao层测试"+appSource.getCpuname());
				appSourceList.add(appSource);
			}
			for(AppSource as: appSourceList){
				//System.out.println(as.getCpuname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appSourceList;//明天查询返回类型对值有无影响
	}

	@Override
	public List<DataSource> getDataSource() {
		try {
			PreparedStatement pst = connection.prepareStatement(sql2);
			ResultSet rs= pst.executeQuery();
			while(rs.next()){
				DataSource dataSource = new DataSource();
				dataSource.setColumnname(rs.getString("columnname"));
				dataSourcesList.add(dataSource);
				System.out.println("daoceshi"+ dataSource.getColumnname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSourcesList;
	}
}

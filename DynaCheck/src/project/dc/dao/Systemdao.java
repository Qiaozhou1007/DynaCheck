package project.dc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import project.dc.dao.interfa.SystemdaoIn;
import project.dc.system.bean.AppSource;
import project.dc.util.DBUtil;

public class Systemdao implements SystemdaoIn{
	
	List<AppSource> appSourceList = new ArrayList<>();
	private static String sql="select * from appSource";
	
	@Override
	public List<AppSource> getAppSource(AppSource appSource) {
		Connection connection = DBUtil.getConnectionS();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				appSource.setCpuname(rs.getString("cpuname"));
				appSource.setCpuvalue(rs.getString("cpuvalue"));
				appSource.setMemoryvalue(rs.getString("memoryvalue"));
				appSource.setDiskiovalue(rs.getString("diskiovalue"));
				appSource.setStoragevalue(rs.getString("storagevalue"));
				appSource.setMessagevalue(rs.getString("messagevalue"));
				//System.out.println(appSource.getCpuname());
				appSourceList.add(appSource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appSourceList;//明天查询返回类型对值有无影响
	}

	@Override
	public List<project.dc.system.bean.DataSource> getDataSource(project.dc.system.bean.DataSource dataSource) {
		// TODO Auto-generated method stub
		return null;
	}
}

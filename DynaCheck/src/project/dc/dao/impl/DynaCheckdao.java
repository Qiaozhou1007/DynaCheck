package project.dc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.dc.dao.DynaCheckdaoIn;
import project.dc.system.bean.DynaCheckBean;
import project.dc.util.DBUtil;

public class DynaCheckdao implements DynaCheckdaoIn{
	
	private static String sql="select * from aibatch.dynamic_Check where CHECK_LIST=? and CHECK_LIST_DTL=? and BUSINESS_LIST=?";
	List<DynaCheckBean> beanList = new ArrayList<>();
	Connection connection = DBUtil.getConnection();
	
	@Override
	public List<DynaCheckBean> getNames(String bizName,String pageName,String tableName) {
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, bizName);
			pst.setString(2, pageName);
			pst.setString(3, tableName);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setId(rs.getInt("id"));
				dynaCheckBean.setColumnName(rs.getString("SCENE_LIST"));
				dynaCheckBean.setDcName(rs.getString("CHECK_LIST"));
				dynaCheckBean.setBizName(rs.getString("CHECK_LIST_DTL"));
				dynaCheckBean.setTableName(rs.getString("BUSINESS_LIST"));
				beanList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beanList;
	}
}

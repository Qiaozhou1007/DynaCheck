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
import project.dc.util.SqlHelper;

public class DynaCheckdao implements DynaCheckdaoIn{
	
	private static String sql ="select * from appsource";
	private static String sql1="";//system appsource
	private static String sql2="";//system datasource
	private static String sql3="";//biz property
	private static String sql4="";//biz amount
	private static String sql5="";//biz work
	List<DynaCheckBean> dynaCheckList = new ArrayList<>();
	Connection connection = DBUtil.getConnection();
	SqlHelper sqlhelper = new SqlHelper();
	
	@Override
	public List<DynaCheckBean> getDynaCheckBean() {
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setCpuname(rs.getString("columnname"));
				//dynaCheckBean.setId(rs1.getString("id"));
				//dynaCheckBean.setSystem_app(rs.getString("system_app"));
				//dynaCheckBean.setSystem_data(rs.getString("system_data"));
				//dynaCheckBean.setBiz_property(rs.getString("biz_property"));
				//dynaCheckBean.setBiz_amount(rs.getString("biz_amount"));
				//dynaCheckBean.setBiz_work(rs.getString("biz_work"));
				//System.out.println("dao层测试"+dynaCheckBean.getCpuname());
				dynaCheckList.add(dynaCheckBean);
			}
			//sys app
			PreparedStatement pst1 = connection.prepareStatement(sql1);
			ResultSet rs1 = pst1.executeQuery();
			while(rs1.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setSaid(rs1.getString(""));//sys app id
				dynaCheckBean.setSystem_app(rs1.getString(""));//sys app name
				dynaCheckList.add(dynaCheckBean);
			}
			//sys data
			PreparedStatement pst2 = connection.prepareStatement(sql1);
			ResultSet rs2 = pst2.executeQuery();
			while(rs2.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setSdid(rs2.getString(""));
				dynaCheckBean.setSystem_data(rs2.getString(""));
				dynaCheckList.add(dynaCheckBean);
			}
			//biz property
			PreparedStatement pst3 = connection.prepareStatement(sql1);
			ResultSet rs3 = pst3.executeQuery();
			while(rs3.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBpid(rs3.getString(""));
				dynaCheckBean.setBiz_property(rs3.getString(""));
				dynaCheckList.add(dynaCheckBean);
			}
			//biz amount
			PreparedStatement pst4 = connection.prepareStatement(sql1);
			ResultSet rs4 = pst4.executeQuery();
			while(rs4.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBaid(rs4.getString(""));
				dynaCheckBean.setBiz_amount(rs4.getString(""));
				dynaCheckList.add(dynaCheckBean);
			}
			//biz work
			PreparedStatement pst5 = connection.prepareStatement(sql1);
			ResultSet rs5 = pst5.executeQuery();
			while(rs5.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBwid(rs5.getString(""));
				dynaCheckBean.setBiz_work(rs5.getString(""));
				dynaCheckList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dynaCheckList;
	}
}

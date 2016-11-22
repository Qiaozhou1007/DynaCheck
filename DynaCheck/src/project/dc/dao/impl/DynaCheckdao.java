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
	private static String sql1="select * from dc where dctype='system' and tabletype='appsource';";//system appsource
	private static String sql2="select * from dc where dctype='system' and tabletype='datasource';";//system datasource
	private static String sql3="select * from dc where dctype='biz' and tabletype='property';";//biz property
	private static String sql4="select * from dc where dctype='biz' and tabletype='amount';";//biz amount
	private static String sql5="select * from dc where dctype='biz' and tabletype='work';";//biz work
	List<DynaCheckBean> saList = new ArrayList<>();
	List<DynaCheckBean> sdList = new ArrayList<>();
	List<DynaCheckBean> bpList = new ArrayList<>();
	List<DynaCheckBean> baList = new ArrayList<>();
	List<DynaCheckBean> bwList = new ArrayList<>();
	Connection connection = DBUtil.getConnection();
	SqlHelper sqlhelper = new SqlHelper();
	
	@Override
	public List<DynaCheckBean> getSystemAppsource() {
		try {
			//sys appsource
			PreparedStatement pst1 = connection.prepareStatement(sql1);
			ResultSet rs1 = pst1.executeQuery();
			while(rs1.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setSaid(rs1.getString("id"));//sys app id
				dynaCheckBean.setSystem_app(rs1.getString("columnname"));//sys app name
				saList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saList;
	}

	@Override
	public List<DynaCheckBean> getSystemDatasource() {
		//sys data
		try {
			PreparedStatement pst2 = connection.prepareStatement(sql2);
			ResultSet rs2 = pst2.executeQuery();
			while(rs2.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setSdid(rs2.getString("id"));
				dynaCheckBean.setSystem_data(rs2.getString("columnname"));
				sdList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdList;
		
	}

	@Override
	public List<DynaCheckBean> getBizProperty() {
		//biz property
		try {
			PreparedStatement pst3 = connection.prepareStatement(sql3);
			ResultSet rs3 = pst3.executeQuery();
			while(rs3.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBpid(rs3.getString("id"));
				dynaCheckBean.setBiz_property(rs3.getString("columnname"));
				bpList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bpList;
		
	}

	@Override
	public List<DynaCheckBean> getBizAmount() {
		//biz amount
		try {
			PreparedStatement pst4 = connection.prepareStatement(sql4);
			ResultSet rs4 = pst4.executeQuery();
			while(rs4.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBaid(rs4.getString("id"));
				dynaCheckBean.setBiz_amount(rs4.getString("columnname"));
				baList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return baList;
		
	}

	@Override
	public List<DynaCheckBean> getBizWork() {
		//biz work
		try {
			PreparedStatement pst5 = connection.prepareStatement(sql5);
			ResultSet rs5 = pst5.executeQuery();
			while(rs5.next()){
				DynaCheckBean dynaCheckBean= new DynaCheckBean();
				dynaCheckBean.setBwid(rs5.getString("id"));
				dynaCheckBean.setBiz_work(rs5.getString("columnname"));
				bwList.add(dynaCheckBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bwList;
		
	}
}

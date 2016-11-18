package project.dc.service;

import java.util.ArrayList;
import java.util.List;

import project.dc.dao.impl.Systemdao;
import project.dc.system.bean.AppSource;
import project.dc.system.bean.DataSource;

public class SystemService {
	Systemdao systemdao = new Systemdao();
	public List<AppSource> getAppData(){
		List<AppSource> appData = new ArrayList<>();
		appData=systemdao.getAppSource();
		for(AppSource so : appData){
			System.out.println("测试值是否到达service层"+so.getCpuname());
		}
		return appData;
	}
	
	public List<DataSource> getDataData(){
		List<DataSource> dataData = new ArrayList<>();
		dataData=systemdao.getDataSource();
		return dataData;
	}
}

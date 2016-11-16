package project.dc.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import project.dc.dao.Systemdao;
import project.dc.system.bean.AppSource;

public class SystemService {
	
	public List<AppSource> getAppData(Systemdao systemdao){
		AppSource appSource = new AppSource();
		List<AppSource> appData = new ArrayList<>();
		appData=systemdao.getAppSource(appSource);
		for(AppSource so : appData){
			System.out.println(so.getCpuname());
		}
		return appData;
		
	}
	
	public String getDataData(){
		return null;
	}
}

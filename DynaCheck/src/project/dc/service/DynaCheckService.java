package project.dc.service;

import java.util.ArrayList;
import java.util.List;

import project.dc.dao.impl.DynaCheckdao;
import project.dc.system.bean.DynaCheckBean;

public class DynaCheckService {
	/*DynaCheckdao dynaCheckdao = new DynaCheckdao();
	//1
	public List<DynaCheckBean> getSystemApp(){
		List<DynaCheckBean> sa = new ArrayList<>();
		sa=dynaCheckdao.getSystemAppsource(null, null);
		for(DynaCheckBean so : sa){
			System.out.println("测试值是否到达service层"+so.getSaid());
		}
		return sa;
	}
	//2
	public List<DynaCheckBean> getSystemData(){
		List<DynaCheckBean> sd = new ArrayList<>();
		sd=dynaCheckdao.getSystemDatasource();
		for(DynaCheckBean so : sd){
			System.out.println("测试值是否到达service层"+so.getSdid());
		}
		return sd;
	}
	//3
	public List<DynaCheckBean> getBizProperty(){
		List<DynaCheckBean> bp = new ArrayList<>();
		bp=dynaCheckdao.getBizProperty();
		for(DynaCheckBean so : bp){
			System.out.println("测试值是否到达service层"+so.getBpid());
		}
		return bp;
	}
	//4
	public List<DynaCheckBean> getBizAmount(){
		List<DynaCheckBean> ba = new ArrayList<>();
		ba=dynaCheckdao.getBizAmount();
		for(DynaCheckBean so : ba){
			System.out.println("测试值是否到达service层"+so.getBaid());
		}
		return ba;
	}
	//5
	public List<DynaCheckBean> getBizWork(){
		List<DynaCheckBean> bw = new ArrayList<>();
		bw=dynaCheckdao.getBizWork();
		for(DynaCheckBean so : bw){
			System.out.println("测试值是否到达service层"+so.getBwid());
		}
		return bw;
	}*/
}

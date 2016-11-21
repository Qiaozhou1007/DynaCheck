package project.dc.service;

import java.util.ArrayList;
import java.util.List;

import project.dc.dao.impl.DynaCheckdao;
import project.dc.system.bean.DynaCheckBean;

public class DynaCheckService {
	DynaCheckdao dynaCheckdao = new DynaCheckdao();
	public List<DynaCheckBean> getSystemData(){
		List<DynaCheckBean> dynaList = new ArrayList<>();
		dynaList=dynaCheckdao.getDynaCheckBean();
		for(DynaCheckBean so : dynaList){
			System.out.println("测试值是否到达service层"+so.getCpuname());
		}
		return dynaList;
	}
}

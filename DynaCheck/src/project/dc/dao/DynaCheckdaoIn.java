package project.dc.dao;

import java.util.List;
import project.dc.system.bean.DynaCheckBean;

public interface DynaCheckdaoIn {
	List<DynaCheckBean> getSystemAppsource();
	List<DynaCheckBean> getSystemDatasource();
	List<DynaCheckBean> getBizProperty();
	List<DynaCheckBean> getBizAmount();
	List<DynaCheckBean> getBizWork();
}

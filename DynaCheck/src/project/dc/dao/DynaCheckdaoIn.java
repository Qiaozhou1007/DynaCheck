package project.dc.dao;

import java.util.List;
import project.dc.system.bean.DynaCheckBean;

public interface DynaCheckdaoIn {
	List<DynaCheckBean> getNames(String bizName,String pageName,String tableName);
}

package project.dc.dao;

import java.util.List;
import project.dc.system.bean.AppSource;
import project.dc.system.bean.DataSource;

public interface SystemdaoIn {
	List<AppSource> getAppSource(AppSource appSource);
	List<DataSource> getDataSource(DataSource dataSource);
}

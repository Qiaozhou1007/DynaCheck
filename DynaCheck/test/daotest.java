

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.dc.util.DBUtil;

public class daotest {
	/*	cpuvalue varchar(25),
		memoryvalue varchar(25),
		diskiovalue varchar(30),
		storagevalue varchar(25),
		messagevalue varchar(30)
	*/
	private String cpuname;
	private String cpuvalue;
	private String memoryvalue;
	private String diskiovalue;
	private String storagevalue;
	private String messagevalue;
	
	public static void main(String args[]){
		List<daotest> strList=new ArrayList<>();
		String sql="SELECT * from appsource";
		daotest dt = new daotest();
		try {
			Connection connection=DBUtil.getConnection();
			PreparedStatement pst=connection.prepareStatement(sql);
			System.out.println(pst);
			ResultSet rs =pst.executeQuery();
			while(rs.next()){
				dt.setCpuname(rs.getString("cpuname"));
				dt.setCpuvalue(rs.getString("cpuvalue"));
				dt.setMemoryvalue(rs.getString("memoryvalue"));
				dt.setDiskiovalue(rs.getString("diskiovalue"));
				dt.setStoragevalue(rs.getString("storagevalue"));
				dt.setMessagevalue(rs.getString("messagevalue"));
				strList.add(dt);
				//System.out.println(dt.getCpuname()+dt.getCpuvalue()+"------"+dt.getMemoryvalue());
			}
			for(daotest dd: strList){
				System.out.println(dd.cpuvalue+dd.diskiovalue+dd.memoryvalue);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setCpuname(String cpuname) {
		this.cpuname = cpuname;
	}
	
	private String getCpuname() {
		// TODO Auto-generated method stub
		return cpuname;
	}

	public String getCpuvalue() {
		return cpuvalue;
	}

	public void setCpuvalue(String cpuvalue) {
		this.cpuvalue = cpuvalue;
	}

	public String getMemoryvalue() {
		return memoryvalue;
	}

	public void setMemoryvalue(String memoryvalue) {
		this.memoryvalue = memoryvalue;
	}

	public String getDiskiovalue() {
		return diskiovalue;
	}

	public void setDiskiovalue(String diskiovalue) {
		this.diskiovalue = diskiovalue;
	}

	public String getStoragevalue() {
		return storagevalue;
	}

	public void setStoragevalue(String storagevalue) {
		this.storagevalue = storagevalue;
	}

	public String getMessagevalue() {
		return messagevalue;
	}

	public void setMessagevalue(String messagevalue) {
		this.messagevalue = messagevalue;
	}
}

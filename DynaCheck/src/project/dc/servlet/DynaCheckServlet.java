package project.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import project.dc.service.DynaCheckService;
import project.dc.system.bean.DynaCheckBean;
@WebServlet("/DynaCheckServlet")
public class DynaCheckServlet extends HttpServlet{
	private static String jn="";
	private static String appsourcedata="";
	private static String datasourcedata="";
	private static String property="";
	private static String amount="";
	private static String work="";
	private static List<DynaCheckBean> space = null;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DynaCheckService dynaCheckService = new DynaCheckService();
		space = dynaCheckService.getSystemData();
		//系统巡检 应用主机
		for(DynaCheckBean dcb : space){
			appsourcedata += "{"+'"'+"id"+'"'+":"+'"'+dcb.getSaid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getSystem_app()+'"'+"}"+",";
		}
		appsourcedata = appsourcedata.substring(0,appsourcedata.length()-1);
		System.out.println(appsourcedata);
		//系统巡检 数据库主机
		for(DynaCheckBean dcb : space){
			datasourcedata += "{"+'"'+"id"+'"'+":"+'"'+dcb.getSdid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getSystem_data()+'"'+"}"+",";
		}
		datasourcedata = datasourcedata.substring(0,datasourcedata.length()-1);
		System.out.println(datasourcedata);
		//业务巡检 性能
		for(DynaCheckBean dcb : space){
			property += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBpid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_property()+'"'+"}"+",";
		}
		property = property.substring(0,property.length()-1);
		System.out.println(property);
		//业务巡检 数量
		for(DynaCheckBean dcb : space){
			amount += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBaid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_amount()+'"'+"}"+",";
		}
		amount = amount.substring(0,amount.length()-1);
		System.out.println(amount);
		//业务巡检 作业
		for(DynaCheckBean dcb : space){
			work += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBwid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_work()+'"'+"}"+",";
		}
		work = work.substring(0,work.length()-1);
		System.out.println(work);
		String json= "{"+'"'+"dat"+'"'+":"+"{"+'"'+"system"+'"'+":"+
					 "{"+'"'+"appsource"+'"'+":"+"["+appsourcedata+"]"+","+
					 '"'+"datasource"+'"'+":"+"["+datasourcedata+"]"+"}"+","+
					 '"'+"biz"+'"'+":"+"{"+'"'+"property"+'"'+":"+"["+property+"]"+","+
					 '"'+"amount"+'"'+":"+"["+amount+"]"+","+
					 '"'+"work"+'"'+":"+"["+work+"]"+"}"+"}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		out.write(json);
		out.close();
		out.flush();
	}
}

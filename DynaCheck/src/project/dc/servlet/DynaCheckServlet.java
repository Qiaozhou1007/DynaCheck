package project.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

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
	private static List<DynaCheckBean> space1 = null;
	private static List<DynaCheckBean> space2 = null;
	private static List<DynaCheckBean> space3 = null;
	private static List<DynaCheckBean> space4 = null;
	private static List<DynaCheckBean> space5 = null;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DynaCheckService dynaCheckService = new DynaCheckService();
		space1 = dynaCheckService.getSystemApp();
		space2 = dynaCheckService.getSystemData();
		space3 = dynaCheckService.getBizProperty();
		space4 = dynaCheckService.getBizAmount();
		space5 = dynaCheckService.getBizWork();
		
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();

		json1.put("appsource", space1);
		json1.put("datasource", space2);
		json2.put("property", space3);
		json2.put("amount", space4);
		json2.put("work", space5);
		json.put("systemcheck", json1);
		json.put("bizcheck", json2);
		System.out.println(json);
		/*
		for(DynaCheckBean dcb : space1){
			appsourcedata += "{"+'"'+"id"+'"'+":"+'"'+dcb.getSaid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getSystem_app()+'"'+"}"+",";
		}
		appsourcedata = appsourcedata.substring(0,appsourcedata.length()-1);
		System.out.println(appsourcedata);
		//系统巡检 数据库主机
		for(DynaCheckBean dcb : space2){
			datasourcedata += "{"+'"'+"id"+'"'+":"+'"'+dcb.getSdid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getSystem_data()+'"'+"}"+",";
		}
		datasourcedata = datasourcedata.substring(0,datasourcedata.length()-1);
		System.out.println(datasourcedata);
		//业务巡检 性能
		for(DynaCheckBean dcb : space3){
			property += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBpid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_property()+'"'+"}"+",";
		}
		property = property.substring(0,property.length()-1);
		System.out.println(property);
		//业务巡检 数量
		for(DynaCheckBean dcb : space4){
			amount += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBaid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_amount()+'"'+"}"+",";
		}
		amount = amount.substring(0,amount.length()-1);
		System.out.println(amount);
		//业务巡检 作业
		for(DynaCheckBean dcb : space5){
			work += "{"+'"'+"id"+'"'+":"+'"'+dcb.getBwid()+'"'+","+'"'+"columnname"+'"'+":"+'"'+dcb.getBiz_work()+'"'+"}"+",";
		}
		work = work.substring(0,work.length()-1);
		System.out.println(work);
		String jsonn= "{"+'"'+"dat"+'"'+":"+"{"+'"'+"system"+'"'+":"+
					 "{"+'"'+"appsource"+'"'+":"+"["+appsourcedata+"]"+","+
					 '"'+"datasource"+'"'+":"+"["+datasourcedata+"]"+"}"+","+
					 '"'+"biz"+'"'+":"+"{"+'"'+"property"+'"'+":"+"["+property+"]"+","+
					 '"'+"amount"+'"'+":"+"["+amount+"]"+","+
					 '"'+"work"+'"'+":"+"["+work+"]"+"}"+"}";
		*/			 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//out.write(jsonn);
		out.print(json);
		out.close();
		out.flush();
	}
}

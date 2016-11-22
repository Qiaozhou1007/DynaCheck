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
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.close();
		out.flush();
	}
}

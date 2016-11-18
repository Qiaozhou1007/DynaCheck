package project.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import project.dc.dao.impl.Systemdao;
import project.dc.service.SystemService;
import project.dc.system.bean.AppSource;
import project.dc.system.bean.DataSource;
@WebServlet("/systemServlet")
public class SystemServlet extends HttpServlet{
	private static String jn="";
	private static String js="";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SystemService systemService = new SystemService();
		//Systemdao systemdao = new Systemdao();
		//AppSource appSource = new AppSource();
		for(AppSource ap : systemService.getAppData()){
			jn+="{"+'"'+"columnname"+'"'+":"+'"'+ap.getCpuname()+'"'+"}"+",";
		}
		jn=jn.substring(0,jn.length()-1);
		String json = "{"+'"'+"appnames"+'"'+":"+"["+jn+"]"+"}";
		//List<JSONObject> js = JSON.parseArray(json,JSONObject.class);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		out.write(json);
		
		for(DataSource dp : systemService.getDataData()){
			js+="{"+'"'+"columnname"+'"'+":"+'"'+dp.getColumnname()+'"'+"}"+",";
		}
		js=js.substring(0,js.length()-1);
		String jsonn = "{"+'"'+"datanames"+'"'+":"+"["+js+"]"+"}";
		out.write(jsonn);
		out.close();
		out.flush();
	}
}

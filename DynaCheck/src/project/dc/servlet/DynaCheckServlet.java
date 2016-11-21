package project.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DynaCheckService dynaCheckService = new DynaCheckService();
		for(DynaCheckBean dcb : dynaCheckService.getSystemData()){
			jn+="{"+'"'+"columnname"+'"'+":"+'"'+dcb.getCpuname()+'"'+"}"+",";
		}
		jn=jn.substring(0,jn.length()-1);
		String json = "{"+'"'+"appnames"+'"'+":"+"["+jn+"]"+"}";
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		out.write(json);
		out.close();
		out.flush();
	}
}

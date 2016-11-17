package project.dc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dc.dao.impl.Systemdao;
import project.dc.service.SystemService;
import project.dc.system.bean.AppSource;
@WebServlet("/systemServlet")
public class SystemServlet extends HttpServlet{
	private static String jn="";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemService systemService = new SystemService();
		Systemdao systemdao = new Systemdao();
		for(AppSource ap : systemService.getAppData(systemdao)){
			System.out.println(ap.getCpuname()+"--测试数据是否传到servlet层---"+ap.getCpuvalue());
			jn+="{"+'"'+"columnname"+'"'+":"+'"'+ap.getCpuname()+'"'+"}"+",";
		}
		jn=jn.substring(0,jn.length()-1);
		String json = "["+jn+"]";
		System.out.println(jn);
		System.out.println(json);
		//关于泛型能否传递在测试中，据说不能
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		response.getWriter().flush();
		//以上为功能测试
	}
}

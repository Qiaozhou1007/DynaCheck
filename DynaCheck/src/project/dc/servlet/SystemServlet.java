package project.dc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dc.dao.Systemdao;
import project.dc.service.SystemService;
import project.dc.system.bean.AppSource;
@WebServlet("/systemServlet")
public class SystemServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemService systemService = new SystemService();
		AppSource appSource = new AppSource();
		Systemdao systemdao = new Systemdao();
		for(AppSource ap : systemService.getAppData(systemdao)){
			System.out.println(ap.getCpuname()+"--测试数据是否穿到servlet层---"+ap.getCpuvalue());
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("hhh");
	}
}

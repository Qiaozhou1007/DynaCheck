package project.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import project.dc.dao.impl.DynaCheckdao;
import project.dc.system.bean.DynaCheckBean;
@WebServlet("/DynaCheckServlet")
public class DynaCheckServlet extends HttpServlet{

	private List<DynaCheckBean> dynaCheckList = null;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		DynaCheckdao dynaCheckdao = new DynaCheckdao();	
		String bizName = request.getParameter("checkList");
		String pageName = request.getParameter("checkListDtl");
		String tableName = request.getParameter("businessList");
		dynaCheckList  = dynaCheckdao.getNames(bizName,pageName, tableName);
		JSONObject json = new JSONObject();
		json.put("tableData", dynaCheckList);
		response.setHeader("Access-Control-Allow-Origin", "*");
		out.print(json);
		out.close();
		out.flush();
	}
}

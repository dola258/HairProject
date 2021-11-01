package hairline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.dao.DesignerDao;

@WebServlet("/dupcheckid")
public class DupCheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String did  = request.getParameter("did");
		
		DesignerDao  designerDao  = new DesignerDao();
		String result    =  designerDao.getDupCheckId(did);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out  = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

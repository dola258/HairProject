package hairline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.dao.DesignerDao;

@WebServlet("/findid")
public class FindId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String result = null;
		
		if( id.equals("true")) {
			DesignerDao designerDao = new DesignerDao();
			result = designerDao.getFindID(name, birth, email);
		} else {
			DesignerDao designerDao = new DesignerDao();
			result = designerDao.getFindPW(name, birth, email);
		}
		
	
		

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

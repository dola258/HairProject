package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.DesignerDao;
import hairline.vo.DesignerVo;

public class DesignerActionInsert implements Action {


	@Override
	public void execute(HttpServletRequest request,
							HttpServletResponse response) 
									throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String in_did = request.getParameter("did");
		String in_pw = request.getParameter("pw");
		String in_dname = request.getParameter("dname");
		String in_dtel = request.getParameter("dtel");
		String in_dbirth = request.getParameter("dbirth");
		String in_email = request.getParameter("email");
		String in_wpname = request.getParameter("wpname");
		
		System.out.println(in_did + "<<<<<<<<<<<<<");
		System.out.println(in_pw + "<<<<<<<<<<<<<");
		System.out.println(in_dname + "<<<<<<<<<<<<<");
		System.out.println(in_dtel + "<<<<<<<<<<<<<");
		System.out.println(in_dbirth + "<<<<<<<<<<<<<");
		System.out.println(in_email + "<<<<<<<<<<<<<");
		System.out.println(in_wpname + "<<<<<<<<<<<<<");
		
		DesignerDao designerdao = new DesignerDao();
		designerdao.designerInsert(in_did, in_pw, in_dname, in_dtel, in_dbirth, in_email, in_wpname);
		
	
		String path = "mem_login.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

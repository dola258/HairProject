package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hairline.base.Action;

public class DesignerActionMember implements Action {

	@Override
	public void execute(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		
		String memberid = uid;
		HttpSession session = request.getSession();
		
		if( memberid != null && !memberid.equals("") ) {
			session.setAttribute("memberid", memberid);
			
			String path = "view/mem_sel.jsp";
			
			request.getRequestDispatcher(path).forward(request, response);
			
		} else {
			session.invalidate();
			
			String path = "mem_join.jsp.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}

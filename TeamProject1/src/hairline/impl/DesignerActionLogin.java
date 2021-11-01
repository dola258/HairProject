package hairline.impl;

import java.io.IOException	;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hairline.base.Action;
import hairline.dao.DesignerDao;
import hairline.vo.DesignerVo;
import javafx.scene.control.Alert;

public class DesignerActionLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 한글처리
		
		String uid = request.getParameter("uid"); // 입력 아이디
		String upw = request.getParameter("upw"); // 입력 암호
		
		HttpSession session = request.getSession(); 
		
		DesignerDao dao = new DesignerDao();
		int ok = dao.getLoginCheck(uid, upw);
		
		if(ok == 1) {
			DesignerVo designervo = new DesignerVo();
			designervo = dao.getforsession(uid);
			session.setAttribute("designervo", designervo);
		
			
			String path = "view/mem_sel.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			
			session.invalidate();
			
			String path = "mem_login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		

	}

}

package hairline.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.base.ActionFactory;

@WebServlet("/hairline")
public class HairLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}

	private void requestFunc(HttpServletRequest request, 
					HttpServletResponse response) 
							throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String command  = request.getParameter("cmd");
		
		ActionFactory fac = new ActionFactory( );
		Action action = fac.getAction(command);
	
		action.execute(request, response);
	}

}

package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;

public class ReserveActionCalendar implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		String cname = request.getParameter("cname");
		String ctel = request.getParameter("ctel");
		String cbirth = request.getParameter("cbirth");
		
		String path = "view/rsv_cal1.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}

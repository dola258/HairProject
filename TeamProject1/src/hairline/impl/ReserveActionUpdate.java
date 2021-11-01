package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.ReserveDao;

public class ReserveActionUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String idx = request.getParameter("idx");
		String did = request.getParameter("designer");
		String rdate = request.getParameter("rdate");
		String time = request.getParameter("time");
		String hcode = request.getParameter("treat");
		String otime = request.getParameter("otime");
		
		ReserveDao reserveDao = new ReserveDao(); 
		reserveDao.getReserveUpdate(idx, did, hcode, rdate, time, otime);
		
		Action action = new ReserveActionList();
		action.execute(request, response);
		
	}

}

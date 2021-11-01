package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.ReserveDao;
import hairline.vo.ReserveVo;

public class ReserveActionInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String idx = request.getParameter("idx");
		String cname = request.getParameter("cname");
		String cbirth = request.getParameter("cbirth");
		String date = request.getParameter("bdate");
		String did = request.getParameter("designer");
		String ctel = request.getParameter("ctel");
		String time = request.getParameter("time");
		String hcode = request.getParameter("treat");
		String datetime = date + " " +  time;
		
		ReserveDao reserveDao = new ReserveDao();
		reserveDao.getReserveInsert(idx, did, ctel, hcode, datetime);
		
				
		Action action = new ReserveActionList();
		action.execute(request, response);
	}

}

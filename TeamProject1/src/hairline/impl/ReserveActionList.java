package hairline.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.ReserveDao;
import hairline.vo.ReserveVo;

public class ReserveActionList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String rdate = request.getParameter("rdate");
		String time = request.getParameter("time");
		
		 
		ReserveDao reserveDao = new ReserveDao();
		List<ReserveVo> res_list = reserveDao.getRes_List(rdate);
		System.out.println(res_list);
		
		request.setAttribute("res_list", res_list);
		
		String    path     = "view/rsv_cal2.jsp?time="+time;
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;

public class CustomerActionUpdate implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// mbaord?cmd=UPDATE 
		//    menu_id =		   
		//    idx     =		   
		//    title   =		   
		//    cont    =		   
		request.setCharacterEncoding("UTF-8");
		
		String   idx        = request.getParameter("idx"); 
		String   cname      = request.getParameter("cname"); 
		String   ctel       = request.getParameter("ctel"); 
		String   cbirth     = request.getParameter("cbirth"); 
		String   did        = request.getParameter("did"); 
		String   specifics  = request.getParameter("specifics"); 
		
		
		// 수정
		CustomerDao   customerDao = new CustomerDao();
		customerDao.customerUpdate( idx, cname, ctel, cbirth, specifics,did );
		
		// 게시판 조회로 이동		
		Action action = new CustomerActionList();
		action.execute(request, response);

	}

}







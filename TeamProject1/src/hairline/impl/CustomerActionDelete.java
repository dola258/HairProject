package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;


public class CustomerActionDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String   idx   = request.getParameter("idx");
		// 삭제
		CustomerDao   customerDao  =  new  CustomerDao();
		CustomerDao.deleteRow(idx);
		
		// 목록 이동
		Action   action   = new CustomerActionList();
		action.execute(request, response);

	}

}

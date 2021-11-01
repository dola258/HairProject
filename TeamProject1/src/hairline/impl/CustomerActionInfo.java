package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;
import hairline.vo.CustomerVo;

public class CustomerActionInfo implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String    idx       =  request.getParameter("idx");
	
		// 게시물 내용조회
		CustomerDao  customerDao  = new CustomerDao();
		CustomerVo   customerVo   = customerDao.customerInfo( idx ); 
		System.out.println("customerVo:"+customerVo);
		
		request.setAttribute("customerVo", customerVo);
		
		
		request.setAttribute("newLineChar", "\n");
		
		String   path = "/view/cinfo.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
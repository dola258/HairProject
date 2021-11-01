package hairline.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;
import hairline.vo.CustomerVo;


public class CustomerActionList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// CurtomerList - 고객 목록
		CustomerDao      customerDao  = new CustomerDao();
		List<CustomerVo> customerList = customerDao.getCustomerList(); // 조회된 현재 페이지 의 data

		
		System.out.println( "CustomerActionList customerList:" +  customerList );
		request.setAttribute("customerList", customerList);
		
		
	    		
		String    path     = "clist.jsp";
		request.getRequestDispatcher(path).forward(request, response);


	}

}

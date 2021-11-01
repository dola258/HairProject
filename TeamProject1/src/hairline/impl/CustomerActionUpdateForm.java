package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;
import hairline.vo.CustomerVo;


public class CustomerActionUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /mboard?cmd=UPDATEFORM&menu_id=MENU01&idx=5
		
		String       idx       =  request.getParameter("idx");


		// 수정할 고객 정보
		CustomerDao     customerDao  =  new CustomerDao();
		CustomerVo      customerVo   =  customerDao.customerInfo(idx);
		
		request.setAttribute("customerVo", customerVo);
		
		String  path = "/view/cupdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);


	}

}

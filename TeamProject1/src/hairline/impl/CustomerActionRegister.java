package hairline.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.CustomerDao;
import hairline.vo.CustomerVo;



public class CustomerActionRegister implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 넘어오는 정보 : POST
		// hidden : regdate
		// input  : cname, ctel, cbirth, did, specifics
		request.setCharacterEncoding("UTF-8");
		String   cname    =  request.getParameter("cname");
		String   ctel     =  request.getParameter("ctel");
		String   cbirth   =  request.getParameter("cbirth");
		String   did    =  request.getParameter("did");
		String   specifics=  request.getParameter("specifics");
		
		CustomerVo  vo       = new CustomerVo( cname, ctel, cbirth, did, specifics );
		System.out.println("vo:" + vo );
		
		// 글쓰기 수행
		CustomerDao  customerDao = new CustomerDao();
		customerDao.customerRegister( vo ); 
		
		System.out.println("hahahahah");
		
		// 게시판 조회로 이동		
		Action action = new CustomerActionList();
		action.execute(request, response);
		
	}

}

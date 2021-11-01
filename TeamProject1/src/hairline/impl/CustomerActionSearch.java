package hairline.impl;
	
import java.io.IOException;	
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.base.Action;
import hairline.dao.ReserveDao;
import hairline.vo.ReserveVo;

public class CustomerActionSearch implements Action {

	@Override
	public void execute(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String path = "rsv_list.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
		
		
	}

}

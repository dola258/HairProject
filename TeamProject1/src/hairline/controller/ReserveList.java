package hairline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.dao.ReserveDao;
import hairline.vo.ReserveVo;

@WebServlet("/reservelist")
public class ReserveList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String rdate = request.getParameter("rdate");
		
		ReserveDao reserveDao = new ReserveDao();
		List<ReserveVo> res_list = reserveDao.getRes_List(rdate);
		
		String html = "";
		
		for (ReserveVo res_list1 : res_list) { 
			html += "<tr>";
			html += "<td>" + res_list1.getDatetime() + "</td>"; 
			html += "<td>" + res_list1.getIdx() + "</td>"; 
			html += "<td>" + res_list1.getCname() + "</td>"; 
			html += "<td>" + res_list1.getCtel() + "</td>"; 
			html += "<td>" + res_list1.getHname() + "</td>";
		html += "</tr>"; }
		 
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

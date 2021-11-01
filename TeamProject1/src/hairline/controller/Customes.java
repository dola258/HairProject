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

@WebServlet("/customers")
public class Customes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String cname = request.getParameter("cname");
	
		
		ReserveDao reserveDao = new ReserveDao();
		List<ReserveVo> reservelist = reserveDao.getReserveList(cname);
		String html = "";
		for (ReserveVo reserveVo : reservelist) {
			html  += "<tr>";
			html  += "<td>" + reserveVo.getIdx() + "</td>";
			html  += "<td><a href='http://localhost:9090/TeamProject1/hairline?cmd=CAL&idx="+reserveVo.getIdx()+"&cname="+reserveVo.getCname()+"&ctel="+reserveVo.getCtel()+"&cbirth="+reserveVo.getCbirth()+"'>" + reserveVo.getCname() + "</a></td>";
			html  += "<td>" + reserveVo.getCtel() + "</td>";
			html  += "<td>" + reserveVo.getCbirth() + "</td>";
			html  += "</tr>";			
		}
		
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

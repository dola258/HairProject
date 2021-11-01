package hairline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hairline.dao.CustomerDao;
import hairline.vo.CustomerVo;

@WebServlet("/searchcustomer")
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String in_cname = request.getParameter("cname");
		
		CustomerDao      customerDao  = new CustomerDao();
		List<CustomerVo> searchcustomerlist = customerDao.getSearchCustomerList(in_cname); 
		System.out.println(searchcustomerlist);
		String html = "";
		for (CustomerVo searchcustomerlist1 : searchcustomerlist) {
			int idx = searchcustomerlist1.getIdx();
			String cname = searchcustomerlist1.getCname();
			String ctel = searchcustomerlist1.getCtel();
			String cbirth = searchcustomerlist1.getCbirth();
			String dname = searchcustomerlist1.getDname();
			String regdate = searchcustomerlist1.getRegdate();
			String hcode = searchcustomerlist1.getHcode();
			
			html  += "<tr>";
			html  += "<td>" + idx + "</td>";
			html  += "<td><a href='http://localhost:9090/TeamProject1/hairline?cmd=INFO&idx="+idx+"&cname="+cname+"&ctel="+ctel+"&cbirth="+cbirth+"&dname="+dname+"&regdate="+regdate+"&hcode="+hcode+ "'>" + cname + "</a></td>";
			html  += "<td>" + ctel + "</td>";
			html  += "<td>" + cbirth + "</td>";
			html  += "<td>" + dname + "</td>";
			html  += "<td>" + regdate + "</td>";
			html  += "<td>" + hcode + "</td>";
			html  += "<td><input type='button' id='btn_delete' value='X' onclick='deleteRow(this,'${customer.idx }' );'/></td>";
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

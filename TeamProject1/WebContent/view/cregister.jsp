<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/reservepage.css" >
<style>
	#register-table {margin: auto; width: 300px; text-align: left;}
	th, td   {padding: 10px; }
</style>
<script>
$(function() {
	$('#btn-logout').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		$.ajax({
			url : 'http://localhost:9090/TeamProject1/logout',
			data: { logout : $('#btn-logout').val()    },
			success : function(result) {
					alert(result);
					location.href = "mem_login.jsp";
			},
			error : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus)
			}
			
				
			});
});		


});
</script>
</head>
<body>
	<div id="table">
		<div class="row">
			<span class="cell" id="td1-1"><h1>&nbsp;<a href="mem_sel.jsp">HAiR LiNE</a></h1></span>
			<span class="cell" id="td1-2">
				<div id="officer">
					<span>
						<img src="../imgs/5.png"/>
					</span>
						${ designervo.dname }<br>${ designervo.tel }<br><button id="btn-logout" value="logout">로그아웃</button>
					<span>
					</span>
				</div>
			</span>
		</div>
		<div class="row">
			<span class="cell" id="td2-1">
				<div id="menus">
					<p id="wpname">${ designervo.wname }</p><br><br><br><br>
					<button class="btn"><a href="../rsv_list.jsp">예약관리</a></button><br><br><br><br>
					<button class="btn"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></button>
				</div>
			</span>
			<span class="cell" id="td2-2">
				<h1>신규등록</h1><br>
								
				<form  action="http://localhost:9090/TeamProject1/hairline?cmd=REGISTER" method="POST">

					<table id="register-table">
					<tr>
					  <td>
					   <label for="cname">고객명</label>
					   </td>
					  <td>
					   <input type="text" id="cname" name="cname">
					  </td>
					</tr>
					<tr>
					  <td>				  
					   <label for="ctel">연락처</label>
					  </td>
					  <td>
					   <input type="text" id="ctel" name="ctel">
					   </td>
					</tr>  
					<tr>  
					  <td>
					   <label for="cbirth">생년월일</label>
					  </td>
					  <td>
					   <input type="text" id="cbirth" name="cbirth">
					  </td>
					</tr>
					<tr>
					  <td>
					   <label for="did">담당자</label>
					  </td>
					  <td>
					   
					   <select name="did" id="did" >
					   
						    <option value="sky">디자이너1</option>
						    <option value="sun">디자이너2</option>
						    <option value="sea">디자이너3</option>
						    <option value="tea">디자이너4</option>
					   
				   </select><br><br>
					  </td>
					</tr>
					<tr>
					  <td>
					   <label for="specifics">특이사항</label>
					  </td>
					  <td> 
					   <input type="text" id="specifics" name="specifics">
					  </td>
					</tr>
					<tr>
					  <td colspan="2">
					  <div align="right">
					  <input type="submit" id="btn_register" style="height:32px; width:50px;" value="등록">
					  <input type="button" style="height:32px; width:50px;" value="취소" onclick="location.href='http://localhost:9090/TeamProject1/hairline?cmd=LIST'"/>
					  </div>																	                 
				  	  </td>
				  	</table>
				  	
				</form>

	</body>
</html>
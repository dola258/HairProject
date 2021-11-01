<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reservepage.css" >
<style>
	#cont { border : 1px solid black;  border-collapse: collapse;
					margin: 30px auto; width: 600px; text-align: center;}
	th, td { border: 1px solid black;
			 border-collapse: collapse;}
	th, td   {padding: 5px; }
   	#cont  td:nth-of-type(1) { width:100px; }
   	#cont  td:nth-of-type(2) { width:300px; }
   	#cont  tr:nth-of-type(8) { height:100px; }
   
   	#cont  td:nth-of-type(2) { text-align: left; padding-left:10px; }     
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
</script>
</head>

<body>
	<div id="table">
		<div class="row">
			<span class="cell" id="td1-1"><h1>&nbsp;<a href="view/mem_sel.jsp">HAiR LiNE</a></h1></span>
			<span class="cell" id="td1-2">
				<div id="officer">
					<span>
						<img src="imgs/5.png"/>
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
					<button class="btn"><a href="rsv_list.jsp">예약관리</a></button><br><br><br><br>
					<button class="btn"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></a></button>
				</div>
			</span>
			<span class="cell" id="td2-2">
			
				<form action="http://localhost:9090/TeamProject1/view/cupdate.jsp?idx=${ param.idx }&cname=${param.cname}&ctel=${param.ctel}&cbirth=${param.cbirth}&specifics=${customerVo.specifics}" method="POST">
				<h1>고객조회</h1><br>
				<table id="cont">
				     <tr>
				       <td>No.</td>
				       <td>${ param.idx }</td>
				     </tr>
				     <tr>
				       <td>고객명</td>
				       <td>${ param.cname }</td>
				     </tr>
				     <tr>
				       <td>연락처</td>
				       <td>${ param.ctel }</td>
				     </tr>
				     <tr>
				       <td>생년월일</td>
				       <td>${ param.cbirth }</td>
				     </tr>
				     <tr>
				       <td>담당자</td>
				       <td>${ param.dname }</td>
				     </tr>
				     <tr>
				       <td>등록일</td>
				       <td>${ param.regdate }</td>
				     </tr>
				     <tr>
				       <td>마지막헤어</td>
				       <td>
				       ${ param.hcode }
				       </td>
				     <tr>
				       <td>특이사항</td>
				       <td>
	           		       ${fn:replace( customerVo.specifics, newLineChar, "<br />")}
				       </td>
				     </tr>
				     <tr>
				     <td colspan="2">
				     	<input type="submit" style="height:32px; width:50px;" value="수정" />
						<input type="button" style="height:32px; width:50px;" value="취소" onclick="location.href='http://localhost:9090/TeamProject1/hairline?cmd=LIST'"/>
				     </td>
				     </tr>
				    </table><br>
  					</form>
  					</span>
</body>
</html>
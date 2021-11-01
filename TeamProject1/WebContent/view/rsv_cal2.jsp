<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/reservepage.css" >
<style>
	table { margin: 30px auto; border: 1px solid black; border-collapse: collapse; border-left: hidden;	border-right: hidden; width:600px; }
	tr, td { border-bottom: 1px solid black; padding: 10px;}
	
	#btn-impor { background-color: white; border-radius: 5px; }
	#btn-logout { background-color: white; border-radius: 5px;}
	#btn-add { width:120px; height:60px; background-color:#343d69; color:#FFBF00; border-radius:5px; font-size:20px; text-align: center;}
	#btn-cancel { width:120px; height:60px; background-color:red; color:white; border-radius:5px; font-size:20px;}
	#day_reserve { text-align: center;}
</style>
<script>
	$(function() {	

		$('#btn-add').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			
			var idx = '${ param.idx}';
			var cname = '${ param.cname}';
			var ctel = '${ param.ctel}';
			var cbirth = '${ param.cbirth}';
			var rdate = '${ param.rdate}';
			
			location.href = "http://localhost:9090/TeamProject1/view/reserve_Final.jsp?idx="+idx+"&cname="+cname+"&ctel="+ctel+"&cbirth="+cbirth+"&rdate=" + rdate;
		});
				
		$('#btn-cancel').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();

			var idx = '${ param.idx}';
			var cname = '${ param.cname}';
			var ctel = '${ param.ctel}';
			var cbirth = '${ param.cbirth}';
			var rdate = '${ param.rdate}';
			
			location.href = "http://localhost:9090/TeamProject1/rsv_list.jsp" ;
		});
//////////////////////////////////////////////////////////////////////////////////////////////////////
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
			<span class="cell" id="td1-1"><h1>&nbsp;<a href="view/mem_sel.jsp">HAiR LiNE</a></h1></span>
			<span class="cell" id="td1-2">
				<div id="officer">
				
					<span>
						<img src="imgs/5.png" />
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
					<button class="btn"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></button>
				</div>
			</span>
			<span class="cell" id="td2-2">
				<h1>${ param.rdate }</h1>
				<table id="day_reserve" style="overflow:visible;">
					<tr height="100px">
						<td>예약시간</td><td>고객번호</td><td>고객명</td><td>담당 디자이너</td><td>시술</td>
					</tr>
					<c:forEach var="reserve" items="${ res_list }">
						<tr>
							<td>${reserve.datetime}</td>
							<td>${reserve.idx}</td>                              
							<td><a href="http://localhost:9090/TeamProject1/view/reserveMod_v0821.jsp?idx=${reserve.idx}&cname=${reserve.cname}&rdate=${param.rdate }&otime=${reserve.datetime}">${reserve.cname}</a></td>
							<td>${reserve.dname}</td>
							<td>${reserve.hname}</td>
						</tr>
					</c:forEach>
				</table>
				<div style="text-align: center;">
				<input type="submit" id="btn-add" value="예약추가"/>&emsp;&emsp;&emsp;<button id="btn-cancel">취소</button>
				</div>
			</span>
	
		</div>
	</div>

</body>
</html>
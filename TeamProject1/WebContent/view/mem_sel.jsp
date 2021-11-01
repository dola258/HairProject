<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&display=swap');
	h1 { font-family: 'Noto Sans', sans-serif;}
</style>
<style>
	#table1 { margin-left: auto; margin-right: auto; border-collapse: collapse;
			  width: 1200px; height: 600px;}	
	#td1 { background-color: #343d69; text-align: center;}
	#td2 { background-color: #FFBF00;  text-align: center;}
	
	#go-reserve { font-size: 60px; color: #FFBF00; background-color: #343d69; text-decoration: none; border: none;}
	#go-customer { font-size: 60px; color: #343d69;  background-color: #FFBF00; text-decoration: none; border: none;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		$('#go-customer').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			var did = '${ param.did}';
			var dname = '${ param.dname}';
			var dtel = '${ param.dtel}';
			var wpname = '${ param.wpname}';
			location.href = "http://localhost:9090/TeamProject1/hairline?cmd=LIST&did="+did+"&dname="+dname+"&dtel="+dtel+"&wpname="+wpname;
			
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
	<div id="outer">
	<form action="http://localhost:9090/TeamProject1/hairline?cmd=SEARCH" method="POST" >
		<table id="table1">
			<tr>
				<td id="td1"><input type="submit" id="go-reserve" value="예약관리"></td><td id="td2"><input type="submit" id="go-customer" value="고객관리"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
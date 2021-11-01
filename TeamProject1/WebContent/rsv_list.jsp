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
	#btn-search { width: 32px; height: 32px; background-image: url('imgs/33333.png'); line-height: 32px;  background-repeat: no-repeat; }

	
	#reserve-table { border : 1px solid black; border-collapse: collapse; 
					margin: 30px auto; width: 900px;  text-align: center;}
	#reserve-table tr { height: 30px;}
	tr, td { border: 1px solid black;}
	
	input { height: 26px; } 
	
</style>
<script>
	$(function() {
		$('#btn-search').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			
			if($('#customer_search').val() == '') {
				alert("이름을 입력해주세요");
				return false;
			} else {
				$.ajax({
					url: 'http://localhost:9090/TeamProject1/customers',
					data: { cname : $('#customer_search').val() },
					success: function(html) {
							$('#reserve-table tbody').remove();
							$('#reserve-table').append(html);
					},
					error : function(xhr) {
						alert(xhr.status + ":" + xhr.textStatus);
					}
				});
			}
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
				<div id="menus" width="100%" style="margin-left:0">
					<p id="wpname">${ designervo.wname }</p><br><br><br><br>
					<button class="btn">예약관리</button><br><br><br><br>
					<button class="btn"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></button>
					
				</div>
			</span>
			<span class="cell" id="td2-2">
				<h1>고객조회</h1>
				<form action="/"></form>
				<div id="searchdiv" style="height:32px; float:right;"><input type="text" id="customer_search" /><img id="btn-search" /></div><br>
				<table id="reserve-table">
					<thead>
					<tr>
						<td>고객번호</td><td>고객명</td><td>연락처</td><td>생년월일</td>
					</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</span>
	
		</div>
	</div>
</body>
</html>
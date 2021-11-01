<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reservepage.css" >
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
	#btn-search { width: 32px; height: 32px; background-image: url('imgs/33333.png'); line-height: 32px;  background-repeat: no-repeat; }
	input { height: 26px; } 
	#list-table { border : 1px solid black; border-collapse: collapse; 
					margin: 30px auto; width: 900px; text-align: center;}
	th, td { border: 1px solid black; border-collapse: collapse;}
    th, td   {padding: 5px; }
   #list-table   th:nth-of-type(1) {  width : 50px;   }
   #list-table   th:nth-of-type(2) {  width : 90px;   }
   #list-table   th:nth-of-type(3) {  width : 140px;  }
   #list-table   th:nth-of-type(4) {  width : 140px;  }
   #list-table   th:nth-of-type(5) {  width : 80px;   }
   #list-table   th:nth-of-type(6) {  width : 100px;  }
   #list-table   th:nth-of-type(7) {  width : 140px;  }
   #list-table   th:nth-of-type(8) {  width : 30px;   }
</style>
<script>
	function  deleteRow(btn_delete, idx) {
		if(!confirm(idx+"번 고객정보를 삭제 하시겠습니까?")){
			return false;
		}else{
			location.href= 'http://localhost:9090/TeamProject1/hairline?cmd=DELETE&idx=' + idx;
		}
		
	}

    
	$(function() {
		$('#btn-search').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			
			if($('#customer_search').val() == '') {
				alert("이름을 입력해주세요");
				return false;
			} else {
				$.ajax({
					url: 'http://localhost:9090/TeamProject1/searchcustomer',
					data: { cname : $('#customer_search').val() },
					success: function(html) {
							$('#list-table tbody').remove();
							$('#list-table').append(html);
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
						${ designervo.dname }<br>${ designervo.tel }<br><button id="btn-logout">로그아웃</button>
					<span>
					</span>
				</div>
			</span>
		</div>
		<div class="row">
			<span class="cell" id="td2-1">
				<div id="menus">
					<p id="wpname">${ designervo.wname }</p><br><br><br><br>
					<button class="btn" id="btnReserve"><a href="rsv_list.jsp">예약관리</a></button><br><br><br><br>
					<button class="btn" id="btnMember"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></button>
				</div>
			</span>
			<span class="cell" id="td2-2">
			<h1>고객관리</h1>
			<input type="button" style="margin-left:30px; height:32px;" value="신규등록" onclick="location.href='http://localhost:9090/TeamProject1/view/cregister.jsp' ">
			<div id="searchdiv" style="height:32px; float:right;"><input type="text"  id="customer_search"/><img id="btn-search" /></div>
				<table id="list-table">
					<thead>
					<tr>
						<th>No.</th>
						<th>고객명</th>
						<th>연락처</th>
						<th>생년월일</th>
						<th>담당자</th>
						<th>등록일</th>
						<th>마지막헤어</th>
						<th>삭제</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="customer" items="${customerList }">
						<tr>
							<td>${customer.idx }</td>
							<td><a href= "http://localhost:9090/TeamProject1/hairline?cmd=INFO&idx=${ customer.idx }&cname=${ customer.cname }&ctel=${ customer.ctel }&cbirth=${ customer.cbirth }&dname=${ customer.dname }&regdate=${ customer.regdate }&hcode=${ customer.hcode }"
							>${ customer.cname }</a></td>
							<td>${customer.ctel }</td>
							<td>${customer.cbirth }</td>
							<td>${customer.dname }</td>
							<td>${customer.regdate }</td>
							<td>${customer.hcode }</td>
							<td><input type="button" id="btn_delete" value="X" onclick="deleteRow(this,'${customer.idx }' );"/></td>

						</tr>
					</c:forEach>     
					</tbody>

				</table>

			</span>
	
		</div>
	</div>
</body>
</html>
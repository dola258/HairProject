<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/common.css" />
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&display=swap');
	h1 { font-family: 'Noto Sans', sans-serif;}
</style>
<style>
	.btn { width: 130px; height: 50px; border-radius: 5px;	margin-top: 470px; }
	#btn-find { float: right; margin-right: 2%;	background-color: #343d69; color: white; }
	#btn-cancel { margin-left: 2%; background-color: red;	color: white; }
			
	#inner { position: absolute; top: 50px; left: 820px; width: 300px;}
		 	 
	input {  border-radius: 5px; border:2px solid black ;  width: 292px; height: 26px}
	input:nth-of-type(2) { width: 205px; height: 26px;}
	
	span { display: inline-block; width: 80px; height: 30px; border-radius: 5px;  border:2px solid black ; 
		   text-align:  center; background-color: gray; color: white; font-size: 15px; }

	p { tex
	t-align: center;}
	
	#bir-div { margin: auto;}
</style>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

$(function () {
	$('#btn-find').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();

	
		if($('#name').val() == '') {
			alert("이름을 입력해주세요");
			return false;
		} else if ($('#birth').val() == '') {
			alert("생년월일을 입력해주세요");
			return false;
			} else if ($('#email').val() == '' ) {
				alert("이메일을 입력해주세요");
				return false;
				}  else {	
					$.ajax({
								url : 'http://localhost:9090/TeamProject1/findid',
								data: { name : $('#name').val(), birth : $('#birth').val(), email : $('#email').val(), id : $('input:radio[id=id]').is(":checked"), pw : $('input:radio[id=pw]').is(":checked")    },
								success : function(result) {
										alert(result)
								},
								error : function(xhr) {
									alert(xhr.status + ':' + xhr.textStatus)
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
	<div id="outer">
		<table id="table1">
			<tr>
				<td id="td1"><button class="btn" id="btn-find" >찾기</button></td><td id="td2"><button class="btn" id="btn-cancel" onclick="location.href='../mem_login.jsp'">취소</button></td>
			</tr>
		</table>
	</div>
	<div id="inner">
		<h1>&nbsp;<a href="../mem_login.jsp">HAiR LiNE</a></h1>
		<input type="text" id="name" placeholder="이름을 입력하세요." onFocus="javascript:this.value=''" /><br><br>
		<span><div id="bir-div">생년월일</div></span>&nbsp;<input type="date" id="birth"><br><br>
		<input type="text" id="email" placeholder="등록된 email을 기재해주세요." onFocus="javascript:this.value=''"/><br><br>
		&emsp;&emsp;&emsp;&emsp;<input type="radio" name="idpw"  id="id" checked="checked" style="width:15px; height:15px;"/>ID찾기&nbsp;<input type="radio" name="idpw" id="pw" style="width:15px; height:15px;"/>PW찾기<br>
		<p>등록된 이메일 주소로<br> ID or PW가 발송됩니다.<p>
	</div>
</body>
</html>
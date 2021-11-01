<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/common.css" />
<title>Insert title here</title>

<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&display=swap');
	h1 { font-family: 'Noto Sans', sans-serif;}
</style>
<style>
	.btn {	width: 130px; height: 50px; border-radius: 5px;
			 margin-top: 470px;}
	#btn-membership { float: right; background-color: #343d69; 
					  margin-right: 2%; color: white; }
	#btn-cancel { background-color: red; color: white; margin-left: 2%}
			
			
	#inner { width: 500px; position: absolute; 
			 top: 20px; left: 820px; }
		 	 
	
	input { widht: 140px; height: 20px;}
	
	span { display: inline-block; width: 60px; line-height: 22px;
		   border-radius: 5px; text-align: center; background-color: gray;
		   color: white; border:2px solid black}
	
	#inner button { width: 60px; height: 23px; font-size: 11px; }
	
	#wp { font-size: 12px; line-height : }
	
	input { border-radius: 5px; border:2px solid black ; width: 177px; line-height: 27px;}
	
	.btn-overlab {  border-radius: 5px; border:2px solid black ;}
	
	#submit { width: 130px; height: 50px; border-radius: 5px; margin-top: 470px; 
			  float: right; background-color: #343d69; margin-right: 2%; color: white; }
</style>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>


$(function() {
	$('#btn_id_dupcheck').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		if($('#did').val() == '') {
			alert('아이디를 입력하세요.');
			return false;
		}
		
		$.ajax({
			url     : 'http://localhost:9090/TeamProject1/dupcheckid',
			data    : { did : $('#did').val() },
			success : function(result) {
				alert(result);
			},
			error   : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus)
			}
		});
	});
	
	$('#btn_email_dupcheck').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		if($('#email').val() == '') {
			alert('이메일을 입력하세요.');
			return false;
		}
		
		$.ajax({
			url     : 'http://localhost:9090/TeamProject1/dupcheckemail',
			data    : { email : $('#email').val() },
			success : function(result) {
				alert(result);
			},
			error   : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus)
			}
		});
	});
	
	$('#btn_tel_dupcheck').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		if($('#dtel').val() == '') {
			alert('전화번호를 입력하세요.');
			return false;
		}
		
		$.ajax({
			url     : 'http://localhost:9090/TeamProject1/dupcheckdtel',
			data    : { dtel : $('#dtel').val() },
			success : function(result) {
				alert(result);
			},
			error   : function(xhr) {
				alert(xhr.status + ':' + xhr.textStatus)
			}
		});
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
	$('#submit').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		
		var did = $('#did').val();
		var pw = $('#pw').val();
		var dname = $('#dname').val();
		var dbirth = $('#dbirth').val();
		var email = $('#email').val();
		var dtel = $('#dtel').val();
		var wpname = $('#wpname').val();

		
		if( did != '') {
			if( pw != '') {
				if( dname != '') {
					if( dbirth != '') {
						if( email != '') {
							if( dtel != '') {
								if( wpname != '') {	
									alert("회원가입완료");
									location.href = "http://localhost:9090/TeamProject1/hairline?cmd=DINSERT&did="+did+"&pw="+pw+"&dname="+dname+"&dbirth="+dbirth+"&email="+email+"&dtel="+dtel+"&wpname="+wpname;
								} else { alert("근무지를 입력해주세요."); }
							} else { alert("전화번호를 입력해주세요."); }
						} else { alert("이메일을 입력해주세요."); }
					} else { alert("생년월일을 입력해주세요."); }
				} else { alert("이름을 입력해주세요."); }
			} else { alert("비밀번호를 입력해주세요."); }
		} else { alert("아이디를 입력해주세요."); }
	
	});
});


</script>
</head>
<body>
	<form action="http://localhost:9090/TeamProject1/hairline?cmd=DINSERT" method="POST">
	<div id="outer">
		<table id="table1">
			<tr>
				<td id="td1"><input type="submit" id="submit" value="회원가입" onclick="pop()"/></td><td id="td2"><button type="submit" class="btn" id="btn-cancel" >취소</button></td>
			</tr>
		</table>
	</div>
	<div id="inner">
			<h1>&nbsp;<a href="../mem_login.jsp">HAiR LiNE</a></h1>
			<span>ID</span>&nbsp;<input type="text" id="did" name="did" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''">&nbsp;<button class="btn-overlab" id="btn_id_dupcheck">중복확인</button><br><br></form>
			<span>PW</span>&nbsp;<input type="password" id="pw" name="pw" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''"><br><br>
			<span>Name</span>&nbsp;<input type="text" id="dname" name="dname" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''"><br><br>
			<span>Birth</span>&nbsp;<input type="date" id="dbirth" name="dbirth"><br><br>
			<span>Email</span>&nbsp;<input type="text" id="email" name="email" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''">&nbsp;<button class="btn-overlab" id="btn_email_dupcheck">중복확인</button><br><br>
			<span>Contact</span>&nbsp;<input type="text" id="dtel" name="dtel" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''">&nbsp;<button class="btn-overlab" id="btn_tel_dupcheck">중복확인</button><br><br>
			<span id="wp">W.P Name</span>&nbsp;<input type="text" id="wpname" name="wpname" placeholder="내용을 입력해주세요" onFocus="javascript:this.value=''"><br><br>
	</div>
	</form>
</body>
</html>
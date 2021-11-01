<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>HAiR LiNE</title>
<link rel="stylesheet" href="css/common.css" />
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&display=swap');
	h1 { font-family: 'Noto Sans', sans-serif;}
</style>
<style>
	.btn {  width: 130px; height: 50px;	border-radius: 5px; }
	
	#btn-membership { margin-top: 470px; float: right; margin-right: 2%; background-color: black; color: white; }
	
	#btn-find { margin-top: 470px; margin-left: 2%; background-color: gray; color: white; }
			
	#btn-login { background-color: #bdbdbd ; color: white; width: 130px; height: 50px;	border-radius: 5px; }
			
	#inner { position: absolute; top: 120px; left: 820px; }
	
	input { height: 30px; border-radius: 5px; border:2px solid black ; }
</style>
<script>

</script>
</head>
<body>
	<div id="outer">
		<table id="table1">
			<tr>
				<td id="td1"><button class="btn" id="btn-membership" onclick="location.href='view/mem_join.jsp'">회원가입</button></td><td id="td2"><button class="btn" id="btn-find" onclick="location.href='view/mem_idpw.jsp'">ID/PW 찾기</button></td>
			</tr>
		</table>
	</div>
	<div id="inner">
	<form action="http://localhost:9090/TeamProject1/hairline?cmd=LOGIN" method="POST" >
		<h1>&nbsp;<a href="mem_login.jsp">HAiR LiNE</a></h1>
		아이디&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="uid" placeholder="아이디"  onFocus="javascript:this.value=''" /><br><br>
		비밀번호&nbsp;<input type="password" name="upw" placeholder="비밀번호"  onFocus="javascript:this.value=''"/><br><br><br><br>
		&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" id="btn-login" value="login" />
	</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/reservepage.css" >

<style>
	#update-table {margin: auto; width: 370px; text-align: left;}
    form td:nth-child(1)   { width:120px;} 
    form td:nth-child(2)   { width:250px;}
    form tr:nth-of-type(7) { height:200px;}
    textarea               { height:180px; width:250px;}
    input                  { width:250px;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
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
						location.href = "../mem_login.jsp";
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
			 	  <h1>고객편집</h1>
    		   <form  action="http://localhost:9090/TeamProject1/hairline?cmd=UPDATE" method="POST">
			    <table id="update-table">
			     <tr>
			       <td>No.</td>
			       <td><input type="text" name="idx" value="${ param.idx }"  readonly /></td>
			     </tr>
			     <tr>
			       <td>고객명</td>
			       <td><input type="text" name="cname" value="${ param.cname }" /></td>
			     </tr>
			     <tr>
			       <td>연락처</td>
			       <td><input type="text" name="ctel"  value="${ param.ctel }" /></td> 
			     </tr>
			     <tr>
			       <td>생년월일</td>
			       <td><input type="text" name="cbirth"  value="${ param.cbirth }" /></td>
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
					   </select>
				   </td>
			     </tr>
			     <tr>
			       <td>특이사항</td>
			       <td><textarea name="specifics">${ param.specifics }</textarea></td>
			     </tr>
			     <tr>
			       <td colspan="2">
			       <div align="right">
			       <input type="submit" style="height:32px; width:50px;" value="확인" >
			       </td>
			       </div>
			     </tr>
			    </table>
			   </form>
			   </span>
</body>
</html>
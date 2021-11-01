<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management Reservation Page</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>

	#table { display: table; width: 1200px; height: 600px; margin-left: auto; margin-right: auto;}
	
	.row {display: table-row; }
	
	.cell { display: table-cell; }
	#td1-1 { background-color: #FFBF00; text-align: center; width: 20%; height: 90px;}
	#td1-2 { background-color: #FFBF00; vertical-align: middle; }
	#td2-1 { background-color: #FFBF00; width: 20%; }


	a { color: black; text-decoration: none;}
	#wpname {border-radius: 30px; text-align: center; width:100%; line-height: 2.4em; color: rgb(243, 156, 18); font-size: 21px; box-shadow: none; background-color: rgb(44, 62, 80); font-weight: bold; }
			

	.btn { width: 240px; background-color: #FFBF00; border-radius: 5px; font-size: 30px; border: 0; outline: 0; margin-left:auto; margin-right: auto;}
	.btn:hover { background-color: #343d69; color: #FFBF00; }
	img { width:50px; height:auto; float:left }
	#officer { display:box; background-color:white; width:200px; height: 66px; margin: auto 2% auto auto; }	
	#btn-impor { background-color: white; border-radius: 5px; }
	#btn-logout { background-color: white; border-radius: 5px;}


#Titles { border-radius: 25px; border: 2px solid #ffff99; padding: 5px; width: 946px; height: 20px;
  		  background-color: #ffcc00; text-align: justify; color: white; font-weight: 500; text-align: center; }

#Labels { border-radius: 25px; border: 2px solid #ffff99; padding: 5px; width: 150px; height: 20px;
  		  background-color: #ffd633; text-align: center; color: white; font-weight: 500; }

#Boxes { border-radius: 25px; border: 2px solid #e6faff; padding: 5px; width: 150px; height: 20px;  
  		 background-color: #00ccff; text-align: center; color: white; font-weight: 500; }

#ComboBox { border-radius: 25px; border: 2px solid #e6faff; padding: 5px; width: 165px; height: 30px; background-color: #00ccff; text-align: center;
  			color: white; font-weight: 500; }
#time { border-radius: 25px; border: 2px solid #e6faff; padding: 5px; width: 165px; height: 30px; background-color: #00ccff; text-align: center;
  			color: white; font-weight: 500; }
  

#rcorners3 { border-radius: 25px;  border: 2px solid #e6faff; padding: 5px; width: 80px; height: 50px; background-color: #33adff; text-align: center;
  			 color: white; font-weight: 500;}

#btnSubmit{ border-radius: 25px; border: 2px solid #e6faff; padding: 5px; width: 80px; height: 32px; 
  			background-color: #33adff; text-align: center; color: white; font-weight: 500; }

#btnConfirm{border-radius: 25px; border: 2px solid #ccffe6; padding: 5px; width: 80px; height: 50px; 
  			background-color: #00ffcc; text-align: center; color: white; font-weight: 500;}

#btnCancel{ border-radius: 25px; border: 2px solid #ff9999; padding: 5px; width: 80px; height: 50px;
		  	background-color: #ff8080; text-align: center; color: white; font-weight: 500;}

#btnModify{ border-radius: 25px; border: 2px solid #37DA12; padding: 5px; width: 80px; height: 50px; color: white; font-weight: 500; }

#Gender{ border-radius: 25px; border: 2px none #ff9999; padding: 5px; width: 80px; height: 50px; color: black; font-weight: 500;}

select {text-align-last: center;text-align: center;-ms-text-align-last: center;-moz-text-align-last: center;}


.form-radio {display: none;}
.form-radio {margin-left: 20px;}
   
</style>
<script>
	$(function() {

		$('.ComboBox').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
		});
		
		$('#btnCancel').on('click', function(e) {
			e.preventDefault();
			e.stopPropagation();
			location.href = "http://localhost:9090/TeamProject1/hairline?cmd=RESERVE&idx=${param.idx}&cname=${param.cname}&ctel=${param.ctel}&cbirth=${param.cbirth}&rdate=${param.rdate}";
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
					<button class="btn"><a href="../rsv_list.jsp">예약관리</button><br><br><br><br>
					<button class="btn"><a href="http://localhost:9090/TeamProject1/hairline?cmd=LIST&did=${param.did }&dname=${param.dname }&dtel=${param.dtel }&wpname=${param.wpname }">고객관리</a></button>
				</div>
			</span>
			<span class="cell" id="td2-2" >
			<form action="http://localhost:9090/TeamProject1/hairline?cmd=RINSERT&idx=${param.idx }&ctel=${param.ctel}&rdate=${param.rdate}" method="POST">
 				 <legend  id="Titles">예   약   등   록</legend><br>
  				 <div style="width: 360px; margin-left: auto; margin-right: auto; padding-left: auto; padding-right: auto;">
				  
				  <label for="cname" id="Labels">고객성함</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="Boxes" name="cname" value="${ param.cname }"  readonly/><br><br>
				  
				   	   <label for="bdate" id="Labels">예약일자</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="date" id="Boxes" name="bdate" value="${ param.rdate }" readonly/>
				   <br><br>
		           <label for="time" id="Labels">예약시간</label>&nbsp;&nbsp;&nbsp;&nbsp;
			  	   <select name="time"  id="time" class="ComboBox">
				  			<option value="" id="ComboBox" class="ComboBox">- 시간을 선택하세요 -</option>
						    <option value="10:00">10:00</option>
						    <option value="10:30">10:30</option>
						    <option value="11:00">11:00</option>
						    <option value="11:30">11:30</option>
						    <option value="12:00">12:00</option>
						    <option value="12:30">12:30</option>
						    <option value="13:00">13:00</option>
						    <option value="13:30">13:30</option>
						    <option value="14:00">14:00</option>
						    <option value="14:30">14:30</option>
						    <option value="15:00">15:00</option>
						    <option value="15:30">15:30</option>
						    <option value="16:00">16:00</option>
						    <option value="16:30">16:30</option>
						    <option value="17:00">17:00</option>
						    <option value="17:30">17:30</option>
						    <option value="18:00">18:00</option>
						    <option value="18:30">18:30</option>
						    <option value="19:00">19:00</option>
						    <option value="19:30">19:30</option>
						    <option value="20:00">20:00</option>
				   </select><br><br>
				   <label for="designer" id="Labels">디자이너</label>&nbsp;&nbsp;&nbsp;&nbsp;
				   <select name="designer"  id="ComboBox" class="ComboBox">
				  			<option value="" id="ComboBox" class="ComboBox">- 디자이너를 선택하세요 -</option>
						    <option value="sky">디자이너1</option>
						    <option value="sun">디자이너2</option>
						    <option value="sea">디자이너3</option>
						    <option value="tea">디자이너4</option>
				   </select><br><br>
				   <label for="treat" id="Labels">시술종류</label>&nbsp;&nbsp;&nbsp;&nbsp;
					  <select name="treat"  id="ComboBox" class="ComboBox">
					  	<option value="" id="ComboBox" class="ComboBox">- 시술을 선택하세요 -</option>
						  	<optgroup label="헤어">
							    <option value="cutMa">[커트] 남성 20,000</option>
							    <option value="cutFe">[커트] 여성 23,000</option>
							    <option value="cutSt">[커트] 학생 18,000</option>
							    <option value="cutKd">[커트] 어린이 18,000</option>
							    <option value="sampoo">[샴푸] 8,000</option>
							    <option value="dyeB">[컬러] 베이직 70,000</option>
							    <option value="dyeBR">[컬러] 베이직(루트) 50,000</option>
							    <option value="dyeP">[컬러] 프리미엄 100,000</option>
							    <option value="dyePR">[컬러] 프리미엄(루트) 70,000</option>
							    <option value="wax">[왁싱] 매니큐어 80,000</option>
							    <option value="permB">[퍼머] 베이직 60,000</option>
							    <option value="permP">[퍼머] 프리미엄 100,000</option>
							    <option value="magicB">[매직] 베이직 100,000</option>
							    <option value="magicPB">[매직] 프리미엄(볼륨) 130,000</option>
							    <option value="magicPS">[매직] 프리미엄(세팅) 150,000</option>
							    <option value="magicPD">[매직] 프리미엄(디지털) 150,000</option>
							    <option value="clinic">[케어] 모발클리닉 80,000</option>
						    </optgroup>
						    <optgroup label="두피">
					    		<option value="scalp">[케어] 두피케어 70,000</option>
					    	</optgroup>
	  					</select><br><br>
	  				<div style="text-align: center;">	 
   						<input name="bbutton"  id="btnConfirm" type="submit" class="button" value="예약" />
   						<input name="Xbutton"  id="btnCancel" type="button" class="button" value="취소" />
					</div>
				</div>
				</form>
			</span>
	
		</div>
	</div>
</body>

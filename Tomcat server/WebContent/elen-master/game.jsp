<%@page import="com.controller.before_value"%>
<%@page import="com.sun.scenario.effect.impl.sw.sse.SSEInvertMaskPeer"%>
<%@page import="java.util.Random"%>
<%@page import="com.model.upload_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.upload_DAO"%>
<%@page import="com.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Elen - Free Bootstrap 4 Template by Colorlib</title>
<style type="text/css">
:root { -
	-body-background-color: white; -
	-font-color: #4e4e4e; -
	-border-gray-color: #FE9A2E; -
	-naver-green-color: #FE9A2E; -
	-naver-green-border-color: #FE9A2E;
}

* {
	margin: 0;
	padding: 0;
}

body {
	background: var(- -body-background-color);
}

.main-container {
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 10px;
}

.main-container .main-wrap {
	width: 768px;
}

.main-container .main-wrap .sel-lang-wrap .lang-select {
	width: 96px;
	height: 30px;
	color: var(- -font-color);
	border: solid 1px var(- -border-gray-color);
}

.main-container .main-wrap .logo-wrap {
	padding-top: 55px;
}

.main-container .main-wrap .logo-wrap img {
	width: 300px;
	height: 150px;
}

.main-container .main-wrap header .sel-lang-wrap {
	display: flex;
	justify-content: flex-end;
}

.main-container .main-wrap header .logo-wrap {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.login-input-section-wrap {
	padding-top: 0px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.login-input-wrap {
	/* width: 465px; */
	height: 48px;
	border: solid 1px var(- -border-gray-color);
	background: white;
}

.password-wrap {
	margin-top: 13px;
}

input:focus {
	outline: 0px;
}

.login-input-wrap input {
	border: none;
	/* width:430px; */
	margin-top: 10px;
	font-size: 23px;
	margin-left: 10px;
	height: 30px;
}

.login-button-wrap {
	padding-top: 13px;
}

.login-button-wrap button {
	width: 465px;
	height: 48px;
	font-size: 25px;
	background: #FE9A2E;
	color: white;
	border: solid 1px var(- -naver-green-border-color);
}

.login-stay-sign-in {
	width: 465px;
	height: 52px;
	display: flex;
	font-size: 15px;
	color: #4e4e4e;
	align-items: center;
	justify-content: flex-start;
	border-bottom: solid 1px var(- -border-gray-color);
}

.login-stay-sign-in i {
	font-size: 25px;
	color: #9ba1a3;
}

.login-stay-sign-in span {
	padding-left: 5px;
	line-height: 25px;
}

.Easy-sgin-in-wrap {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding-top: 40px;
}

.Easy-sgin-in-wrap h2 {
	font-size: 20px;
}

.Easy-sgin-in-wrap .sign-button-list {
	padding-top: 25px;
	list-style: none;
	width: 465px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.Easy-sgin-in-wrap .sign-button-list li {
	padding-bottom: 10px;
}

.Easy-sgin-in-wrap .sign-button-list li button {
	width: 465px;
	height: 56px;
	border: solid 1px var(- -border-gray-color);
	text-align: left;
	background: white;
}

.Easy-sgin-in-wrap .sign-button-list li button i {
	padding-left: 15px;
	font-size: 20px;
}

.fa-qrcode {
	color: var(- -naver-green-color);
}

.fa-line {
	color: var(- -naver-green-color);
}

.fa-facebook-square {
	color: #4064ac;
}

.Easy-sgin-in-wrap .sign-button-list li button span {
	padding-left: 20px;
	font-size: 18px;
}

.Easy-sgin-in-wrap .forget-msg {
	color: var(- -font-color);
	font-size: 14px;
	padding-top: 10px;
}

footer {
	padding-top: 95px;
	padding-bottom: 15px;
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 768px;
}

.copyright-wrap {
	display: flex;
	flex-direction: column;
	align-items: center;
	height: 15px;
}

footer .copyright-wrap span img {
	width: 59px;
	height: 11px;
}

footer .copyright-wrap span {
	font-size: 13px;
	line-height: 15px;
}

.containerLogout {
	display: flex;
	flex-direction: row-reverse;
	A: link{  
		color: red;
}

;
A:visited {
	color: red;
}

;
font-size


:

 

60px


;
}

/* 버튼 시작 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	box-sizing: border-box;
	height: 100%;
	width: 100%;
}

body {
	background: #E1332D;
}

h1 {
	color: #fff;
	font-size: 5em;
	font-weight: bold;
	margin: 0 0 1em;
}

.container {
	display: table;
	height: 100%;
	width: 100%;
}
 
.buttons {
	display: table-cell;
	padding: 1em;
	text-align: center;
	vertical-align: middle;
} 
[class*="btn-"] {
	position: relative;
	display: inline-block;
	width: 100%;
	color: #fff;
	font-size: 35px;
	line-height: 76px;
	margin-right: 1em;
	max-width: 290px;
	/* 버튼 크기 조정 */
	text-decoration: none;
	text-transform: uppercase;
	vertical-align: middle;
}

/**
 * ===========================
 * @class : btn-2
 * ===========================
 */
.btn-1 {
	background: #1cb93f;
	border: 1px solid white;
	box-shadow: 0 2px 0 #FFFFFF, 2px 4px 6px #77d88d;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
}
.btn-1:hover {
	background: #09b530;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color: #ec817d;
	text-shadow: -1px -1px 0 #dddddd;
}
 
 
 
 
.btn-2 {
	background: #fa4d9c;
	border: 1px solid white;
	box-shadow: 0 2px 0 #FFFFFF, 2px 4px 6px #fa4d9c;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
}
.btn-2:hover {
	background: #f92083;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color:#ec817d;
	text-shadow: -1px -1px 0 #dddddd;
}





.btn-3 {
	background: #FF7012;
	border: 1px solid white;
	box-shadow: 0 2px 0 #FFFFFF, 2px 4px 6px #F15F5F;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
}
.btn-3:hover {
	background: #FF5E00;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color: #ec817d;
	text-shadow: -1px -1px 0 #dddddd;
}

.btn-4 {
	background: #fcc216;
	border: 1px solid white;
	box-shadow: 0 2px 0 #FFFFFF, 2px 4px 6px #fcc216;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
}
.btn-4:hover {
	background: #ffbf00;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color: #ec817d;
	text-shadow: -1px -1px 0 #dddddd;
}







---지순누나가 만든 버튼-------------



.btnbtnbtn{position:relative;width:600px;margin:20px auto;text-align:Center;}

.btn3{
	height:80px;
	color:#fff;
	font-size:40px;
	background: #FF7012;
	border: 1px solid white;
	box-shadow: 0 2px 0 #F15F5F, 2px 4px 6px #F15F5F;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
	width: 630px
}

.btnbtnbtn input:hover {
	background: #FF5E00;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color: #ec817d;
	text-shadow: -1px -1px 0 #c2211c;
}


-------------QNA 스타일-----------------------




#qna_wrap{position:relative;width:500px;height:500px;}
#qna_wrap .qnaQ{position:relative;float:left;width:100%;margin-bottom:10px;margin-top:1%;margin-left:10%; }
#qna_wrap .qnaA{position:relative;float:left;width:100%;margin-bottom:10px;margin-top:1%;margin-left:10%;padding-bottom:3%;}
.qna_w{float:left;width:80%;padding:2% 1% 1% 1%;background:#fff;border-radius:30px;border:2px solid black;box-shadow:5px 5px 5px #e0e0e0;}
.q_text{float:left;width:80%;font-size:18px;text-align:center;margin:0 10%;}/* 문제데이터 글씨 */
.qnaA b{float:left;width:100%;font-size:20px;}
#qna_wrap em{position:absolute;left:15px;top:10px;width:50px;height:50px;text-align:center;line-height:50px;font-style:normal;font-size:30px;font-wieght:1000;color:#fff;background:skyblue;border-radius:100%;}
.qna_w input{display:inline-block;width:40%;line-height:36px;font-size:18px;color:#skyblue;text-align:center;border:none;border-bottom:3px solid skyblue;text-align:center;margin-right:30px; margin-top:0;#fff;}





</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">




</head>
<body>
	<%
		String join_name = (String) session.getAttribute("join_name");

	String save = request.getParameter("save");
	String no_save = request.getParameter("no_save");
	String join_fail = request.getParameter("join_fail");
	String login_fail = request.getParameter("login_fail");
	String update_success = request.getParameter("update_success");
	String join_success = request.getParameter("join_success");
	String no_success = request.getParameter("no_success");

	MemberDTO info = (MemberDTO) session.getAttribute("login_info");
	//로그인 id,pw,name 들어있는 객체 = info

	String img_name = request.getParameter("img_name");
	String img_text = request.getParameter("img_text");
	// 저장된 이미지
	
	
	String imgtestpp="images/s4.jpg";
	
	double random_value = Math.random();
	int random_num=(int)(random_value *30);
	// 랜덤함수 0~29 까지
	
	int num=0;
	
	
	String Random_img[] = new String[30];
	for(int i=0; i<30; i++){
		Random_img[i]= "pic"+(i+1)+".jpg";
	}
	 // 이미지 넣는 로직
	 
	 
	 
	String Random_text[]= new String[30]; 
     Random_text[0]="Two horses are running through a field";
     Random_text[1]="People are eating food at kitchen and a young boy is sitting on the chair";
     Random_text[2]="A group of children and adults are gathered around the table";
     Random_text[3]="A sandwich and fries are shaped as a heart";
     Random_text[4]="Groceries are displayed with fruits vegetables caned and packaged goods";
     Random_text[5]="A cat is sleeping on an outdoor bench";
     Random_text[6]="A big truck is parked on a camping ground";
     Random_text[7]="The police officer is waving hand on a motorcycle";
     Random_text[8]="Two giraffes are looking around by the tree";
     Random_text[9]="There are brown cake and strawberries on the plate";
     Random_text[10]="A group of giraffes are standing next to the rhinos";
     Random_text[11]="A bunch of food is piled on top of the table";
     Random_text[12]="A large bird is waddling on the beach";
     Random_text[13]="A dark colored airplane sitting on a runway";
     Random_text[14]="An artistic vase with a yellow flower and two roses is placed on table";
     Random_text[15]="A wooden bench is placed next to a green fence in the amusement park";
     Random_text[16]="A spotted cat is rolling around by the laptop";
     Random_text[17]="A man playing tennis on a court with a tennis racket";
     Random_text[18]="A woman with child and dog sit on the grass in front of a bench";
     Random_text[19]="A man is riding a skateboard down a rural road";
     Random_text[20]="A dog wrapped in a blanket while sleeping on a bed";
     Random_text[21]="A yellow school bus is traveling down a road filled with traffic";
     Random_text[22]="Two teams of girls are playing soccer";
     Random_text[23]="Four giraffes are resting next to a tree";
     Random_text[24]="A little boy is sitting on a wooden rocking chair";
     Random_text[25]="A woman is riding a surfboard in a skimpy outfit";
     Random_text[26]="A white table topped with small white plates filled with chocolate and baking ingredients ";
     Random_text[27]="A river filled with lots of boats next to tall buildings ";
     Random_text[28]="Baseball batter waiting for ball while umpire holds in glove  out";
     Random_text[29]="A train is standing at the station under tree";
    		 
     System.out.println("random_num="+random_num);
     
     /* 
    		 ---------랜덤게임 로직 */
 	Random rd=new Random();
	int random_number1=0;
	int random_number2=0;
	String random_blank="____";
	
	String before_split=Random_text[random_num];
	// brefore_split 에 랜덤택스트 를 담고
	String[] after_split=before_split.split(" ");
	// after_sprit 스프릿에 배열로담앗어
	
	while(true){
		random_number1=rd.nextInt(after_split.length);
		// a cat 이라하면  배열로 [0][1] 에 a, cat 들어가고 길이요소가 2개니깐 rd.nextint 
		random_number2=rd.nextInt(after_split.length);
		// 빈칸을 주는 로직
		if(random_number1<random_number2){
			break; //가장가까운 반복문 하나를 탈출
		}
	}
	
String	one=after_split[random_number1];
       // 랜덤 넘버 1 에 __________있는 답
String	two=after_split[random_number2];
	// 랜덤 넘버2 에 ______있는 답 
	String[] answer_split=after_split;
	
	
String three="First hint"+one+("  ")+"Second hint"+("  ")+two;

System.out.println("three="+three);
	
	
	
	after_split[random_number1]=random_blank;
	// 첫번쨰 밑줄
	after_split[random_number2]=random_blank;
	// 두번쨰 밑줄
	
	
	
	String[] read= new String[30];
	String read2=" ";
	if(read !=after_split ){
		for(int i=0; i<after_split.length; i++){
			if(after_split[i]!=after_split[random_number1] && after_split[i]!=after_split[random_number2] ) {
				read2=read2+after_split[i];
				read2=read2+" ";
			}
		}
		
		
	}
	  System.out.println("read2="+ read2);
	//read2는 폐기 안쓸거임
	
	
	   System.out.println("answer="+ answer_split[0]+" ");
	
      String oneline="";
	
	for(int i=0; i<answer_split.length; i++){
		
		oneline=oneline+answer_split[i];
		oneline = oneline+ " ";
		
	}
	
	
	   System.out.println("oneline="+ oneline);
	 
	  
	
	// 스플릿 된 after_split 을 한줄로 만들기 위한 작업
     
    
	 
	 
	%>





	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary"
			class="js-fullheight text-center">

			<h1 id="colorlib-logo">
				<a href="main.jsp" style="color: black;">Imagine Learn<span
					style="color: black;">.</span></a>
			</h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li class="colorlib-active"><a href="main.jsp">Home</a></li>
				
					<li><a href="main.jsp">로그인 하러 가기!</a></li>
					<li><a href="upload.jsp">사진 업로드!</a></li>
					<li><a href="game.jsp">게임 하러가기!</a></li>
					<%if (info != null) {%>
					<li><a href="update.jsp">회원 정보 수정</a></li>
					<%}%>
					<%if (info != null) {%>
					<li><a href="../logout">로그 아웃</a></li>
					<%}%>
				</ul>
			</nav>
<% if (info != null) {%>
			<div class="colorlib-footer">
				<p>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						class="icon-heart" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
				<ul>
					<li><a href="#"><i class="icon-facebook"></i></a></li>
					<li><a href="#"><i class="icon-twitter"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin"></i></a></li>
				</ul>
			</div>
		</aside>
		<!-- END COLORLIB-ASIDE -->




		<div id="colorlib-main">



			<div>
				<!-- <div class="overlay"></div>	 -->
				
<div align="center" style="margin:20px 0 40px 0" >
           
					<img src="images/<%=Random_img[random_num] %>"  id="Random_img"  style="width: 800px; height: 400px;" >
</div>
                  
		

<div id="qna_wrap">
	<div class="qnaQ">
		<div class="qna_w">
			<em >Q</em>
			<div class="q_text"><p id="hint"   style="color:blue;line-height:30px;font-size:24px;text-align:center;display: block ;"><%=oneline%> </p></div>
		</div>
	</div>
	
	<div class="qnaQ" id="answer" style="display: none;">
		<div class="qna_w" style="background:skyblue;border:none;">
			<div class="q_text"><p id="hint2" style="color:blue; font-size:30px; text-align:center;"><%=before_split%> </p></div>
			<div style="display: none;"><p id=hint3><%=three %></p></div>
		</div>
	</div>
	
	<div class="qnaA" align="center">
		<div class="qna_w">
			<em>A</em>
			<b id="blank_txt" style="font-size:26px;color:orange;margin:-15px 0 10px 0;">빈칸을 채워주세요.</b>
			
			<input type="text" id="check1" placeholder="1번 정답을 입력해주세요"  >
			<input type="text" id="check2" placeholder="2번 정답을 입력해주세요.">
		</div>
	</div>
</div>

				
			</div>
			</div>
		
		

				<div align="center" style="positon:relative; float:left;  width:100%;background:white;margin-top: -20px;margin-left:240px">
					<div class="buttons main-container" style="positon:relative;float:left;width:100%;">
					
						<input type="button" onclick="check()" class="btn-2" value="정답확인" style="margin:0 10px;border-radius:20px;">
						<input type="button" onclick="answer()" class="btn-4" value="정답 문장 보기" style="margin:0 10px;border-radius:20px;">	
						<input type="button" onclick="location.href='game.jsp'" class="btn-3" value="다 음 문 제" style="margin:0 20px;border-radius:20px;">	

                	</div>
				</div>
						




					


						
     </div>
						</div>
						<!-- End of Button 4 -->
	</section>




<%}%>

	<%if (info == null) {%>
<div class="hero-wrap js-fullheight">

<div style="position:fixed;left:850px;top:80px;width:800px;height:800px;background:url(images/w1.png) no-repeat;background-size:100% ;">
	<h1 style="position:relative;font-size: 35px; color:black; text-align: center; z-index:10000000;margin-top:443px; margin-left:20px "  ><a style="color: black" href="main.jsp">로그인을 시작해주세요. </a></h1>
</div>
	
<div align="center" style="padding-left: 100px; padding-top: 500px">
</div>
	
</div>
<%} %>

	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/jquery.timepicker.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>




	<script type="text/javascript">
		function fontView() {

			let p = document.querySelector('#img_txt'); //요소(태그)객체
			let p_display_val = p.style.display; //요소객체의 display 속성값 접근

			if (p_display_val === 'none') { //off
				p.style.display = 'block'; //on

			} else if (p_display_val === 'block') {
				p.style.display = 'none';
			}
		}


		
	
		
	
		function after(){
			
			
			
			document.getElementById("Random_img").src = "images/<%=Random_img[random_num]%>";
			alert("<%=Random_img[random_num]%>");
			
		
			
		
			
		}
		
		function answer(){
			let p =document.getElementById("answer");
			let p_display_val = p.style.display; //요소객체의 display 속성값 접근

			if (p_display_val === 'none') { //off
				p.style.display = 'block'; //on

			} else if (p_display_val === 'block') {
				p.style.display = 'none';
			}
			
		}
		//정답 스크립트
		
		function check(){
			 
			let one1 = document.getElementById("check1").value;
			let two2 = document.getElementById("check2").value;
			let blank_txt =document.getElementById("blank_txt").innerHTML;
			let blank_txt2 =document.getElementById("blank_txt");
			 var speak = document.getElementById("blank_txt");
			
			
			var one="<%=one%>";
			var two="<%=two%>";
			
	          if(one1 != one && two2 != two ) {
			/* 
				document.getElementById("check1").value="틀렸습니다";
				document.getElementById("check2").value="틀렸습니다"; */
				document.getElementById("blank_txt").innerHTML=" Borth words are incorrect";
				                                                        //둘다 틀렸습니다
				 blank_txt2.style.color = "red";   
			    speech(speak.innerHTML);
			    document.getElementById("blank_txt").innerHTML=" 둘다 틀렸습니다";
	          }
	          else if(one1 == one && two2 == two){
	        	 /*  document.getElementById("check1").value="정답입니다";
					document.getElementById("check2").value="정답입니다"; */
					let blank_txt =document.getElementById("blank_txt").innerHTML=" Good job, you're right! ";
					                                                                 //정답입니다
					 blank_txt2.style.color = "blue"; 
				    speech(speak.innerHTML);
				    document.getElementById("blank_txt").innerHTML=" 정답입니다";
	          }	
	          else if (one1 != one && two2==two){
	        	/*   document.getElementById("check1").value="틀렸습니다";
				 document.getElementById("check2").value="정답입니다"; */
				let blank_txt =document.getElementById("blank_txt").innerHTML="First word is wrong ";
				 blank_txt2.style.color = "red";    
				 //첫번쨰 빈칸이 틀렸습니다
				
			    speech(speak.innerHTML);
			    document.getElementById("blank_txt").innerHTML=" 첫번쨰 빈칸이 틀렸습니다";
	          }
	          
	          else if (one1 == one && two2 != two){
	        	/*   document.getElementById("check1").value="정답입니다";
					document.getElementById("check2").value="틀렸습니다"; */
					let blank_txt =document.getElementById("blank_txt").innerHTML=" Second word is wrong";
					 blank_txt2.style.color = "red";                                   //두번쨰 빈칸이 틀렸습니다
				    speech(speak.innerHTML);
				    document.getElementById("blank_txt").innerHTML=" 두번쨰 빈칸이 틀렸습니다";
	        	  
	          }
			
				
			
			
		   }
		
		
		
		
			
			window.onload=function(){
				read=document.getElementById("hint2")
				read2=document.getElementById("hint3")
				document.getElementById("hint").onclick=function(){
					//문제 클릭시
					speech(read2.innerHTML)
				}		
		
				
				document.getElementById("hint2").onclick=function(){
					speech(read.innerHTML)
					//정답보기 문제 클릭시
				}		
		
			}
	 // 동적으로 퀘스트 아이디에 온클릭속성 부여 -> 문제 문구 클릭하면 소리로 출력
		
		
		var voices = [];
		function setVoiceList() {
		voices = window.speechSynthesis.getVoices();
		}
		setVoiceList();
		if (window.speechSynthesis.onvoiceschanged !== undefined) {
		window.speechSynthesis.onvoiceschanged = setVoiceList;
		}
		function speech(txt) {
		if(!window.speechSynthesis) {
		alert("음성 재생을 지원하지 않는 브라우저입니다. 크롬, 파이어폭스 등의 최신 브라우저를 이용하세요");
		return;
		}
		//en-US
		//ko-KR
		var lang = 'en-US';
		var utterThis = new SpeechSynthesisUtterance(txt);
		utterThis.onend = function (event) {
		console.log('end');
		};
		utterThis.onerror = function(event) {
		console.log('error', event);
		};
		var voiceFound = false;
		for(var i = 0; i < voices.length ; i++) {
		if(voices[i].lang.indexOf(lang) >= 0 || voices[i].lang.indexOf(lang.replace('-', '_')) >= 0) {
		utterThis.voice = voices[i];
		voiceFound = true;
		}
		}
		if(!voiceFound) {
		alert('voice not found');
		return;
		}
		utterThis.lang = lang;
		utterThis.pitch = 1;
		utterThis.rate = 0.8; //속도
		window.speechSynthesis.speak(utterThis);
		}
		
		   
		
			
			
		
		</script>
		
	
	
	
	
	
	








</body>
</html>
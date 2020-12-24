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

:root{
	--body-background-color: white;
	--font-color: #4e4e4e;
	--border-gray-color : #FE9A2E;
	--naver-green-color: #FE9A2E;
	--naver-green-border-color: #FE9A2E;
}

*{
	margin:0;
	padding:0;
}

body{
	background:var(--body-background-color);
}
.main-container{
	width:100%;
	display:flex;
	flex-direction:column;
	align-items:center;
	margin-top: 21px;
}
.main-container .main-wrap{
	width:768px;
}
.main-container .main-wrap .sel-lang-wrap .lang-select
{
	width: 96px;
	height: 30px;
	color: var(--font-color);
	border: solid 1px var(--border-gray-color);
}
.main-container .main-wrap .logo-wrap{
	padding-top:55px;
}
.main-container .main-wrap .logo-wrap img
{
	width: 300px;
	height: 150px;
}

.main-container .main-wrap header .sel-lang-wrap{
	display:flex;
	justify-content:flex-end;
}

.main-container .main-wrap header .logo-wrap{
	display:flex;	
	flex-direction: column;
	align-items: center;
}
.login-input-section-wrap{
	padding-top: 0px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.login-input-wrap{
	width: 465px;
	height :48px;
	border: solid 1px var(	--border-gray-color );
	
	background: white;
}
.password-wrap{
	margin-top: 13px;
}



.login-input-wrap input{
	border: none;
	width:430px;
	margin-top: 10px;
	font-size: 23px;
	margin-left: 10px;
	height:30px;
}
.login-button-wrap {
	padding-top: 13px;
}
.login-button-wrap button{
	width: 465px;
	height :48px;
	font-size: 25px;
	background: #FE9A2E;
	color: white;
	border: solid 1px var(--naver-green-border-color);
}
.login-stay-sign-in{
	width: 465px;
	height: 52px;
	
	display: flex;
	font-size: 15px;
	color: #4e4e4e;
	align-items: center;
	justify-content: flex-start;
	border-bottom: solid 1px var(--border-gray-color);
}
.login-stay-sign-in i{
	font-size: 25px;
	color: #9ba1a3;
}
.login-stay-sign-in span{
	padding-left: 5px;
	line-height: 25px;
}

.Easy-sgin-in-wrap{

	display: flex;
	flex-direction: column;
	align-items: center;
	padding-top: 40px;

}
.Easy-sgin-in-wrap h2{
	font-size: 20px;
}
.Easy-sgin-in-wrap .sign-button-list
{
	padding-top:25px;
	list-style: none;
	width: 465px;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.Easy-sgin-in-wrap .sign-button-list li{
	padding-bottom: 10px;
}
.Easy-sgin-in-wrap .sign-button-list li button{
	width: 465px;
	height: 56px;
	border: solid 1px var(--border-gray-color);
	text-align: left;
	background: white;
}
.Easy-sgin-in-wrap .sign-button-list li button i{
	padding-left: 15px;
	font-size: 20px;
}
.fa-qrcode
{
	color:var(--naver-green-color);
}
.fa-line{
	color:var(--naver-green-color);
}
.fa-facebook-square
{
	color:#4064ac;
}
.Easy-sgin-in-wrap .sign-button-list li button span{
	padding-left: 20px;
	font-size: 18px;
}
.Easy-sgin-in-wrap .forget-msg{
	color:var(--font-color);
	font-size: 14px;
	padding-top: 10px;

}
footer{
   
	padding-top: 95px;
	padding-bottom: 15px;

	display:flex;
	flex-direction:column;
	align-items:center;
	width:768px;



}
.copyright-wrap{

	display: flex;
	flex-direction: column;
	align-items: center;
	height: 15px;


}
footer .copyright-wrap span img{
	width: 59px;
	
	height: 11px;
}
footer .copyright-wrap span{
	font-size: 13px;
	line-height: 15px;
}


.containerLogout{
	display: flex;
	flex-direction: row-reverse;
	A:link {
		color : red;
	};
	A:visited {
		color : red;
};
	font-size: 60px;
}


/* 버튼 시작 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html,
body {
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
/* 
.buttons {
	display: table-cell;
	padding: 1em;
	text-align: center;
	vertical-align: middle;
} */

[class*="btn-"] {
	position: relative;
	display: inline-block;
	width: 100%;
	color: #fff;
	font-size: 43px;
	line-height: 100px;
	margin-right:2em;
	max-width: 240px;
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





</style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700" rel="stylesheet">

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

   
    String join_name= (String)session.getAttribute("join_name");

	String save = request.getParameter("save");
	String no_save = request.getParameter("no_save");
	String join_fail = request.getParameter("join_fail");
	String login_fail = request.getParameter("login_fail");
	String update_success = request.getParameter("update_success");
	String join_success = request.getParameter("join_success");
	String no_success = request.getParameter("no_success");
	
	
	MemberDTO info = (MemberDTO) session.getAttribute("login_info");
	//로그인 id,pw,name 들어있는 객체 = info
			
String img_name= request.getParameter("img_name");
String img_text= request.getParameter("img_text");




	// 저장된 이미지
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 System.out.println("img_name="+ img_text);
			 
	%>
	
	


	<div id="colorlib-page" >
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight text-center" >
		
			<h1 id="colorlib-logo"><a href="main.jsp"style="color:black;">Imagine Learn<span style="color:black;">.</span></a></h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li class="colorlib-active"><a href="main.jsp">Home</a></li>
					
					
					
					
			      	<li><a href="main.jsp">로그인 하러가기!</a></li>
					<li><a href="upload.jsp">사진 업로드!</a></li>
					<li><a href="game.jsp">게임 하러가기!</a></li>
					<%if (info !=null) {%>
					<li><a href="update.jsp">회원 정보 수정</a></li>
					<%} %>
					<%if (info !=null) {%>
					<li><a href="../logout">로그 아웃</a></li>
					<%} %>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
				<ul>
					<li><a href="#"><i class="icon-facebook"></i></a></li>
					<li><a href="#"><i class="icon-twitter"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin"></i></a></li>
				</ul>
			</div>
		</aside> <!-- END COLORLIB-ASIDE -->
		
		<%if (info!= null) {%>
		
		
		<div id="colorlib-main">
			
			
		
			<div >
				<!-- <div class="overlay"></div>	 -->			
				<div align="center" style="margin-top: 20px;">		
				
				<%if(img_name == null) {%>
				 <img src="images/up3.png"  style=" width:45%; height:auto;">
               <%} %>
               
                <!-- 가이드 화면 -->
                 
				<%if(img_name != null) {%>
				 <img src="../img/<%=img_name%>"  style=" width:35%; height:auto; ">
                <%} %>
                <!-- 사진 출력 화면 -->
         
		
	</div>
	</div>
	<%if (img_text != null) {%>
	
	<p id="img_txt" style="font-size: 40px; color:#FE9A2E; display:none; text-align: center; margin-top:10px "><%=img_text %> </p>
	
	<%} %>
	<%if (img_text ==null) {%>
	<h1 id="img_txt" style="font-size: 55px; color:#FE9A2E; display:block; text-align: center;  margin-top: -30px; margin-bottom: 50px"autocomplete="off;"  >Imagine  Learn
	</h1>
	<%} %>
	<div align="center" style="margin-top: 20px">
	
	<div class="buttons">
		
		<!-- Start of Button 1 -->
		<input type="button" onclick="location.href='upload.jsp'" class="btn-1" value="속도조절" style="margin-left: 100px; border-radius: 30px; ">
		
		<!-- End of Button 1 -->
		
		<!-- Start of Button 2 -->
		<input type="button" onclick="fontView()" class="btn-2" value="글자보기" style="border-radius: 30px;">
		<!-- End of Button 2 -->
		
		<!-- Start of Button 3 -->
		<input type="button" onclick="font_voice()" class="btn-3" value="소리듣기" style="border-radius: 30px;">
		<!-- End of Button 3 -->
		
		<!-- Start of Button 4 -->
		
		<input type="button" onclick="location.href='uploadbutton.jsp'" class="btn-4" value="사진 업로드"  style="border-radius: 30px;" >

		
		
		<!-- End of Button 4 -->
                     	</div>
                        </div>
						</div>
			     		</div>
			
		</div>
		
		<%} %>
		
		
		
	<%if (info == null) {%>
<div class="hero-wrap js-fullheight">

<div style="position:fixed;left:850px;top:80px;width:800px;height:800px;background:url(images/w1.png) no-repeat;background-size:100% ;">
	<h1 style="position:relative;font-size: 35px; color:black; text-align: center; z-index:10000000;margin-top:443px; margin-left:20px "  ><a style="color: black" href="main.jsp">로그인을 시작해주세요. </a></h1>
</div>
	
<div align="center" style="padding-left: 100px; padding-top: 500px">
</div>
	
</div>
<%} %>
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
  
  
  <!-- 자바스크립트 이미지 태그 추가 createElement 
  시간지연함수 settimeouy  -->
 
	<script>
		function fontView(){
			
			let p = document.querySelector('#img_txt'); //요소(태그)객체
			let p_display_val = p.style.display; //요소객체의 display 속성값 접근
			
			if(p_display_val === 'none'){    //off
				p.style.display = 'block'; //on
				
			}else if(p_display_val === 'block'){
				p.style.display = 'none';			
			}
		}
		
		function fontVoice(){
			let p = document.querySelector('#img_txt'); 
			let text = p.innerHTML; //<tag명>내용</tag명> << 내용을 접근할 때
			
			//Voice API를 넣으시오.
			
		}
	</script>
  
  
<script>
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
function font_voice(){
    var t = document.getElementById("img_txt");
    speech(t.innerHTML);
}
</script>
  
  
  
    
  </body>
</html>
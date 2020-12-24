<%@page import="com.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
outline:0px;
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

input:focus {
    outline:0px;
   	width: 465px;
	height :48px;
	border: solid 1px var(	--border-gray-color );
	
	background: white;
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
	
	%>
	
	
	
	<%if (info!=null) {%>
	<% if("y".equals(update_success)){%>
	<script type="text/javascript">
	alert("  <%=info.getName() %>님 정보가 수정되었습니다 ")
	</script>
	<%} %>
	<%} %>
	
		
	
	
	<% if("y".equals(join_success)){%>
	<script type="text/javascript">
	alert("  <%=join_name %>님  회원가입이 성공적으로 되었습니다 ")
	</script>
	<%} %>
	
	
	<% if("n".equals(join_fail)){%>
	<script type="text/javascript">
	alert("  회원가입실패 정보를 확인해주세요 ")
	</script>
	<%} %>
	
	
	
		
	<%if (info==null) {%>
	<% if("n".equals(login_fail)){%>
	<script type="text/javascript">
	alert("  로그인 실패하였습니다 ")
	</script>
	<%} %>
	<%} %>
	
	

	
	
	
	
<%-- 	
    <%  if("y".equals(save)){%>
	<script type="text/javascript">
	alert("회원 가입 성공 ! <%=join_name %>님 로그인을 해주세요.")
	</script>
	<%} %>
	
	
	
		
    <%  if("n".equals(no_save)){%>
	<script type="text/javascript">
	alert("회원 가입 실패 기입란에 정보를 다 기입 해주세요!.")
	</script>
	<%} %>
	
 --%>	 

 










	<div id="colorlib-page" >
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight text-center" >
		
			<h1 id="colorlib-logo"><a href="main.jsp"style="color:black;">Imagine Learn<span style="color:black;">.</span></a></h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li class="colorlib-active"><a href="main.jsp">Home</a></li>
					<%if (info ==null) {%>
					<li><a href="join.jsp">회원 가입</a></li>
					<%} %>
					
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
		
		
		
		<%if (info==null) {%>
		<div id="colorlib-main">
			
			
			
			<div class="hero-wrap js-fullheight" style="background-image:url(images/z1.jpg); " data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				
				
				<div class="js-fullheight d-flex justify-content-center align-items-center">
					<div class="col-md-8 text text-center">
					
						
<div style="position:relative;width:250px;height:250px;margin:0 auto;padding:30px 20px 20px 20px;background:#fff;border-radius:100%;z-index:1000000; ">
	<img src="images/logo.PNG" width="100%" />           <!-- border-radius:100% width :250px ; height:250px; 원만들기 -->
</div>
						<div class="desc">
							<h1  style = " font-size:3.5em;">Imagine <span style="color: #FE9A2E">Learn</span></h1>
						
							    <form action="../LoginServiceController" method="post">
	<div class="main-container"> </div>
		<div class="main-wrap">   </div>
		                      
		
	
		<section class="login-input-section-wrap">
			<div class="login-input-wrap">	
				<input placeholder="아이디를 입력해주세요" type="text" name=id ></input>
				
			</div>
			<div class="login-input-wrap password-wrap">	
				<input placeholder="비밀번호를 입력해주세요" type="password" name=pw></input>
			</div>
			<div class="login-button-wrap" >
				<button style="border-radius: 30px !important;">로 그 인 하 기</button>
				
			</div>
	
		
		</form>
	   
		
	</div>
	</div>
						</div>
					</div>
				</div>
				
					
			</div>
			
			 <%} %> 
			 	
		<%if (info!=null) {%>
		<div id="colorlib-main">
			
			
			
			<div class="hero-wrap js-fullheight" style="background-image:url(images/z3.jpg); " data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				
				
				<div class="js-fullheight d-flex justify-content-center align-items-center">
					<div class="col-md-8 text text-center">
					
						<div class="img mb-4" style="background-image: url(images/logo.PNG); "></div>
						<div class="desc">
							<h1  style = " font-size:3.5em;">Imagine Learn</h1></div>
								<div>
								<h1  style = " font-size:7em; color:#FE9A2E; line-height:130px !important;">Welcome</h1>
						</div>
							    <form action="../LoginServiceController" method="post">
	<div class="main-container">
		<div class="main-wrap"> 
		                    
	
		<section class="login-input-section-wrap">


	
		
		</form>
	   
		
	</div>
	</div>
						</div>
					</div>
				</div>
				
					
			</div>
			
			 <%} %> 
		
			
	
  <!-- loader -->
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
    
  </body>
</html>
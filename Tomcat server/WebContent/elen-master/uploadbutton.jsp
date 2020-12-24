<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>



<style type="text/css">


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
	background: white;
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
	font-size: 35px;
	line-height: 150px;
	margin-right:3em;
	max-width: 150px;
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
.btn-2 {
	background: #FF7012;
	border: 1px solid white;
	box-shadow: 0 2px 0 #F15F5F, 2px 4px 6px #F15F5F;
	font-weight: bold;
	letter-spacing: 1px;
	-webkit-transition: all .15s linear;
	transition: all .15s linear;
}
.btn-2:hover {
	background: #FF5E00;
	border: 1px solid rgba(0, 0, 0, 0.05);
	box-shadow: 1px 1px 2px rgba(255, 255, 255, 0.2);
	color: #ec817d;
	text-shadow: -1px -1px 0 #c2211c;
}


---------------------고양이 스타일 -----------------


</style>
</head>
<body translate="no">


<style>
.cat {
  position: relative;
  width: 100%;
  max-width: 500px;
  text-align:center;
  overflow: hidden;
  background-color: white;
}
.cat::before {
  content: '';
  display: block;
  padding-bottom: 100%;
}
.cat:hover > * {
  -webkit-animation-play-state: paused;
          animation-play-state: paused;
}
.cat:active > * {
  -webkit-animation-play-state: running;
          animation-play-state: running;
}

.cat__head, .cat__tail, .cat__body {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  -webkit-animation: rotating 2.79s cubic-bezier(0.65, 0.54, 0.12, 0.93) infinite;
          animation: rotating 2.79s cubic-bezier(0.65, 0.54, 0.12, 0.93) infinite;
}
.cat__head::before, .cat__tail::before, .cat__body::before {
  content: '';
  position: absolute;
  width: 50%;
  height: 50%;
  background-size: 200%;
  background-repeat: no-repeat;
  background-image: url("images/cat.png");
}

.cat__head::before {
  top: 0;
  right: 0;
  background-position: 100% 0%;
  -webkit-transform-origin: 0% 100%;
          transform-origin: 0% 100%;
  -webkit-transform: rotate(90deg);
          transform: rotate(90deg);
}

.cat__tail {
  -webkit-animation-delay: .2s;
          animation-delay: .2s;
}
.cat__tail::before {
  left: 0;
  bottom: 0;
  background-position: 0% 100%;
  -webkit-transform-origin: 100% 0%;
          transform-origin: 100% 0%;
  -webkit-transform: rotate(-30deg);
          transform: rotate(-30deg);
}

.cat__body {
  -webkit-animation-delay: .1s;
          animation-delay: .1s;
}
.cat__body:nth-of-type(2) {
  -webkit-animation-delay: .2s;
          animation-delay: .2s;
}
.cat__body::before {
  right: 0;
  bottom: 0;
  background-position: 100% 100%;
  -webkit-transform-origin: 0% 0%;
          transform-origin: 0% 0%;
}

@-webkit-keyframes rotating {
  from {
    -webkit-transform: rotate(720deg);
            transform: rotate(720deg);
  }
  to {
    -webkit-transform: none;
            transform: none;
  }
}

@keyframes rotating {
  from {
    -webkit-transform: rotate(720deg);
            transform: rotate(720deg);
  }
  to {
    -webkit-transform: none;
            transform: none;
  }
}
.box {
  display: -webkit-box;
  display: flex;
  -webkit-box-flex: 1;
          flex: 1;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
          flex-direction: column;
  -webkit-box-pack: start;
          justify-content: flex-start;
  -webkit-box-pack: center;
          justify-content: center;
  -webkit-box-align: center;
          align-items: center;
  background-color: #e6dcdc;
}


.dim {display:none; position:fixed; z-index:10; top:0; left:0; width:100%; height:100%; background:white; }
.pop {display:none; position:fixed; z-index:20; top:50%; left:50%;  width:700px; height:700px; padding:70px 100px; margin-top:-450px; margin-left:-250px; background:white;}
.pop .btn_close {position:absolute; top:0; right:0;}
</style>

<div id="wrap">
   <div class="pop">
      <div class="cat">
         <div class="cat__body"></div>
         <div class="cat__body"></div>
         <div class="cat__tail"></div>
         <div class="cat__head"></div>
      <div>
       
         </div>
      </div>
      <p align="center" style="width:100%;font-size:30px; color: #FF5E00; margin-top:50px;">로딩중입니다..  </p>
	  <p align="center" style="width:100%;font-size:30px; color: #FF5E00; margin-top:20px;">잠시만 기다려주세요 <span style="color: red">♥</span> </p>
   </div>
   
</div>




<form action="../uploads" method="post" enctype="multipart/form-data">

<div align="center" style="position:relative;width:640px;height:640px;text-align:center;margin:0 auto;margin-top:100px;background-image:url(images/w3.png);" >
					
	<div align="center" style="float:left;width:100%;text-align:center;margin:290px 0 0 40px;">
		<input name="fileName" type="file" >
	</div>
	
	<div align="center" style="float:left;width:100%;text-align:center;padding-top:30px;margin-left:40px;">
		<input type="submit"  class="btn-2 btn_open "  value="완료" style="border-radius:100%;"> 
	</div>
	
</form>
						
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script>
// 열기버튼 클릭시

	
$('.btn_open').on('click', function(){
   $('.pop').css('display','block')
   // .dim은 #wrap의 마지막 자식으로 들어감
   $('#wrap').append('<div class="dim"></div>')
   $('.dim').css('display','block');
});

// 닫기버튼 클릭시 
$('.btn_close').on('click', function(){
   $('.pop').css('display','none');
   $('.dim').css('display','none');
   $('.dim').remove();
});

// 바깥에 클릭시 (동적 이벤트)
$(document).on('click','.dim', function() {
   $('.btn_close').trigger('click');
});
</script>
</body>
</html>
</html>
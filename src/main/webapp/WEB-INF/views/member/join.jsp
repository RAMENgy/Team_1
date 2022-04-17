<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>오늘 뭐먹지? : 회원가입</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
 <jsp:include page="../inc/postcode.jsp"></jsp:include>
 <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript">
 
	var userid=0;
 	$(document).ready(function(){
 		// id="ibtn" 중복확인 클릭
 		$('#userid').blur(function(){
//  			alert("메시지");
 			$.ajax({
 				url:'${pageContext.request.contextPath }/member/idcheck',
 				data:{"userid":$('#userid').val()},
 				success:function(rdata){
 					if(rdata=='iddup'){
 						userid=1;
 						rdata="이미 사용중인 아이디 입니다";
 					}else{
 						userid=0;
 						rdata="사용가능한 아이디 입니다";
 					}
 					$('#iddiv').html(rdata);
 				}
 			});
 		});//
 	});//

 	$(document).ready(function(){
 		$('#join').submit(function(){
//  			alert("전송");
// 				아이디 비밀번호 이름 이메일 비어있으면 제어
				if($('#userid').val()==""){
					alert("아이디 입력하세요");
					$('#userid').focus();
					return false;
				}

				
				if($('#password').val()==""){
					alert("비밀번호 입력하세요");
					$('#password').focus();
					return false;
				}
				if($('#password').val()!=$('#password2').val()){
					alert("비밀번호 틀림 입력하세요");
					$('#password2').focus();
					return false;
				}
				
				if($('#name').val()==""){
					alert("이름 입력하세요");
					$('#name').focus();
					return false;
				}
				
				if($('#address').val()==""){
					alert("주소 입력하세요");
					$('#address').focus();
					return false;
				}
				
				if($('#tel').val()==""){
					alert("휴대전화 입력하세요");
					$('#tel').focus();
					return false;
				}
				
				if(userid==1) {
					alert("중복된 아이디입니다.");
					return false;
				}
				
 		});//


});//
 </script>
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 본문메인이미지 -->
<div id="sub_img_member"></div>
<!-- 본문메인이미지 -->
<!-- 왼쪽메뉴 -->
<!-- <nav id="sub_menu"> -->
<!-- </nav> -->
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>회원가입</h2>
                        <form action="${pageContext.request.contextPath }/member/joinPro" method="post" id="join">
                            <div class="group-input">
                                <label for="userid">아이디</label>
                                <input type="text" id="userid" name="userid">
								<label></label><div id="iddiv"></div>
                            </div>
   
                            <div class="group-input">
                                <label for="password">비밀번호</label>
                                <input type="password" id="password" name="password">
                            </div>
                            
                             <div class="group-input">
                                <label for="password">비밀번호 확인</label>
                                <input type="password" id="password2" name="password2">
                            </div>
                            
                             <div class="group-input">
                                <label for="name">이름</label>
                                <input type="name" id="name" name="name">
                            </div>
                            
                            <div class="group-input">
                                <label for="address">주소</label>
                                <input type="address" id="address" name="address">
                                <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                            </div>

                            <div class="group-input">
                                <label for="tel">휴대전화</label>
                                <input type="tel" id="tel" name="tel">  
                            </div>
                            
                            <button type="submit" class="site-btn login-btn">회원가입</button>
 
 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->    
 
<article>
</article>

</div>

 <!-- Register Form Section End -->

    <!-- Partner Logo Section Begin -->
    <jsp:include page="../inc/partner.jsp"></jsp:include>
    <!-- Partner Logo Section End -->

    <!-- Footer Section Begin -->
    <jsp:include page="../inc/bottom.jsp"></jsp:include>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <jsp:include page="../inc/js.jsp"></jsp:include>

</body>
</html>
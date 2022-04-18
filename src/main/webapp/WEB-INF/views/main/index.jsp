<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>오늘 뭐 먹지?</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <jsp:include page="../inc/css.jsp"></jsp:include>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
   
    <jsp:include page="../inc/top.jsp"></jsp:include>
    
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero-items owl-carousel">
            <div class="single-hero-items set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                        	<c:forEach var="n1" items="${sessionScope.notice1 }">
                            <span>공지사항</span>
                            <h1><fmt:formatDate value="${n1.date}" pattern="yyyy.MM.dd"/><br>공지사항</h1>
                            <p>${n1.subject }</p>
                            <a href="${pageContext.request.contextPath }/notice/content?id=${n1.id}" class="primary-btn">해당 공지사항 바로가기</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single-hero-items set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/hero-2.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <c:forEach var="n2" items="${sessionScope.notice2 }">
                            <span>이벤트</span>
                            <h1><fmt:formatDate value="${n2.date}" pattern="yyyy.MM.dd"/><br>이벤트</h1>
                            <p>${n2.subject }</p>
                            <a href="${pageContext.request.contextPath }/notice/content?id=${n2.id}" class="primary-btn">해당 이벤트 바로가기</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Banner Section Begin -->
    <div class="banner-section spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4">
                	<a href="${pageContext.request.contextPath }/recipeboard/bestrecipe">
                    <div class="single-banner">
                        <img src="${pageContext.request.contextPath }/resources/img/Team_1-banner.png" alt="">
                        <div class="inner-text">
                            <h4>좋아요 1위 레시피</h4>
                        </div>
                    </div>
                    </a>
                </div>
                <div class="col-lg-4">
                	<a href="${pageContext.request.contextPath }/food/recent">
                    <div class="single-banner">
                        <img src="${pageContext.request.contextPath }/resources/img/Team_1-banner2.png" alt="">
                        <div class="inner-text">
                            <h4>최근 들어온 식자재</h4>
                        </div>
                    </div>
                    </a>
                </div>
                <div class="col-lg-4">
                    <div class="single-banner">
                        <img src="${pageContext.request.contextPath }/resources/img/Team_1-banner3.png" alt="">
                        <div class="inner-text">
                            <h4>지난 인기 레시피 모아보기</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner Section End -->

    <!-- 중간 불필요 페이지 삭제 공란 -->

    <!-- Footer Section Begin -->
    
     <jsp:include page="../inc/bottom.jsp"></jsp:include>
    
    <!-- Footer Section End -->

    <!-- Js Plugins -->
   <jsp:include page="../inc/js.jsp"></jsp:include>
</body>

</html>
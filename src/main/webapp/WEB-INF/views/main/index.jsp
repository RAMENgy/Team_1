<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header-section">
        <jsp:include page="../inc/top.jsp"></jsp:include>
    </header>
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero-items owl-carousel">
            <div class="single-hero-items set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <span>이번주 행사 상품(항목)</span>
                            <h1>행사중인 식재료 이름(제목)</h1>
                            <!-- 모바일은 상관없으나 pc에서는 4글자가 최적
                            아니면 글자 크기를 변경해야 할듯 -->
                            <p>행사 상세 내역 설명란(내용)</p>
                            <a href="#" class="primary-btn">해당 게시글 바로가기</a>
                        </div>
                    </div>
                    <div class="off-card">
                        <h4>부가 설명란 <span>(없어도 될듯)</span></h4>
                    </div>
                </div>
            </div>
            <div class="single-hero-items set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/hero-2.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <span>누적 좋아요 1위 레시피(항목)</span>
                            <h1>해당 레시피 제목(제목)</h1>
                            <!-- 모바일은 상관없으나 pc에서는 4글자가 최적
                            아니면 글자 크기를 변경해야 할듯 -->
                            <p>레시피 내용 간략 설명(내용)</p>
                            <a href="#" class="primary-btn">해당 레시피 바로가기</a>
                        </div>
                    </div>
                    <div class="off-card">
                        <h4>부가 설명란 <span>(없어도 될듯)</span></h4>
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
                    <div class="single-banner">
                        <img src="${pageContext.request.contextPath }/resources/img/Team_1-banner.png" alt="">
                        <div class="inner-text">
                            <h4>이번주 인기 레시피</h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-banner">
                        <img src="${pageContext.request.contextPath }/resources/img/Team_1-banner2.png" alt="">
                        <div class="inner-text">
                            <h4>이번주 인기 식자재</h4>
                        </div>
                    </div>
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
    <footer class="footer-section">
     <jsp:include page="../inc/bottom.jsp"></jsp:include>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/jquery-ui.min.js"></script>
    <script src="../resources/js/jquery.countdown.min.js"></script>
    <script src="../resources/js/jquery.nice-select.min.js"></script>
    <script src="../resources/js/jquery.zoom.min.js"></script>
    <script src="../resources/js/jquery.dd.min.js"></script>
    <script src="../resources/js/jquery.slicknav.js"></script>
    <script src="../resources/js/owl.carousel.min.js"></script>
    <script src="../resources/js/main.js"></script>
</body>

</html>
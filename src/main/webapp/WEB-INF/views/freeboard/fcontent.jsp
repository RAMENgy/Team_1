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
    <title>Fashi | Template</title>

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

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Blog</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Blog Section Begin -->
    <section class="blog-section spad">
        <div class="container">
            <div class="row">
                <!-- 사이드 바 시작 -->
                <jsp:include page="item/side.jsp"></jsp:include>
                <!-- 사이드 바 끝 -->
                <!-- 글 내용 시작 -->
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row container">
		                <table class="table">
							<tr><td>글번호</td><td>${FBDTO.id }</td>
							     <td>글쓴날짜</td><td>${FBDTO.date }</td></tr>
							<tr><td>글쓴이</td><td>${FBDTO.member_id }</td>
							    <td>조회수</td><td>${FBDTO.readcount }</td></tr>
							<tr><td>글제목</td><td colspan="3">${FBDTO.subject }</td></tr>
							
							<tr><td>글내용</td><td colspan="3" style="white-space:pre">${FBDTO.content }</td></tr>
						</table>
						
						<c:if test="${!empty sessionScope.id }">
							<c:if test="${FBDTO.member_id eq sessionScope.id }">
								<button class="btn btn-outline-dark" type="submit" class="btn" onclick="location.href='${pageContext.request.contextPath }/free/update?id=${FBDTO.id }'">글수정</button>
								<button class="btn btn-outline-dark" type="submit" class="btn" onclick="location.href='${pageContext.request.contextPath }/free/delete?id=${FBDTO.id }'">글삭제</button>
							</c:if>
						</c:if>
						<button class="btn btn-outline-dark" type="submit" class="btn" onclick="location.href='${pageContext.request.contextPath }/free/board'">글목록</button>
					</div>
				</div>
                
                <!-- 글 내용 끝 -->
                
            </div>
        </div>
    </section>
    <!-- Blog Section End -->


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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
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
    
     <!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
	#tablebox{
		width: 600px;
		margin: 0 auto;
	}
</style>
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
                    <div class="breadcrumb-text product-more">
                        <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./center.html">Center</a>
                        <span>Notice</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

<body>

<table id="tablebox" class="table">
<tr><td>번호</td><td>${noticeDTO.id}</td>
	<td>작성일</td><td>${noticeDTO.date}</td></tr>
<tr><td>작성자</td><td>${noticeDTO.name}</td>
	<td>조회수</td><td>${noticeDTO.readcount}</td>
<tr><td>제목</td><td colspan="3">${noticeDTO.subject}</td></tr>
<tr><td>글내용</td><td colspan="3">${noticeDTO.content}</td></tr>


<!-- <div> -->
	<tr>
		<td colspan="10">
<c:if test="${ ! empty sessionScope.id }">

	<c:if test="${sessionScope.id eq noticeDTO.member_id}">
	
		
	</c:if>
	
	
</c:if>

<c:if test="${ ! empty sessionScope.userid }">

	<c:if test="${sessionScope.userid eq 'admin'}">
	
<input type="button" value="글수정" class="btn" style="float: right;"
onclick="location.href='${pageContext.request.contextPath }/notice/update?id=${noticeDTO.id}'">
<input type="button" value="글삭제" class="btn" style="float: right;"
onclick="location.href='${pageContext.request.contextPath }/notice/delete?id=${noticeDTO.id}'">	

<input type="button" value="글목록" class="btn" style="float: right;"
onclick="location.href='${pageContext.request.contextPath }/notice/list'">
	</c:if>
</c:if>
		</td>
	</tr>	
</table>



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
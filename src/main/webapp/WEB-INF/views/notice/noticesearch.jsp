<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
    
     <!-- Blog Section Begin -->
    <section class="blog-section spad">
        <div class="container">
            <div class="row">
                <!-- 사이드 바 시작 -->
                <jsp:include page="item/side.jsp"></jsp:include>
                <!-- 사이드 바 끝 -->

<div class="col-lg-9 order-1 order-lg-2">
    <div class="row container">
		<table class="table table-hover" style="text-align: center;">
			<thead>
				<tr> 
					<th>번호</th> 
					<th>제목</th> 
					<th>작성자</th> 
					<th>작성일자</th> 
				</tr>
			</thead>

	<c:forEach var="nDTO" items="${boardList }">
		<tr onclick="location.href='${pageContext.request.contextPath }/notice/content?id=${nDTO.id}'">
    		<td>${nDTO.id}</td>
    		<td class="left">${nDTO.subject}</td>
    		<td>${nDTO.name}</td>
    		<td><fmt:formatDate value="${nDTO.date}" pattern="yyyy.MM.dd"/> </td>
		</tr> 
	</c:forEach> 

		
	

		
	</table>	
	
<c:if test="${ ! empty sessionScope.userid }">

	<c:if test="${sessionScope.userid eq 'admin'}">
	
<input type="button" value="글쓰기" class="btn btn-outline-dark m-sm-1" 
onclick="location.href='${pageContext.request.contextPath }/notice/write'">		

	
	</c:if>


	
</c:if>
</div>
</div>
</div>
</div>


	
<!-- 페이지 번호 영역 시작 -->
<div class="col">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${ pageDTO.startPage > pageDTO.pageBlock }">
				<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/notice/list?pageNum=${pageDTO.startPage-pageDTO.pageBlock}' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled page-item"><a class="page-link" href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
		<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/notice/list?pageNum=${i}">${i} </a></li>
		</c:forEach>
	
		<c:choose>
			<c:when test="${ pageDTO.endPage < pageDTO.pageCount }">
				<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/notice/list?pageNum=${pageDTO.startPage+pageDTO.pageBlock}' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled page-item"><a class="page-link" href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>

<!-- 페이지 번호 영역 끝 -->	


    </section>
		
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
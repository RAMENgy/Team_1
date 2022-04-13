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
    		<td>${nDTO.member_id}</td>
    		<td><fmt:formatDate value="${nDTO.date}" pattern="yyyy.MM.dd"/> </td>
		</tr> 
	</c:forEach> 
	
		<tr>
			<td colspan="10">
				
				<form action="${pageContext.request.contextPath }/notice/search" method="get">
					<input type="text" name="search" class="input_box">
					<input type="submit" value="검색" class="btn btn-default">
					</form>
			
				
			</td> 
		</tr>
		</table>


<c:if test="${ ! empty sessionScope.userid }">

	<c:if test="${sessionScope.userid eq 'admin'}">
	
<input type="button" value="글쓰기" class="btn btn-default" 
onclick="location.href='${pageContext.request.contextPath }/notice/write'">		
<input type="button" value="글수정" class="btn" 
onclick="location.href='${pageContext.request.contextPath }/notice/update?num=${noticeDTO.num}'">
<input type="button" value="글삭제" class="btn" 
onclick="location.href='${pageContext.request.contextPath }/notice/delete?num=${noticeDTO.num}'">	
	
	</c:if>
	
</c:if>

	
<c:if test="${ pageDTO.startPage > pageDTO.pageBlock }">
<a href="${pageContext.request.contextPath }/notice/list?pageNum=${pageDTO.startPage-pageDTO.pageBlock}">Prev</a>
</c:if>

<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
<a href="${pageContext.request.contextPath }/notice/list?pageNum=${i}">${i} </a>
</c:forEach>

<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
<a href="${pageContext.request.contextPath }/notice/list?pageNum=${pageDTO.startPage+pageDTO.pageBlock}">Next</a>
</c:if>		

	</div>
</div>
		
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
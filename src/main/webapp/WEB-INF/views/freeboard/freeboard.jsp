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
                
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row container">
                    	<!-- 게시판 영역 시작 -->
                    	<h3>자유 게시판</h3>
                        <table class="table table-hover" style="text-align: center;">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
							</thead>
							
							<!-- 글 영역 시작 -->
							<tbody>
								<c:forEach var="FBDTO" items="${boardList }">
									<tr onclick="location.href='${pageContext.request.contextPath }/free/content?id=${FBDTO.id}'">
										<td>${FBDTO.id}</td>
										<td>${FBDTO.subject}</td>
										<td>${FBDTO.name}</td>
										<!-- TODO member_id 기반 name get 하기 -->
										<td><fmt:formatDate value="${FBDTO.date}" pattern="yyyy.MM.dd"/></td>
										<td>${FBDTO.readcount}</td>
									</tr>
								</c:forEach>
							</tbody>
							<!-- 글 영역 끝 -->
							
						</table>
						<!-- 게시판 영역 끝 -->
						<c:if test="${!empty sessionScope.userid }">
							<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/free/write'">글쓰기</button>
						</c:if>
						
						<!-- 페이지 번호 영역 시작 -->
						<div class="col">
							<ul class="pagination justify-content-center">
								<c:choose>
									<c:when test="${ pageDTO.startPage > pageDTO.pageBlock }">
										<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/free/board?pageNum=${pageDTO.startPage-pageDTO.pageBlock}' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
									</c:when>
									<c:otherwise>
										<li class="disabled page-item"><a class="page-link" href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
									</c:otherwise>
								</c:choose>
								
								<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/free/board?pageNum=${i}">${i} </a></li>
								</c:forEach>
							
								<c:choose>
									<c:when test="${ pageDTO.endPage < pageDTO.pageCount }">
										<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/free/board?pageNum=${pageDTO.startPage+pageDTO.pageBlock}' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>
									</c:when>
									<c:otherwise>
										<li class="disabled page-item"><a class="page-link" href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
						
						<!-- 페이지 번호 영역 끝 -->
                    </div>
                </div>
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
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
    <title>레시피 둘러보기</title>

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
                        <a href="#"><i class="fa fa-home"></i> 레시피</a>
                        <span>레시피 둘러보기</span>
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
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="blog-item">
                            	<c:forEach var="rbDTO" items="${recipeboardList }">
                                <div class="bi-text">
                                    <a onclick="location.href='${pageContext.request.contextPath }/recipeboard/content?id=${rbDTO.id}'">
                                    <img src="${pageContext.request.contextPath }/resources/recipeimg/${rbDTO.img}" onerror="this.src='https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif'">
                                        <h4>${rbDTO.subject}
                                        	<c:if test="${rbDTO.comcount ne 0}">
												[${rbDTO.comcount }]
											</c:if></h4>
                                    <p>${rbDTO.name} <span>조회수 : ${rbDTO.readcount} / 좋아요 : ${rbDTO.like_count} / <fmt:formatDate value="${rbDTO.date }" pattern="yyyy.MM.dd"/> </span></p>
                                    </a>
                                </div>
                                <br>
                                </c:forEach>
                                
                                <!-- 게시판 영역 끝 -->
								<c:if test="${!empty sessionScope.userid }">
									<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/recipeboard/write'">글쓰기</button>
								</c:if>
								
								<!-- 페이지 번호 영역 시작 -->
								<div class="col">
									<ul class="pagination justify-content-center">
										<c:choose>
											<c:when test="${ pageDTO.startPage > pageDTO.pageBlock }">
												<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/recipeboard/list?pageNum=${pageDTO.startPage-pageDTO.pageBlock}' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
											</c:when>
											<c:otherwise>
												<li class="disabled page-item"><a class="page-link" href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
											</c:otherwise>
										</c:choose>
										
										<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
										<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/recipeboard/list?pageNum=${i}">${i} </a></li>
										</c:forEach>
									
										<c:choose>
											<c:when test="${ pageDTO.endPage < pageDTO.pageCount }">
												<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/recipeboard/list?pageNum=${pageDTO.startPage+pageDTO.pageBlock}' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>
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
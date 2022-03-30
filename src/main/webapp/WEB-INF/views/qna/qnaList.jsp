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
    <title>QnA</title>

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
                        <a href="#"><i class="fa fa-home"></i> 고객센터</a>
                        <span>QnA</span>
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
                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
    				<div class="blog-sidebar">
        				<div class="search-form">
            				<h4>QnA 검색</h4>
            				<form action="#">
			                <input type="text" placeholder="검색어를 입력하세요">
			                <button type="submit"><i class="fa fa-search"></i></button>
            				</form>
        				</div>
    				</div>
				</div>
                <!-- 사이드 바 끝 -->
                
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row container">
                    	<!-- 게시판 영역 시작 -->
                    	<h3>QnA</h3>
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
								<c:forEach var="qnaDTO" items="${boardList }">
									<tr>
										<td>${qnaDTO.id}</td>
										<td>${qnaDTO.subject}</td>
										<td>${qnaDTO.member_id}</td>
										<!-- TODO member_id 기반 name get 하기 -->
										<td><fmt:formatDate value="${qnaDTO.date }" pattern="yyyy.MM.dd"/></td>
										<td>${qnaDTO.readcount}</td>
									</tr>
								</c:forEach>
							</tbody>
							<!-- 글 영역 끝 -->
							
						</table>
						<!-- 게시판 영역 끝 -->
						
						
						<!-- 페이지 번호 영역 시작 -->
						<div class="col">
							<ul class="pagination justify-content-center">
								<c:if test="${ pageDTO.startPage > pageDTO.pageBlock }">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/qna/qnalist?pageNum=${pageDTO.startPage-pageDTO.pageBlock}">이전</a>
								</c:if>
								
								<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/qna/qnalist?pageNum=${i}">${i} </a>
								</c:forEach>
								
								<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/qna/qnalist?pageNum=${pageDTO.startPage+pageDTO.pageBlock}">다음</a>
								</c:if>
							</ul>
						</div>
						<!-- 페이지 번호 영역 끝 -->
						<input type="button" value="글쓰기" class="site-btn" 
						onclick="location.href='${pageContext.request.contextPath }/qna/qnawrite'">
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
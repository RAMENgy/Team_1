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
    <title>${FBDTO.subject } : 오늘 뭐 먹지?</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <jsp:include page="../inc/css.jsp"></jsp:include>
    <style type="text/css">
    textarea,button {vertical-align: middle;}
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
                    	<h3>게시글</h3>
		                <table class="table">
							<tr><td>글번호</td><td>${FBDTO.id }</td>
							     <td>글쓴날짜</td><td><fmt:formatDate value="${FBDTO.date}" pattern="yyyy.MM.dd"/></td></tr>
							<tr><td>글쓴이</td><td>${FBDTO.name }</td>
							    <td>조회수</td><td>${FBDTO.readcount }</td></tr>
							<tr><td>글제목</td><td colspan="3">${FBDTO.subject }</td></tr>
							
							<tr><td>글내용</td><td colspan="3" height="400px" style="white-space:pre">${FBDTO.content }</td></tr>
						</table>
						
						<!-- 댓글 리스트 null 인지 판별 후 -->
						<h3>댓글</h3>
						<table class="table">
						 	<thead>
								<tr>
									<th>작성자</th>
									<th>댓글</th>
									<th>날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="FBCDTO" items="${CommentList }">
								<!-- 댓글 리스트 받아오기 -->
									<tr>
										<!-- id코드로 id 이름 가져오기 -->
										<td>${FBCDTO.name}</td>
										<td>${FBCDTO.content}
										<td><fmt:formatDate value="${FBCDTO.date}" pattern="yyyy.MM.dd"/></td>
										<c:if test="${FBCDTO.member_id eq sessionScope.id}">
											<i class="ti-close" onclick="location.href='${pageContext.request.contextPath }/free/deleteComment?id=${FBCDTO.id }&page=${FBDTO.id }'"></i>
										</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						<!-- 댓글 리스트 끝 -->
						
						<!-- session 로그인 여부 판별 후 댓글 입력 창 생성 -->
						<c:if test="${!empty sessionScope.id }">
						<div class="blog-details-inner" style="width: 100%">
							<div class="leave-comment">
	                            <h4>댓글 남기기</h4>
	                            <form class="comment-form" action="${pageContext.request.contextPath }/free/writeComment" method="post">
	                                <div class="">
	                                    <div class="col-lg-12">
	                                    	<input type="hidden" name="freeboard_id" value="${FBDTO.id }">
	                                        <textarea placeholder="Messages" name="content" style="width: 70%"></textarea>
	                                        <button style="height: 100px" type="submit" class="btn btn-outline-dark">댓글쓰기</button>
	                                        <!-- ajax? -->
	                                    </div>
	                                </div>
	                            </form>
	                        </div>
                        </div>
                        </c:if>
                        <!-- 댓글 입력 창 끝 -->
                        
                        <!-- session 로그인 여부 판별 후 글 수정 삭제 버튼 생성-->
						<div class="row container">
							<c:if test="${!empty sessionScope.id }">
								<c:if test="${FBDTO.member_id eq sessionScope.id }">
									<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/free/update?id=${FBDTO.id }'">글수정</button>
									<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/free/delete?id=${FBDTO.id }'">글삭제</button>
								</c:if>
							</c:if>
							<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/free/board'">글목록</button>
						</div>
						<!-- 글 수정 삭제 버튼 끝 -->
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
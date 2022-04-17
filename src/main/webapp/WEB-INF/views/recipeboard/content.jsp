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
    <title>${rbDTO.subject }</title>

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
							<tr><td>글번호</td><td>${rbDTO.id }</td>
							     <td>글쓴날짜</td><td>${rbDTO.date }</td></tr>
							<tr><td>글쓴이</td><td>${rbDTO.member_id }</td>
							    <td>조회수</td><td>${rbDTO.readcount }</td></tr>
							<tr><td>글제목</td><td colspan="3">${rbDTO.subject }</td></tr>
							
							<tr><td>글내용</td><td colspan="3" ><img src="${pageContext.request.contextPath }/resources/recipeimg/${rbDTO.img}"
							onerror="this.src='https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif'"><br>
							<span style="white-space:pre">${rbDTO.content }</span></td></tr>
						</table>
						
						<!-- session 로그인 여부 판별 후 글 수정 삭제 버튼 생성-->
						<div class="row container">
							<c:if test="${!empty sessionScope.id }">
								<c:if test="${rbDTO.member_id eq sessionScope.id }">
									<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/recipeboard/update?id=${rbDTO.id }'">글수정</button>
									<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/recipeboard/delete?id=${rbDTO.id }'">글삭제</button>
								</c:if>
							</c:if>
							<button class="btn btn-outline-dark" type="submit" onclick="location.href='${pageContext.request.contextPath }/recipeboard/list'">글목록</button>
						</div>
						<!-- 글 수정 삭제 버튼 끝 -->
						
						<!-- 댓글 리스트 null 인지 판별 후 -->
						<table class="table">
						 	<thead>
								<tr>
									<th>작성자</th>
									<th>댓글내용</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="rbDTO" items="${recipeboardList }">
								<!-- 댓글 리스트 받아오기 -->
									<tr>
										<td>작성자</td>
										<td>내용</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						<!-- 댓글 리스트 끝 -->
						
						<!-- session 로그인 여부 판별 후 댓글 입력 창 생성 -->
						<c:if test="${!empty sessionScope.id }">
						<div class="blog-details-inner">
							<div class="leave-comment">
	                            <h4>댓글 남기기</h4>
	                            <form action="#" class="comment-form">
	                                <div class="">
	                                    <div class="col-lg-12">
	                                        <textarea placeholder="Messages"></textarea>
	                                        <button type="submit" class="site-btn">Send message</button>
	                                        <!-- ajax? -->
	                                    </div>
	                                </div>
	                            </form>
	                        </div>
                        </div>
                        </c:if>
                        <!-- 댓글 입력 창 끝 -->
                        
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
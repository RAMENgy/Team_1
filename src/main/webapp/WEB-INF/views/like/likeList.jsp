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
    <title>내가 좋아요한 레시피</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <jsp:include page="../inc/css.jsp"></jsp:include>
    
    <!-- 좋아요 삭제 -->
    <script type="text/javascript">
    	function f1(id) {
    	 	if (confirm("좋아요목록에서 삭제하시겠습니까?") == true){
    	 		
    			location.href="${pageContext.request.contextPath }/like/deleteLikeList?id="+id
    		} else {
    			return;
    		}
    	}
    	
    </script>
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

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> 마이페이지</a>
                        <span>좋아요한 레시피</span>
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
                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
                    <div class="blog-sidebar">
                        <div class="search-form">
                            <h4>내 좋아요한 레시피 검색</h4>
                            <form action="${pageContext.request.contextPath }/like/likesearch" method="get">
                                <input type="text" placeholder="검색어를 입력하세요" name="search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                        <div class="recent-post">
                            <h4>최근 작성된 레시피</h4>
                            <div class="recent-blog">
                            <c:forEach var="reDTO" items="${reList }">
                                <a href="${pageContext.request.contextPath }/recipeboard/content?id=${reDTO.id}" class="rb-item">
                                    <div class="rb-pic">
                                        <img src="" onerror="this.src='https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif'">
                                    </div>
                                    <div class="rb-text">
                                        <h6>${reDTO.subject }</h6>
                                        <p>${reDTO.member_id }<span> - <fmt:formatDate value="${reDTO.date }" pattern="yyyy.MM.dd"/></span></p>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2" style="padding-left: 20%;">
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="blog-item">
                                <div class="bi-pic">
                                </div>
                                <c:forEach var="lDTO" items="${boardList }" varStatus="status">
                                <div class="bi-text">
                                    <a href="${pageContext.request.contextPath }/recipeboard/content?id=${lDTO.re_id}">
                                	<img src="" onerror="this.src='https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif'"/>
                                	<!-- img칼럼 값 없을때 "이미지 없음" 표시 -->
                                        <h4>${lDTO.id}. ${lDTO.subject } </h4>
                                    </a>
                                    <p>
                                    ${lDTO.member_id}(작성자 id값) <span>- <fmt:formatDate value="${lDTO.date }" pattern="yyyy.MM.dd"/></span>
                                    <button><i class="fa fa-trash" aria-hidden="true" onclick="f1(${lDTO.id})"></i></button>
                                    </p>
                                   	
                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->

    <!-- Partner Logo Section Begin -->
<%--     <jsp:include page="../inc/partner.jsp"></jsp:include> --%>
    <!-- Partner Logo Section End -->
	
    <!-- Footer Section Begin -->
    <jsp:include page="../inc/bottom.jsp"></jsp:include>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <jsp:include page="../inc/js.jsp"></jsp:include>
</body>

</html>
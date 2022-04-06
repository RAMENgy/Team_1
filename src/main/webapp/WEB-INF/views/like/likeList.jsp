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
                            <h4>전체레시피 중에서 검색?</h4>
                            <form action="#">
                                <input type="text" placeholder="or 좋아요 한 레시피에서?">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
<!--                         <div class="blog-catagory"> -->
<!--                             <h4>Categories</h4> -->
<!--                             <ul> -->
<!--                                 <li><a href="#">Fashion</a></li> -->
<!--                                 <li><a href="#">Travel</a></li> -->
<!--                                 <li><a href="#">Picnic</a></li> -->
<!--                                 <li><a href="#">Model</a></li> -->
<!--                             </ul> -->
<!--                         </div> -->
                        <div class="recent-post">
                            <h4>최근 게시글 영역</h4>
                            <div class="recent-blog">
                                <a href="#" class="rb-item">
                                    <div class="rb-pic">
                                        <img src="${pageContext.request.contextPath }/resources/img/blog/recent-1.jpg" alt="">
                                    </div>
                                    <div class="rb-text">
                                        <h6>삭제 검토중 (없어도 될듯))</h6>
                                        <p>ㅇㅇㅇㅇ<span>ㅇㅇㅇㅇ</span></p>
                                    </div>
                                </a>
                                <a href="#" class="rb-item">
                                    <div class="rb-pic">
                                        <img src="${pageContext.request.contextPath }/resources/img/blog/recent-2.jpg" alt="">
                                    </div>
                                    <div class="rb-text">
                                        <h6>아니면 select max(num)-1 from recipe</h6>
                                        <p>Fashion <span>- May 19, 2019</span></p>
                                    </div>
                                </a>
                                <a href="#" class="rb-item">
                                    <div class="rb-pic">
                                        <img src="${pageContext.request.contextPath }/resources/img/blog/recent-3.jpg" alt="">
                                    </div>
                                    <div class="rb-text">
                                        <h6>select max(num)-2 from recipe 이런식으로 보여주기</h6>
                                        <p>ddd <span>- ddd</span></p>
                                    </div>
                                </a>
                                <a href="#" class="rb-item">
                                    <div class="rb-pic">
                                        <img src="${pageContext.request.contextPath }/resources/img/blog/recent-4.jpg" alt="">
                                    </div>
                                    <div class="rb-text">
                                        <h6>The Personality Trait That Makes...</h6>
                                        <p>Fashion <span>- May 19, 2019</span></p>
                                    </div>
                                </a>
                            </div>
                        </div>
<!--                         <div class="blog-tags"> -->
<!--                             <h4>Product Tags</h4> -->
<!--                             <div class="tag-item"> -->
<!--                                 <a href="#">Towel</a> -->
<!--                                 <a href="#">Shoes</a> -->
<!--                                 <a href="#">Coat</a> -->
<!--                                 <a href="#">Dresses</a> -->
<!--                                 <a href="#">Trousers</a> -->
<!--                                 <a href="#">Men's hats</a> -->
<!--                                 <a href="#">Backpack</a> -->
<!--                             </div> -->
<!--                         </div> -->
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="blog-item">
                                <div class="bi-pic">
                                    <img src="${lDTO.img}" alt="">
                                </div>
                                <c:forEach var="lDTO" items="${boardList }">
                                <div class="bi-text">
                                    <a href="./blog-details.html">
                                        <h4>${lDTO.id}. ${lDTO.subject }</h4>
                                    </a>
                                    <p>
                                    ${lDTO.member_id}(작성자 id값) <span>- <fmt:formatDate value="${lDTO.date }" pattern="yyyy.MM.dd"/></span>
                                    <button><i class="fa fa-trash" aria-hidden="true" onclick="f1(${lDTO.id})"></i></button>
                                    </p>
                                   	
                                </div>
                                </c:forEach>
                            </div>
                        </div>
<!--                         <div class="col-lg-6 col-sm-6"> -->
<!--                             <div class="blog-item"> -->
<!--                                 <div class="bi-pic"> -->
<%--                                     <img src="${pageContext.request.contextPath }/resources/img/blog/blog-2.jpg" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="bi-text"> -->
<!--                                     <a href="./blog-details.html"> -->
<!--                                         <h4>likeList 생성해서 forEach로 recipe테이블에서 제목/작성자/날짜 가져오기</h4> -->
<!--                                     </a> -->
<%--                                     <p>${lDTO.id } <span><fmt:formatDate value="${lDTO.date }" pattern="yyyy.MM.dd"/></span></p> --%>
<!--                                     <form action="deleteLikeList"> -->
<!-- 	                                <button type="submit">   	 -->
<!--                                    	<i class="fa fa-trash" aria-hidden="true"></i> -->
<!--                                    	</button> &lt;- 구현 및 추가여부 검토중... -->
<!--                                    	</form> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="col-lg-6 col-sm-6"> -->
<!--                             <div class="blog-item"> -->
<!--                                 <div class="bi-pic"> -->
<%--                                     <img src="${pageContext.request.contextPath }/resources/img/blog/blog-3.jpg" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="bi-text"> -->
<!--                                     <a href="./blog-details.html"> -->
<!--                                         <h4>likeList 생성해서 forEach로 recipe테이블에서 제목/작성자/날짜 가져오기</h4> -->
<!--                                     </a> -->
<!--                                     <p>travel <span>- May 19, 2019</span></p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="col-lg-6 col-sm-6"> -->
<!--                             <div class="blog-item"> -->
<!--                                 <div class="bi-pic"> -->
<%--                                     <img src="${pageContext.request.contextPath }/resources/img/blog/blog-4.jpg" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="bi-text"> -->
<!--                                     <a href="./blog-details.html"> -->
<!--                                         <h4>likeList 생성해서 forEach로 recipe테이블에서 제목/작성자/날짜 가져오기</h4> -->
<!--                                     </a> -->
<!--                                     <p>Fashion <span>- May 19, 2019</span></p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="col-lg-6 col-sm-6"> -->
<!--                             <div class="blog-item"> -->
<!--                                 <div class="bi-pic"> -->
<%--                                     <img src="${pageContext.request.contextPath }/resources/img/blog/blog-5.jpg" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="bi-text"> -->
<!--                                     <a href="./blog-details.html"> -->
<!--                                         <h4>likeList 생성해서 forEach로 recipe테이블에서 제목/작성자/날짜 가져오기…</h4> -->
<!--                                     </a> -->
<!--                                     <p>Model <span>- May 19, 2019</span></p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="col-lg-6 col-sm-6"> -->
<!--                             <div class="blog-item"> -->
<!--                                 <div class="bi-pic"> -->
<%--                                     <img src="${pageContext.request.contextPath }/resources/img/blog/blog-6.jpg" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="bi-text"> -->
<!--                                     <a href="./blog-details.html"> -->
<!--                                         <h4>likeList 생성해서 forEach로 recipe테이블에서 제목/작성자/날짜 가져오기</h4> -->
<!--                                     </a> -->
<!--                                     <p>Fashion <span>- May 19, 2019</span></p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
                        <div class="col-lg-12">
                            <div class="loading-more">
                                <i class="icon_loading"></i>
                                
                                <a href="#">
                                    더 펼쳐보기(펼쳐보기 없이 그냥 한번에 다 보여주는게 나아보임)
                                </a>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Product Shop Section Begin -->
    <section class="product-shop spad">
        <div class="container">
            <div class="row">
            
                <!-- 사이드 바 시작 -->
                <jsp:include page="item/side.jsp"></jsp:include>
                <!-- 사이드 바 끝 -->
                
                <div class="col-lg-9 order-1 order-lg-2">
                   
                    <div class="product-list">
                        <div class="row">
                           
                            
                         
                            
                         <c:forEach var="fDTO" items="${foodList}">
                            <div class="col-lg-4 col-sm-6">
                                <div class="product-item">
                                    
                                    <div class="pi-text">
                                 
                                          <div class="catagory-name">${fDTO.subject }</div>
                                       <a href="${pageContext.request.contextPath }/food/content?id=${fDTO.id}">
                                          <img src="${pageContext.request.contextPath }/resources/food/${fDTO.img}"
                                        onerror="this.src='https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif'">
                                            <h5>${fDTO.subject }</h5>
                                        </a>
                                        <div class="product-price">
                                            ${fDTO.amount }원
  
                                        </div>
                                    </div>
                                </div>
                            </div>
                         </c:forEach>
                       
                        
                    </div>
                    <c:if test="${pageDTO.startPage > pageDTO.pageBlock }">
						<a href="${pageContext.request.contextPath }/food/serach?pageNum=${pageDTO.startPage-pageDTO.pageBlock}&search=${pageDTO.search}">이전</a>
						</c:if>
						
						<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
						<a href="${pageContext.request.contextPath }/food/serach?pageNum=${i}&search=${pageDTO.search}">${i} </a>
						</c:forEach>
						
						<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
						<a href="${pageContext.request.contextPath }/food/serach?pageNum=${pageDTO.startPage+pageDTO.pageBlock}&search=${pageDTO.search}">다음</a>
						</c:if>
						
						 </div>
                </div>
                
            </div>

        </div>
    </section>
    
    <!-- Product Shop Section End -->

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
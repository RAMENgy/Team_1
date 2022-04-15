
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
    <section class="product-shop spad checkout-section spad">
        <div class="container">
            <div class="row">
                <!-- 사이드 바 시작 -->
                <jsp:include page="item/side.jsp"></jsp:include>
                <!-- 사이드 바 끝 -->
                <div class="col-lg-9 order-1 order-lg-2">
                   
                    <div class="product-list">
                        <div class="row cart-table">
                        <form class="checkout-form" action="${pageContext.request.contextPath }/food/basket" method="post">
                           <input type="hidden" name="member_id" value="${sessionScope.id}">
                           <input type="hidden" name="product_id" value="${foodDTO.id}">
                           <table id="notice">
								<tr><td>이름 :</td><td> ${foodDTO.subject}</td></tr>
								<tr><td>가격 :</td><td> ${foodDTO.amount} 원</td></tr>
								<tr><td>내용 :</td><td> ${foodDTO.content}</td></tr>
								<c:if test = "${! empty sessionScope.id}" >
									<tr><td>수량 :</td><td> <input type="number" name="count"></td></tr>
								</c:if>
                         	</table>
                         	<button type="submit" class="site-btn login-btn" name="basket">장바구니담기</button>
                         </form>
               		 </div>
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
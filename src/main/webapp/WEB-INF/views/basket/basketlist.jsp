<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>오늘 뭐 먹지?</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">


    <jsp:include page="../inc/css.jsp"></jsp:include>
    
    <script type="text/javascript">
    	function f1(id) {
    	 	if (confirm("장바구니에서 삭제하시겠습니까?") == true){
    			location.href="basket/delete?id="+id
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
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <!-- Header End -->
   

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="#"><i class="fa fa-home"></i> 마이페이지 </a>
                        <span>장바구니</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th class="p-name">상품</th>
                                    <th>가격</th>
                                    <th>수량</th>
                                    <th>총 가격</th>
                                    <th><i class="ti-close"></i></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:choose>
                           			<c:when test="${empty basketList }">
                           				<tr>
                           					<td class="cart-pic first-row" colspan="6">
                                    			장바구니가 비었습니다.
                                    		</td>
                                    	</tr>
                           			</c:when>
                           			<c:otherwise>
                           				<c:forEach var="basketList" items="${basketList }">
                           				<tr>
                           					<td class="cart-pic first-row">
                                    			<img src="${pageContext.request.contextPath }/resources/food/${basketList.img}">
                                   			</td>
                                    		<td class="cart-title first-row">
                                       			${basketList.subject }
                                    		</td>
                                    		<td class="p-price first-row">
                                    			<fmt:formatNumber type="number" value="${basketList.amount }"/>원
                                    		</td>
                                    		<td class="qua-col first-row">
                                    			<form action="${pageContext.request.contextPath }/basket/update">
                                    			<input type="hidden" value="${basketList.bid }" name="id">
                                       			<div class="quantity">
                                            		<div class="pro-qty">
                                               			<input type="text" value="${basketList.count }" name="count">
                                            		</div>
                                        		</div>
                                        		<button type="submit">변경</button>
                                        		</form>
                                   			</td>
                                    		<td class="total-price first-row"><fmt:formatNumber type="number" value="${basketList.subprice }"/>원</td>
                                    		<td class="close-td first-row"><i class="ti-close" onclick="f1(${basketList.bid })"></i></td>
                                		</tr> 
                                		</c:forEach>
                           			</c:otherwise>
                           		</c:choose>
                            </tbody>
                        </table>
                    </div>
                    
                    
                    <c:choose>
                    <c:when test="${empty basketList }">
                    
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="food/list" class="primary-btn continue-shop">쇼핑계속하기</a>
                                <a href="basket/deleteAll" class="primary-btn up-cart">장바구니 전체 삭제</a>
                            </div>
                        </div>
                       
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                	<ul>
                                    	<li class="cart-total">최종가격 <span>0원</span></li>
	                                </ul>
                                	<a href="order" class="proceed-btn">주문하기</a>
                            </div>
                        </div>
                       
                    </div>
                    </c:when>
                    
					<c:otherwise>
					
					 <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="food/list" class="primary-btn continue-shop">쇼핑계속하기</a>
                                <a href="basket/deleteAll" class="primary-btn up-cart">장바구니 전체 삭제</a>
                            </div>
                            <!-- <div class="discount-coupon">
                                <h6>Discount Codes</h6>
                                <form action="#" class="coupon-form">
                                    <input type="text" placeholder="Enter your codes">
                                    <button type="submit" class="site-btn coupon-btn">Apply</button>
                                </form>
                            </div> -->
                        </div>
                       
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                	<ul>
                                    	<li class="cart-total">최종가격 <span><fmt:formatNumber type="number" value="${map.sumMoney}"/>원</span></li>
	                                </ul>
                                	<a href="order" class="proceed-btn">주문하기</a>
                            </div>
                        </div>
                       
                    </div>
					
					</c:otherwise>					                    
                    
                    </c:choose>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

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
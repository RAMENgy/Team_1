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
    <title>Fashi | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">


    <jsp:include page="../inc/css.jsp"></jsp:include>
    
    <script type="text/javascript">
    	function f1(id) {
    		location.href="orderdetail?id="+id
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
                        <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.html">Shop</a>
                        <span>Shopping Cart</span>
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
                                	<th>주문 번호</th>
                                    <th>주문 일자</th>
                                    <th></th>
                                    <th>상태</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:choose>
                           			<c:when test="${empty orderList }">
                           				<tr>
                           					<td class="cart-pic first-row" colspan="4">
                                    			주문 내역이 없습니다.
                                    		</td>
                                    	</tr>
                           			</c:when>
                           			<c:otherwise>
                           				<c:forEach var="orderList" items="${orderList }">
                           				<tr>
                           					<td class="cart-pic first-row">
                                    			${orderList.id }
                                   			</td>
                                    		<td class="cart-title first-row">
                                    			${orderList.date }
                                    		</td>
                                    		<td class="qua-col first-row">
                                    			<input type="button" value="상세보기" onclick="f1(${orderList.id})">
                                   			</td>
                                    		<td class="total-price first-row">
                                    			${orderList.status }
                                    		</td>
                                    		
                                		</tr> 
                                		</c:forEach>
                           			</c:otherwise>
                           		</c:choose>
                            </tbody>
                        </table>
                    </div>
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
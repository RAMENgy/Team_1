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

    <!-- Css Styles -->
    <jsp:include page="../inc/css.jsp"></jsp:include>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$.ajax({
    			url:'${pageContext.request.contextPath }/order/orderinfojson',
    			dataType:'json',
    			success:function(rdata){
    				$('#acc-create').change(function(){
    					if($('#acc-create').is(':checked')){
        					$('#jname').val("${memberDTO.name}");
           					$('#jtel').val("${memberDTO.tel}");
           					$('#jaddress').val("${memberDTO.address}");
        				} else{
        					$('#jname').val("");
           					$('#jtel').val("");
           					$('#jaddress').val("");
        				}
    				});
    			}
    		});
    	});
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
                        <a href="./index.html"><i class="fa fa-home"></i> 마이페이지</a>
                        <span>주문정보확인</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="checkout-section spad">
        <div class="container">
            	<form class="checkout-form">
                <div class="row">
                    <div class="col-lg-6">
                    
                        <h4>배송정보</h4>
                                
                        <br>
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="jname">이름</label>
                                <input type="text" id="jname" name="receiver_name" value="${orderDTO.receiver_name }" readonly>
                            </div>
                            <div class="col-lg-6">
                                <label for="jtel">전화번호</label>
                                <input type="text" id="jtel" name="receiver_tel" value="${orderDTO.receiver_tel }" readonly>
                            </div>
                           
                            <div class="col-lg-12">
                                <label for="jaddress">주소</label>
                                <input type="text" id="jaddress" name="address" value="${orderDTO.address }" readonly>
                            </div>
                           <!--  <div class="col-lg-12">
                                <label for="cun">우편번호<span>*</span></label>
                                <input type="text" id="cun">
                            </div> -->
                           
                        </div>
                    </div>
                    
                    <div class="col-lg-6">
                        <div class="place-order">
                            <h4>주문 확인</h4>
                            <div class="order-total">
                                <ul class="order-table">
                                    <li>Product <span>Total</span></li>
                                    <c:forEach var="orderpList" items="${orderpList }">
                                    <li class="fw-normal">${orderpList.subject }<br>
                                    <fmt:formatNumber type="number" value="${orderpList.amount }"/>원 * ${orderpList.count }개<span><fmt:formatNumber type="number" value="${orderpList.subprice }"/>원</span></li>
                                    </c:forEach>
                                    <li class="total-price">총액 <span><fmt:formatNumber type="number" value="${map.sumMoney }"/>원</span></li>
                                </ul>
                                
                            </div>
                        </div>
                    </div>
                </div>
                </form>
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
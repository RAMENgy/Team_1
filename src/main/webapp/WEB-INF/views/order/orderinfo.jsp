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
    <title>주문하기</title>

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
    	
    	$(document).ready(function(){
    	    $("#point").change(function(){
    	        if($("#point").is(":checked")){
    	        	var pointSub = ${map.sumMoney } - ${sessionScope.point };
    	            alert(pointSub+"d11dddd");
    	            $('#pointSub').text(pointSub+"");
    	            
    	        }else{
    	            alert("체크박스 체크 해제!");
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
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.html">Shop</a>
                        <span>Check Out</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="checkout-section spad">
        <div class="container">
            <form action="${pageContext.request.contextPath }/order/insertorder" method="post" class="checkout-form">
            	<input type="hidden" value="${memberDTO.id }" name="member_id">
            	<c:forEach var="basketList" items="${basketList }" varStatus="status">
	            	<input type="hidden" value="${basketList.bid }" name="basketlist[${status.index }].id">
    	        	<input type="hidden" value="${basketList.pid }" name="basketlist[${status.index }].product_id">
    	        	<input type="hidden" value="${basketList.count }" name="basketlist[${status.index }].count">
            	</c:forEach>
                <div class="row">
                    <div class="col-lg-6">
                        <!-- <div class="checkout-content">
                            <a href="#" class="content-btn">Click Here To Login</a>
                        </div> -->
                        <h4>주문고객</h4>
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="fir">이름<span>*</span></label>
                                <input type="text" id="fir" value="${memberDTO.name }" readonly>
                            	<br>
                                <label for="phone">전화번호<span>*</span></label>
                                <input type="text" id="phone" value="${memberDTO.tel }" readonly>
                            </div>
                        </div>
                    	
                    	<br><br>
                    
                        <h4>배송정보</h4>
                        <div class="create-item">
                                    <label for="acc-create">
                                        주문자 정보와 동일
                                        <input type="checkbox" id="acc-create">
                                        <span class="checkmark"></span>
                                    </label>
                        </div>
                                
                        <br>
                       
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="jname">이름<span>*</span></label>
                                <input type="text" id="jname" name="receiver_name">
                            </div>
                            <div class="col-lg-6">
                                <label for="jtel">전화번호<span>*</span></label>
                                <input type="text" id="jtel" name="receiver_tel">
                            </div>
                           
                            <div class="col-lg-12">
                                <label for="jaddress">주소</label>
                                <input type="text" id="jaddress" name="address">
                            </div>
                            <div class="col-lg-12">
                                <label for="cun">우편번호<span>*</span></label>
                                <input type="text" id="cun">
                            </div>
                           
                        </div>
                    </div>
                    
                    
                    <div class="col-lg-6">
                        <div class="place-order">
                            <h4>주문 확인</h4>
                            <div class="order-total">
                                <ul class="order-table">
                                    <li>Product <span>Total</span></li>
                                    <c:forEach var="basketList" items="${basketList }">
                                    <li class="fw-normal">${basketList.subject } * ${basketList.count } <span><fmt:formatNumber type="number" value="${basketList.subprice }"/>원</span></li>
                                    </c:forEach>
                                    <li class="total-price">총액 <span><fmt:formatNumber type="number" value="${map.sumMoney }"/>원</span></li>
                                    <li class="total-price">사용 가능 포인트 <span>${sessionScope.point }원</span></li>
                                    <li class="total-price"><input type="checkbox" id="point"></li>
                                    <li class="total-price">포인트 사용 후 금액<span id="pointSub"></span></li>
                                </ul>
                                <!-- <div class="payment-check">
                                    <div class="pc-item">
                                        <label for="pc-check">
                                            Cheque Payment
                                            <input type="checkbox" id="pc-check">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                    <div class="pc-item">
                                        <label for="pc-paypal">
                                            Paypal
                                            <input type="checkbox" id="pc-paypal">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div> -->
                                <div class="order-btn">
                                    <button type="submit" class="site-btn place-btn">주문하기</button>
                                </div>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header Section Begin -->
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
                <div class="mail-service">
                    <i class=" fa fa-envelope"></i>
                    Team_1-Team_Project@gogo.com
                </div>
                <div class="phone-service">
                    <i class=" fa fa-phone"></i>
                    +82 000-0000-0000
                </div>
            </div>
            <div class="ht-right">
            	
            	<!-- 로그인/회원정보 섹션 시작  -->
            	
				<c:if test="${ ! empty sessionScope.userid }">
				    <a href="${pageContext.request.contextPath }/member/logout" class="login-panel"><i class="fa fa-user-times"></i>로그아웃　</a>
				    <a href="${pageContext.request.contextPath }/member/update" class="login-panel"><i class="fa fa-user-circle"></i>정보수정　</a>	
					<span class="login-panel">${sessionScope.name }님
					현재포인트 : <span style="color: blue;">${sessionScope.point}</span>점　</span> 
				</c:if>
                <c:if test="${ empty sessionScope.userid }">
					<a href="${pageContext.request.contextPath }/member/join" class="login-panel"><i class="fa fa-user-plus"></i>Join Us　</a>
				    <a href="${pageContext.request.contextPath }/member/login" class="login-panel"><i class="fa fa-user"></i>Login　</a>
				</c:if>
				
				
                
                <!-- 로그인/회원정보 섹션 끝  -->
                
                <div class="top-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"><i class="ti-twitter-alt"></i></a>
                    <a href="#"><i class="ti-linkedin"></i></a>
                    <a href="#"><i class="ti-pinterest"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="inner-header">
            <div class="row">
                <div class="col-lg-2 col-md-2">
                    <div class="logo">
                        <a href="${pageContext.request.contextPath }/main/main">
                            <img src="${pageContext.request.contextPath }/resources/img/Team_1-logo.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-lg-7">
                    <div class="advanced-search">
<!--                         <button type="button" class="category-btn">통합검색</button> -->
                        <form action="${pageContext.request.contextPath }/search" class="input-group" method="post">
							<select name="casearch">
							<option>---카테고리를 선택하세요---</option>
							<option value="food">식품</option>
							<option value="recipe">레시피</option>
							</select>
                            <input type="text" name="search" placeholder="검색어를 입력하세요.">
                            
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 text-right col-lg-3">
                    <ul class="nav-right">
                        <li class="heart-icon"><a href="${pageContext.request.contextPath }/like/likelist">
                                <i class="icon_heart_alt"></i>
                                <span>
                                <c:if test="${ ! empty sessionScope.userid }">
								    ${sessionScope.likecount} 
								</c:if>
				                <c:if test="${ empty sessionScope.userid }">
									0
								</c:if>
                                </span>
                            </a>
                        </li>
                        <li class="cart-icon"><a href="${pageContext.request.contextPath }/basket">
                                <i class="icon_bag_alt"></i>
                                <span>장</span>
                            </a>
                            <div class="cart-hover">
                                <div class="select-items">
                                    <table>
                                        <tbody>
                                        	
                                        	<c:choose>
                                        		<c:when test="${empty sessionScope.userid }">
                                        		<tr>
                                                	<td class="si-text">
                                                    	<div class="product-selected">
                                                        	<p>로그인 해 주세요.</p>
                                                    	</div>
                                                	</td>
                                                    <!-- 항목 옆에 X표시 누르면 바로 삭제?
                                                    기능 고민중 불필요시 삭제 -->
                                            		</tr>
                                        		</c:when>
                           						<c:when test="${empty basketList }">
                           							<tr>
                                                	<td class="si-text">
                                                    	<div class="product-selected">
                                                        	<p>장바구니가 비었습니다.</p>
                                                    	</div>
                                                	</td>
                                                    <!-- 항목 옆에 X표시 누르면 바로 삭제?
                                                    기능 고민중 불필요시 삭제 -->
                                            		</tr>
                           						</c:when>
                           						<c:otherwise>
                                        		<c:forEach var="basketList" items="${basketList }">
                                           			<tr>
                                               		<td class="si-pic"><img src="${basketList.img }" alt=""></td>
                                                	<td class="si-text">
                                                    	<div class="product-selected">
                                                        	<p>${basketList.amount }</p>
                                                        	<h6>${basketList.subject }</h6>
                                                    	</div>
                                                	</td>
                                                	<td class="si-close">
                                                    <i class="ti-close"></i>
                                                    <!-- 항목 옆에 X표시 누르면 바로 삭제?
                                                    기능 고민중 불필요시 삭제 -->
                                                	</td>
                                            		</tr>
                                         		</c:forEach>
                                         		</c:otherwise>
                                         	</c:choose>
                                        </tbody>
                                    </table>
                                </div>
                           			<c:choose>
                           				<c:when test="${empty sessionScope.userid }">
                           				
                           				</c:when>
                           				<c:when test="${empty basketList }">
                           					<div class="select-total">
                                   				<span>장바구니 합계 금액</span>
                                    			<h5>0</h5>
                                			</div>
                                			<div class="select-button">
                                   				<a href="${pageContext.request.contextPath }/food/list" class="primary-btn view-card">쇼핑하러가기</a>
                                			</div>
                           				</c:when>
                           				<c:otherwise>
                                			<div class="select-total">
                                   				<span>장바구니 합계 금액</span>
                                    			<h5>${map.sumMoney }</h5>
                                			</div>
                                			<div class="select-button">
                                   				<a href="${pageContext.request.contextPath }/basket" class="primary-btn view-card">구매하러가기</a>
                                    			<a href="#" class="primary-btn checkout-btn">장바구니 전체삭제</a>
                                			</div>
                                		</c:otherwise>
                                	</c:choose>
                                	
                            </div>
                        </li>
                        <li class="cart-price">현재 장바구니 금액</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="nav-item">
        <div class="container">
            <div class="nav-depart">
<!--                 <div class="depart-btn"> -->
<!--                     <i class="ti-menu"></i> -->
<!--                     <span>카테고리</span> -->
<!--                     불필요시 삭제 -->
<!--                     <ul class="depart-hover"> -->
<!--                         <li class="active"><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                         <li><a href="#">???</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
            </div>
            <nav class="nav-menu mobile-menu">
                <ul>
                    <li><a href="${pageContext.request.contextPath }/main/main">홈으로</a></li>
                    <li><a href="${pageContext.request.contextPath }/food/list">식자재 둘러보기</a>
                    	<ul class="dropdown">
                            <li><a href="${pageContext.request.contextPath }/meat/list">고기</a></li>
                            <li><a href="${pageContext.request.contextPath }/vegetable/list">채소</a></li>
                            <li><a href="${pageContext.request.contextPath }/fruit/list">과일</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath }/recipeboard/list">레시피 둘러보기</a>
                        <ul class="dropdown">
                            <li><a href="#">이번주 인기 레시피</a></li>
                            <li><a href="${pageContext.request.contextPath }/recipeboard/list">전체 레시피 모아보기</a></li>
                            <li><a href="${pageContext.request.contextPath }/recipeboard/write">레시피 작성하기</a></li>
                    </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath }/free/board">자유게시판</a></li>
                    <li><a href="${pageContext.request.contextPath }/notice/list">고객센터</a>
                   		<ul class="dropdown">
                            <li><a href="${pageContext.request.contextPath }/notice/list">공지사항/이벤트</a></li>
                            <li><a href="${pageContext.request.contextPath }/board/list">QnA</a></li>
                        </ul>
                    </li>
                    <li><a href="#">마이페이지</a>
                        <ul class="dropdown">
                            <li><a href="#">회원정보조회</a></li>
                            <li><a href="${pageContext.request.contextPath }/basket">장바구니</a></li>
                            <li><a href="${pageContext.request.contextPath }/order/orderlist"">구매내역보기</a></li>
                            <li><a href="#">나의 QnA</a></li>
                            <li><a href="${pageContext.request.contextPath }/like/likelist">내가 좋아요한 레시피</a></li>
                            <li><a href="#">???</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
        </div>
    </div>
</header>
<!-- Header End -->
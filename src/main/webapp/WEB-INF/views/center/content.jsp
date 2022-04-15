<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
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
                    <div class="breadcrumb-text product-more">
                        <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./center.html">Center</a>
                        <span>QnA</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->
<!-- id="tablebox" -->
<body>
	<div class="col-lg-9 order-1 order-lg-2">
      <div class="row container">
		<table class="table">
			<tr><td>번호</td><td>${qnaDTO.id}</td>
			<td>작성일</td><td>${qnaDTO.date}</td></tr>
			<tr><td>작성자</td><td>${qnaDTO.name}</td>
			<td>조회수</td><td>${qnaDTO.readcount}</td>
			<tr><td>제목</td><td colspan="3">${qnaDTO.subject}</td></tr>
			<tr><td>글내용</td><td colspan="3">${qnaDTO.content}</td></tr>


<tr>
	<td colspan="10">
<c:if test="${ ! empty sessionScope.id }">

	<c:if test="${sessionScope.id eq qnaDTO.member_id  || sessionScope.userid eq 'admin'}">
	
	<input type="button" value="글수정" class="btn" style="float: right;"
	onclick="location.href='${pageContext.request.contextPath }/board/update?id=${qnaDTO.id}'">
	<input type="button" value="글삭제" class="btn" style="float: right;"
	onclick="location.href='${pageContext.request.contextPath }/board/delete?id=${qnaDTO.id}'">	

	<input type="button" value="글목록" class="btn" style="float: right;"
	onclick="location.href='${pageContext.request.contextPath }/board/list'">

	</c:if>
	
	
</c:if>


	</td>
</tr>	
</table>

<!-- 댓글 내용  -->
	<c:if test="${! empty commentDTO }">
	  <c:if test="${ sessionScope.userid ne 'admin'  }"> 
		<table id="tablebox" class="table">
		<%-- <tr><td>작성자</td>
    			<td><input type="text" name="member_id" value="${sessionScope.id}" ></td></tr> --%>
    	<tr><td>답변</td><td colspan="3">${commentDTO.content}</td></tr>
    			<tr><td></td><td>
    			
   				</td></tr>
		</table>  
	 </c:if> 

<!-- 댓글 수정  -->		
	<c:if test="${ sessionScope.userid eq 'admin'  }">
	<div id="tablebox">
	<form action="${pageContext.request.contextPath }/board/commentupdatePro" method="post">
	
	<input type="hidden" name="id" value="${commentDTO.id}">
	<input type="hidden" name="qna_board_id" value="${commentDTO.qna_board_id}"> 

		<table class="table table-hover" style="text-align: center;">
			<thead>
				<tr><td>답변 수정</td>
					
    				<td><textarea name="content" rows="10" cols="40" class="form-control">${commentDTO.content }</textarea></td></tr>
   			</thead>
   			
   			<tr>
   				<td colspan="10">
   				<input type="submit" value="답변수정" class="btn" style="float: right;">
   				<input type="button" value="답변삭제" class="btn" style="float: right;" 
				onclick="location.href='${pageContext.request.contextPath }/board/commentdelete?id=${commentDTO.id }'">
   				</td>
   				
   			</tr>
   			
		</table>
	</form>
				
   				
</div>
	</c:if> 
	</c:if>
	
	</div>
</div>


<!-- 댓글 쓰기 화면 -->

	<c:if test="${ empty commentDTO }">
	<c:if test="${ sessionScope.userid eq 'admin' }">
	<div id="tablebox">
	<form action="${pageContext.request.contextPath }/board/commentPro" method="post">
	
	<input type="hidden" name="qna_board_id" value="${qnaDTO.id}"> 
		<table class="table table-hover" style="text-align: center;">
			<thead>
				<tr><td>답변</td>
					
    				<td><textarea name="content" rows="10" cols="40" class="form-control"></textarea></td></tr>
   			</thead>
   			
   			<tr>
   				<td colspan="10">
   				<input type="submit" value="답변저장" class="btn" style="float: right;">
   				
   				</td>
   				
   			</tr>
   			
		</table>
	</form>
</div>

	</c:if>	
</c:if>
  

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
	<div class="blog-sidebar">
        <div class="search-form">
            <h4>식자재 검색</h4>
            <form action="${pageContext.request.contextPath }/food/search">
                <input type="text" name="search-food" placeholder="검색어를 입력하세요">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
    <div class="filter-widget">
        <a class="fw-title" href="${pageContext.request.contextPath }/food/list">카테고리</a>
        <ul class="filter-catagories">
        	</br>
             <li><a href="${pageContext.request.contextPath }/meat/list">고기</a></li>
            <li><a href="${pageContext.request.contextPath }/vegetable/list">채소</a></li>
            <li><a href="${pageContext.request.contextPath }/fruit/list">과일</a></li>
        </ul>
    </div>
</div>
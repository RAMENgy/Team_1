<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
    <div class="blog-sidebar">
        <div class="search-form">
            <h4>자유게시판 검색</h4>
            <form action="${pageContext.request.contextPath }/free/search">
                <input type="text" name="search" placeholder="검색어를 입력하세요">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
</div>
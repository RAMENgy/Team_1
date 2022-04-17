<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
    <div class="blog-sidebar">
        <div class="search-form">
            <h4>레시피 검색하기</h4>
            <form action="#">
                <input type="text" placeholder="검색어를 입력하세요!">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
        <div class="recent-post">
            <h4>최근 레시피</h4>
            <div class="recent-blog">
                <a href="#" class="rb-item">
                    <div class="rb-pic">
                        <img src="${pageContext.request.contextPath }/resources/img/blog/recent-1.jpg" alt="">
                    </div>
                    <div class="rb-text">
                        <h6>The Personality Trait That Makes...</h6>
                        <p>Fashion <span>- May 19, 2019</span></p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
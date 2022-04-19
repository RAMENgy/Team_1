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
    <title>레시피 작성하기</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <jsp:include page="../inc/css.jsp"></jsp:include>
    
    <style type="text/css">
    /* 	div 속성 */
	html, body {
	  height: 100%;
	  margin: 0;
	}
	
	.full-height {
	  height: 100%;
	}
	
	/* 	다중 이미지 업로드 */
	#att_zone{
		width: 660px;
	}
	#att_zone:empty:before{
		content : attr(data-placeholder);
		color : #999;
	}
	
	.filebox label { 
		display: inline-block; 
		padding: .5em .75em; 
		color: #999; 
		font-size: inherit; 
		line-height: normal; 
		vertical-align: middle; 
		background-color: #fdfdfd; cursor: pointer; border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; } .filebox input[type="file"] { /* 파일 필드 숨기기 */ position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px; overflow: hidden; clip:rect(0,0,0,0); border: 0; }

	</style>
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
                        <span>Blog</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Blog Section Begin -->
    <section class="blog-section spad">
        <div class="container">
            <div class="row">
                <!-- 사이드 바 시작 -->
                <jsp:include page="item/side.jsp"></jsp:include>
                <!-- 사이드 바 끝 -->
                
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="container">
                    	<!-- 글쓰기 영역 시작 -->
                    	<form action="${pageContext.request.contextPath }/recipeboard/writePro" method="post" enctype="multipart/form-data">
						<table class="table" id="notice">
						<tr><td>작성자</td>
						    <td><input class="form-control" type="text" id="member_id" name="member_id" value="${sessionScope.name }" readonly></td></tr>
						<tr><td>제목</td>
						    <td><input class="form-control" type="text" id="subject" name="subject"></td></tr>
						<tr><td>내용</td>
						    <td><div class="full-height form-control" id='image_preview' contentEditable="true">
						    		<div id='att_zone' data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
						    		<div>
						    		<textarea id="content" name="content" placeholder="여기에 레시피를 입력해주세요!" cols="70" rows="10"></textarea>
						    		</div>
						    	</div>
						    	</td></tr>
						</table>
						<div class="filebox">
							<label for="btnAtt">사진/파일</label>
							<input type="file" id="btnAtt" name="file"/>
						</div>
						<button class="btn btn-outline-dark m-sm-1" type="submit">글쓰기</button>
						<button class="btn btn-outline-dark m-sm-1" type="button" onclick="location.href='${pageContext.request.contextPath }/recipeboard/list'">글목록</button>
						</form>
						<script>
						( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
								  imageView = function imageView(att_zone, btn){
								    var attZone = document.getElementById(att_zone);
								    var btnAtt = document.getElementById(btn)
								    var sel_files = [];
								    
								    btnAtt.onchange = function(e){
								      var files = e.target.files;
								      var fileArr = Array.prototype.slice.call(files)
								      for(f of fileArr){
								        imageLoader(f);
								      }
								    }  
								    
								    // 탐색기에서 드래그앤 드롭 사용
								    attZone.addEventListener('dragenter', function(e){
								      e.preventDefault();
								      e.stopPropagation();
								    }, false)
								    
								    attZone.addEventListener('dragover', function(e){
								      e.preventDefault();
								      e.stopPropagation();
								      
								    }, false)
								  
								    attZone.addEventListener('drop', function(e){
								      var files = {};
								      e.preventDefault();
								      e.stopPropagation();
								      var dt = e.dataTransfer;
								      files = dt.files;
								      for(f of files){
								        imageLoader(f);
								      }
								      
								    }, false)
								    
								    /*첨부된 이미지들을 배열에 넣고 미리보기 */
								    imageLoader = function(file){
								      sel_files.push(file);
								      var reader = new FileReader();
								      reader.onload = function(ee){
								        let img = document.createElement('img')
								        
								        img.src = ee.target.result;
								        attZone.appendChild(makeDiv(img, file));
								      }
								      
								      reader.readAsDataURL(file);
								    }
								    
								    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
								    makeDiv = function(img, file){
								      var div = document.createElement('div')
								      
								      
								      var btn = document.createElement('input')
								      btn.setAttribute('type', 'button')
								      btn.setAttribute('value', 'x')
								      btn.setAttribute('delFile', file.name);
								      
								      btn.onclick = function(ev){
								        var ele = ev.srcElement;
								        var delFile = ele.getAttribute('delFile');
								        for(var i=0 ;i<sel_files.length; i++){
								          if(delFile== sel_files[i].name){
								            sel_files.splice(i, 1);      
								          }
								        }
								        
								        dt = new DataTransfer();
								        for(f in sel_files) {
								          var file = sel_files[f];
								          dt.items.add(file);
								        }
								        btnAtt.files = dt.files;
								        var p = ele.parentNode;
								        attZone.removeChild(p)
								      }
								      div.appendChild(img)
								      div.appendChild(btn)
								      return div
								    }
								  }
								)('att_zone', 'btnAtt')

						</script>
                    	<!-- 글쓰기 영역 끝 -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->


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
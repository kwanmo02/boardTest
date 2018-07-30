<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/bootstrap/css/dashboard.css" rel="stylesheet">
<link href="/bootstrap/css/blog.css" rel="stylesheet">
</head>

<body>

	<!-- top -->
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<h2 class="blog-post-title">게시글 상세보기</h2>
							<hr>

							<form class="form-signin" action="/middleUpdatePosts">
								제목 : <label>${posts.posts_title}</label><br>
								<br> <input type="hidden" name="postsTitle"
									value="${posts.posts_title}"> 
									글내용 : <label>${posts.posts_content}</label>
									<input type="hidden" name="postsContent"value="${posts.posts_content}">
									<br>
								<br><%--  <input type="hidden" name="postsContent"
									value="${posts.posts_content}">  --%>
									
									
									
									 <c:forEach var="list" items="${AttachList}"> 
									첨부파일 : <label>${list.upload_picname}</label><br>
									<input type="hidden" name="upload_picname" value="${list.upload_picname}">
								 	</c:forEach>
								 	
								 	<c:forEach var="list2" items="${updateAttachList2}">
								 	첨부파일: <label>${list2.upload_picname}</label>
								 	</c:forEach> 
								 	
								 	
								 	
								 	 
								<br>
								<input type="hidden" name="board_no" value="${posts.board_no}">
								<c:if test="${posts.mem_id eq memberVo.mem_id }">
								<button type="submit" class="btn btn-default" name="posts_no" value="${posts.posts_no}">수정</button>
								</c:if>
								
							</form>

							<form class="form-signin" action="/deletePosts">
								<c:if test="${posts.mem_id == memberVo.mem_id}">
								<input type="hidden" name="board_no" value="${posts.board_no}">
								<button type="submit" class="btn btn-default" name="posts_no" value="${posts.posts_no}">삭제</button>
								</c:if>
							</form>
							
							
							<a href="/posts/newRePost.jsp?board_no=${posts.board_no}&posts_no2=${posts.posts_no}" class="btn btn-default">답글</a> 
							<%-- <form class="form-signin" action="/posts/newRePost.jsp?board_no=${posts.board_no}&posts_no2=${posts.posts_no}">
								<button type="submit" value="${posts.board_no}">답글</button>
							</form> --%>
							
							
							
							<hr>
							<hr>
								<c:forEach var="content" items="${list}">
										<form action="/deleteCommentServlet">
								댓글 --->> <label>${content.comment_content}</label>
										  <label>[${content.mem_id} /</label>
										  <fmt:formatDate value="${content.comment_reg }" pattern="yyyy-MM-dd"/>]
										  <input type="hidden" name="comment_no" value="${content.comment_no}">
										  <input type="hidden" value="${posts.posts_no}" name="posts_no">
										  <input type="hidden" value="${param.board_no}" name="board_no">
										  
										  
										  <c:if test="${content.comment_del_yn eq 'false'}">
										 	 <input type="submit" value="삭제">
										  </c:if>
										  
										  <br>
										</form>
								</c:forEach>
								 <br>
								
								
							<form class="form-signin" action="/postsComment">
								<input type="text" name="reposts" placeholder="댓글을 입력해주세요">
								<input type="hidden" name="posts_no" value="${posts.posts_no}">
								<input type="hidden" name="board_no" value="${board_no}">
								<button type="submit">댓글저장</button>
							</form>





						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
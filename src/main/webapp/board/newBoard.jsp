<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

				<div class="blog-header">
					<h3 class="blog-title">게시판 Editor</h3>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<h2 class="blog-post-title">으디 게시판 한번 수정해 보슈</h2>
							<hr>
							<form class="form-signin" action="/createBoard">
								자유게시판 생성 <input type="text" name="board_name" value="${board}">
								<select name="newboardedit">
									<option value="true">사용</option>
									<option value="false">미사용</option>
								</select>
								<button type="submit">생성</button>
								<hr>
								<hr>
							</form>
							
								<c:forEach var="list" items="${boardList}" >
									<form class="form-signin" action="/updateBoard" method="post">
										게시판 이름<input type="text" name="board" value="${list.board_name}">
										<select name="boardEdit">
											<option value="true" <c:if test="${list.board_yn=='true'}">selected</c:if>>사용</option>
											<option value="false" <c:if test="${list.board_yn=='false'}">selected</c:if>>미사용</option>
										</select>
										<input type="hidden" name="boardNo" value="${list.board_no}">
										<button type="submit">수정</button>
										<br>
										<br>
									</form>
								
								</c:forEach>
							
								

								

								<hr>
							

						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
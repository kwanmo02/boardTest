<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.ddit.posts.model.PostsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




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
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">




<script>
	$(function() {
		$("table tbody tr").on("click", function() {
			$("#id").val($(this).data("id"));
			$("#frm").submit();
			console.log("table tbody tr clicked" + $(this).data("id")); //this 클릭시의 tr태그 값
		});
	});
</script>

</head>

<body>
	<%@ include file="/common/top.jsp"%>


	<form id="frm" action="/postDetail" method="get">
		<input type="hidden" name="id" id="id">
		<input type="hidden" name="board_no" value="${board_no}">
		<input type="hidden" name="updateAttachList" value="${AttachList}">
		<input type="hidden" name="updateAttachList2" value="${updateAttachList2}">
	</form>
		





	<%@include file="/common/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


		<div class="row">
			<div class="col-sm-8 blog-main">
				<h2 class="sub-header">게시글</h2>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>게시글 번호</th>
								<th>제 목</th>
								<th>작성자 아이디</th>
								<th>작성일시</th>
							</tr>
							
						</thead>

						<tbody>
							
							<c:forEach var="postsVo" items="${PostsList}">
								<%--tr태그 클릭시 상세 페이지로 이동 --%>
								<c:choose>
								<c:when test="${'false' eq postsVo.posts_yn}">
								<tr data-id="${postsVo.posts_no}">
									<!-- var.컬럼명 -->
									<th>${postsVo.posts_no}</th>
									<th>${postsVo.posts_title}</th>
									<th>${postsVo.mem_id}</th>
									<th><fmt:formatDate value="${postsVo.posts_reg}"
											pattern="yyyy/MM/dd" />
								</tr>
								</c:when>
								<c:when test="${'true' eq postsVo.posts_yn}">
									<tr onclick='event.cancelBubble=true;' ${postsVo.posts_no}> 
										<th onclick='event.cancelBubble=true;'>${postsVo.posts_no}</th>
										 <th onclick='event.cancelBubble=true;'>${postsVo.posts_title}</th>
			                             <th onclick='event.cancelBubble=true;'>${postsVo.mem_id}</th>
			                             <th onclick='event.cancelBubble=true;'><fmt:formatDate value="${postsVo.posts_reg}" pattern="yyyy-MM-dd"/></th>
			                         </tr>
								</c:when>
								
								</c:choose>
							</c:forEach>
							

						</tbody>
					</table>


				</div>
				
				<a href="/newPost?board_no=${board_no}&posts_no" class="btn btn-default pull-right">새글쓰기</a>
				
				<div class="text-center">
					<ul class="pagination">
					
						<%=request.getAttribute("pageNavi")%>


					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>


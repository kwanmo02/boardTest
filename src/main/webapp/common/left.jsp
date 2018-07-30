<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li class="active"><a href="/jsp/main.jsp">Main <span class="sr-only">(current)</span></a></li>
			<li><a href=""></a></li>
			<li><a href="/newBoard">자유게시판 생성</a></li>

		<c:forEach var="board" items="${boardList}">
			<c:if test="${board.board_yn=='true'}">
			<li><a href="/postServlet?page=1&pageSize=10&board_no=${board.board_no}">${board.board_name}</a></li>
			</c:if>
			
		</c:forEach>


	</ul>
</div>

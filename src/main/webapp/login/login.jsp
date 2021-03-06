<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS --> 
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="login.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <%@ include file="/common/jQuery.jsp" %>
    
    
    <script>
    	function getCookie(name){
    		var cookies = document.cookie;
    		
    		
    		var cookieArr = cookies.split("; ");
    		var cookieResult = "";
    		
    		
    		for(var i in cookieArr){
    			var cookie = cookieArr[i];
    			var cookieNameValue = cookie.split("=");
    			
    			var cookieName = cookieNameValue[0];
    			var cookieValue = cookieNameValue[1];
    			
    			if(name == cookieName){
    				cookieResult = cookieValue;
    				break;
    			}
				
    		}
    		return cookieResult; 
    	}	
    	
    	//쿠키추가
    	function setCookie(cookieName, cookieValue, expires){
    		var dt = new Date();
    		dt.setDate(dt.getDate() + parseInt(expires));
    		document.cookie = cookieName + "=" + cookieValue + "; " + "; path=/; expires=" +  dt.toGMTString();
    	}
    	
    	//쿠키삭제
    	function deleteCookie(cookieName){
			setCookie(cookieName,"",-1)

    	}
    	
    	
    	
  		$(function(){
				if (getCookie("rememberMe") == "y") {
					//userId input에 userId cookie값을 설정
					document.getElementById("userId").value = getCookie("userId");
					$("#userId").val(getCookie("userId"));
					$("#rememberMe").attr("checked", true);
					$("#rememberMe").val(getCookie("rememberMe"));
  			}
				
				
				//rememberMe 체크박스클릭이벤트
				$("#rememberMe").on("click", function(){
					
					if($(this).is(":checked")){
						//rememberMe cookie 설정
						setCookie("rememberMe", "y", 30);
						setCookie("userId", $("#userId").val(), 30);
					}else{
						//쿠키제거
						deleteCookie("rememberMe");
					}
				});
		});
		</script>
    
    
</head>

<body onload="javascript:init();">

	<!-- 
		1. 사용자가 로그인 화면을 접속한다.(localhost:8180/login/login.jsp)
		2. 사용자가 아이디, 비밀번호를 입력후 signin 버튼을 클릭
		 -> signin 버튼이 속한 form 태그의 action 속성에 설정된 url로 요청
		3. LoginServlet 파라미터(userId, password)를 확인 후 고정된 값을 비교 
			같을경우에는 response객체의 writer객체를 이용하여 화면에 "접속성공"
			틀릴경우에는 "접속 실패" 메세지 출력
		
	 -->

	<div class="container">
		session.getId : <%=session.getId()%>
		<form class="form-signin" action="/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			
			<%-- <%
				String userId = request.getParameter("userId");
				userId = userId==null ? "": userId;
			%> El로 했으므로 지워도 된다.--%>
			
			<label for="userId" class="sr-only">userId</label> 
			<input type="text" name="mem_id" id="userId" class="form-control" placeholder="Email address" required autofocus 
						value="${param.mem_id}">
											
			
			<label	for="password" class="sr-only">Password</label> 
			<input type="password" name="password" id="Password" class="form-control" placeholder="Password" required>
				
				
			<div class="checkbox">
				 <label> 
				 	<input type="checkbox" id="rememberMe" name="rememberMe" value="remember-me"> 내맴속에 지어즈앙
				</label> 
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Signin</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

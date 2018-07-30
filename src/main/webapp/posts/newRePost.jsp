<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>




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


<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->

<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>

<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->

<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>

<script type="text/javascript">
	var oEditors = [];

	$(function() {

		nhn.husky.EZCreator.createInIFrame({

			oAppRef : oEditors,

			elPlaceHolder : "ir1", //textarea에서 지정한 id와 일치해야 합니다. 

			//SmartEditor2Skin.html 파일이 존재하는 경로

			sSkinURI : "/SE2/SmartEditor2Skin.html",

			htParams : {

				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)

				bUseToolbar : true,

				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)

				bUseVerticalResizer : true,

				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)

				bUseModeChanger : true,

				fOnBeforeUnload : function() {

				}

			},

			fOnAppLoad : function() {

				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용

				

			},

			fCreator : "createSEditor2"

		});

		//저장버튼 클릭시 form 전송

		$("#save").click(function() {

			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			if(validation()){
				if(frmCheck()){
					$("#frm").submit();
					
				}
			}

		});

	});
	
	
	

	var oTbl;
	var filenum = 0;
	//Row 추가
	function insRow() {
	  if(filenum==5){
	     alert("파일은 최대 5개까지만 첨부가 가능합니다.");
	     return;
	   }
	  oTbl = document.getElementById("addTable");
	  var oRow = oTbl.insertRow();
	  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
	  var oCell = oRow.insertCell();

	  //삽입될 Form Tag
	  var frmTag = "<input type=\"file\" id=\"uploadFile\" name=\"uploadFile\"/>";
	  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
	  filenum++;
	  oCell.innerHTML = frmTag;
	}
	//Row 삭제
	function removeRow() {
	  oTbl.deleteRow(oTbl.clickedRowIndex);
	}

	function frmCheck(){
	  var frm = document.form;
	  
	  for( var i = 0; i <= frm.elements.length-1 ; i++ ){
	     if( frm.elements[i].name == "uploadFile" )
	     {
	         if( !frm.elements[i].value ){
	             alert("첨가파일을 선택하지 않았습니다.");
	                 frm.elements[i].focus();
	          return false;
	          }
	      }
	   }
	    return true;
	 }
	
	
	
	
	
	
	
	
	
	
	
	</script>


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
							<h2 class="blog-post-title">답글</h2>
							<hr>
							
							<form id="frm" class="form-signin" method="post" action="/createReposts" enctype="multipart/form-data">
								<%-- <input type="hidden" value="${param.posts_no2}" name="posts_no2">
								<input type="hidden" value="${param.posts_gcode}" name="posts_gcode"> --%>
								제목 : <input type="text" name="posts_title" placeholder="제목을 입력해주세요"><br><br>
								<textarea rows="10" cols="30" id="ir1" name="content" style="width: 650px; height: 350px;"></textarea>
 								 <input type="hidden" name="board_no" value="${param.board_no}">  
 								 <input type="hidden" name="posts_no2" value="${param.posts_no2}">  
								<hr>
								${param.board_no}
								<hr>
								
										<table>
								  <tr>
								    <td colspan="2" align="left" bgcolor="#FFFFFF">
								      <table >
								        <tr>
								         <td colspan="5" bgcolor="#FFFFFF" height="25" align="left">
								         <input name="addButton" type="button" style="cursor:hand" onClick="insRow()" value="첨부파일 추가">
								         <font color="#FF0000"></font></td>
								        </tr>
								        <tr>
								         <td height="25">
								           <table id="addTable">
								            <tr>
								              <td align="left"></td>
								            </tr>
								          </table></td>
								        </tr>
								       </table>
								      </td>
								   </tr>
								 </table>
								
								
								<button id="save" type="submit">저장</button>
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
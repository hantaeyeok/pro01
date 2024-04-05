<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path0" value="<%=request.getContextPath() %>"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<title>${title }</title>
<%@ include file ="/head.jsp"%>
<style>
.container {width: 1400px;}
.page {clear: both; height: 100vh}
#page1 { background-color: #81F7F3; }
#page2 { background-color: #AC58FA; }
#page3 { background-color: #9FF781; }
#page4 { background-color: #FF0000; }
.page_title {font-size :36px;  padding-top: 2em; text-align: center;}
</style>
</head>

<body>
<h1>메인</h1>
<div id="header">
	<%@ include file="/header.jsp" %>
</div>
<div id="contents">
	<h2>콘텐츠 영역</h2>
	<div>
		<section class="page" id="page1">
			<h3 class="page_title" >${author }</h3>
		</section>
	</div>
	<div>
		<h3 class="page_title" >디렉토리 확인</h3>
		<section class="page" id="page2">
			<div style="width: 1400px"; margin : 0 auto;>
			<h3>임시서버에플리케이션 : ${realPath }</h3>
			<h3>main 프로젝트 디렉토리 : ${path0 }</h3>
			<h3>head 프로젝트 디렉토리 : ${ipath }</h3>
			<h3>header 프로젝트 디렉토리 : ${hpath }</h3>
			</div>
		</section>
</div>

<div id="footer">
	<%@ include file="/footer.jsp" %>
</div>
</body>
</html>
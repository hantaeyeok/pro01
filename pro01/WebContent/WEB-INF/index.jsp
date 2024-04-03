<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<%@ include file ="/head.jsp"%>
</head>
<body>
<h1>메인</h1>
<div id="header">
	<%@ include file="/header.jsp" %>
</div>
<div id="contents">
	<h2>콘텐츠 영역</h2>
	<p>${author }</p>
</div>
<div id="footer">
	<%@ include file="/footer.jsp" %>
</div>
</body>
</html>
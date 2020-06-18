<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/test.css" rel="stylesheet">
<meta charset="UTF-8">
<title><fmt:message key="title.ranking" /></title>
</head>
<body>
	<h1>
		<fmt:message key="title.ranking" />
	</h1>

	<div class=center>
		<h2>
			<fmt:message key="btn.personal.ranking" />
		</h2>
	</div>

	<h3>あなたの現在順位は○○です</h3>

	<br>
	<a href="overallRanking" class="btn"><fmt:message
			key="btn.overall.ranking" /></a>
	<br>
	<br>
	<a href="ranking" class="btn"><fmt:message key="btn.back" /></a>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>
	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
</body>
</html>
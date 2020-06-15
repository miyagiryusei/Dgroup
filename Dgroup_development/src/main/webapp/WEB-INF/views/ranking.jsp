<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/commons.css" rel="stylesheet">
<meta charset="UTF-8">
<title><fmt:message key="title.ranking" /></title>
</head>
<body>
	<h1>
		<fmt:message key="title.ranking" />
	</h1>

	<a href="overallRanking" class="btn"><fmt:message
			key="btn.overall.ranking" /></a>
	<br><br>

	<a href="personalRanking" class="btn"><fmt:message
			key="btn.personal.ranking" /></a>
	<br><br>
<%-- 	<a href="login" class="btn"><fmt:message key="btn.back" /></a> --%>
</body>
</html>
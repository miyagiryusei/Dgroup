<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/commons.css" rel="stylesheet">
<title><fmt:message key="title.blackjack" /></title>
</head>
<body>
	<h1>ブラックジャック</h1>
	<a href="login" class="btn"><fmt:message key="btn.start" /></a>

	<br><br>


	 <a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a><br><br>

	 <a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
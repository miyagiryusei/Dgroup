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
<title><fmt:message key="title.myPage" /></title>
<link href="css/myPage.css" rel="stylesheet">
</head>
<body>

	<br>
	<br>

	<div class=whit>
		<h3>正常に登録できました。</h3>
	</div>

<c:if test="${ empty flg}">
		<a href="login" class="logoutBtn">ログイン画面へ</a>
	</c:if>

	<c:if test="${not empty flg}">
		<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
		<br>
		<br>

		<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
	</c:if>





</body>
</html>
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

<title>Insert title here</title>
</head>
<body>

	<form:form action="accounteditA" modelAttribute="user">
		<h1>アカウント編集</h1>
		<div>
			<label>ID</label> <input type="text" name="loginName">
		</div>
		<div>
			<label>パスワード</label> <input type="password" name="pass">
		</div>
		<button type="submit">変更する</button>
	</form:form>

	<div>
		 <a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a><br><br>

	 <a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>

	</div>
</body>
</html>
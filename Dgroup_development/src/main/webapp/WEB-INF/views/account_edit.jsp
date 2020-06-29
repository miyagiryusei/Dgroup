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
<link href="css/myPage.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>


	<form:form action="accounteditA" modelAttribute="user">
		<h1>アカウント編集</h1>
		<c:if test="${not empty msg}">
		<div class=whit>
			<h3>${msg}</h3>
		</div>
		</c:if>

		<label>ユーザー名</label><br>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			 <input type="text" name="userName"
				class="btn-border-gradient">
			<form:errors path="userName" class="required" />
		</div>
		<br>
		<br>

		<label>パスワード</label><br>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			 <input type="password" name="pass"
				class="btn-border-gradient">
			<form:errors path="pass" class="required" />
		</div>
		<br>
		<br>

		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

			<button type="submit" class="btn btn-border-gradient">
				<span class="btn-text-gradient--gold">変更</span>
			</button>
		</div>
	</form:form>

	<div>
		<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a><br>
		<br> <a href="logout" class="logoutBtn"><fmt:message
				key="btn.logout" /></a>

	</div>
</body>
</html>
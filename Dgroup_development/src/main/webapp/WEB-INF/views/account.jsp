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
<link href="css/account.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>




	<form:form action="account" modelAttribute="user" method="post">
		<h1>アカウント作成</h1>
		<c:if test="${not empty massage}">
		<div class=whit>
			<h3>${massage}</h3>
		</div>
		</c:if>

		<p>
			<label>ID</label>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<input class="btn-border-gradient" type="text" name="loginId">
			<form:errors path="loginId" class="required" />
		</div>

		<p>
			<label>ユーザー名</label>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<input class="btn-border-gradient" type="text" name="userName">
			<form:errors path="userName" class="required" />
		</div>

		<p>
			<label>パスワード</label>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<input class="btn-border-gradient" type="password" name="pass">
			<form:errors path="pass" class="required" />
		</div>

		<br>
		<br>


		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

			<button type="submit" class="btn btn-border-gradient">
				<span class="btn-text-gradient--gold">作成</span>
			</button>
		</div>
	</form:form>
	<div>

		<a href="login" class="myPageBtn">戻る</a><br>
		<br>


	</div>

</body>
</html>
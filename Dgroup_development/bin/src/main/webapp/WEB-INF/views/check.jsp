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
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<form:form action="checkA" method="post" modelAttribute="user"
		class="center">
		<h1 class="checkh1">確認画面</h1>
	${msg}
	<p class="checkp">以下の内容でよろしいですか？</p>

		<div>
			<c:if test="${empty flg}">
			<label>ID</label> <input type="text" name="loginId" value="${id}"
				readonly>
				</c:if>
		</div>
		<div>
			<label>名前</label> <input type="text" name="loginName" value="${name}"
				readonly>
		</div>

		<div>
			<label>パスワード(再入力)</label> <input type="password" name="pass">
		</div>
		<div>
			<c:if test="${not empty flg}">
				<form:button name="update" class="button-right">
					<fmt:message key="btn.update" />
				</form:button>
			</c:if>
			<c:if test="${empty flg}">
				<form:button name="insert" class="button-right">
					<fmt:message key="btn.insert" />
				</form:button>
			</c:if>

		</div>
	</form:form>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>





</body>
</html>
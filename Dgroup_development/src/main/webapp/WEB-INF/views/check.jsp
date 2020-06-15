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

	<form:form action="check" method="post" modelAttribute="checkForm"
		class="right">
	<h1 class ="checkh1">確認画面</h1>
	<p class ="checkp">以下の内容でよろしいですか？</p>

		<div>
			<label>名前</label> <input type="text" name="loginame"
				value="${loginname}" readonly>
		</div>
		<div>
			<label>パスワード</label> <input type="password" name="pass">
		</div>
		<div>
				<form:button class="button-right">
					<fmt:message key="btn.insert" />
				</form:button>
			</div>
	</form:form>



</body>
</html>
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
<title><fmt:message key="title.login" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty errMsg}">
		<p>${fn:escapeXml(errMsg)}</p>
	</c:if>

	<form:form action="login" method="post" modelAttribute="loginForm" class="right">
		<fieldset>
			<div>
				<label class="little-right"><fmt:message key="lbl.id" /></label>
				<div><form:input path="loginId" /></div>
				<form:errors path="loginId" class="required" />
			</div>
			<div>
				<label><fmt:message key="lbl.pass" /></label>
				<div><form:input type="password" path="password" /></div>
				<form:errors path="password" class="required" />
			</div>
			<div>
				<form:button class="button-right">
					<fmt:message key="btn.login" />
				</form:button>
			</div>
		</fieldset>
	</form:form>
	<div class="right">
		<a href="index">TOP画面に戻る</a>
	</div>


</body>
</html>
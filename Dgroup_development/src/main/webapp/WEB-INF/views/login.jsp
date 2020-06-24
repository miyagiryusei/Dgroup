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
<link href="css/login.css" rel="stylesheet">
</head>
<body>



	<header>
		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<a href="insert" class="btn btn-border-gradient"><span
				class="btn-text-gradient--gold"><fmt:message
						key="btn.begginer" /></span></a>
		</div>
	</header>

	<div class="loading">
		<span class="dreams">O</span> <span class="dreams">k</span> <span class="dreams">i</span> <span class="dreams">V</span>
		<span class="dreams">e</span><span class="dreams">g</span><span class="dreams">a</span><span class="dreams">s</span>
	</div>

	<c:if test="${not empty errMsg}">
		<div class=whit>
		<h3>${fn:escapeXml(errMsg)}</h3>
		</div>
	</c:if>


	<form:form action="login" method="post" modelAttribute="loginForm"
		class="right">
		<fieldset>

			<div>

				<label class="little-right"><fmt:message key="lbl.id" /></label><br>
				<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
					<form:input path="loginId" class="btn-border-gradient" />
					<form:errors path="loginId" class="required" />
				</div>

			</div>
			<div>
				<label><fmt:message key="lbl.pass" /></label><br>
				<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
					<form:input type="password" path="password"
						class="btn-border-gradient" />
						<form:errors path="password" class="required" />
				</div>

			</div>

			<div class="aa">
				<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
					<button type="submit" class="btn btn-border-gradient">
						<span class="btn-text-gradient--gold"><fmt:message
								key="btn.login" /></span>
					</button>
				</div>
			</div>



		</fieldset>



	</form:form>


</body>
</html>
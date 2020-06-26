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
<title>Insert title here</title>
<link href="css/myPage.css" rel="stylesheet">
</head>
<body class="background${fn:escapeXml(user.backgroundId)}">

	<c:if test="${empty user}">
		<c:redirect url="/login" />
	</c:if>

	<h1>ポーカーホーム画面</h1>

	<div class=white>
		<h3>${fn:escapeXml(user.userName)}<br>
			所持コイン：${fn:escapeXml(user.coin)}<br>
			ランク：${fn:escapeXml(user.rankName)}
		</h3>
	</div>

	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="poker" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.poker" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="pokerRule" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold">ポーカールール</span></a>
	</div>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
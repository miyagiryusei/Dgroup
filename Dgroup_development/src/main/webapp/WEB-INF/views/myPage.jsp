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
	<c:if test="${empty user}">
　  	<c:redirect url="/login" />
    </c:if>

	<h1>Myページ</h1>

	<div class=white>
	<h3>${fn:escapeXml(user.userName)}<br>
	所持コイン：${fn:escapeXml(user.coin)}<br>
	ランク：${fn:escapeXml(user.rankName)}</h3>
	</div>


   <div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="pokerHome" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.poker" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="blackjack" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.blackjack" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

		<a href="item" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.itemShop" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="itemList" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.itemList" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="ranking" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.ranking" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="account_edit" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.acount" /></span></a>
	</div>
	<br>
	<br>

	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
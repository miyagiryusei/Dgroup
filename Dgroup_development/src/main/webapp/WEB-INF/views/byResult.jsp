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
<title><fmt:message key="title.byResult" /></title>
</head>
<body class="background${fn:escapeXml(user.backgroundId)}">

	<br>
	<br>
	<div class=whit>
		<h3>購入が完了しました</h3>
	</div>

	<br><br>


	<div class="aa">
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

		<a href="item" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.itemShop" />へ</span></a>
	</div>


	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

		<a href="itemList" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold">アイテムリストへ</span></a>
	</div>
	</div>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>
</body>
</html>
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
</head>
<link href="css/myPage.css" rel="stylesheet">
<title><fmt:message key="title.itemShop" /></title>
</head>
<body>
	<h1>所持アイテム</h1>
	<form:form action="itemuse" modelAttribute="user" method="get">

	<div class=white>
		<h3>${fn:escapeXml(us.userName)}<br>
		所持コイン:${fn:escapeXml(us.coin)}</h3>
	</div>


		<c:if test="${not empty itemcoin}">
		<div class=white>
			<h3>コインを${itemcoin}枚得ました</h3>
		</div>
		</c:if>





		<c:if test="${empty msg}">
			<table>
				<tr>
					<th>使用</th>
					<th>アイテム名</th>
					<th>効果</th>
					<th>所持数</th>

				</tr>

				<c:forEach var="list" items="${list}">
					<tr>
						<td><form:radiobutton value="${list.itemId}" path="itemId" /></td>
						<td class="icon bird">${fn:escapeXml(list.name)}</td>
						<td>${fn:escapeXml(list.effect)}</td>
						<td>${fn:escapeXml(list.itemCount)}</td>
					</tr>
				</c:forEach>





			</table>

			<br>
			<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

				<button type="submit" class="btn btn-border-gradient"><span
					class="btn-text-gradient--gold">使用</span></button>
			</div>
<!-- 			<button type="submit" class=>使用</button> -->
			<br>
			<br>

		</c:if>
		<c:if test="${not empty msg}">
		<div class=whit>
			<h3>${msg}</h3>
		</div>
		</c:if>
	</form:form>


	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
</body>
</html>
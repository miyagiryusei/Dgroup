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
<link href="css/commons.css" rel="stylesheet">
<title><fmt:message key="title.itemShop" /></title>
</head>
<body>
	<h2>所持アイテム</h2>
	<form:form action="itemuse" modelAttribute="user" method="get">
		<p>${fn:escapeXml(us.userName)}</p>
		<p>所持コイン:${fn:escapeXml(us.coin)}</p>

		<c:if test="${not empty itemcoin}">
			<p>コインを${itemcoin}枚得ました</p>
		</c:if>



		<c:if test="${empty msg}">
			<h3>所持アイテム一覧</h3>
			<table>
				<tr>
					<th>使用</th>
					<th>アイテム名</th>
					<th>効果</th>
					<th>所持数</th>

				</tr>

				<c:forEach var="list" items="${list}">
					<tr>
						<td><form:checkbox value="${list.itemId}" path="itemId" /></td>
						<td>${fn:escapeXml(list.name)}</td>
						<td>${fn:escapeXml(list.effect)}</td>
						<td>${fn:escapeXml(list.itemCount)}</td>
					</tr>
				</c:forEach>
				<button type="submit">使用</button>
				<br>
				<br>




			</table>

		</c:if>
		<c:if test="${not empty msg}">
			${msg}
		</c:if>
	</form:form>


	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
</body>
</html>
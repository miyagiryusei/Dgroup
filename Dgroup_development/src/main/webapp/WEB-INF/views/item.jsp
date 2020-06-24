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

	<form:form action="buy" modelAttribute="itemShopForm" method="get">
		<h1>アイテムショップ</h1>




		<div class=white>
		<h3>
		${fn:escapeXml(user.userName)}<br>
		所持コイン:${fn:escapeXml(user.coin)}<br>
		</h3>
		</div>

		<c:if test="${not empty msgg}">
			<div class=whit>
				<h3>${msgg}</h3>
			</div>
		</c:if>

				<table>
					<caption>アイテム一覧</caption>
					<thead>
						<tr>
							<th></th>
							<th>アイテム名</th>
							<th>効果</th>
							<th>必要コイン</th>
						</tr>


						<c:forEach items="${item}" var="item">
							<tr>
								<td><form:checkbox value="${item.itemId}" path="itemId" /></td>
								<td>${item.name}</td>
								<td>${item.effect }</td>
								<td>${item.price}</td>

							</tr>
						</c:forEach>

					</thead>


				</table>


		<br>

		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

			<button type="submit" class="btn btn-border-gradient">
				<span class="btn-text-gradient--gold">購入</span>
			</button>
		</div>
	</form:form>


	<br>


	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>



</body>
</html>
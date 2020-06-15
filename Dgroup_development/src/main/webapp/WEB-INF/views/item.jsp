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
<link href="css/commons.css" rel="stylesheet">
<title><fmt:message key="title.itemShop" /></title>
</head>
<body>
	<h2>アイテムショップ</h2>
	<p>userName<p>
	所持コイン:999


	<table>
    <caption>アイテム一覧</caption>
    <thead>
      <tr>
		<th> </th>
        <th>アイテム名</th>
        <th>効果</th>
        <th>必要コイン</th>
<%--         <fmt:message key="lbl.itemName" /> --%>
<%--         <fmt:message key="lbl.itemEffect" /> --%>
<%--         <fmt:message key="lbl.itemPlace" /> --%>
      </tr>
    </thead>
<!--     	<tr> -->
<%--     	 <c:forEach items="${friendList}" var="friend"> --%>
<%--            <td><form:checkbox label="${friend.userName}" value="${friend.userName}" path="friendList"/></td> --%>
<%--          </c:forEach> --%>
<!--         </tr> -->
		<tr>
			<td><input type="checkbox"></td>
			<td>test1</td>
			<td>test1111</td>
			<td>100</td>
		</tr>

		<tr>
			<td><input type="checkbox"></td>
			<td>test2</td>
			<td>test2222</td>
			<td>999</td>
		</tr>

</table>
<br>

	<a href="buy" class="btn"><fmt:message
			key="btn.buy" /></a>
	<br><br>


	<a href="item" class="btn"><fmt:message key="btn.back" /></a>
	<br>

	<form action="logout" method="post">
    	<button type="submit">
     		<fmt:message key="btn.logout" />
    	</button>
  	</form>

</body>
</html>
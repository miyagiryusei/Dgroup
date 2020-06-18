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
	<p>userName
	<p>所持コイン:999
	<table>
		<caption>所持アイテム一覧</caption>
		<tr>
			<th>アイテム名</th>
			<th>効果</th>
			<th>所持数</th>
		</tr>
		<tr>
			<td>アイテム１</td>
			<td>すごい</td>
			<td>3</td>
		</tr>
		<tr>
			<td>アイテム2</td>
			<td>やばい</td>
			<td>1</td>
		</tr>
	</table>
	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>

	<a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
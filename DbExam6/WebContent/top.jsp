<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB連携＿演習問題6</title>
</head>
<body>

	<h1>検索条件を入力してください</h1>

	<c:if test="${not empty msg}">
    <div class="msg">
      <p>${requestScope.msg}</p>
    </div>
    </c:if>

	<form action="InputServlet" method="get">
	product_id:<input type="text" name="product_id" value="${fn:escapeXml(param.id) }">

	<br>
	<input type="submit" name="btn" value="検索">
	</form>

</body>
</html>
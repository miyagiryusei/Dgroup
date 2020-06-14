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
<title><fmt:message key="title.itemList" /></title>
</head>
<body>

	<h2>所持アイテム一覧</h2>

	<table>
    <caption>アイテム一覧</caption>
    <thead>
      <tr>
        <th><fmt:message key="lbl.itemName" /></th>
        <th><fmt:message key="lbl.itemEffect" /></th>
      </tr>
    </thead>
</table>
<br>
	<a href="itemShop" class="btn"><fmt:message
			key="btn.itemShop" /></a>
	<br><br>
	<a href="item" class="btn"><fmt:message key="btn.back" /></a>


</body>
</html>
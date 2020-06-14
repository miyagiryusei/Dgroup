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
<title><fmt:message key="title.item" /></title>
</head>
<body>
	<h1>アイテム</h1>

	 <a href="itemShop" class="btn"><fmt:message key="btn.itemShop" /></a>
     <br><br>

	 <a href="itemList" class="btn"><fmt:message key="btn.itemList" /></a>

	 <br><br>
	 <a href="myPage" class="btn"><fmt:message key="btn.back" /></a>


</body>
</html>
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
<link href="css/myPage.css" rel="stylesheet">
</head>
<body>
	<p>結果<p>

	<p>${pokerResult}</p>
	<p>${getCoin}</p>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<a href="pokerGame" class="btn">もう一度</a>


</body>
</html>
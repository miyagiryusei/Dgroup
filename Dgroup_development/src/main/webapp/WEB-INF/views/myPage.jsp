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
<title><fmt:message key="title.myPage" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<h1>Myページ</h1>


    <a href="poker" class="btn"><fmt:message key="btn.poker" /></a>
    <br><br>


    <a href="blackjack" class="btn"><fmt:message key="btn.blackjack" /></a>
 　 <br><br>


    <a href="item" class="btn"><fmt:message key="btn.item" /></a>
    <br><br>


    <a href="ranking" class="btn"><fmt:message key="btn.ranking" /></a>
    <br><br>


    <a href="acount" class="btn"><fmt:message key="btn.acount" /></a>
    <br><br>

	<form action="logout" method="post">
    	<button type="submit">
     		<fmt:message key="btn.logout" />
    	</button>
  	</form>
</body>
</html>
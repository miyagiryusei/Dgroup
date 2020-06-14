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
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<h1>Myページ</h1>

	<p>
    <a href="poker" class="btn"><fmt:message key="btn.poker" /></a>
    </p>

  	<p>
    <a href="blackjack" class="btn"><fmt:message key="btn.blackjack" /></a>
 　 </p>

    <p>
      <a href="itemShop" class="btn"><fmt:message key="btn.itemShop" /></a>
    </p>

    <p>
      <a href="ranking" class="btn"><fmt:message key="btn.ranking" /></a>
    </p>

    <p>
      <a href="acount" class="btn"><fmt:message key="btn.acount" /></a>
    </p>

	<form action="logout" method="post">
    	<button type="submit">
     		<fmt:message key="btn.logout" />
    	</button>
  	</form>
</body>
</html>
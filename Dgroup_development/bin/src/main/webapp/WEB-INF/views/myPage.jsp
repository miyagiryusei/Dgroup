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
<link href="css/myPage.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty user}">
　  	<c:redirect url="/login" />
    </c:if>

	<h1>Myページ</h1>

	<p>${fn:escapeXml(user.userName)}</p>
	<p>所持コイン：${fn:escapeXml(user.coin)}</p>
	<p>ランク：${fn:escapeXml(user.rankName)}</p>



    <a href="poker" class="btn"><fmt:message key="btn.poker" /></a>
    <br><br>


    <a href="blackjack" class="btn"><fmt:message key="btn.blackjack" /></a>
 　 <br><br>


    <a href="item" class="btn"><fmt:message key="btn.itemShop" /></a>
    <br><br>

    <a href="itemList" class="btn"><fmt:message key="btn.itemList" /></a>
    <br><br>


    <a href="ranking" class="btn"><fmt:message key="btn.ranking" /></a>
    <br><br>


    <a href="account_edit" class="btn"><fmt:message key="btn.acount" /></a>
    <br><br>

	 <a href="login" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
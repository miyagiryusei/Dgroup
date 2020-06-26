<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCtype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="widht=device-widht, initial-scale=1.0">
<link rel="stylesheet" href="css/poker.css">
<script src="js/jquery.min.js"></script>
<script src="js/poker.js" defer></script>
<title>poker</title>
</head>
<body>
	<%-- <c:if test="${empty user}">
		<c:redirect url="/login" />
	</c:if> --%>
	<div class=white>
		<h3>${fn:escapeXml(user.userName)}<br>
			所持コイン：${fn:escapeXml(user.coin)}<br>
			ランク：${fn:escapeXml(user.rankName)}
		</h3>
	</div>
	<div id="img"></div>
	<div id="msgdisplay" class="msgdisplay"></div>
	<div id="roledisplay" class="roledisplay"></div>
	<div class="button">
		<input id="startbutton" type="button" value="START"
			onclick="startgame()"><br> <input id="nextbutton"
			type="button" value="NEXT GAME" onclick="nextgame()"><br>
		<input type="text" id="betmaney" placeholder="金額を入力して下さい"><br>
		<input type="button" id="betbutton" value="BET" onclick="bet()"><br>
		<input type="button" id="changebutton" value="CHANGE"
			onclick="change()">
	</div>
	<div class="roledisplay" id="resultbetmany"></div>
	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
</body>
</html>
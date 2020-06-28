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
	<c:if test="${empty user}">
		<c:redirect url="/login" />
	</c:if>
	<div class=white>
		<h3>${fn:escapeXml(user.userName)}<br> 所持コイン：<span id="coin">${fn:escapeXml(user.coin)}</span><br>
			ランク：<span id="rank">${fn:escapeXml(user.rankName)}</span>
		</h3>
	</div>
	<div class=whit>
		<div id="resultmany"></div>
	</div>
	<div id="img"></div>

	<div id="msgdisplay" class="msgdisplay"></div>
	<div id="roledisplay" class="roledisplay"></div>



	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<input class="btn btn-border-gradient" id="startbutton" type="button"
			value="START" onclick="startgame()"><br>
	</div>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<input class="btn btn-border-gradient-next" id="nextbutton"
			type="button" value="NEXT GAME" onclick="nextgame()"><br>
	</div>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<input class="btn btn-border-gradient-betmany" type="number"
			id="betmaney" placeholder="金額を入力して下さい">
	</div>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<input class="btn btn-border-gradient-change" type="button"
			id="changebutton" value="CHANGE" onclick="change()">
	</div>
	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
</body>
</html>
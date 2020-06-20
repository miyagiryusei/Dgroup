<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/ranking.css" rel="stylesheet">
<meta charset="UTF-8">
<title><fmt:message key="title.ranking" /></title>
</head>
<body>
	<h1>
		<fmt:message key="title.ranking" />
	</h1>

	<div class=center>
		<h2>
			<fmt:message key="btn.personal.ranking" />
		</h2>
	</div>

	<article>
		<h3>${fn:escapeXml(user.userName)}様
			開始日：${fn:escapeXml(user.insertTime)}
			総ゲーム数：${fn:escapeXml(pokerRanking[0].count)}
			ポーカー試合数${fn:escapeXml(pokerSumList[0].count)}
			ブラックジャック試合数${fn:escapeXml(bjSumList[0].count)}</h3>

		<p>・${fn:escapeXml(user.userName)}様の現在の所持金は${fn:escapeXml(user.coin)}です</p>

		<p>所持金ランキングで現在${fn:escapeXml(pokerRanking[0].rank)}位です。1位との差額は${fn:escapeXml(pokerRanking[0].difference)}です</p>



		<p>・${fn:escapeXml(user.userName)}様のBJでの総獲得金額は${fn:escapeXml(bjSumList[0].sumCoin)}です。</p>

		<p>BJ総獲得金額ランキングで${fn:escapeXml(bjSumList[0].rank)}位です。1位との差額は${fn:escapeXml(bjSumList[0].difference)}です</p>



		<p>・${fn:escapeXml(user.userName)}様のポーカーでの総獲得金額は${fn:escapeXml(pokerSumList[0].sumCoin)}です。</p>

		<p>ポーカー総獲得金額ランキングで${fn:escapeXml(pokerSumList[0].rank)}位です。1位との差額は${fn:escapeXml(pokerSumList[0].difference)}です</p>



		<p>・${fn:escapeXml(user.userName)}様のポーカー1試合での最高獲得枚数は${fn:escapeXml(pokerOneTimeList[0].coin)}です。</p>

		<p>ポーカー1試合での最高獲得枚数ランキングで${fn:escapeXml(pokerOneTimeList[0].rank)}位です。1位との差額は${fn:escapeXml(pokerOneTimeList[0].difference)}です</p>


		<p>・${fn:escapeXml(user.userName)}様がポーカーで出したの最高の役は${fn:escapeXml(pokerRoleRankingList[0].pokerRoleName)}です</p>


		<p>・${fn:escapeXml(user.userName)}様が今まで出したポーカーの役</p>

		<c:forEach items="${pokerRoleCountList}" var="role">
				・役：${fn:escapeXml(role.pokerRoleName)} 回数：${fn:escapeXml(role.count)}様<br>
		</c:forEach>

	</article>

	<br>
	<a href="overallRanking" class="btn"><fmt:message
			key="btn.overall.ranking" /></a>
	<br>
	<br>
	<a href="ranking" class="btn"><fmt:message key="btn.back" /></a>
	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>
	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
</body>
</html>
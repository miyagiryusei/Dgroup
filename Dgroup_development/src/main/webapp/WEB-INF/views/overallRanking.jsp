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
			<fmt:message key="btn.overall.ranking" />
		</h2>
	</div>

	<h3>
		総ゲーム数：${fn:escapeXml(overallSumMatch[0].count)}<br>
		ポーカー試合数:${fn:escapeXml(overallpokerSumMatch[0].count)}<br>
		ブラックジャック試合数:${fn:escapeXml(overallbjSumMatch[0].count)}<br>
	</h3>

<article  class = overall>
	<table>
		<caption>総合コイン獲得ランキング-50位まで表示-</caption>
		<thead>
			<tr>
				<th>順位</th>
				<th><fmt:message key="lbl.user.name" /></th>
				<th>ランク名</th>
				<th><fmt:message key="|b|.coin.have" /></th>
				<th>一位との差</th>
				<th>総ゲーム回数</th>
			</tr>
		</thead>
		<c:forEach items="${overallRanking}" var="ranking">
			<tr>
				<td>${fn:escapeXml(ranking.rank)}</td>
				<td>${fn:escapeXml(ranking.userName)}</td>
				<td>${fn:escapeXml(ranking.rankName)}</td>
				<td>${fn:escapeXml(ranking.coin)}</td>
				<td>${fn:escapeXml(ranking.difference)}</td>
				<td>${fn:escapeXml(ranking.count)}</td>
			</tr>
		</c:forEach>
	</table>
	</article>
	<br>
	<a href="personalRanking" class="btn"><fmt:message
			key="btn.personal.ranking" /></a>
	<br>
	<br>
	<a href="ranking" class="btn"><fmt:message key="btn.back" /></a>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>
	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>

</body>
</html>
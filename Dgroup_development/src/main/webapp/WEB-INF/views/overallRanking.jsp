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
	<a id="top"></a>
	<div class="title-set">
		<h1>
			<fmt:message key="btn.overall.ranking" />
		</h1>
	</div>


	<div class=white>
		<h3>
			総ゲーム数：${fn:escapeXml(overallSumMatch[0].count)}<br>
			ポーカー試合数:${fn:escapeXml(overallpokerSumMatch[0].count)}<br>
			ブラックジャック試合数:${fn:escapeXml(overallbjSumMatch[0].count)}<br>
		</h3>
	</div>

	<div class=overall>
		<table>
			<caption>総合コイン獲得ランキング-50位まで表示-</caption>
			<thead>
				<tr>
					<th class=borderleft>順位</th>
					<th><fmt:message key="lbl.user.name" /></th>
					<th>ランク名</th>
					<th><fmt:message key="|b|.coin.have" /></th>
					<th>一位との差</th>
					<th>総ゲーム回数</th>
				</tr>
			</thead>
			<c:forEach items="${overallRanking}" var="ranking">
				<tr>
					<td class=borderleft>${fn:escapeXml(ranking.rank)}</td>
					<td>${fn:escapeXml(ranking.userName)}</td>
					<td>${fn:escapeXml(ranking.rankName)}</td>
					<td>${fn:escapeXml(ranking.coin)}</td>
					<td>${fn:escapeXml(ranking.difference)}枚</td>
					<td>${fn:escapeXml(ranking.count)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class=overall>
		<table>
			<caption>BJコイン獲得ランキング-50位まで表示-</caption>
			<thead>
				<tr>
					<th class=borderleft>順位</th>
					<th><fmt:message key="lbl.user.name" /></th>
					<th>ランク名</th>
					<th>BJ獲得コイン</th>
					<th>一位との差</th>
					<th>総ゲーム回数</th>
				</tr>
			</thead>
			<c:forEach items="${overallbjSum}" var="ranking">
				<tr>
					<td class=borderleft>${fn:escapeXml(ranking.rank)}</td>
					<td>${fn:escapeXml(ranking.userName)}</td>
					<td>${fn:escapeXml(ranking.rankName)}</td>
					<td>${fn:escapeXml(ranking.coin)}</td>
					<td>${fn:escapeXml(ranking.difference)}枚</td>
					<td>${fn:escapeXml(ranking.count)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class=overall>
		<table>
			<caption>ポーカーコイン獲得ランキング-50位まで表示-</caption>
			<thead>
				<tr>
					<th class=borderleft>順位</th>
					<th><fmt:message key="lbl.user.name" /></th>
					<th>ランク名</th>
					<th>ポーカー獲得コイン</th>
					<th>一位との差</th>
					<th>総ゲーム回数</th>
				</tr>
			</thead>
			<c:forEach items="${overallPokerSum}" var="ranking">
				<tr>
					<td class=borderleft>${fn:escapeXml(ranking.rank)}</td>
					<td>${fn:escapeXml(ranking.userName)}</td>
					<td>${fn:escapeXml(ranking.rankName)}</td>
					<td>${fn:escapeXml(ranking.coin)}</td>
					<td>${fn:escapeXml(ranking.difference)}枚</td>
					<td>${fn:escapeXml(ranking.count)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class=overall>
		<table>
			<caption>ポーカー１試合コイン最高獲得ランキング-50位まで表示-</caption>
			<thead>
				<tr>
					<th class=borderleft>順位</th>
					<th><fmt:message key="lbl.user.name" /></th>
					<th>ランク名</th>
					<th>ポーカー総獲得コイン</th>
					<th>一位との差</th>
					<th>総ゲーム回数</th>
				</tr>
			</thead>
			<c:forEach items="${overallPokerOnetime}" var="ranking">
				<tr>
					<td class=borderleft>${fn:escapeXml(ranking.rank)}</td>
					<td>${fn:escapeXml(ranking.userName)}</td>
					<td>${fn:escapeXml(ranking.rankName)}</td>
					<td>${fn:escapeXml(ranking.coin)}</td>
					<td>${fn:escapeXml(ranking.difference)}枚</td>
					<td>${fn:escapeXml(ranking.pokerRoleName)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<div class=overall>
		<table>
			<caption>ポーカー出した役ランキング-50位まで表示-</caption>
			<thead>
				<tr>
					<th class=borderleft>順位</th>
					<th><fmt:message key="lbl.user.name" /></th>
					<th>ランク名</th>
					<th>ポーカーの役</th>
				</tr>
			</thead>
			<c:forEach items="${overallPokerRoleRanking}" var="ranking">
				<tr>
					<td class=borderleft>${fn:escapeXml(ranking.rank)}</td>
					<td>${fn:escapeXml(ranking.userName)}</td>
					<td>${fn:escapeXml(ranking.rankName)}</td>
					<td>${fn:escapeXml(ranking.pokerRoleName)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<article>
		<table>
			<caption>ポーカー出た役の回数</caption>
			<thead>
				<tr>

					<th class=borderleft>役</th>
					<th>回数</th>

				</tr>
			</thead>
			<c:forEach items="${overallPokerRoleCount}" var="role">
				<tr>
					<td class=borderleft>${fn:escapeXml(role.pokerRoleName)}</td>
					<td>${fn:escapeXml(role.count)}回</td>
				</tr>
			</c:forEach>
		</table>
	</article>

	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="personalRanking" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.personal.ranking" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="ranking" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.back" /></span></a>
	</div>

	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	<br>
	<br>
	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
	<br>
	<br>
	<a href="#top" class="topBtn">ページ↑へ</a>
	<br>
	<br>
	<a href="#bottom" class="bottomBtn">ページ↓へ</a>
	<a id="bottom"></a>
</body>
</html>
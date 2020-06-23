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
			<fmt:message key="btn.personal.ranking" />
		</h1>
	</div>

	<div class=white>
		<h3>${fn:escapeXml(user.userName)}様<br>
			開始日：${fn:escapeXml(user.insertTime)}<br>
			総ゲーム数：${fn:escapeXml(pokerRanking[0].count)}<br>
			ポーカー試合数:${fn:escapeXml(pokerSumList[0].count)}<br>
			ブラックジャック試合数:${fn:escapeXml(bjSumList[0].count)}
		</h3>
	</div>

	<div class="border-gradient">
		<article>
			<table>
				<caption>総合コイン獲得ランキング</caption>
				<tr>
					<th class=borderleft>${fn:escapeXml(user.userName)}様の現在の所持金</th>
					<th>所持金ランキング</th>
					<th>1位との差額</th>
				</tr>
				<tr>
					<td class=borderleft>${fn:escapeXml(user.coin)}枚です</td>
					<td>現在${fn:escapeXml(pokerRanking[0].rank)}位です</td>
					<td>${fn:escapeXml(pokerRanking[0].difference)}枚です</td>
				</tr>
			</table>
		</article>
	</div>

	<div class="border-gradient">
		<article>
			<table>
				<caption>BJコイン獲得ランキング</caption>
				<tr>
					<th class=borderleft>${fn:escapeXml(user.userName)}様のBJでの総獲得金額</th>
					<th>BJ総獲得金額ランキング</th>
					<th>1位との差額</th>
				</tr>
				<tr>
					<td class=borderleft>${fn:escapeXml(bjSumList[0].coin)}枚です</td>
					<td>現在${fn:escapeXml(bjSumList[0].rank)}位です</td>
					<td>${fn:escapeXml(bjSumList[0].difference)}枚です</td>
				</tr>
			</table>
		</article>
	</div>

	<div class="border-gradient">
		<article>
			<table>
				<caption>ポーカーコイン獲得ランキング</caption>
				<tr>
					<th class=borderleft>${fn:escapeXml(user.userName)}様のポーカーでの総獲得金額</th>
					<th>ポーカー総獲得金額ランキング</th>
					<th>1位との差額</th>
				</tr>
				<tr>
					<td class=borderleft>${fn:escapeXml(pokerSumList[0].coin)}枚です</td>
					<td>現在${fn:escapeXml(pokerSumList[0].rank)}位です</td>
					<td>${fn:escapeXml(pokerSumList[0].difference)}枚です</td>
				</tr>
			</table>
		</article>
	</div>

	<div class="border-gradient">
		<article>
			<table>
				<caption>ポーカー１試合コイン最高獲得ランキング</caption>
				<tr>
					<th class=borderleft>${fn:escapeXml(user.userName)}様のポーカー1試合での最高獲得枚数</th>
					<th>ポーカー1試合での最高獲得枚数ランキング</th>
					<th>1位との差額</th>
				</tr>
				<tr>
					<td class=borderleft>${fn:escapeXml(pokerOneTimeList[0].coin)}枚です</td>
					<td>現在${fn:escapeXml(pokerOneTimeList[0].rank)}位です</td>
					<td>${fn:escapeXml(pokerOneTimeList[0].difference)}枚です</td>
				</tr>
			</table>
		</article>
	</div>

	<div class="border-gradient-maxrole">
		<article>
			<table>
				<tr>
					<th class=borderleft>${fn:escapeXml(user.userName)}様がポーカーで出したの最高の役</th>
				</tr>
				<tr>
					<td class=borderleft>
						${fn:escapeXml(pokerRoleRankingList[0].pokerRoleName)}</td>
				</tr>
			</table>
		</article>
	</div>

	<div class="border-gradient-role">
		<article>
			<table>
				<caption>${fn:escapeXml(user.userName)}様が今まで出したポーカーの役</caption>
				<tr>
					<th class=borderleft>役</th>
					<th>回数</th>
				</tr>
				<c:forEach items="${pokerRoleCountList}" var="role">
					<tr>
						<td class=borderleft>${fn:escapeXml(role.pokerRoleName)}</td>
						<td>${fn:escapeXml(role.count)}回</td>
					</tr>
				</c:forEach>
			</table>
		</article>
	</div>

	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="overallRanking" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message
					key="btn.overall.ranking" /></span></a>
	</div>
	<br>
	<br>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
		<a href="ranking" class="btn btn-border-gradient"><span
			class="btn-text-gradient--gold"><fmt:message key="btn.back" /></span></a>
	</div>

	<div class=btnback>
		<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>
	</div>
	<br>
	<br>
	<div class=btnback>
		<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>
	</div>
	<br>
	<br>
	<a href="#top" class="topBtn">ページ↑へ</a>
	<br>
	<br>
	<a href="#bottom" class="bottomBtn">ページ下へ</a>
	<a id="bottom"></a>
</body>
</html>
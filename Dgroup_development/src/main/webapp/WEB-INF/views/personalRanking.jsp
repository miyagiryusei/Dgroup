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
<body class="background${fn:escapeXml(user.backgroundId)}">

	<a id="top"></a>
	<div class="title-set">
		<h1>
			<fmt:message key="btn.personal.ranking" />
		</h1>
	</div>

	<div class=white>
		<h3>${fn:escapeXml(user.userName)}様<br>
			ランク：${fn:escapeXml(user.rankName)}<br>
			所持金：${fn:escapeXml(user.coin)}<br>
			<%-- 			開始日：${fn:escapeXml(user.insertTime)}<br>  --%>
			<!-- 			総ゲーム数： -->
			<%-- 			<c:if test="${pokerRanking[0].count == null}"> --%>
			<!-- 			未プレイ -->
			<%-- 			</c:if> --%>

			<%-- 			<c:if test="${pokerRanking[0].count != null}"> --%>
			<%-- 			${fn:escapeXml(pokerRanking[0].count)} --%>
			<%-- 			</c:if><br> --%>
			ポーカー試合数:
			<c:if test="${pokerSumList[0].count == null}">
			未プレイ
			</c:if>

			<c:if test="${pokerSumList[0].count != null}">
			${fn:escapeXml(pokerSumList[0].count)}
			</c:if>

			<!-- 			<br>ブラックジャック試合数: -->

			<%-- 			<c:if test="${bjSumList[0].count == null}"> --%>
			<!-- 			未プレイ -->
			<%-- 			</c:if> --%>

			<%-- 			<c:if test="${bjSumList[0].count != null}"> --%>
			<%-- 			${fn:escapeXml(bjSumList[0].count)} --%>
			<%-- 			</c:if> --%>

		</h3>
	</div>

	<!-- 	<article> -->
	<!-- 		<table> -->
	<%-- 			<caption>総合コイン獲得ランキング</caption> --%>
	<!-- 			<tr> -->
	<%-- 				<th>${fn:escapeXml(user.userName)}様の現在の所持金</th> --%>
	<!-- 				<th>所持金ランキング</th> -->
	<!-- 				<th>1位との差額</th> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<%-- 				<td>${fn:escapeXml(user.coin)}枚です</td> --%>
	<%-- 				<td>現在:${fn:escapeXml(pokerRanking[0].rank)}位です</td> --%>
	<%-- 				<td>${fn:escapeXml(pokerRanking[0].difference)}枚です</td> --%>
	<!-- 			</tr> -->
	<!-- 		</table> -->
	<!-- 	</article> -->

	<!-- 	<article> -->
	<!-- 		<table> -->
	<%-- 			<caption>BJコイン獲得ランキング</caption> --%>
	<!-- 			<tr> -->
	<%-- 				<th>${fn:escapeXml(user.userName)}様のBJでの総獲得金額</th> --%>
	<!-- 				<th>BJ総獲得金額ランキング</th> -->
	<!-- 				<th>1位との差額</th> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<%-- 				<td><c:if test="${bjSumList[0].coin == null}">未プレイ</c:if> <c:if --%>
	<%-- 						test="${bjSumList[0].coin != null}">${fn:escapeXml(bjSumList[0].coin)}枚です</c:if></td> --%>
	<%-- 				<td>現在: <c:if test="${bjSumList[0].rank == null}">未プレイ</c:if> <c:if --%>
	<%-- 						test="${bjSumList[0].rank != null}">${fn:escapeXml(bjSumList[0].rank)}位です</c:if></td> --%>
	<%-- 				<td><c:if test="${bjSumList[0].difference == null}">未プレイ</c:if> --%>
	<%-- 					<c:if test="${bjSumList[0].difference != null}">${fn:escapeXml(bjSumList[0].difference)}枚です</c:if></td> --%>
	<!-- 			</tr> -->
	<!-- 		</table> -->
	<!-- 	</article> -->

	<article>
		<table>
			<caption>ポーカーコイン獲得ランキング</caption>
			<tr>
				<th>${fn:escapeXml(user.userName)}様のポーカーでの総獲得金額</th>
				<th>ポーカー総獲得金額ランキング</th>
				<th>1位との差額</th>
			</tr>
			<tr>
				<td><c:if test="${pokerSumList[0].coin == null}">未プレイ</c:if> <c:if
						test="${pokerSumList[0].coin != null}">${fn:escapeXml(pokerSumList[0].coin)}枚です</c:if>
				</td>
				<td>現在: <c:if test="${pokerSumList[0].rank == null}">未プレイ</c:if>
					<c:if test="${pokerSumList[0].rank != null}">${fn:escapeXml(pokerSumList[0].rank)}位です</c:if></td>
				<td><c:if test="${pokerSumList[0].difference == null}">未プレイ</c:if>
					<c:if test="${pokerSumList[0].difference != null}">${fn:escapeXml(pokerSumList[0].difference)}枚です</c:if>
				</td>
			</tr>
		</table>
	</article>

	<article>
		<table>
			<caption>ポーカー１試合コイン最高獲得ランキング</caption>
			<tr>
				<th>${fn:escapeXml(user.userName)}様のポーカー1試合での最高獲得枚数</th>
				<th>ポーカー1試合での最高獲得枚数ランキング</th>
				<th>1位との差額</th>
			</tr>
			<tr>
				<td><c:if test="${pokerOneTimeList[0].coin == null}">未プレイ</c:if>
					<c:if test="${pokerOneTimeList[0].coin != null}">${fn:escapeXml(pokerSumList[0].coin)}枚です</c:if>
				</td>
				<td>現在: <c:if test="${pokerOneTimeList[0].rank == null}">未プレイ</c:if>
					<c:if test="${pokerOneTimeList[0].rank != null}">${fn:escapeXml(pokerSumList[0].rank)}位です</c:if></td>
				<td><c:if test="${pokerOneTimeList[0].difference == null}">未プレイ</c:if>
					<c:if test="${pokerOneTimeList[0].difference != null}">${fn:escapeXml(pokerSumList[0].difference)}枚です</c:if>
				</td>
			</tr>
		</table>
	</article>

	<article>
		<table>
			<tr>
				<th>${fn:escapeXml(user.userName)}様がポーカーで出したの最高の役</th>
			</tr>
			<tr>
				<td><c:if
						test="${pokerRoleRankingList[0].pokerRoleName == null}">未プレイ</c:if>
					<c:if test="${pokerRoleRankingList[0].pokerRoleName != null}">${fn:escapeXml(pokerRoleRankingList[0].pokerRoleName)}</c:if>
				</td>
			</tr>
		</table>
	</article>

	<c:if test="${pokerRoleCountList[0].pokerRoleName != null}">
		<article>
			<table>
				<caption>${fn:escapeXml(user.userName)}様が今まで出したポーカーの役</caption>
				<tr>
					<th>役</th>
					<th>回数</th>
				</tr>
				<c:forEach items="${pokerRoleCountList}" var="role">
					<tr>
						<td>${fn:escapeXml(role.pokerRoleName)}</td>
						<td>${fn:escapeXml(role.count)}回</td>
					</tr>
				</c:forEach>
			</table>
		</article>
	</c:if>

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
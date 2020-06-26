<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポーカールール</title>
<link rel="stylesheet" href="css/pokerRule.css" />
</head>
<body class="background${fn:escapeXml(user.backgroundId)}">
	<a id="top"></a>
	<c:if test="${empty user}">
		<c:redirect url="/login" />
	</c:if>

	<h1 class=title>ポーカールール</h1>

	<div class=white>
		<h3 class="border-none">${fn:escapeXml(user.userName)}様<br>
			所持コイン：${fn:escapeXml(user.coin)}<br>
			ランク：${fn:escapeXml(user.rankName)}
		</h3>
	</div>
	<br>

	<article>
		<h1>本アプリにおけるポーカールール</h1>
		<article>
			<h2>1. ポーカーとは</h2>
			<p>5枚の手札の組み合わせで、カードの強さをきそうトランプゲームです。</p>
			<p>自分の手札で強い組み合わせをつくり、より大きな配当を得ましょう。</p>
			<br />
			<h2>2. ポーカーに必要なカード</h2>
			<p>
				52枚のカード（1~13の<span style="color: rgb(0, 0, 0);">♠</span>・<span
					style="color: red;">♥</span>・<span style="color: red;">♦</span>・<span
					style="color: rgb(0, 0, 0);">♣</span>のカード）とジョーカー1枚を用いてポーカーを行います。

			</p>
			<p>
				<img src="css/tramp/s01.png" width="150px" /> <img
					src="css/tramp/s10.png" width="150px" /> <img
					src="css/tramp/s11.png" width="150px" /> <img
					src="css/tramp/s12.png" width="150px" /> <img
					src="css/tramp/s13.png" width="150px" />
			</p>
			<br />
			<h2>3. ポーカーのカードの強さ</h2>
			<p>カードは強い方から、A、K、Q、J、10、9、8、7、6、5、4、3、2 の順番になります。</p>
			<p>
				スートの強さ順は<span style="color: rgb(0, 0, 0);">♠</span>＞<span
					style="color: red;">♥</span>＞<span style="color: red;">♦</span>＞<span
					style="color: rgb(0, 0, 0);">♣</span>
			</p>
			<p>ジョーカーはオールマイティーのカードです。ずべてのカードの代わりに使うことができます。</p>
			<br />
			<h2>4. ポーカーの組み合わせ</h2>

			<article class="roleExplanation">
				<h3>強い順に説明します</h3>

				<table>
					<tr>
						<th>ロイヤルストレートフラッシュ</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同種のマークで、10・J・Q・K・Aが５枚の組み合わせによって作られます。<br>カード１つがジョーカーでも成り立ちます。
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×1000枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/s01.png" width="100px" />
							<img src="css/tramp/s10.png" width="100px" /> <img
							src="css/tramp/s11.png" width="100px" /> <img
							src="css/tramp/s12.png" width="100px" /> <img
							src="css/tramp/s13.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/h01.png" width="100px" />
							<img src="css/tramp/h10.png" width="100px" /> <img
							src="css/tramp/h11.png" width="100px" /> <img
							src="css/tramp/h12.png" width="100px" /> <img
							src="css/tramp/h13.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/d10.png" width="100px" /> <img
							src="css/tramp/d11.png" width="100px" /> <img
							src="css/tramp/d12.png" width="100px" /> <img
							src="css/tramp/d13.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/c10.png" width="100px" /> <img
							src="css/tramp/c11.png" width="100px" /> <img
							src="css/tramp/c12.png" width="100px" /> <img
							src="css/tramp/c13.png" width="100px" /></td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<th>ファイブカード</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカードが4枚揃って、かつ残りの１枚がジョーカーの組み合わせによって作られます。</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×200枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/d01.png" width="100px" /> <img
							src="css/tramp/h01.png" width="100px" /> <img
							src="css/tramp/s01.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c02.png" width="100px" />
							<img src="css/tramp/d02.png" width="100px" /> <img
							src="css/tramp/h02.png" width="100px" /> <img
							src="css/tramp/s02.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>ストレートフラッシュ</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じマークのカード5枚、数字の順番にならんだ組み合わせです。<br>またカード１つがジョーカーでも成り立ちます。<br>ただし……K・A・2……とは続きません。
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×100枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/s03.png" width="100px" />
							<img src="css/tramp/s04.png" width="100px" /> <img
							src="css/tramp/s05.png" width="100px" /> <img
							src="css/tramp/s06.png" width="100px" /> <img
							src="css/tramp/s07.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/h08.png" width="100px" />
							<img src="css/tramp/h09.png" width="100px" /> <img
							src="css/tramp/h10.png" width="100px" /> <img
							src="css/tramp/h11.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>フォーカード</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカードが4枚そろった組み合わせです。<br>またカード１つがジョーカーでも成り立ちます。（※フルハウスとしては扱われません）
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×40枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/d01.png" width="100px" /> <img
							src="css/tramp/h01.png" width="100px" /> <img
							src="css/tramp/s01.png" width="100px" /> <img
							src="css/tramp/h13.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/d01.png" width="100px" /> <img
							src="css/tramp/h01.png" width="100px" /> <img
							src="css/tramp/s10.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>フルハウス</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカードが3枚と2枚の組み合わせです。 スリーカード+ワンペアです。<br>またカード１つがジョーカーでも成り立ちます。（※フォーカードになる場合はフォーカードとして扱われます）
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×20枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/d01.png" width="100px" /> <img
							src="css/tramp/h01.png" width="100px" /> <img
							src="css/tramp/s13.png" width="100px" /> <img
							src="css/tramp/h13.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c01.png" width="100px" />
							<img src="css/tramp/d01.png" width="100px" /> <img
							src="css/tramp/h10.png" width="100px" /> <img
							src="css/tramp/s10.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>フラッシュ</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>数字がバラバラで、同じマークのカードが5枚そろった組み合わせです。 <br>またカード１つがジョーカーでも成り立ちます。
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×10枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c03.png" width="100px" />
							<img src="css/tramp/c05.png" width="100px" /> <img
							src="css/tramp/c07.png" width="100px" /> <img
							src="css/tramp/c09.png" width="100px" /> <img
							src="css/tramp/c11.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d02.png" width="100px" />
							<img src="css/tramp/d04.png" width="100px" /> <img
							src="css/tramp/d06.png" width="100px" /> <img
							src="css/tramp/d08.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>ストレート</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>カード5枚の数字が順にならぶ組み合わせです。<br>マークはバラバラです。 <br>またカード１つがジョーカーでも成り立ちます。
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×5枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c03.png" width="100px" />
							<img src="css/tramp/d04.png" width="100px" /> <img
							src="css/tramp/h05.png" width="100px" /> <img
							src="css/tramp/s06.png" width="100px" /> <img
							src="css/tramp/c07.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/c10.png" width="100px" /> <img
							src="css/tramp/d11.png" width="100px" /> <img
							src="css/tramp/h12.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>スリーカード</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカードが3枚ある組み合わせです。 <br>またカード１つがジョーカーでも成り立ちます。（※スリーカードになる場合はスリーカードとして扱われます）
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×2枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c03.png" width="100px" />
							<img src="css/tramp/d03.png" width="100px" /> <img
							src="css/tramp/h03.png" width="100px" /> <img
							src="css/tramp/s06.png" width="100px" /> <img
							src="css/tramp/c07.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/c01.png" width="100px" /> <img
							src="css/tramp/d13.png" width="100px" /> <img
							src="css/tramp/h02.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>ツーペア</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカード2枚が2つある組み合わせです。</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×1枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c03.png" width="100px" />
							<img src="css/tramp/d03.png" width="100px" /> <img
							src="css/tramp/h06.png" width="100px" /> <img
							src="css/tramp/s06.png" width="100px" /> <img
							src="css/tramp/c07.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/c01.png" width="100px" /> <img
							src="css/tramp/d13.png" width="100px" /> <img
							src="css/tramp/h02.png" width="100px" /> <img
							src="css/tramp/s13.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>ワンペア</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカード2枚が1つある組み合わせです。<br>またカード１つがジョーカーでも成り立ちます。
						</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×（-1）枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c03.png" width="100px" />
							<img src="css/tramp/d03.png" width="100px" /> <img
							src="css/tramp/h04.png" width="100px" /> <img
							src="css/tramp/s06.png" width="100px" /> <img
							src="css/tramp/c07.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/c02.png" width="100px" /> <img
							src="css/tramp/d13.png" width="100px" /> <img
							src="css/tramp/h04.png" width="100px" /> <img
							src="css/tramp/joker.png" width="100px" /></td>
					</tr>
				</table>

				<br>
				<table>
					<tr>
						<th>ブタ</th>
					</tr>
					<tr>
						<td class="example">説明
					</tr>
					<tr>
						<td>同じ数字のカードが１枚もない場合の組み合わせです。</td>
					</tr>
					<tr>
						<td class="example">倍率
					</tr>
					<tr>
						<td>BET額×（-1）枚
					</tr>
					<tr>
						<td class="example">カードの例
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/c02.png" width="100px" />
							<img src="css/tramp/d03.png" width="100px" /> <img
							src="css/tramp/h05.png" width="100px" /> <img
							src="css/tramp/s08.png" width="100px" /> <img
							src="css/tramp/c09.png" width="100px" /></td>
					</tr>
					<tr>
						<td class="kard"><img src="css/tramp/d01.png" width="100px" />
							<img src="css/tramp/c05.png" width="100px" /> <img
							src="css/tramp/d08.png" width="100px" /> <img
							src="css/tramp/h11.png" width="100px" /> <img
							src="css/tramp/s13.png" width="100px" /></td>
					</tr>
				</table>

			</article>
		</article>
		<h2>5. 本ゲームの進め方</h2>
		<article>
			<h3>1. スタートボタンを押してゲームスタート</h3>
			<p>スタートボタンを押すことでポーカーゲームが開始されます。</p>
			<h3>自身の手札を確認</h3>
			<p>表示されている手札の役を確認</p>
			<h3>3. 賭けるBET額を選択</h3>
			<p>自身の所持金の額の範囲内で、賭けるコインの枚数を指定します。</p>
			<h3>4. カードの交換</h3>
			<p>最初に表示されているカードを確認したうえ、交換したいカードを選び、changeボタンを押してカードを交換してください。</p>
			<h3>5. 配当の受け取り</h3>
			<p>
				交換後のカードの役とBET額に対する配当が表示されます。<br>表示された配当があなたの所持金に追加されます。
			</p>
		</article>
		<br> 以上が本ゲームに置けるポーカーのルールです。ランキング上位を目指しながらゲームを楽しんでください
	</article>
	<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a>

	<a href="logout" class="logoutBtn"><fmt:message key="btn.logout" /></a>

	<a href="#top" class="topBtn">ページ↑へ</a>

	<a href="#bottom" class="bottomBtn">ページ↓へ</a>

	<a href="pokerHome" class="btnBack">戻る</a>
	<a id="bottom"></a>
</body>
</html>
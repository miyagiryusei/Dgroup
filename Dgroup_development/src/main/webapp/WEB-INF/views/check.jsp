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

	<form:form action="checkA" method="post" modelAttribute="user"
		class="center">
		<h1 class="checkh1">確認画面</h1>

		<c:if test="${not empty msg}">
		<div class=whit>
			<h3>${msg}</h3>
		</div>
		</c:if>
		<c:if test="${empty msg}">
		<div class=whit>
			<h3>以下の内容でよろしいですか？</h3>
		</div>
		</c:if>



		<c:if test="${empty flg}">
			<p>
				<label>ID</label>
			</p>

			<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
				<input type="text" class="btn-border-gradient" name="loginId"
					value="${id}" readonly>
			</div>
		</c:if>



		<p>
			<label>ユーザー名</label>
		</p>

		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<input type="text" class="btn-border-gradient" name="userName"
				value="${name}" readonly>
		</div>



		<p>
			<label>パスワード(再入力)</label>
		</p>

		<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
			<input type="password" class="btn-border-gradient" name="pass">
			<form:errors path="pass" class="required" />

		</div>
		<br>
		<br>

		<div>
			<c:if test="${not empty flg}">
				<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

					<form:button name="update" class="btn btn-border-gradient">
						<span class="btn-text-gradient--gold"><fmt:message
								key="btn.update" /></span>
					</form:button>
				</div>
			</c:if>

			<c:if test="${empty flg}">
				<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">

					<form:button name="insert" class="btn btn-border-gradient">

						<span class="btn-text-gradient--gold"><fmt:message
								key="btn.insert" /></span>

					</form:button>
				</div>
			</c:if>



		</div>
	</form:form>


		<a href="insert" class="myPageBtn">戻る</a>
		<br>
		<br>

	<c:if test="${not empty flg}">
		<a href="myPage" class="logoutBtn"><fmt:message key="btn.menu" /></a>
	</c:if>




</body>
</html>
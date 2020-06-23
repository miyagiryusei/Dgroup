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
<link href="css/account.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
  ${massage}

	<form:form action="account" modelAttribute="user" method="post">
  <h1>アカウント作成</h1>
 <p>
  <label>ID</label>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
    <input class="btn-border-gradient" type="text" name="loginId">
    <form:errors path="loginId" class="required"/>
</div>

<p>
<label>ユーザー名</label>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
    <input class="btn-border-gradient" type="text" name="userName">
  <form:errors path="userName" class="required"/>
  </div>

  <p>
  <label>パスワード</label>
	<div class="btn-border-gradient-wrap btn-border-gradient-wrap--gold">
    <input class="btn-border-gradient" type="password" name="pass">
    <form:errors path="pass" class="required"/>
  </div>

<p>
	<button type="submit" class="btn-border-gradient">
    <span class="btn-text-gradient--gold">
    作成する</span></button>
	</form:form>
	<div>
		<a href="myPage" class="myPageBtn"><fmt:message key="btn.myPage" /></a><br><br>


	</div>

</body>
</html>
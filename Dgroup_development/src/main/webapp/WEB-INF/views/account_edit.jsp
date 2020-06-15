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
<title>Insert title here</title>
</head>
<body>
	<form action="account_edit.jsp" method="post">
		<h1>アカウント編集</h1>
		<div>
			<label>※名前</label> <input type="text" name="loginName">
		</div>
		<div>
			<label>※PASS</label> <input type="password" name="pass">
		</div>
		<button type="submit">変更する</button>
	</form>
	<div>
		<a href="mypage.jsp">TOP画面に戻る</a>
	</div>
</body>
</html>
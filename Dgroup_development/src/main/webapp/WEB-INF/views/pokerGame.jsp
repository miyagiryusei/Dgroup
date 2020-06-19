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
<link href="css/myPage.css" rel="stylesheet">
</head>
<body>
	<form:form method="post" action="pokerResult" modelAttribute="gameForm">


		<form:select name="coin" path="betCoin">
			<c:forEach items="${betCoin}" var="coin">
				<option value="${coin}">${coin}</option>
			</c:forEach>
		</form:select>



		<p>
			<form:button>
			BET
		</form:button>
		</p>
	</form:form>



</body>
</html>
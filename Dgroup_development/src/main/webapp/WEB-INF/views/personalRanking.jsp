<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/commons.css" rel="stylesheet">
<meta charset="UTF-8">
<title><fmt:message key="title.ranking" /></title>
</head>
<body>
	<h1>
		<fmt:message key="title.ranking" />
	</h1>

<div class=center><h2><fmt:message key="btn.personal.ranking" /></h2></div>

<table>
    <caption>検索結果</caption>
    <thead>
      <tr>
        <th><fmt:message key="|b|.ranking" /></th>
        <th><fmt:message key="lbl.user.name" /></th>
        <th><fmt:message key="|b|.coin.have" /></th>
      </tr>
    </thead>
</table>
<br>
	<a href="overallRanking" class="btn"><fmt:message
			key="btn.overall.ranking" /></a>
	<br><br>
	<a href="ranking" class="btn"><fmt:message key="btn.back" /></a>
</body>
</html>
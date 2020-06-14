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

<h2><fmt:message key="btn.overall.ranking" /></h2>

<table>
    <caption>検索結果</caption>
    <thead>
      <tr>
        <th><fmt:message key="|b|.ranking" /></th>
        <th><fmt:message key="lbl.user.name" /></th>
        <th><fmt:message key="|b|.coin.have" /></th>
      </tr>
    </thead>
      <tr>
        <th>1</th>
        <th>田中</th>
        <th>9999</th>
      </tr>
      <tr>
        <th>2</th>
        <th>axiz</th>
        <th>9998</th>
      </tr>
</table>
<br>
	<a href="personalRanking" class="btn"><fmt:message
			key="btn.personal.ranking" /></a>
	<br><br>
	<a href="ranking" class="btn"><fmt:message key="btn.back" /></a>
</body>
</html>
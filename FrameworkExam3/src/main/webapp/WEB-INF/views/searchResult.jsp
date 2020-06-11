<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchResult</title>
</head>
<body>
<h1>検索結果</h1><br>
<c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>

<c:if test="${not empty msg}">
    <p>${result}</p>
  </c:if>

<a href="top">戻る</a>
</body>
</html>
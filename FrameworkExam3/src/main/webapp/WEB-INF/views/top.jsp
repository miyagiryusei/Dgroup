<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- BootstrapのCSS読み込み -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- jQuery読み込み -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Top</title>
</head>
<body>
<h1>検索条件を入力してください。</h1><br>
<c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
<form:form action="searchR" modelAttribute="search">
product_id:<form:input path="id" /><br>
<form:button>検索</form:button>
</form:form>
<button type="button" class="btn btn-success btn-lg">Blue</button>
<button type="button" class="btn btn-danger">Red</button>
</body>
</html>
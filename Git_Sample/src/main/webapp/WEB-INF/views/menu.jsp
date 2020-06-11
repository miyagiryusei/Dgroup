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
<title><fmt:message key="title.menu" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>${fn:escapeXml(sessionInfo.loginUser.userName)}さん、こんにちは</p>

  <p>
    <a href="select"><fmt:message key="btn.search" /></a>
  </p>
  <c:if test="${sessionInfo.loginUser.isAdmin()}">
    <p>
      <a href="insert"><fmt:message key="btn.insert" /></a>
    </p>
    <p>
      <a href="update"><fmt:message key="btn.update" /></a>
    </p>
    <p>
      <a href="delete"><fmt:message key="btn.delete" /></a>
    </p>
  </c:if>
  <form action="logout" method="post">
    <button type="submit">
      <fmt:message key="btn.logout" />
    </button>
  </form>
</body>
</html>

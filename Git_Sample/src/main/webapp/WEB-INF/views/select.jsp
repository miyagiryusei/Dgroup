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
<title><fmt:message key="title.search" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    検索したいデータ情報を入力してください<br> ※全て空白の場合は全検索を行います
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="list" modelAttribute="selectForm" method="get">
    <fieldset>
      <div>
        <label><fmt:message key="lbl.user.name" /></label>
        <form:input path="userName" />
      </div>
      <div>
        <label><fmt:message key="lbl.tel" /></label>
        <form:input path="tel" />
      </div>
    </fieldset>
    <form:button>
      <fmt:message key="btn.search" />
    </form:button>
  </form:form>
  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>

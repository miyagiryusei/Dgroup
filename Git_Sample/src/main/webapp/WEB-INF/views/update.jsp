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
<title><fmt:message key="title.update" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    更新するIDを入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="updateInput" method="post"
    modelAttribute="updateForm">
    <fieldset>
      <div>
        <label class="required"><fmt:message key="lbl.id" /></label>
        <form:input path="loginId" />
        <form:errors path="loginId" class="error" />
      </div>
    </fieldset>
    <form:button>
      <fmt:message key="btn.confirm" />
    </form:button>
  </form:form>
  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>

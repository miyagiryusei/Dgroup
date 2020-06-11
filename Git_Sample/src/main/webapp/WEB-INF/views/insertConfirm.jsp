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
<title><fmt:message key="title.insert.confirm" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="insert" method="post" modelAttribute="insertForm">
    <fieldset class="label-130">
      <div>
        <label><fmt:message key="lbl.id" /></label>
        <form:input path="loginId" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.user.name" /></label>
        <form:input path="userName" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.tel" /></label>
        <form:input path="tel" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.role" /></label>
        <form:input path="roleName" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.pass" /> <fmt:message
            key="lbl.confirm.input" /></label>
        <form:password path="confirmPassword" />
      </div>
    </fieldset>
    <div>
      <form:button name="insert">
        <fmt:message key="btn.insert" />
      </form:button>
      <form:button name="back">
        <fmt:message key="btn.back" />
      </form:button>
    </div>
  </form:form>
  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>

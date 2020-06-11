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
<title><fmt:message key="title.delete.confirm" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <form:form action="delete" method="post" modelAttribute="deleteForm">
    <fieldset>
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
      <form:hidden path="userId" readonly="true" />
    </fieldset>
    <div>
      <form:button name="delete">
        <fmt:message key="btn.delete" />
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

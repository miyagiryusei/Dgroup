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
<title><fmt:message key="title.insert" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    登録情報を入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="insertConfirm" method="post"
    modelAttribute="insertForm">
    <fieldset class="label-60">
      <div>
        <label class="required"><fmt:message key="lbl.id" /></label>
        <form:input path="loginId" />
        <form:errors path="loginId" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.user.name" /></label>
        <form:input path="userName" />
        <form:errors path="userName" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.tel" /></label>
        <form:input path="tel" />
        <form:errors path="tel" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.role" /></label>
        <form:select path="roleId">
          <form:options items="${sessionInfo.roleList}"
            itemLabel="roleName" itemValue="roleId" />
        </form:select>
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.pass" /></label>
        <form:password path="password" showPassword="true" />
        <form:errors path="password" class="error" />
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

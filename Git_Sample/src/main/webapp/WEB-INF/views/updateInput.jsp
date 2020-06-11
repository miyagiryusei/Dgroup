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
<title><fmt:message key="title.update.input" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    １箇所以上の項目を変更してください
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="updateConfirm" method="post"
    modelAttribute="updateForm">
    <fieldset>
      <div>
        <label><fmt:message key="lbl.id" /></label>
        <form:input path="loginId" />
        <form:errors path="loginId" class="error" />
      </div>
      <div>
        <label><fmt:message key="lbl.user.name" /></label>
        <form:input path="userName" />
        <form:errors path="userName" class="error" />
      </div>
      <div>
        <label><fmt:message key="lbl.tel" /></label>
        <form:input path="tel" />
        <form:errors path="tel" class="error" />
      </div>
      <div>
        <label><fmt:message key="lbl.role" /></label>
        <form:select path="roleId">
          <form:options items="${sessionInfo.roleList}"
            itemLabel="roleName" itemValue="roleId" />
        </form:select>
      </div>
      <div>
        <label><fmt:message key="lbl.pass" /></label>
        <form:password path="password" showPassword="true" />
        <form:errors path="password" class="error" />
      </div>
    </fieldset>
    <div>
      <form:button name="confirm">
        <fmt:message key="btn.confirm" />
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

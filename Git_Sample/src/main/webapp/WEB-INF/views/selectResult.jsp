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
<title><fmt:message key="title.search.result" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <c:if test="${sessionInfo.loginUser.isAdmin()}">
    <p>
      <fmt:message key="edit.sel.msg" />
    </p>
    <c:if test="${not empty errMsg}">
      <p class="error">${fn:escapeXml(errMsg)}</p>
    </c:if>
  </c:if>

  <form:form action="selectResult" modelAttribute="selectResult" method="post">

    <table>
      <caption>
        <fmt:message key="lbl.search.result" />
      </caption>
      <thead>
        <tr>
          <c:if test="${sessionInfo.loginUser.isAdmin()}">
            <th><fmt:message key="lbl.sel" /></th>
          </c:if>
          <th><fmt:message key="lbl.id" /></th>
          <th><fmt:message key="lbl.user.name" /></th>
          <th><fmt:message key="lbl.tel" /></th>
          <th><fmt:message key="lbl.role" /></th>
          <th><fmt:message key="lbl.create.datetime" /></th>
          <th><fmt:message key="lbl.update.datetime" /></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${userlist}" var="user">
          <tr>
            <c:if test="${sessionInfo.loginUser.isAdmin()}">
              <td class="center"><label><form:checkbox
                    path="userId" value="${fn:escapeXml(user.userId)}"></form:checkbox></label></td>
            </c:if>
            <td>${fn:escapeXml(user.loginId)}</td>
            <td>${fn:escapeXml(user.userName)}</td>
            <td>${fn:escapeXml(user.telephone)}</td>
            <td>${fn:escapeXml(user.roleName)}</td>
            <td>${fn:escapeXml(user.createDatetimeFormatDate)}</td>
            <td>${fn:escapeXml(user.updateDatetimeFormatDate)}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <c:if test="${sessionInfo.loginUser.isAdmin()}">
      <br>
      <form:button name="update">
        <fmt:message key="btn.edit" />
      </form:button>
      <form:button name="delete">
        <fmt:message key="btn.delete" />
      </form:button>
    </c:if>
  </form:form>

  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>

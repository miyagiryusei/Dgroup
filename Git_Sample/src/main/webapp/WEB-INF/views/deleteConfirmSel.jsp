<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="title.delete.confirm" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p><fmt:message key="delete.msg" /></p>
  <p><fmt:message key="confirm.msg" /></p>
  <table>
    <caption><fmt:message key="lbl.delete.target" /></caption>
    <thead>
      <tr>
        <th><fmt:message key="lbl.id" /></th>
        <th><fmt:message key="lbl.user.name" /></th>
        <th><fmt:message key="lbl.tel" /></th>
        <th><fmt:message key="lbl.role" /></th>
        <th><fmt:message key="lbl.create.datetime" /></th>
        <th><fmt:message key="lbl.update.datetime" /></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${deleteUserList}" var="user">
        <tr>
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
  <br>
  <form action="deleteConfirmSel" method="post">
    <div>
      <button type="submit" name="delete">
        <fmt:message key="btn.delete" />
      </button>
      <button type="submit" name="back">
        <fmt:message key="btn.back" />
      </button>
    </div>
  </form>
</body>
</html>

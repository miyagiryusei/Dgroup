<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="title.delete.result" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    <fmt:message key="lbl.execute.user" />
    ：${fn:escapeXml(sessionInfo.loginUser.userName)}
  </p>
  <p>正常に削除されました</p>
  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>

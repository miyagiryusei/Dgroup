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
<title><fmt:message key="title.myPage" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>


	 <p>正常に登録できました。</p>
    <a href="myPage" class="btn"><fmt:message key="title.myPage" /></a>
	 <a href="logout" class="btn"><fmt:message key="btn.logout" /></a>



</body>
</html>
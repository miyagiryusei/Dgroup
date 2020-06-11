<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索結果</h1>
	<p>${requestScope.msg}</p>

	product_id:${requestScope.productList.productId}
	<br>product_name:${requestScope.productList.productName}
	<br>price:${requestScope.productList.price}

	<p><a href="top.jsp">戻る</a></p>

</body>
</html>
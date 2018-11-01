<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参照画面</title>
</head>
<body>
	<h2>球団名</h2>
	<c:out value="${baseballTeam.teamName}" />
	<br>
	<h2>本拠地</h2>
	<c:out value="${baseballTeam.headquarters}" />
	<br>
	<h2>発足</h2>
	<c:out value="${baseballTeam.inauguration}" />
	<br>
	<h2>歴史</h2>
	<pre><c:out value="${baseballTeam.history}" /></pre>
	<br><br>

	<form action="${pageContext.request.contextPath}/baseball/toLink" method="POST">
		<input type="submit" value="戻る">
	</form>


</body>
</html>
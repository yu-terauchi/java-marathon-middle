<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>プロ野球</th>
		</tr>
		<tr>
			<th>セントラル・リーグ一覧</th>
		</tr>
	</table>

		<c:forEach var="baseballTeam" items="${baseballTeamList}">
			<a href="${pageContext.request.contextPath}/baseball/toReference?id=<c:out value="${baseballTeam.id}"/>">
				<c:out value="${baseballTeam.teamName}" /><br>
			</a>
		</c:forEach>
</body>
</html>
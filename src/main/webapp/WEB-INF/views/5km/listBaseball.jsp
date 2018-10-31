<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>central league list</title>
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

	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=1">読売ジャイアンツ</a>
	</form>
	
	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=2">阪神タイガース</a>
	</form>
	
	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=3">中日ドラゴンズ</a>
	</form>
	
	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=4">横浜DeNAベイスターズ</a>
	</form>
	
	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=5">広島東洋カープ</a>
	</form>
	
	<form action="baseball/toReference" method="GET">
		<a href="${pageContext.request.contextPath}/baseball/toReference?id=6">東京ヤクルトスワローズ</a>
	</form>
</body>
</html>
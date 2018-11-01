<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="cssファイルのURLをここに書け！！.css">
</head>
<body>
	<table>
		<tr>
			<th>ホテル検索</th>
		</tr>
	</table>

	<form action="${pageContext.request.contextPath}/search/toOutput" method="POST">
		<p>一泊料金</p>
		<input type="text" name="searchingPrice" id="searchingPrice">
		<p>円以下</p>
		<br> <input type="submit" value="検索">
	</form>

</body>
</html>
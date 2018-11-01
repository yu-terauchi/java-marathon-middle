<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>洋服shop</th>
		</tr>
	</table>

	<form action="${pageContext.request.contextPath}/clothStore/toOutput" method="POST">
		<input type="radio" name="gender" value="0" >Man
		<input type="radio" name="gender" value="1" >Woman
	
		<select name="color">
			<option value="赤">赤</option>
			<option value="青">青</option>
			<option value="黄色">黄色</option>
			<option value="白">白</option>
		</select>
		<input type="submit" value="検索">
		
	</form>
	<c:forEach var="cloth" items="${clothList}">
		<table border="1">
			<tr>
				<td>ジャンル</td>
				<td><c:out value="${cloth.genre}" /></td>
			</tr>
			<tr>
				<td>サイズ</td>
				<td><c:out value="${cloth.size}" /></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><fmt:formatNumber value="${cloth.price}" />円</td>
			</tr>
		</table>
			<br>
	</c:forEach>


</body>
</html>
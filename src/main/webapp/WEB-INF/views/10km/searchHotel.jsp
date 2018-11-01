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
			<th>ホテル検索</th>
		</tr>
	</table>

	<form:form action="${pageContext.request.contextPath}/searchHotel/toOutput"
		method="POST">
		<form:errors path="price" cyyStyle="color:red" element="div"/>
		<p>
			一泊料金 <form:input path="price"/> 円以下
		</p>
		<br> <input type="submit" value="検索">
	</form:form>

	<c:forEach var="hotel" items="${hotelList}">
		<table border="1">
			<tr>
				<td>ホテル名</td>
				<td><c:out value="${hotel.hotelName}" /></td>
			</tr>
			<tr>
				<td>最寄り駅</td>
				<td><c:out value="${hotel.nearestStation}" /></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><fmt:formatNumber value="${hotel.price}" />円</td>
			</tr>
		</table>
			<br>
	</c:forEach>


</body>
</html>
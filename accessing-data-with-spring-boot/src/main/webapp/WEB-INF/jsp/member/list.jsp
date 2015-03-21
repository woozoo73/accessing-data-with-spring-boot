<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>members</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${members}">
			<tr>
				<td><a href="/members/${member.id}">${member.id}</a></td>
				<td>${member.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href='/members/new'>new</a>

</body>
</html>
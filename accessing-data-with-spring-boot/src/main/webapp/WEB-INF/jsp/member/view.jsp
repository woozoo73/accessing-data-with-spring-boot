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
<title>members-${member.id}</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>field</th>
				<th>value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>id</th>
				<td>${member.id}</td>
			</tr>
			<tr>
				<th>name</th>
				<td>${member.name}</td>
			</tr>
			<tr>
				<th>password</th>
				<td>${member.password}</td>
			</tr>
			<tr>
				<th>group.name</th>
				<td>${member.group.name}</td>
			</tr>
			<c:forEach var="email" items="${member.emails}">
			<tr>
				<th>email</th>
				<td>${email.value}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/members">list</a>
	<a href="/members/${member.id}/edit">edit</a>
	
	<form:form commandName="member">
	<input type="hidden" name="_method" value="DELETE" />
	<form:hidden id="id" path="id" />
	<input type="submit" value="delete" />
	</form:form>

</body>
</html>
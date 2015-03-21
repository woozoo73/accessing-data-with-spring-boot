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

	<form:form commandName="member">
	<form:hidden id="id" path="id" />
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
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th>password</th>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<th>group</th>
				<td><form:input path="group.id" /></td>
			</tr>
			<tr>
				<th>email#1</th>
				<td><form:input path="emails[0].value" /></td>
			</tr>
			<tr>
				<th>email#2</th>
				<td><form:input path="emails[1].value" /></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" />
	</form:form>
	
	<a href="/members">list</a>

</body>
</html>
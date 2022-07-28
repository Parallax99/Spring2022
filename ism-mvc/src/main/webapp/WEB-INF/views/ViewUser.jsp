<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<h2>User Details</h2>
	<table border="1">
		<tr>
			<th>userId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Role</th>

		</tr>
		<tr>
				<td>${user.userId }</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.gender}</td>
				<td>${user.role}</td>
			</tr>
		
	</table>
</body>
</html>
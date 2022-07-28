<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Password</th>
			<th>Role</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td>${u.lastName}</td>
				<td>${u.gender}</td>
				<td>${u.email}</td>
				<td>${u.password}</td>
				<td>${u.role}</td>
				<td><a href="DeleteUser?userId=${u.userId}">Delete</a>|<a
					href="ViewUser?userId=${u.userId}">View</a></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	<h2>Sign Up</h2>
	<%-- <form action="Submit" method="post">
		<label>FirstName</label>
		<input type="text" name="firstName">
		<label>LastName</label>
		<input type="text" name="lastName">
		<label>Email</label>
		<input type="email" name="email">
		<label>Password</label>
		<input type="password" name="password">
		<button type="submit">Submit</button>
	</form> --%>
	
	<f:form method="post" action="Submit" modelAttribute="user">
		FirstName: <f:input path="firstName"/><f:errors path="firstName"></f:errors>
		<br>
		LastName: <f:input path="lastName"/><f:errors path="lastName"></f:errors>
		<br>
		Email: <f:input path="email"/><f:errors path="email"></f:errors>${error}
		<br>
		Password: <f:input path="password"/><f:errors path="password"></f:errors>
		<br>
		Gender: <br>Male: <f:radiobutton path="gender" value="male"/> Female: <f:radiobutton path="gender" value="female"/>
		<f:button type="submit">SignUp</f:button><button type="reset">Reset</button>
	</f:form>
	<a href="Login">Already SignedUp?</a>
</body>
</html>
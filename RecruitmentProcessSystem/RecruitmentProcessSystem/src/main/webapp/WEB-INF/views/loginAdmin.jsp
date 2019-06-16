<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Admin</title>
</head>
<body>
	<h1>Spring MVC 5 - Spring Security 5 - Hibernate 5</h1>
	<h2>${message}</h2>

	<form name='loginForm'
		action="<c:url value='/admin/j_spring_security_login' />"
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input id="username" type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input id="password" type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input id="loginAdmin" name="submit"
					type="submit" value="login" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form name='' action=""
		method='POST'>
		<table>
			<tr>
				<td>Old Password:</td>
				<td><input type='password' name='oldPassword'></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type='password' name='newPassword' /></td>
			</tr>
			<tr>
				<td>Confirm New Password:</td>
				<td><input type='password' name='confirmNewPassword' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="" type="submit" value="save" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	${noticed }
</body>
</html>
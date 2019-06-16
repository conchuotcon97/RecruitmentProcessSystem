<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User Page</h1>
	<h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>


	<form action="<c:url value="/j_spring_security_logout" />"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout" />
	</form>
	<form name='' action="interviewer" method='POST'>
		<table>
			<tr>
				<td>User number:</td>
				<td colspan="10">${user.getUserNumber() }</td>
			</tr>
			<tr>
				<td>Full name:</td>
				<td><input name="fullName" type="text"
					value="${user.getFullName() }" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" type="text" value="${user.getEmail() }" /></td>
			</tr>
			<tr>
				<td>Avatar:</td>
				<td><input name="avatar" type="text"
					value="${user.getAvatar() }" /></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input name="birthday" type="date"
					value="${user.getBirthday() }" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><select>
						<option><c:if test="${user.isGender() }">
								Male
							</c:if>
						</option>
				</select></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input name="phone" type="text" value="${user.getPhone() }" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input name="address" type="text"
					value="${user.getAddress() }" /></td>
			</tr>
			<tr>
				<td>Position:</td>
				<td>${user.getPosition().getPositionName() }</td>
			</tr>
			<tr>
				<td>Department:</td>
				<td>${user.getDepartment().getDepartmentName() }</td>
			</tr>
			<tr>
				<td colspan='2'><input name="" type="submit" value="save" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<a href="changePasswordInterviewer"> Change password</a>
</body>
</html>
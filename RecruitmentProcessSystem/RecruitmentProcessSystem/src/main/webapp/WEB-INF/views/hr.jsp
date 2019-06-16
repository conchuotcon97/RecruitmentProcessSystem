<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Page</title>
</head>
<body>
	<h1>User Page</h1>
	<h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>

	<form action="<c:url value="/hr/j_spring_security_logout" />"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout" />
	</form>

	<form name='' action="hr" method='POST'>
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
	<a href="changePasswordHR"> Change password</a>
	<a href="vacancy"> Change password</a>
</body>
</html>

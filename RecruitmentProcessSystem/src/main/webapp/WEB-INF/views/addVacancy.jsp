<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name='' action="" method='POST'>
		<table>
			<tr>
				<td>Position:</td>
				<td><select name="positionName">
						<c:forEach var="position" items="${listPosition }">
							<option>${position.getPositionName() }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Number opening:</td>
				<td><input id="" type='' name="numberOpening" /></td>
			</tr>
			<tr>
				<td>Department:</td>
				<td><select name="departmentName">
						<c:forEach var="department" items="${listDepartment }">
							<option>${department.getDepartmentName() }</option>
						</c:forEach>
				</select></td>
			</tr>
			
			
			<tr>
				<td>Description:</td>
				<td><input id="" type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Requirment:</td>
				<td><input id="" type="text" name="requirement" /></td>
			</tr>
			<tr>
				<td>Offer:</td>
				<td><input id="" type="text" name="offer" /></td>
			</tr>
			<tr>
				<td>Experience:</td>
				<td><input id="" type="text" name="experience" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input id="" type="text" name="gender" /></td>
			</tr>
			<tr>
				<td>Degree:</td>
				<td><input id="" type="text" name="degree" /></td>
			</tr>
			
			<tr>
				<td colspan='2'><input id="" name="submit"
					type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>
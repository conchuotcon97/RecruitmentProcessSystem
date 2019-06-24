<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body> <p> ddddddddddddddd</p>


	<table>
		<tr>
			<th>vacancy number</th>
			<th>date created</th>
			<th>date close</th>
			<th>creator</th>
			<th>state</th>
			<th>Position</th>
			<th>Description</th>
			<th>number opening</th>
			<th>Department</th>
			<th>Requirment</th>
			<th>Offer</th>
			<th>Experience</th>
			<th>Gender</th>
			<th>Degree</th>
			<th>vacancy number</th>
		</tr>
		<c:forEach var="vacancy" items="${listVacancy}">
			<tr>
				<td><a href="applicantVacancy"> ${vacancy.getVacancyNumber()}</a>
				<td>${vacancy.getDateCreated()}
				<td>${vacancy.getDateClose() }
				<td>${vacancy.getUser().getFullName() }
				<td>${vacancy.getState() }
				<td>${vacancy.getPosition().getPositionName() }
				<td>${vacancy.getDescription() }
				<td>${vacancy.getNumberOpening() }
				<td>${vacancy.getDepartment().getDepartmentName() }
				<td>${vacancy.getRequirement() }
				<td>${vacancy.getOffer() }
				<td>${vacancy.getExperience()}
				<td>
				<c:choose>
					<c:when test="${vacancy.isGender() }">
						Male
					</c:when>
					<c:when test="${vacancy.isGender() == false }">
						Female
					</c:when>
				</c:choose>
				</td>
				
				<td>${vacancy.getDegree()}
				<td>${vacancy.getVacancyNumber()}
			</tr>
		</c:forEach>
	</table>
	
	<a href="addVacancy">Add vacancy</a>
</body>
</html>
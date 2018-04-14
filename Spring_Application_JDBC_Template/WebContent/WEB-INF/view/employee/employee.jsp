<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Employee Information</h2>
		
	<form:form method="POST" action="/Spring_Application_JDBC_Template/employee/addEmployee">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfJoining">Date Of Joining("yyyy-MM-dd")</form:label></td>
				<td><form:input type="date" path="dateOfJoining" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date Of Birth("yyyy-MM-dd")</form:label></td>
				<td><form:input type="date" path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td><form:label path="depId">Department Id</form:label></td>
				<td><form:input path="depId" /></td>
			</tr>
			<tr>
				<td><form:label path="positionid">Position Id</form:label></td>
				<td><form:input path="positionid" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
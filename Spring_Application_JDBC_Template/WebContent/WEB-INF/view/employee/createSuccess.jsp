<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Employee Information</h2>
	Logged in as : <h3>${user}</h3>
	
	<table>
			<tr>
				<td>Name</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Date Of Joining("yyyy-MM-dd")</td>
				<td>${dateOfJoining}</td>
			</tr>
			<tr>
				<td>Date Of Birth("yyyy-MM-dd")</td>
				<td>${dateOfBirth}</td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td>${depId}</td>
			</tr>
			<tr>
				<td>Position Id</td>
				<td>${positionid}</td>
			</tr>
		
		</table>
		
		<jsp:include page="main.jsp"></jsp:include>  
		
</body>
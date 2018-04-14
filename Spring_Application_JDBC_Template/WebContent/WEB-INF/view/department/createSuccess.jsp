<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Department Information</h2>
	
	
	<table>
			<tr>
				<td>Name</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${description}</td>
			</tr>
			
		</table>
		
		<jsp:include page="main.jsp"></jsp:include>  
		
</body>
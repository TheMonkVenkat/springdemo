<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	<body>
	
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName"/>
			<br/><br/>
			Last Name: <form:input path="lastName"/>
			<br/><br/>
			Country: <form:select path="country">
							<form:options items="${countryOptions}"/>
					</form:select>
			<br/><br/>
			Favorite Programming Language: 
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions }"/>
			<br/><br/>
			Operating Systems:
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			Windows <form:checkbox path="operatingSystems" value="Windows"/>
			Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
			<br/><br/>
			<input type="submit" value="Submit" />
		</form:form>
	
	</body>

</html>
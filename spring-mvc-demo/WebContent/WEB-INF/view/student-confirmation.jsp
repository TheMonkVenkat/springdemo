<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>The Student Confirmation</head>

<body>
	The Student is confirmed: ${student.firstName } ${ student.lastName } from ${student.country }
	<br/>
	<br>
	Favorite Programming Language is: ${student.favoriteLanguage }
	<br>
	<br/>
	Opertating Systems:
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
		<li> ${temp} </li>
		</c:forEach>
	</ul>
</body>
</html>
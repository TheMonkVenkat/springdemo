<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>The Student Confirmation</head>

<body>
	The Customer is confirmed: ${customer.firstName } ${ customer.lastName }
	<br/>
	Free Passes: ${customer.freePasses}
	
	<br>
	Postal Code: ${ customer.postalCode }
	
	<br>
	Course Code: ${ customer.courseCode }
	
</body>
</html>
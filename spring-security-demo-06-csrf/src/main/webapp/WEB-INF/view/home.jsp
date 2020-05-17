<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Blackbox company home page</title>
	</head>
	<body>
		<h2>Welcome to TheBlackBoxSol Company</h2>
		<hr />
		<p>Hey! Good morning. welcome to TheBlackBoxSol company home page</p>
		<br>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="logout" />
		</form:form>
	</body>
</html>
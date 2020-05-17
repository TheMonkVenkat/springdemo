<!DOCTYPE html>

<html>
<head>
	<title>Hello World - Input Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css" />
	<script type="js" src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>

	<form action="processFormRequestParam" method="get">
		<input type="text" name="studentName" placeholder="What's your name?" />

		<input type="submit" />
	</form>

</body>
</html>
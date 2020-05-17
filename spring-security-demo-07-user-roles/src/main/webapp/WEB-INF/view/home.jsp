<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Blackbox company home page</title>
	</head>
	<body>
		<h2>Welcome to TheBlackBoxSol Company</h2>
		<hr />
		<p>Hey! Good morning. welcome to TheBlackBoxSol company home page</p>
		<hr>
		<!-- Display uder name and user role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br/><br/>
			Role: <security:authentication property="principal.authorities"/>
		</p>
		<hr/>
		
		
		<security:authorize access="hasRole('ADMIN')">
		
			<!-- Add a link to point to leaders... this is for managers -->
			<p>
				<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
				(Only for Admin peeps)
			</p>
			
		</security:authorize>
		
		
		
		
		<security:authorize access="hasRole('MANAGER')">
		
			<!-- Add a link to point to systems ... this is for Admins -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				(Only for Manager peeps)
			</p>
		
		</security:authorize>
		
		
		
		<br>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="logout" />
		</form:form>
	</body>
</html>
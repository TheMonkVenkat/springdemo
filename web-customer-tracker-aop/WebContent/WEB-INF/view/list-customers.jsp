<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>List Customers</title>
	
		<!-- reference our style sheets -->
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Model</h2>
		</div>
	</div>
	<div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer"
							onclick="window.location.href='showFormForAdd'; return false;"
							class="add-button"
			/>
			<br/>
			<!-- Add search button -->
			<form:form action="search" method="GET">
				Search Customer: <input type="text" name="theSearchName"/>
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- Loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${ customers }">
				
					<!-- Create an update link with customer ID -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					
					<!-- Create an delete link with customer ID -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName }</td>
						<td>${tempCustomer.lastName }</td>
						<td>${tempCustomer.email }</td>
						<td><a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Expense Details</h1>
	<a href="/expenses">Go back</a>
	
	<div><p>Expense Name: <c:out value="${expenses.title}"></c:out></p></div>
	<div><p>Expense Description: <c:out value="${expenses.description}"></c:out></p></div>
	<div><p>Vendor: <c:out value="${expenses.vendor}"></c:out></p></div>
	<div><p>Amount Spent: <c:out value="${expenses.amount}"></c:out></p></div>

</body>
</html>
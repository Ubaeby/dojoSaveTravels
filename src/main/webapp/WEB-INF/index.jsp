<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>For Travel expenses</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>

	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${expenses}">
				<tr>
					<td><c:out value="${i.title}"></c:out></td>
					<td><c:out value="${i.vendor}"></c:out></td>
					<td>$<c:out value="${i.amount}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>Add an expense:</h2>

	<form:form action="/expenses" method="post" modelAttribute="expense">
		<div>
			<form:label path="title">Expense Name: </form:label>

			<form:input path="title" />
		</div>
		<div>
			<form:label path="vendor">Vendor: </form:label>

			<form:input path="vendor" />
		</div>
		<div>
			<form:label path="amount">Amount: </form:label>

			<form:input type="number" path="amount" />
		</div>
		<div>
			<form:label path="description">Description: </form:label>

			<form:textarea path="description" />
		</div>

		<div>
			<form:errors path="title" class="text-danger" /> <br>
			<form:errors path="vendor" class="text-danger" /><br>
			<form:errors path="amount" class="text-danger" /><br>
			<form:errors path="description" class="text-danger" /><br>

		</div>
		<button>Submit</button>
	</form:form>


</body>
</html>
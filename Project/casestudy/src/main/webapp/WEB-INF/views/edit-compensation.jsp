<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Compensation</title>
</head>
<body>
	<form action="updateCompensation" method="post">
		<label>Compensation ID:</label>
		<input type="text" name="id" value="${compensation.id}" readonly/><br><br>
		
		<label>EMPLOYEE ID:</label>
		<input type="text" name="employeeId" value="${compensation.employeeId}" readonly/><br><br>
		
		<label>Month:</label>
		<input type="text" name="compMonth" value="${compensation.compMonth}" readonly/><br><br>
		
		<label>Compensation Type:</label>
		<input type="text" name="compensationType" value="${compensation.compensationType}" readonly/><br><br>
		
		<label>Amount:</label>
		<input type="number" step="0.01" name="amount" value="${compensation.amount}" required/><br><br>
		
		<label>Description:</label>
		<input type="text" name="description" value="${compensation.description}"/>
		
		<br><br>

    		<button type="submit">Update</button>
		
	</form>
</body>
</html>
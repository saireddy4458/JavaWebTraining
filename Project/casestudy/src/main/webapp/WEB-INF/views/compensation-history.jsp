<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Compensation History</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/style.css'/>">
</head>

<body>

<div class="container">

	<div class="header">
		<h2>Compensation History - ${empName}</h2>

		<div class="comp-page-actions">
			<a class="btn-secondary"
			   href="<c:url value='/employee/addCompensation?id=${reportDto.employeeId}'/>" style="text-decoration: none">
			    Add Compensation
			</a>

			<a class="btn-secondary"
			   href="<c:url value='/employee/search'/>" style="text-decoration: none">
			   Home
			</a>
		</div>
	</div>

	<div class="search-card">

		<form:form method="get"
				   action="viewReport"
				   modelAttribute="reportDto">

			<form:hidden path="employeeId"/>

			<div class="form-group">
				<label>Start Month</label>
				<form:input path="startMonth"
				            type="month"
				            cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label>End Month</label>
				<form:input path="endMonth"
				            type="month"
				            cssClass="form-control"/>
			</div>

			<button class="btn-primary" type="submit">
				Generate Report
			</button>

		</form:form>

	</div>
</div>

</body>
</html>

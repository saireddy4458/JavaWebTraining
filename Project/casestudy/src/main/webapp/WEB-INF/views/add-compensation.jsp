<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Add Compensation</title>
<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>

<body>

	<div class="form-container">
		<div class="page-header">
			<a
				href="${pageContext.request.contextPath}/employee/report?id=${compDto.employeeId}"
				class="btn btn-back" style="text-decoration: none"> ← Back to
				History </a>
		</div>

		<h2>Add Compensation -- ${employeeName}</h2>
		<c:if test="${not empty successMessage}">
			<div class="alert success-alert">${successMessage}</div>
		</c:if>

		<c:if test="${not empty errorMessage}">
			<div class="alert error-alert">${errorMessage}</div>
		</c:if>

		<form:form method="post" action="saveCompensation"
			modelAttribute="compDto" class="employee-form">

			<form:hidden path="employeeId" />

			<div class="form-group">
				<label>Type</label>
				<form:select path="compensationType" cssClass="form-control">
					<form:option value="">-- Select --</form:option>
					<form:option value="SALARY">Salary</form:option>
					<form:option value="BONUS">Bonus</form:option>
					<form:option value="COMMISSION">Commission</form:option>
					<form:option value="ALLOWANCE">Allowance</form:option>
					<form:option value="ADJUSTMENT">Adjustment</form:option>
				</form:select>
			</div>

			<div class="form-group">
				<label>Amount</label>
				<form:input path="amount" type="number" step="0.01"
					cssClass="form-control" />
			</div>

			<div class="form-group">
				<label>Description</label>
				<form:textarea path="description" cssClass="form-control" />
			</div>

			<div class="form-group">
				<label>Month</label>
				<form:input path="compMonth" type="month" cssClass="form-control" />
			</div>

			<button class="btn btn-primary" type="submit">Save</button>

		</form:form>

	</div>

</body>
</html>

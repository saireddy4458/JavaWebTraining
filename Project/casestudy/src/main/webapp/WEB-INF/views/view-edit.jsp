<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>

<!-- SAME CSS FILE -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/styles.css'/>">
</head>

<body>

<div class="form-container">

	<!-- Header -->
	<div class="page-header">
		<a href="<c:url value='/employee/search'/>"
			class="btn btn-back"
			style="text-decoration: none">
			← Back to Search
		</a>
	</div>

	<h2 class="form-title">Edit Employee</h2>

	<!-- SUCCESS MESSAGE -->
	<c:if test="${not empty successMessage}">
		<div class="alert success-alert">
			${successMessage}
		</div>
	</c:if>

	<!-- ERROR MESSAGE -->
	<c:if test="${not empty errorMessage}">
		<div class="alert error-alert">
			${errorMessage}
		</div>
	</c:if>

	<c:if test="${not empty genericError}">
		<div class="alert error-alert">
			${genericError}
		</div>
	</c:if>

	<!-- EDIT FORM -->
	<form:form method="post"
			   action="update"
			   modelAttribute="employeeDetails"
			   class="employee-form">

		<!-- IMPORTANT: Hidden ID -->
		<form:hidden path="id"/>

		<!-- FIRST NAME -->
		<div class="form-group">
			<form:label path="firstName">
				First Name <span class="required">*</span>
			</form:label>
			<form:input path="firstName" cssClass="form-control"/>
			<form:errors path="firstName" cssClass="error-msg"/>
		</div>

		<!-- MIDDLE NAME -->
		<div class="form-group">
			<form:label path="middleName">Middle Name</form:label>
			<form:input path="middleName" cssClass="form-control"/>
			<form:errors path="middleName" cssClass="error-msg"/>
		</div>

		<!-- LAST NAME -->
		<div class="form-group">
			<form:label path="lastName">
				Last Name <span class="required">*</span>
			</form:label>
			<form:input path="lastName" cssClass="form-control"/>
			<form:errors path="lastName" cssClass="error-msg"/>
		</div>

		<!-- BIRTH DATE -->
		<div class="form-group">
			<form:label path="birthDate">
				Birth Date <span class="required">*</span>
			</form:label>
			<form:input path="birthDate" type="date"
				cssClass="form-control"/>
			<form:errors path="birthDate" cssClass="error-msg"/>
		</div>

		<!-- POSITION -->
		<div class="form-group">
			<form:label path="position">
				Position <span class="required">*</span>
			</form:label>
			<form:input path="position" cssClass="form-control"/>
			<form:errors path="position" cssClass="error-msg"/>
		</div>

		<!-- BUTTONS -->
		<div class="button-group">
			<button type="submit" class="btn btn-primary">
				Update Employee
			</button>
			<button type="reset" class="btn btn-secondary">
				Clear
			</button>
		</div>

	</form:form>

</div>

</body>
</html>

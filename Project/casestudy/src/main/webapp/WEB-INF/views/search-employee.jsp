<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Employee Search</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div class="container">

		<!-- Header -->
		<div class="header">
			<h1>Employee Search</h1>
			<div class="header-actions">

				<a href="${pageContext.request.contextPath}/employee/add"
					class="btn-secondary" style="text-decoration: none">Add
					Employee</a> <a href="${pageContext.request.contextPath}/employee/home"
					class="btn-secondary" style="text-decoration: none">Home</a>

			</div>
		</div>

		<!-- Search Form -->
		<div class="search-card">
			<form:form id="searchForm" method="post" modelAttribute="searchDto"
				action="${pageContext.request.contextPath}/employee/results">

				<div class="form-group">
					<label for="searchCriteria">Search By</label>

					<form:select path="searchCriteria" cssClass="form-control"
						onchange="toggleSearchFields()">

						<form:option value="all">All</form:option>
						<form:option value="firstName">First Name</form:option>
						<form:option value="lastName">Last Name</form:option>
						<form:option value="position">Position</form:option>

					</form:select>
				</div>

				<div id="allFields" class="input-grid">
					<div class="form-group">
						<label>First Name</label>
						<form:input path="firstName" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label>Last Name</label>
						<form:input path="lastName" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label>Position</label>
						<form:input path="position" cssClass="form-control" />
					</div>
				</div>

				<div id="singleField" class="form-group" style="display: none;">
					<label id="searchLabel"></label>
					<form:input path="searchValue" cssClass="form-control" />
				</div>

				<button type="submit" class="btn-search">Search</button>

			</form:form>
		</div>

		<!-- Results Table -->
		<div class="table-card">
			<div class="table-wrapper">
				<table class="employee-table">
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Position</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${empty employees}">
							<tr>
								<td colspan="6" class="no-results">No employees found.</td>
							</tr>
						</c:if>

						<c:forEach var="emp" items="${employees}">
							<tr>
								<td>${emp.id}</td>
								<td>${emp.firstName}</td>
								<td>${emp.middleName}</td>
								<td>${emp.lastName}</td>
								<td>${emp.position}</td>
								<td><a class="btn-primary"
									href="${pageContext.request.contextPath}/employee/viewEdit?id=${emp.id}"
									style="text-decoration: none; padding: 6px 12px; display: inline-block;">
										Edit Details </a> <a class="btn-primary" href="${pageContext.request.contextPath}/employee/report?id=${emp.id}"
									style="text-decoration: none; padding: 6px 12px; display: inline-block;">
										Compensation </a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<div class="table-footer">
				Showing
				<c:out value="${fn:length(employees)}" />
				<c:choose>
					<c:when test="${fn:length(employees) == 1}">
						employee
					</c:when>
					<c:otherwise>
						employees
					</c:otherwise>
				</c:choose>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		function toggleSearchFields() {
			var c = document.getElementById('searchCriteria').value;
			var allFields = document.getElementById('allFields');
			var singleField = document.getElementById('singleField');
			var searchLabel = document.getElementById('searchLabel');

			if (c === 'all') {
				allFields.style.display = 'grid';
				singleField.style.display = 'none';
			} else {
				allFields.style.display = 'none';
				singleField.style.display = 'block';

				if (c === 'firstName')
					searchLabel.textContent = 'First Name';
				if (c === 'lastName')
					searchLabel.textContent = 'Last Name';
				if (c === 'position')
					searchLabel.textContent = 'Position';
			}
		}
	</script>

</body>
</html>

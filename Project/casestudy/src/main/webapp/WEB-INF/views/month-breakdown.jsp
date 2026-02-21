<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Monthly Breakdown</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>

<body>

	<div class="container">

		<!-- Header -->
		<div class="header">
			<h2>Monthly Breakdown - ${monthlyBreakDown.employeeName}
				(${monthlyBreakDown.month})</h2>


			<div class="breakdown-actions">
				<a class="btn-secondary"
					href="<c:url value='/employee/reportResult'/>"
					style="text-decoration: none;"> ← Back to Report </a>
				<a class="btn-secondary"
					href="<c:url value='/employee/report?id=${monthlyBreakDown.employeeId}'/>"
					style="text-decoration: none;"> ← Back to History </a>
			</div>
		</div>

		<!-- Table -->
		<div class="table-card">
			<div class="table-wrapper">
				<table class="employee-table">

					<thead>
						<tr>
							<th>Type</th>
							<th>Description</th>
							<th>Amount</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>

						<!-- No Records -->
						<c:if test="${empty monthlyBreakDown.compensationList}">
							<tr>
								<td colspan="4" class="no-results">No records found.</td>
							</tr>
						</c:if>

						<!-- Data Rows -->
						<c:forEach var="item" items="${monthlyBreakDown.compensationList}">
							<tr>
								<td>${item.compensationType}</td>

								<td>${item.description}</td>

								<td>₹ <fmt:formatNumber value="${item.amount}"
										type="number" minFractionDigits="2" />
								</td>

								<td><a class="btn-primary" href=""
									style="text-decoration: none; padding: 6px 12px; display: inline-block;">
										Edit Compensation </a></td>
							</tr>
						</c:forEach>

					</tbody>

					<!-- Total Row -->
					<c:if test="${not empty monthlyBreakDown.compensationList}">
						<tfoot>
							<tr>
								<th colspan="2">Total</th>
								<th>₹ <fmt:formatNumber
										value="${monthlyBreakDown.totalAmount}" type="number"
										minFractionDigits="2" />
								</th>
								<th></th>
							</tr>
						</tfoot>
					</c:if>

				</table>
			</div>
		</div>
	</div>

</body>
</html>

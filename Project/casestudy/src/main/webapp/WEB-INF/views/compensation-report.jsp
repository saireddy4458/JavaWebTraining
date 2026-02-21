<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Compensation Report</title>

<link rel="stylesheet"
      href="<c:url value='/resources/css/style.css'/>">
</head>

<body>

<div class="container">

    <!-- Header Section -->
    <div class="header">
        <h2>Compensation Report - ${empName}</h2>

        <div class="comp-page-actions">
            <a class="btn-secondary"
               href="<c:url value='/employee/report?id=${employeeId}'/>"
               style="text-decoration:none;">
                ← Back to History
            </a>

            <a class="btn-secondary"
               href="<c:url value='/employee/search'/>"
               style="text-decoration:none;">
                Home
            </a>
        </div>
    </div>


    <!-- Report Table -->
    <div class="table-card">
        <div class="table-wrapper">
            <table class="employee-table">

                <thead>
                    <tr>
                        <th>Month</th>
                        <th>Total Compensation</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>

                    <!-- No Data -->
                    <c:if test="${empty reportData}">
                        <tr>
                            <td colspan="3" class="no-results">
                                No records found.
                            </td>
                        </tr>
                    </c:if>

                    <!-- Data Rows -->
                    <c:forEach var="entry" items="${reportData}">
                        <tr>
                            <td>${entry.key}</td>

                            <td>
                                ₹ <fmt:formatNumber value="${entry.value}" 
                                                    type="number"
                                                    minFractionDigits="2"/>
                            </td>

                            <td>
                                <a class="btn-primary"
                                   href="<c:url value='/employee/monthBreakDown?empId=${employeeId}&month=${entry.key}'/>"
                                   style="text-decoration:none; padding:6px 12px; display:inline-block;">
                                    View Breakdown
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>

                <!-- Total Row -->
                <c:if test="${not empty reportData}">
                    <tfoot>
                        <tr>
                            <th>Total</th>
                            <th colspan="2">
                                ₹ 
                                <fmt:formatNumber 
                                    value="${reportData.values().stream().sum()}" 
                                    type="number"
                                    minFractionDigits="2"/>
                            </th>
                        </tr>
                    </tfoot>
                </c:if>

            </table>
        </div>
    </div>

</div>

</body>
</html>

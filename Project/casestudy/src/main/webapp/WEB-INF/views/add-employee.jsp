<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>

    <!-- Your custom CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>
<body>
<div class="form-container">
	<div class="page-header">
    		<a href="<c:url value='/employee/search' />" class="btn btn-back" style="text-decoration: none">
        		← Back to Search
    		</a>
	</div>
    <h2 class="form-title">Add Employee</h2>

    <!-- SUCCESS / ERROR MESSAGES -->
    <c:if test="${not empty successMessage}">
        <div class="alert success-alert">
            ${successMessage}
        </div>
    </c:if>

    <c:if test="${not empty duplicateMessage}">
        <div class="alert error-alert">
            ${duplicateMessage}
        </div>
    </c:if>

    <c:if test="${not empty genericMessage}">
        <div class="alert error-alert">
            ${genericMessage}
        </div>
    </c:if>

    <!-- EMPLOYEE FORM -->
    <form:form method="post" action="save"
               modelAttribute="employee" class="employee-form">

        <!-- FIRST NAME -->
        <div class="form-group">
            <form:label path="firstName">First Name <span class="required">*</span></form:label>
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
            <form:label path="lastName">Last Name <span class="required">*</span></form:label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName" cssClass="error-msg"/>
        </div>

        <!-- DATE OF BIRTH -->
        <div class="form-group">
            <form:label path="birthDate">Birth Date <span class="required">*</span></form:label>
            <form:input path="birthDate" type="date" cssClass="form-control"/>
            <form:errors path="birthDate" cssClass="error-msg"/>
        </div>

        <!-- POSITION -->
        <div class="form-group">
            <form:label path="position">Position <span class="required">*</span></form:label>
            <form:input path="position" cssClass="form-control"/>
            <form:errors path="position" cssClass="error-msg"/>
        </div>

        <!-- FORM BUTTONS -->
        <div class="button-group">
            <button type="submit" class="btn btn-primary">Add Employee</button>
            <button type="reset" class="btn btn-secondary">Clear</button>
        </div>

    </form:form>

</div>

</body>
</html>

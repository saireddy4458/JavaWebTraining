<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Codificación de Caracteres -->
        <meta charset="UTF-8">

        <!-- Configuración inicial de ancho y escala -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        
        <!-- Título de la página -->
        <title>Home Page</title>

        <!-- Hoja de estilo -->
        <link rel="stylesheet" href="<core:url value="/resources/css/estilo.css" />">
    </head>
	<body>
		
		<div class="header">
		    Employment System
		</div>
		
		<div class="container">
		
		    <!-- LEFT MAIN AREA -->
		    <div class="content">
		
		        <div class="card">
		            <a href="search" style="text-decoration: none">Employment Details</a>
		        </div>
		
		        <div class="card">
		            Default Views
		        </div>
		
		    </div>
		
		    <!-- RIGHT SIDEBAR -->
		    <div class="sidebar">
		        <div class="employee">
		            <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" alt="Employee">
		            <div class="bubble">
		                Hi! HR 👋
		            </div>
		        </div>
		    </div>
		
		</div>
	
	</body>
</html>

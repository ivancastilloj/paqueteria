<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java"%> 
<%@ page import="com.basico.model.pedido"%> 
<%@ page import="com.basico.entregar"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Pedidos</h2>
	<br>

	
	<div class="container">

		<table class="table table-striped">
				<thead>
					<tr>
					
						<th>Origen</th>
						<th>Destino</th>
						<th>Tamaño</th>
						<th>Fecha</th>

					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listaEnvios}" var="envios">
					<p>
					<tr>
						
				<td><a href="maps.jsp">	<c:out value="${envios.origen}"></c:out></a>	</td>
						<td><c:out value="${envios.destino}"></c:out></td>
						<td><c:out value="${envios.tamano}"></c:out></td>
						<td><c:out value="${envios.fecha}"></c:out></td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>













<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
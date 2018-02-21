<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="pujar" method="post">
   Introduzca su nick de transportista <input type="text" name="nombre">
    Introduzca su contraseña (password) <input type="password" name="password">
 Ha pujado en  ${sessionScope.puja} euros.
 
   <input type="submit" value="Registrar">
</form>
</body>
</html>
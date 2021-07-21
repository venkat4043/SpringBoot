<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>

<title>Alien Details</title>
</head>
<body>
	Welcome back ${name} <br><br>
	Result is : ${alien} <br><br><hr>
	
	<form action="getAliens">	
		<input type="submit" value="getAliens"><br>		
	</form><hr>
	
	<%-- <form action="add">
		Enter number a : <input type="text" name="num1"><br>
		Enter number b : <input type="text" name="num2"><br>
		<input type="submit" value="Add"><br>
		Result is : ${num3}
	</form> --%>
	
	<form action="addAlien">
		Enter alien number : <input type="text" name="aid"> Only numbers please <br>
		Enter alien name : <input type="text" name="aname"><br>
		<input type="submit" value="AddAlien"><br>		
	</form> <hr>
	
	<form action="addAlien">
		Enter alien number : <input type="text" name="aid"><br>
		Enter alien name : <input type="text" name="aname"><br>
		<input type="submit" value="UpdateAlien"><br>		
	</form> <hr>
	
	<form action="deleteAlien">
		Enter alien number to delete : <input type="text" name="aid"><br>
		
		<input type="submit" value="deleteAlien"> Delete only available records exception handiling cheyyala Raja <br>
	</form> <hr>
	
	
	<form action="getAlien">
		Enter alien number : <input type="text" name="aid"><br>		
		<input type="submit" value="getAlien"> Fetch only available records exception handiling cheyyala Raja <br>		
	</form><hr>
	<form action="getAlienbyName">
		Enter alien name : <input type="text" name="aname"><br>		
		<input type="submit" value="getAlienbyName"><br>		
	</form><hr>
	<form action="orderByName">
		Enter alien name : <input type="text" name="aname"><br>		
		<input type="submit" value="orderByName"><br>		
	</form> 
	
</body>
</html>
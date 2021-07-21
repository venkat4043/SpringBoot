<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Kindha Chudu</h1>
	
	<form align="center" action="/">	
		<input type="submit" value="Back to Home"><br>		
	</form>
	

	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Aliens</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                
            </tr>
            <c:forEach items="${alien}" var="al">
                    <tr>
                        <td>${al.getAid()}</td>
                        <td>${al.getAname()}</td>                        
                    </tr>
            </c:forEach>
        </table>
    </div>
	
</body>
</html>
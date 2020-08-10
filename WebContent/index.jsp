<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Sign-Up</title>
    <body>
        <h>
        <u>Sign-up page</u></h>
        <br>
        <br>
        <form method="post" action="signup">
            
                <label for="username">Email:</label> <input type="email"
                    id="email" name="email"><br>
                <br> <label for="password">Password:</label> <input
                    type="password" id="password1" name="password1"><br>
                <br> <label for="password">Confirm Password:</label> <input
                    type="password" id="password2" name="password2"><br>
                <br> <label for="Username">Username:</label> <input
                    type="text" id="password2" name="username"><br>
            
                <br> <input type="submit" id="submitbtn" value="Submit">
            
            <br>
        </form>
        
            <form method="post" action="login.jsp">
                <p>
                    <u>Already a member?</u>
                </p>
                <input type="submit" id="submitbtn" value="Log in">
            </form>
    </body>

</head>
</html>
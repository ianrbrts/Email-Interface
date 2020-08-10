<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Sign-Up</title>
    <body>
        <h1>Inbox!</h1>
        <h2>Click on Subjects to Open Messages</h2>
        
        <form method='post' action='compose'>
        	<input type="submit" value="Compose Message">
        </form>
        <br><br>
        
        <!-- table that contains emails -->
        <table border="1" cellpadding="5">
        	<th>Subject</th>
        	<th>Sender</th>
        	<th>Time</th>
        	
        	<c:forEach var="message" items="${messageitems}">
	        	<tr>
	        		<td colspan="1" onclick="openMessage(${message.id})" id="subject">${message.subject}</td>
	        		<td colspan="1">${message.sender}</td>
	        		<td colspan="1">${message.time}</td>
	        	</tr>
	        	
	        	<tr style="display:none;" id="messagerow${message.id}" >
	        		<td colspan="3" id="message">${message.content}</td>
	        	</tr>
	        	
	        	
        	</c:forEach>
        </table>
        <br><br>
        <form method="post" action="logout">
        	<input type="submit" value="Log out">
        </form>
        
    </body>
<script>
    		
    		//document.getElementById("subject").addEventListener("click", openMessage);
    		
    		
    		function openMessage(messageid){
    			var row = document.getElementById("messagerow" + messageid);
    			if(row.style.display == "none"){
     				row.style.display = ""; //for removing the style
     			}
     			else{
     				row.style.display = "none";
     			}
    		}
	        		
					
</script>
</head>
</html>
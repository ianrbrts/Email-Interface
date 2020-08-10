<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet"  href="<c:url value="/Messenger/WebContent/inbox.css"/>" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    
<style>

	h1, h2{
	    font-family: "roboto";
	}
	
	body{
		text-align: center;
		background-color: #F5F5F5;
	}
	
	table{
		margin-left: auto;
		margin-right: auto;
	}
	
	th{
	    height: 50px;
	    width: 250px;
	}
	
	td, th{
	    padding: 15px;
	    border-bottom: 1px solid #ddd;
	    text-align: left;
	    font-family: "Roboto";
	}
	
	#subject{
	    cursor: pointer;
	    text-decoration: none;
	}
	
	#subject:hover{
	    text-decoration: underline;
	}
	
	li{
		display:inline;
		float: right;
		padding: 14px 16px;
		color: white;
		font-family: "Roboto";
	}
	
	#logo{
		float: left;
	}
	
	ul{
		background-color: #00BDA3;
		padding: 20px;
		display: block;
		list-style-type: none;
		margin: 0;
		
		overflow: hidden;
	}
	
	li:hover{
		background-color: #008775;
	}

</style>
</head>
	<ul>
		<li>LOGOUT</li>
		<li id="logo">INBOX</li>
	</ul>
 	<title>Inbox</title>
    <body>
        
        <h2>Click on Subjects to Open Messages</h2>
        
        <form method='post' action='compose'>
        	<input type="submit" value="Compose Message">
        </form>
        <br><br>
        
        <!-- table that contains emails -->
        <table>
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

</html>
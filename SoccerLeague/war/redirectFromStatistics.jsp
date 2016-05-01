<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ page import="com.google.appengine.api.users.UserService" %>
	<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
	<%@ page import= "soccerLeague.DataTransfer" %>
	<%@ page import= "soccerLeague.RegisteredUser" %>
	<%@ page import="soccerLeague.SoccerPlayer"%>



	 <html>
	 
	<head> 
		<title>redirectFromStatistics</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>		
	</head>

	<body>
		<header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
			
			<%
			UserService userService;
			DataTransfer myDataBase= DataTransfer.getDataTransfer();
			
			User user;
			SoccerPlayer x;
			
			boolean loggedIn = true;
			
			
			try{
			    userService = UserServiceFactory.getUserService();
				user = userService.getCurrentUser();
				String email= user.getEmail();
				x=	myDataBase.getSoccerPlayerData(email);
				
				
			} catch(Exception e){ %> 
				
				<nav><ul>
					<li><a href="index.html">home</a></li>
					<li><a href="Statistics.jsp">Statistics</a></li>
					<li><a href="calendar.html">calendar</a></li>
					<li><a href="registration.jsp">Register</a></li>
					<li><a href="contact.html">contact us</a></li>
					<li><a href="LogIn.html">Log In</a></li>
					<li><a href="soccerleague">SoccerLeague</a></li>
					
				</ul></nav>		
			<% 	loggedIn=false;out.println("Sorry, no stats are available");} %>
			
			<%
				if(loggedIn == true) { %> 
				
				 <nav><ul>
					<li><a href="index.html">home</a></li>
						<li><a href="Statistics.jsp">statistics</a></li>
						<li><a href="calendar.html">calendar</a></li>
						<li><a href="contact.html">contact us</a></li>
						<li>
						<div class="dropdown">
						<button class="dropbtn">Profile</button>
						<div class="dropdown-content">
						<a href="profile.jsp">View Profile</a>
						<a href="PersonalStats.jsp">Personal Stats</a>
						<a href="teamStats.jsp">Team Stats</a>
						<a href="teamForm.jsp">Make Team</a>
						<a href="index.jsp">Look For Team</a>
						</div>
						</div>
						</li>
						<li><a href="LogIn.html">Log Out</a></li>
					
				</ul></nav>
				
				<%out.println("Sorry, no stats are available");} ; %>
		
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ page import="com.google.appengine.api.users.UserService" %>
	<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
	<%@ page import= "soccerLeague.DataTransfer" %>
	<%@ page import= "soccerLeague.RegisteredUser" %>
	<%@ page import="soccerLeague.SoccerPlayer"%>
	<%@ page import="soccerLeague.SoccerTeam"%>



	 <html>
	 
	 <head> 
		<title>Austin Regional Soccer Association</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>		
	</head>

	<body>
		<header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
	 
	 <nav><ul>
					<li><a href="index.html">home</a></li>
						<li><a href="statistics.html">statistics</a></li>
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
	
	 	<body>
	  <%
	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
	     // System.out.println("ok getting the player worked");
	     
	     SoccerTeam team = myDataBase.getSoccerTeam(x.getTeam());	
	     
	   
	      %>
	      
	  <p><b><%out.println(x.getTeam() + " Stats"); %></b>.</p>
	<!-- table format -->  
		<table border="1">
		<tr>
		<td>Wins:</td>
		<td><%
		
		try{
			out.print(team.getWins());
		}catch(NullPointerException e){
			out.print(0);
		}
		 %></td>
		</tr>
		<tr>
		<td>Losses:</td>
		<td><%
		
		try{
			out.print(team.getLosses());
		}catch(NullPointerException e){
			out.print(0);
		}
		%></td>
		</tr>
		
		</table>
	      </body>
	 </html>
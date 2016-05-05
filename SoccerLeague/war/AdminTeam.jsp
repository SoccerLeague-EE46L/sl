
   
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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Team Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        
        <title>Austin Regional Soccer Association</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>	
        
           
    <header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
				<nav><ul>
					<li><a href="index.html">home</a></li>
					<li><a href="Statistics.jsp">Statistics</a></li>
					<li><a href="calendar.jsp">calendar</a></li>
					<li><a href="registration.jsp">Register</a></li>
					<li><a href="contact.html">contact us</a></li>
					<li><a href="soccerleague">SoccerLeague</a></li>
					
						<div class="dropdown">
						<button class="dropbtn">Admin</button>
						<div class="dropdown-content">
						<a href="AdminTeam.jsp">Team Panel</a>
						<a href="AdminPlayer.jsp">Player Panel</a>
						<a href = "AdminSchedule.jsp">Schedule Event</a>
		
						</div>
						</div>
					
				</ul></nav>
		</header>
        
    </head>
    
     <%
    
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    String email= user.getEmail();
    
    if(!email.equals("admin@google.com")){
    	//response.sendRedirect("SigIn.jsp");
    }
    
    %>
    
    <body>

      <form action="/adminteamupdate" method="get">
      
        <h1>Edit Team Info</h1>
        
        <fieldset>
          <legend><span class="number"></span>Team to Update</legend>
          <label for="name">Team Name:</label>
          <input type="text" id="teamName" name="teamName">
          <label for="wins"># of Wins to add(0 for no win to add):</label>
          <input type="text" id="Wins" name="numWins">
          <label for="loss"># of Losses to add(0 for no loss to add):</label>
          <input type="text" id="Losses" name="numLosses">
        </fieldset>
         
        <button type="submit">Update Team Stats</button>
      </form>
      
    </body>
=======
   
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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Team Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        
        <title>Austin Regional Soccer Association</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>	
        
           
    <header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
				<nav><ul>
					<li><a href="index.html">home</a></li>
					<li><a href="Statistics.jsp">Statistics</a></li>
					<li><a href="calendar.jsp">calendar</a></li>
					<li><a href="registration.jsp">Register</a></li>
					<li><a href="contact.html">contact us</a></li>
					<li><a href="soccerleague">SoccerLeague</a></li>
					
						<div class="dropdown">
						<button class="dropbtn">Admin</button>
						<div class="dropdown-content">
						<a href="AdminTeam.jsp">Team Panel</a>
						<a href="AdminPlayer.jsp">Player Panel</a>
						<a href = "AdminSchedule.jsp">Schedule Event</a>
		
						</div>
						</div>
					
				</ul></nav>
		</header>
        
    </head>
    
     <%
    
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    String email= user.getEmail();
    
    if(!email.equals("admin@google.com")){
    	//response.sendRedirect("SigIn.jsp");
    }
    
    %>
    
    <body>

      <form action="/adminteamupdate" method="get">
      
        <h1>Edit Team Info</h1>
        
        <fieldset>
          <legend><span class="number"></span>Team to Update</legend>
          <label for="name">Team Name:</label>
          <input type="text" id="teamName" name="teamName">
          <label for="wins"># of Wins to add(0 for no win to add):</label>
          <input type="text" id="Wins" name="numWins">
          <label for="loss"># of Losses to add(0 for no loss to add):</label>
          <input type="text" id="Losses" name="numLosses">
        </fieldset>
         
        <button type="submit">Update Team Stats</button>
      </form>
      
    </body>

</html>

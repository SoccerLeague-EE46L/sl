
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="soccerLeague.RegisteredUser" %>
<%@ page import= "soccerLeague.SoccerPlayer" %>
<%@ page import= "soccerLeague.SoccerTeam" %>
<%@ page import= "soccerLeague.DataTransfer" %>
<%@ page import= "com.googlecode.objectify.ObjectifyService" %> 



      

<html>
	<head> 
		<title>Austin Regional Soccer Association</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>		
	</head>

	<body>
	   <%
	   
	   ObjectifyService.register(RegisteredUser.class);
	   ObjectifyService.register(SoccerPlayer.class);
	   ObjectifyService.register(SoccerTeam.class);

      UserService userService = UserServiceFactory.getUserService();
      User user = userService.getCurrentUser();
      DataTransfer myDataBase= DataTransfer.getDataTransfer();
      String email;
      if(user==null){
      		email="notAnEmail";
      	System.out.println(email);
    	}
  	  else{
 		   email=user.getEmail();
          System.out.println(email);
 		}
   	 
    	%>
		<header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
				<nav><ul>
					<li><a href="index.jsp">home</a></li>
					<li><a href="Statistics.jsp">Statistics</a></li>
					<li><a href="calendar.jsp">calendar</a></li>
					<li><a href="contact.html">contact us</a></li>
					<%if (user != null && myDataBase.isInDataBase(email)) {
						%>
						<li>
						<div class="dropdown">
						<button class="dropbtn">Profile</button>
						<div class="dropdown-content">
						<a href="profile.jsp">View Profile</a>
						<a href="PersonalStats.jsp">Personal Stats</a>
						<a href="teamStats.jsp">Team Stats</a>
						<%
						SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
						if(x.isCoach()==true){
						%>
							<a href="PlayersNeedingTeam.jsp">Look For Players</a>
							<a href="teamsNeedingPlayers.jsp">Add Players</a>
						<%
						}
						else{
						%>
						<a href="teamForm.jsp">Make Team</a>
						<a href="teamsNeedingPlayers.jsp">Look For Team</a>
						<%
						}
						%>
						</div>
						</div>
						</li>
						<li><a href="logOut.jsp">Log Out</a></li>
						<%
						}
						else{
						%>
							<li><a href="registration.jsp">Register</a></li>
							<li><a href="LogIn.html">Log In</a></li>
						<%
						}
						%>					
				</ul></nav>
		</header>
		<div>
	
			<h2>News</h2>
			<ul>
				<li> season will resume on june 5, 2016 after the holidays</li>
				<li> we will continue to play in cedar park until further notice</li>
			</ul>
		</div>
		<div>
			<h2> miscellaneous</h2>
			<ul>
				<li> teams looking for new kits place your order before may 31</li>
				<li> anyone interested in watching champions league games contact me</li>
			</ul>
		</div>
		</body>
	</html>

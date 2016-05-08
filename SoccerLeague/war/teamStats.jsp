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
	<%@ page import="soccerLeague.SoccerTeamStats"%>
	



	 <html>
	 
	 <head> 
		<title>Austin Regional Soccer Association</title>
		<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>		
	</head>

	<body>
		<%
		  UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
		%>
		<header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
	 
	 <nav><ul>
					<li><a href="index.jsp">home</a></li>
						<li><a href="Statistics.jsp">statistics</a></li>
						<li><a href="calendar.html">calendar</a></li>
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
					if(x.isCoach()==true){
					%>
						<a href="PlayersNeedingTeam.jsp">Look For Players</a>
						<a href="addPlayers.jsp">Add Players</a>
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
							<li><a href="logIn.jsp">Log In</a></li>
						<%
						}
						%>
				</ul></nav>
				
				</header>
				
			
	
	 	<body>
	  <%
	     if(x.getTeam()==null){
	     	%>
	     	<h2>You are currently not associated with any team</h2>
	     	<%
	 		}
	 		else{
	     SoccerTeam team = myDataBase.getSoccerTeam(x.getTeam());	
	      %>
	  <p><b><%out.println(x.getTeam() + " Stats"); %></b>.</p>
	<!-- table format -->  
				<table border="1">
				
				<tr>
				<td>League Position:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getLeagueRank());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				
				<tr>
				<td>Points:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getPoints());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				
				<tr>
				<td>Games Played:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getGamesPlayed());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				
				
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
				<td>Draws:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getTies());
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
				
				<tr>
				<td>Goals Scored:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getGoalsScored());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				
				<tr>
				<td>Goals Received:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getGoalsReceived());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				<tr>
				<td>Goal Difference:</td>
				<td><%
				try{
					out.print(team.getTeamStats().getGoalDifference());
				}catch(NullPointerException e){
					out.print(0);
				}
				 %></td>
				</tr>
				
				
				
				</table>
				<%
			}
			%>
	      </body>
	 </html>
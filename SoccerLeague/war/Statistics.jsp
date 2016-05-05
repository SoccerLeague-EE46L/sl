<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.google.appengine.api.users.User" %>
  <%@ page import="com.google.appengine.api.users.UserService" %>
  <%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <%@ page import= "soccerLeague.DataTransfer" %>
  <%@ page import= "soccerLeague.SoccerLeague" %>
  <%@ page import= "soccerLeague.SoccerTeam" %>
  <%@ page import= "soccerLeague.SoccerPlayer" %>
  <%@ page import= "java.util.*" %>
   
 
  
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statistics</title>
<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>		
</head>
<body>
<header>
		<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
		<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
</header>
<%
	UserService userService;
	DataTransfer myDataBase= DataTransfer.getDataTransfer();
	
	User user;
	SoccerPlayer x;
	
	try{
	    userService = UserServiceFactory.getUserService();
		user = userService.getCurrentUser();
		String email= user.getEmail();
		x=	myDataBase.getSoccerPlayerData(email);
		
	} catch(Exception e){}
	
	
// 	if (user != null && !(myDataBase.isInDataBase(email)))
// 	{
// 		System.out.println("going to stats cause they are already in the system");
// 		response.sendRedirect("PersonalStats.jsp");
// 	}

%>

  <p><b>Statistics</b></p>
  <table>
    <thead>
        <th></th>
        <th>league Position</th>
        <th>Points</th>
        <th>Games Played</th>
        <th>Wins</th>
        <th>Draws</th>
        <th>Losses</th>
        <th>Goals Scored</th>
        <th>Goals Received</th>
        <th>Goal Difference</th>
    </thead>
    <% try{
    		
    	TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
 
    	for(int i=0; i<myDataBase.getAllSoccerTeams().size();i++){
    		
    		tmap.put(myDataBase.getAllSoccerTeams().get(i).getTeamStats().getPoints(), myDataBase.getAllSoccerTeams().get(i).getTeamName());   		
    	}
    	
    for(Map.Entry<Integer, String> entry: tmap.entrySet()) { %>
    <tr>
    
    <%
    	String teamName = entry.getValue();
    	Integer numGoals = entry.getKey();
    	
    	SoccerTeam team = myDataBase.getSoccerTeam(teamName);   
    %>
        <th><%out.println(teamName); %></th>
        <td><%out.println(team.getTeamStats().getPoints());%>
        <td><%out.println(team.getTeamStats().getGamesPlayed());%>
        <td><%out.println(team.getTeamStats().getWins());%>
        <td><%out.println(team.getTeamStats().getTies());%>
        <td><%out.println(team.getTeamStats().getLosses());%>
        <td><%out.println(team.getTeamStats().getGoalsScored());%>
        <td><%out.println(team.getTeamStats().getGoalsReceived());%>
        <td><%out.println(team.getTeamStats().getGoalDifference());%>

        
     
    </tr>
  	<%}}catch(Exception e){response.sendRedirect("redirectFromStatistics.jsp");} %>
</table>


<button type="submit">Sign Up</button>

</body>
</html>
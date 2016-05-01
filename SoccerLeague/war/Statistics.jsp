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
        <th>Wins</th>
        <th>Losses</th>
        <th>Most Goals</th>
        <th>Most Assists</th>
    </thead>
    <% try{
    for(int i=0; i < myDataBase.getAllSoccerTeams().size(); i++) { %>
    <tr>
    
    <%
    	String mostGoals = myDataBase.getAllSoccerTeams().get(i).getHighestGoalScorer();
    	SoccerPlayer mostGoalsUser = myDataBase.getSoccerPlayerData(mostGoals);
    	
    	String mostAssists = myDataBase.getAllSoccerTeams().get(i).getHighestAssistScorer();
    	SoccerPlayer mostAssistUser= myDataBase.getSoccerPlayerData(mostAssists);
    
    %>
        <th><%out.println(myDataBase.getAllSoccerTeams().get(i)); %></th>
        <td><%out.println(myDataBase.getAllSoccerTeams().get(i).getWins()); %></td>
        <td><%out.println(myDataBase.getAllSoccerTeams().get(i).getLosses()); %></td>
        <td><%out.println(mostGoalsUser.getFirstName() + " " + mostGoalsUser.getLastName()); %>
        <td><%out.println(mostAssistUser.getFirstName() + " " + mostAssistUser.getLastName()); %>
    </tr>
  	<%}}catch(Exception e){response.sendRedirect("redirectFromStatistics.jsp");} %>
</table>


<button type="submit">Sign Up</button>

</body>
</html>
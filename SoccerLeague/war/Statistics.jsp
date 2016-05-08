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
  <%@ page import= "java.util.List" %>
   
 
  
 
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

	DataTransfer myDataBase= DataTransfer.getDataTransfer();	
%>

  <p><b>Statistics</b></p>
  <table border="1">
  		<tr>
  		<td>Team</td>
        <td>Position</td>
        <td>Points</td>
        <td>Games Played</td>
        <td>Wins</td>
        <td>Draws</td>
        <td>Losses</td>
        <td>Goals Scored</td>
        <td>Goals Received</td>
        <td>Goal Difference</td>
        </tr>
 <%
		List<SoccerTeam> teams= myDataBase.getAllSoccerTeams();
  	 	//sorting teams by amount of points//
    	for(int i=0; i<teams.size();i++) {
    		for(int k=0;k<teams.size();k++){
    			if(teams.get(k).getTeamStats().getPoints()>teams.get(i).getTeamStats().getPoints()){
    				SoccerTeam temp= teams.get(i);
    				teams.set(i,teams.get(k));
    				teams.set(k,temp);	
    			}
    		}	
    	}
    	for(int j=0; j<teams.size();j++){
    	SoccerTeam team= teams.get(j);
    	%>
    <tr>
        <td><%out.println(team.getTeamName()); %></td>
        <td><%try{
        out.println(team.getTeamStats().getLeagueRank()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getPoints()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getGamesPlayed()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getWins()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getTies()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getLosses()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getGoalsScored()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getGoalsReceived()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
        <td><%try{
        out.println(team.getTeamStats().getGoalDifference()); 
        }catch(NullPointerException e){
        out.println(0);	
        }
        %></td>
    </tr>
    <% }
    	%>
</table>



</body>
</html>
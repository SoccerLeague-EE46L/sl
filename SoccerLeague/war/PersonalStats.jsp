
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
	 
	 
	 	<body>
	  <%
	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
	     // System.out.println("ok getting the player worked");
	     
	    
	     
	      %>
	      
	  <p><b>Personal Stats</b>.</p>
	<!-- table format -->  
		<table border="1">
		<tr>
		<td>My Team:</td>
		<td><%out.print(x.getTeam()); %></td>
		</tr>
		<tr>
		<td>Jersey:</td>
		<td><%out.print(x.getJerseyNumber()); %></td>
		</tr>
		<tr>
		<td>Positions Played:</td>
		<td><%out.print(x.getPositionsPlayed()); %></td>
		</tr>
		<tr>
		<td>Games Played:</td>
		<td><%out.print(x.getMyStats().getGamesPlayed()); %></td>
		</tr>
		<tr>
		<td>Goals:</td>
		<td><%out.print(x.getMyStats().getGoals()); %></td>
		</tr>
		<tr>
		<td>Assists:</td>
		<td><%out.print(x.getMyStats().getAssists()); %></td>
		</tr>
		<tr>
		<td>Clean Sheets:</td>
		<td><%out.print(x.getMyStats().getCleanSheets()); %></td>
		</tr>
		<tr>
		<td>Red Cards:</td>
		<td><%out.print(x.getMyStats().getRedCards()); %></td>
		</tr>
		<tr>
		<td>Yellow Cards:</td>
		<td><%out.print(x.getMyStats().getYellowCards()); %></td>
		</tr>
		</table>
	      </body>
	 </html>

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
	<%@ page import="java.util.List" %>


	 <html>
	 
	 
	 	<body>

	  <%

	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
	      List<SoccerTeam> teams= myDataBase.getAllSoccerTeams();
	     // System.out.println("ok getting the player worked");
	      %>
	      
	  <p><b>Teams Looking For Players</b>.</p>
	<!-- table format -->  
	<form action="requestteam" method="get"> 
		<table border="1">
		
		<tr>
		<td>Team</td>
		<td>Positions Needed</td>
		<td>Coach Info</td>
		<td>Request Team</td>
		</tr>
		<tr>
		<%
		for(int i=0;i<teams.size();i++){
		%>
		<tr>
		<%
			if(teams.get(i).needsPlayers()){
			 String teamName= teams.get(i).getTeamName();
			%>
					<td><%out.print(teamName); %></td>
					<td><%
					List pos= teams.get(i).getPosNeeded();
					for(int k=0;k<pos.size();k++){
					out.print(pos.get(k)+ " ");
					} 
					%></td>
					<td><%RegisteredUser coach=myDataBase.getRegisteredUserData(teams.get(i).getCoach());
					out.print(coach.getFirstName()+ ": "+coach.getEmail());
					 %></td>
					 <td>
          			<input type="checkbox" id="<%out.print(teamName);%>" value="<%out.print(teamName);%>" name="<%out.print(teamName);%>"><label class="light" for="<%out.print(teamName);%>">Send Request</label><br>
					 </td>
			</tr>
			<%

			}
		}
		%>
		</table>
				<button type="submit">Submit Requests</button> 
		</form>
	      </body>
	 </html>
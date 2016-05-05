
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
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      if(user==null || myDataBase.getSoccerPlayerData(user.getEmail()).isCoach()==false){
				response.sendRedirect("index.jsp");
	      }

	      String email= user.getEmail();
	      SoccerPlayer x=myDataBase.getSoccerPlayerData(email);
	      List<SoccerPlayer> players= myDataBase.getAllSoccerPlayers();

	      %>
	      
	  <p><b>Players Looking For A Team</b>.</p>
	<!-- table format -->  
		<table border="1">

		<tr>
		<td>Name</td>
		<td>Positions Played</td>
		<td>Player Info</td>
		</tr>
		<tr>
		<%
		for(int ind=0; ind<players.size();ind++){System.out.println(players.get(ind).getFirstName());}
		for(int i=0;i<players.size();i++){
		%>
		<tr>
		<%
			if(players.get(i).needsTeam()){
			%>
					<td><%out.print(players.get(i).getFirstName()+ " "+players.get(i).getLastName() ); %></td>
					<td><%
					System.out.println(players.get(i).getFirstName());
					List pos= players.get(i).getPosition().getPositionsPlayed();
					if(pos!=null){
						for(int k=0;k<pos.size();k++){
						out.print(pos.get(k)+ " ");
						}
					} 
					%></td>
					<td><%
					out.print(players.get(i).getEmail());
					 %></td>
			</tr>
			<%

			}
		}
		%>
		</table>
	      </body>
	 </html>
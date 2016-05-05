<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List"%>

<%@ page import="com.google.appengine.api.users.User"%>

<%@ page import="com.google.appengine.api.users.UserService"%>

<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="soccerLeague.RegisteredUser"%>
<%@ page import="soccerLeague.SoccerPlayer"%>
<%@ page import="soccerLeague.SoccerTeam"%>
<%@ page import="soccerLeague.DataTransfer"%>
<%@ page import="com.googlecode.objectify.ObjectifyService"%>
<%@ page import="java.util.ArrayList" %>


<html>
<head>
<title>Austin Regional Soccer Association</title>
<link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css" />
</head>



<body>
	<%
	  
      UserService userService = UserServiceFactory.getUserService();
      User user = userService.getCurrentUser();
      DataTransfer myDataBase= DataTransfer.getDataTransfer();
      if(user==null || myDataBase.getSoccerPlayerData(user.getEmail()).isCoach()==false){
			response.sendRedirect("index.jsp");
      }
    	  System.out.println("ok you are a coach");
    	  SoccerPlayer coach= myDataBase.getSoccerPlayerData(user.getEmail());
    	  List<String> requests= coach.getRequests();
    	  %>
    	  
    	  <p><b>Requests To Join The Team</b></p>
    		<!-- table format -->  
    			<form action="/addplayer" method="get"> 
    			<table border="1">

    			<tr>
    			<td>Name</td>
    			<td>Positions Played</td>
    			<td>Player Info</td>
    			<td>Process Requests</td>
    			</tr>
    			<%
    			List<String> remaining= new ArrayList<String>();
    			for(int i=0;i<requests.size();i++){
    				SoccerPlayer interest=myDataBase.getSoccerPlayerData((requests.get(i)));
    			%>
    			<tr>
    			<%
    						if(interest.needsTeam()){
    							remaining.add(interest.getEmail());
    							
    				%>
    						<td><%out.print(interest.getFirstName()+ " "+ interest.getLastName() ); %></td>
    						<td><%
    						List pos= interest.getPosition().getPositionsPlayed();
    						if(pos!=null){
    							for(int k=0;k<pos.size();k++){
    							out.print(pos.get(k)+ " ");
    							}
    						} 
    						%></td>
    						<td><%
    						out.print(interest.getEmail());
    						 %></td>
    						 <td>
    						 <label for="decision"></label>
    					<select id="decision" name="descision">
						<option value="<%out.print("A"+interest.getEmail());%>">accept</option>
						<option value="<%out.print("D"+interest.getEmail());%>">decline</option>
						<option value="<%out.print("L"+interest.getEmail());%>"></option>
						</optgroup>
						</select> 
					 </td>
    				</tr>
    				<%
    				}
     			}
    				
    			%>
    			</table>
    			<button type="submit">Submit</button> 
    			</form>
</body>
</html>
      
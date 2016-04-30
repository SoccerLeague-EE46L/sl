
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
	      System.out.println("ok getting the player worked");
	      %>
	<ul>
		<li><h1><% out.println(x.getFirstName());%></h1> </li>
	</ul>
	      </body>
	 </html>
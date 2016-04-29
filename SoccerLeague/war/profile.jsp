
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<%@ page import="com.google.appengine.api.users.User" %>
	<%@ page import="com.google.appengine.api.users.UserService" %>
	<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
	<%@ page import= "soccerLeague.DataTransfer" %>
	<%@ page import= "soccerLeague.RegisteredUser" %>



	 <html>
	 	<body>
	  <%
	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();
	      DataTransfer myDataBase= DataTransfer.getDataTransfer();
	      RegisteredUser x=(RegisteredUser)myDataBase.getSoccerPlayerData(email);
	      System.out.println("ok getting the player worked");
	      %>
	<ul>
		<li><% 
		x.getFirstName();
		%>
		</li>
	</ul>
	      </body>
	 </html>
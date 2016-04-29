  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="java.util.List" %>
  <%@ page import="com.google.appengine.api.users.User" %>
  <%@ page import="com.google.appengine.api.users.UserService" %>
  <%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <%@ page import= "soccerLeague.DataTransfer" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statistics</title>
</head>
<body>
<%
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();
	String email= user.getEmail();
	DataTransfer myDataBase= DataTransfer.getDataTransfer();
	myDataBase.getSoccerPlayerData(email);
	
// 	if (user != null && !(myDataBase.isInDataBase(email)))
// 	{
// 		System.out.println("going to stats cause they are already in the system");
// 		response.sendRedirect("PersonalStats.jsp");
// 	}
%>
<p><%myDataBase.getSoccerPlayerData(email).getMyStats().getAssists(); %><p>

</body>
</html>
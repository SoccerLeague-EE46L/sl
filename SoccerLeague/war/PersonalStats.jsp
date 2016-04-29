 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="java.util.List" %>
  <%@ page import="com.google.appengine.api.users.User" %>
  <%@ page import="com.google.appengine.api.users.UserService" %>
  <%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <%@ page import= "soccerLeague.DataTransfer" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	 <form action="/stats" method="get">
      
        <h1>Here Are Your Personal Statistics</h1>
        
        
        <fieldset>
          <legend><span class="number">1</span>Your basic info</legend>
          <label for="name">First Name:</label>
          <%
          SoccerPlayer Person  = ObjectifyService.ofy();
      	
          %>
          
          <label for="name">Last Name:</label>
          <input type="text" id="lastName" name="last_name">
          
          
          <label>Age:</label>
          <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
          <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label>
        </fieldset>
        
	
        
        <button type="submit">Sign Up</button>
      </form>
</body>
</html>
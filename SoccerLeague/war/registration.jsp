
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="soccerLeague.DataTransfer"%>

<html>
<body>
	<%
      UserService userService = UserServiceFactory.getUserService();
      User user = userService.getCurrentUser();
      DataTransfer myDataBase= DataTransfer.getDataTransfer();
      if(user==null){
        %>
	<p>
		<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign
			in</a> with your Google account to register
	</p>
	<%
 	}  
    else if (user != null && (!myDataBase.isInDataBase(user.getEmail()))) {
		System.out.println("testing print statement: inside registration jsp");
		response.sendRedirect("registrationForm.jsp");
     }
     else {
		response.sendRedirect("index.jsp");
      }
  %>
</body>
</html>
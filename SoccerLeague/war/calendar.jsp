<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import= "soccerLeague.DataTransfer" %>
	<%@ page import= "soccerLeague.RegisteredUser" %>
	<%@ page import="soccerLeague.SoccerPlayer"%>
	<%@ page import="soccerLeague.Month" %>
	<%@ page import="soccerLeague.SoccerTeam" %>
	<%@ page import="com.google.appengine.api.users.User" %>
  	<%@ page import="com.google.appengine.api.users.UserService" %>
  	<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
	<%@ page import="java.util.List" %>
<%@ include file="calendarCommon.jsp" %>

<html>
<head>
  <title>devdaily.com calendar</title>
  <link rel="StyleSheet" href="/blog/calendar.css" type="text/css" media="screen" />
</head>

<body id="regular_page">

<div id="calendar_main_div">
<table border="1" cellspacing="0" cellpadding="4" id="calendar_table">
  <tr>
    <td width="100%" colspan="7" class="month_year_header">
      <%=monthName%>, <%=intYear%>
    </td>
  </tr>
  <tr class="week_header_row">
    <th width="14%" class="th_day_cell day">Sun</th>
    <th width="14%" class="th_day_cell day">Mon</th>
    <th width="14%" class="th_day_cell day">Tue</th>
    <th width="14%" class="th_day_cell day">Wed</th>
    <th width="14%" class="th_day_cell day">Thu</th>
    <th width="15%" class="th_day_cell day">Fri</th>
    <th width="15%" class="th_day_cell day">Sat</th>
  </tr>
<%
{
	 UserService userService = UserServiceFactory.getUserService();
	 DataTransfer myDataBase= DataTransfer.getDataTransfer();
    User user = userService.getCurrentUser();
    //if(!email.equals(null))
   // {
    
   // }
    
    //if(!team.equals(null))
   // {
   List<SoccerTeam> teams = myDataBase.getAllSoccerTeams();
    //}
  Month aMonth = Month.getMonth( Integer.parseInt(currentMonthString), Integer.parseInt(currentYearString) );
  int [][] days = aMonth.getDays();
  int t = 0;
  int games = 0;
  for( int i=0; i<aMonth.getNumberOfWeeks(); i++ )
  {
    %><tr class="week_data_row"><%
    for( int j=0; j<7; j++ )
    {
      if( days[i][j] == 0 )
      {
        %><td class="empty_day_cell">&nbsp;</td><%
        
      }
      else
      {
        // this is "today"
        if( currentDayInt == days[i][j] && currentMonthInt == aMonth.getMonth() && currentYearInt == aMonth.getYear() )
        {
        	for(t=0;t<teams.size();t++)
        	{
        	if(!((teams.get(t).getSchedule())[aMonth.getMonth()][(i*j)] ==null))
        	{
        		games++;
         	
        	}
        	}
        	if(games > 0)
        	{
        		 %><td class="today_cell"><a href="calendar.html"><%=games%></a></td><%
        	}
        	else
        	{
        		%><td class ="today_cell"><%=days[i][j]%></td><% 
        	}
        	
        }
        else
        {
        	for(t=0;t<teams.size();t++)
        	{
          	if(!((teams.get(t).getSchedule())[aMonth.getMonth()][(i*j)] ==null))
        	{
         	  games++;
        	}
        	}
        	if(games >0)
        	{
        		%><td class="today_cell"><a href="Calendar.html"><%=teams.get(t).getSchedule()[aMonth.getMonth()][(i*j)]%></a></td><%	
        	}
        	else{
        		%><td class ="day_cell"><%=days[i][j]%></td><%
        	}
        	games = 0;
        }
        
      } // end outer if
    }} // end for
    %>
    </tr>
  <%}

%>
</table>

<%-- end of "calendar_div" --%>
</div>

<!-- navigation links -->
<%-- sorry, i don't know how to get this look without a table --%>
<table id="calendar_nav_table" border="0">
  <tr>
    <td id="prev_link">
      <form method="post">
        <input type="submit" name="PREV" value=" << ">
        <input type="hidden" name="month" value="<%=prevMonth%>">
        <input type="hidden" name="year" value="<%=prevYear%>">
      </form>
    </td>
    <td id="link_to_month_view">
      <form action="calendarMonthPrintView.jsp" method="post">
        <input type="submit" value="  Full-Screen Print View  " class="submit_button">
        <input type="hidden" name="month" value="<%=intMonth%>">
        <input type="hidden" name="year"  value="<%=intYear%>">
      </form>
    </td>
    <td id="next_link">
      <form method="post">
        <input type="submit" name="NEXT" value=" >> ">
        <input type="hidden" name="month" value="<%=nextMonth%>">
        <input type="hidden" name="year" value="<%=nextYear%>">
      </form>
    </td>
  </tr>
</table>
  <!-- navigation links end -->

</body>
</html>
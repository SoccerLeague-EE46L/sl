<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="calendarCommon.jsp" %>

<html>
<head>
  <title>Calendar</title>
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
    <th width="14%" class="thdaycell day">Sun</th>
    <th width="14%" class="thdaycell day">Mon</th>
    <th width="14%" class="thdaycell day">Tue</th>
    <th width="14%" class="thdaycell day">Wed</th>
    <th width="14%" class="thdaycell day">Thu</th>
    <th width="15%" class="thdaycell day">Fri</th>
    <th width="15%" class="thdaycell day">Sat</th>
  </tr>
<%
	{
  Month aMonth = Month.getMonth( Integer.parseInt(currentMonthString), Integer.parseInt(currentYearString) );
  int [][] days = aMonth.getDays();
  for( int i=0; i<aMonth.getnofweeks(); i++ )
  {
%><tr class="weekdatarow"><%
    for( int j=0; j<7; j++ )
    {
      if( days[i][j] == 0 )
      {
        %><td class="emptydaycell">&nbsp;</td><%
      }
      else
      {
        if( currentDayInt == days[i][j] && currentMonthInt == aMonth.getMonth() && currentYearInt == aMonth.getYear() )
        {
          %><td class="todaycell"><%=days[i][j]%></td><%
        }
        else
        {
          %><td class="daycell"><%=days[i][j]%></td><%
        }
      } 
    } 
    %>
    </tr>
  <%}
}
%>
</table>


</div>


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


</body>
</html>
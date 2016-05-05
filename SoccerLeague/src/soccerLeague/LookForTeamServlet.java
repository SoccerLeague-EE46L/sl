package soccerLeague;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LookForTeamServlet extends HttpServlet {
	private static DataTransfer myData = DataTransfer.getDataTransfer();
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException{
		 resp.getWriter().println("hello world");
		 resp.sendRedirect("/teamsNeedingPlayers.jsp");
	 }
}

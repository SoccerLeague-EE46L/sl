package soccerLeague;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LookForTeamServlet extends HttpServlet {
	private static DataTransfer myData = DataTransfer.getDataTransfer();
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException{
		 System.out.println("ok i am here");
		 resp.getWriter().println("hello world");
	 }
}

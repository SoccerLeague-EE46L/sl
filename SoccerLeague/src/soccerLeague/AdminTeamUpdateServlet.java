package soccerLeague;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminTeamUpdateServlet extends HttpServlet{

	public AdminTeamUpdateServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		System.out.println("hello");
		String teamName = req.getParameter("teamName");
		
		System.out.println(teamName);
		
		String winsToParse = req.getParameter("numWins");
	
		String lossesToParse = req.getParameter("numLosses");
		
	
		int wins = Integer.parseInt(winsToParse);
		
		int losses = Integer.parseInt(lossesToParse);
		
		
		System.out.println("Hello: " + winsToParse);
		System.out.println(losses);
		
		 DataTransfer myDataBase= DataTransfer.getDataTransfer();
		 
		SoccerTeam x = myDataBase.getSoccerTeam(teamName);
//		if(x.getTeamStats()==null){
//			x.setTeamStats(new SoccerTeamStats());
//		}
		
		x.addWin();
		

		for (int i=0; i<wins; i++) { x.addWin();}
	
		for (int i=0; i<losses; i++) { x.addLoss();}
	
	}


}

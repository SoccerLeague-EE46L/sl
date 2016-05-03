package soccerLeague;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AdminPlayerUpdateServlet extends HttpServlet{

	public AdminPlayerUpdateServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		System.out.println("Hello admin player update");
		DataTransfer myDataBase= DataTransfer.getDataTransfer();
		
		String teamName = req.getParameter("teamName");
		String jerseyNum = req.getParameter("jerseyNumber");
		int jersey = Integer.parseInt(jerseyNum);
		String numGoals = req.getParameter("numGoals");
		int goals= Integer.parseInt(numGoals);
		String numYellow = req.getParameter("numYellowCards");
		int yellow = Integer.parseInt(numYellow);
		String numCleans = req.getParameter("numCleanSheets");
		int cleans = Integer.parseInt(numCleans);
		
		
		SoccerTeam team = myDataBase.getSoccerTeam(teamName);
		
		if(team.getTeamStats()==null){
			team.setTeamStats(new SoccerTeamStats());
		}
		
		SoccerPlayer player = null;
		
		for(int i=0; i<team.getRoster().size(); i++){
			player=myDataBase.getSoccerPlayerData(team.getRoster().get(i));
			if (player.getJerseyNumber()== jersey){ break;}
		}
		
		for (int i=0; i<goals; i++) { player.getMyStats().setGoals(1); }
		
		for (int i=0; i<yellow; i++) { player.getMyStats().setYellowCards(1);}
		
		for (int i=0; i<cleans; i++) { player.getMyStats().setCleanSheets(1);}
	}

}

package soccerLeague;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AddPlayerServlet extends HttpServlet {
	private static DataTransfer myDataBase= DataTransfer.getDataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<String> accepted= new ArrayList<String>();
		List<String> pending= new ArrayList<String>();
		UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
		Map params= req.getParameterMap();
		Iterator decisions = params.values().iterator();
		while(decisions.hasNext()){
			String[] x= (String[])decisions.next();
			for(int i=0;i<x.length;i++){
				if(x[i].charAt(0)=='A'){
					System.out.println("accepted:");
					System.out.println(x[i].substring(1));
					accepted.add(x[i].substring(1));
				}
				else if(x[i].charAt(0)=='L'){
					System.out.println("waiting:");
					System.out.println(x[i].substring(1));
					pending.add(x[i].substring(1));
				}
			}
		}
		SoccerPlayer coach= myDataBase.getSoccerPlayerData(user.getEmail());
		SoccerTeam team= myDataBase.getSoccerTeam(coach.getTeam());
		team.addPlayer(accepted, user.getEmail());
		myDataBase.putSoccerTeam(team);
		coach.setRequest(pending);
		myDataBase.putRegisteredUserData(coach);
		resp.sendRedirect("/index.jsp");
	}

}

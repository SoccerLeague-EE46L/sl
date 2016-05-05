package soccerLeague;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class RequestTeamServlet extends HttpServlet{
    private static DataTransfer myDataBase= DataTransfer.getDataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 UserService userService = UserServiceFactory.getUserService();
	     User user = userService.getCurrentUser();
		Map x= req.getParameterMap();
		Iterator y = x.values().iterator();
		
		while(y.hasNext()){
			String[] request=(String[])y.next();
			for(int i=0;i<request.length;i++){
				SoccerTeam team=myDataBase.getSoccerTeam(request[i]);
				SoccerPlayer coach= myDataBase.getSoccerPlayerData(team.getCoach());
				coach.addRequest(user.getEmail());
			}
		}
		resp.sendRedirect("/index.jsp");
	}


}

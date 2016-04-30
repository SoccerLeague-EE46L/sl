package soccerLeague;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Result;

public class MakeTeamServlet extends HttpServlet {
	private static DataTransfer myDataBase= DataTransfer.getDataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		System.out.println("i am where i want to be");
	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();  
	      RegisteredUser x = ofy().load().type(SoccerPlayer.class).id(email).now();
	      String teamname=req.getParameter("teamName");
	      String removeteam=req.getParameter("removeTeam");
	      System.out.println(req.getParameter("beCoach"));
	     
	   
	}

}

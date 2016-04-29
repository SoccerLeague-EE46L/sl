package soccerLeague;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class MakeTeamServlet extends HttpServlet {
	private static DataTransfer myDataBase= DataTransfer.getDataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
	      UserService userService = UserServiceFactory.getUserService();
	      User user = userService.getCurrentUser();
	      String email= user.getEmail();      
	      System.out.println(myDataBase.getSoccerPlayerData(email).getFirstName());
	      
      
	}

}

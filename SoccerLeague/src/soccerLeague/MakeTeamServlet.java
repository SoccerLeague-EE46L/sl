package soccerLeague;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
	      System.out.println(email);
	      RegisteredUser x = ofy().load().type(SoccerPlayer.class).id(email).now();
	      
			String[]sportPos =x.getSportPositions();
			ArrayList<String> sports=new ArrayList<String>();
			for(int k=0;k<sportPos.length;k++){
				System.out.println(sportPos[k]);
				sports.add(sportPos[k]);
			}
			ArrayList<String> positions= new ArrayList<String>();
			
			Map params=req.getParameterMap();
			Iterator iter= params.values().iterator();
			while(iter.hasNext()){
				String[]y=(String[]) iter.next();
				for(int j=0;j<y.length;j++){
					if(sports.contains(y[j])){
						System.out.println(y[j]);
						positions.add(y[j]);
					}
				}
			}
	      
	      String teamName=req.getParameter("teamName");
	      System.out.println("about to make team");
	      x.makeTeam(teamName,positions);
	      System.out.println("made the team");
	      resp.sendRedirect("/loggedIn.jsp");
	   
	}

}

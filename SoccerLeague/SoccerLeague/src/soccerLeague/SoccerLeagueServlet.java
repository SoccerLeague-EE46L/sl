package soccerLeague;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;






@SuppressWarnings("serial")
public class SoccerLeagueServlet extends HttpServlet {
	//do I need an instance of this or should I make it static//
	DataTransfer myData = DataTransfer.getDataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<String> temp= new ArrayList<>();
		temp.add("defender");
		temp.add("midfielder");
		Registration.createUser("soccerLeague.SoccerPlayer","aldair","sanchez","5129021114","508 e howard lane",temp );
		System.out.println("created it the user");
		SoccerPlayer foo = myData.getSoccerPlayerData("test@example.com");
		if(foo==null){
			resp.setContentType("text/plain");
            resp.getWriter().println("Hello, unknown user");
		}
		else{
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, " + foo.getFirstName()+ "here is all your info"+ foo.getLastName()+ foo.getPositionsPlayed().get(0)+ foo.getPositionsPlayed().get(1));
		}
		System.out.println("about to make the team");
		SoccerTeam x= new SoccerTeam(foo, "ut longhorns");
		System.out.println("created the team");
		foo.makeTeam("UT Longhorns");
		foo.updateRegisteredUserName("Ramiro");
		foo = (SoccerPlayer) myData.getRegisteredUserData("test@example.com");
		if(foo==null){
			resp.setContentType("text/plain");
            resp.getWriter().println("Hello, unknown user");
		}
		else{
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, " + foo.getFirstName());
        resp.getWriter().println("the manager of" +foo.getTeam().getTeamName());
        resp.getWriter().println(" is " +foo.getTeam().getCoach().getFirstName());

		}
	}
}

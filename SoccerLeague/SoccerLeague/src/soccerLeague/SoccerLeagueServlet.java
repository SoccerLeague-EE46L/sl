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
		SoccerPlayer dummy= new SoccerPlayer("aldair","sanchez","aldsan512@yahoo.com","5129021114","508 e howard lane",temp );
		myData.putRegisteredUserData(dummy);
		SoccerPlayer foo =(SoccerPlayer) myData.getRegisteredUserData("aldsan512@yahoo.com");
		if(foo==null){
			resp.setContentType("text/plain");
            resp.getWriter().println("Hello, unknown user");
		}
		else{
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, " + foo.getFirstName()+ "here is all your info"+ foo.getLastName()+ foo.getMyStats().getGamesPlayed());
		}
		myData.updateRegisteredUserName(dummy, "Ramiro");
		foo =(SoccerPlayer) myData.getRegisteredUserData("aldsan512@yahoo.com");
		if(foo==null){
			resp.setContentType("text/plain");
            resp.getWriter().println("Hello, unknown user");
		}
		else{
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, " + foo.getFirstName());
		}
	}
}

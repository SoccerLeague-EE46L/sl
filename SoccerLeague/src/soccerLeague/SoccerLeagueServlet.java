package soccerLeague;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;






@SuppressWarnings("serial")
public class SoccerLeagueServlet extends HttpServlet {
	//do I need an instance of this or should I make it static//
	DataTransfer myData = new DataTransfer();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		RegisteredUser dummy= new RegisteredUser("aldair","sanchez","aldsan512@yahoo.com","5129021114");
		myData.putRegisteredUserData(dummy);
		RegisteredUser foo = myData.getRegisteredUserData("aldsan512@yahoo.com");
		if(foo==null){
			resp.setContentType("text/plain");
            resp.getWriter().println("Hello, unknown user");
		}
		else{
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, " + foo.getFirstName());
		}
		myData.updateRegisteredUserName(dummy, "Ramiro");
		foo = myData.getRegisteredUserData("aldsan512@yahoo.com");
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

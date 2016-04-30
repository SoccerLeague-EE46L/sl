package soccerLeague;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		Class<RegisteredUser> userClass = null;
		try {
			System.out.println(req.getParameter("sport"));
		userClass = (Class<RegisteredUser>) Class.forName(req.getParameter("sport"));
		System.out.println("it recognized the sport correctly from request");
		} catch (ClassNotFoundException e) {
			System.out.println("sorry this is not a sport we support");
		}
		RegisteredUser user=null;
		System.out.println("was able to recognize sport");
		
		try {
			user= userClass.newInstance();
			System.out.println("creating new instance");
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = getEmail();
		//this part of the code checks the positions parameters to see which positions the player is willing to play
		String[]sportPos =user.getSportPositions();
		ArrayList<String> sports=new ArrayList<String>();
		for(int k=0;k<sportPos.length;k++){
			System.out.println(sportPos[k]);
			sports.add(sportPos[k]);
		}
		ArrayList<String> positions= new ArrayList<String>();
		Map params=req.getParameterMap();
		Iterator x= params.values().iterator();
		while(x.hasNext()){
			String[]y=(String[]) x.next();
			for(int j=0;j<y.length;j++){
				if(sports.contains(y[j])){
					System.out.println(y[j]);
					positions.add(y[j]);
				}
			}
		}
	
		user.setBasicInfo(req.getParameter("first_name"),req.getParameter("last_name"),email,req.getParameter("phone_number"),req.getParameter("address"),positions);
		System.out.println(req.getParameter("first_name")+req.getParameter("last_name")+email+req.getParameter("address")+req.getParameter("phone_number")+positions);
		user.putRegisteredUserData();
        resp.sendRedirect("/loggedIn.jsp");
	}
	public static String getEmail(){
		  UserService userService = UserServiceFactory.getUserService();
	        User user = userService.getCurrentUser();
	        if (user != null) {
	            System.out.println("Hello, " + user.getNickname());
	        } else {
	        	System.out.println("wow no email");
	        }
	        return user.getEmail();
			
	    }
}

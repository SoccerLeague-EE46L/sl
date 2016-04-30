package soccerLeague;

import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList needsToBeREmoved= new ArrayList();
		user.setBasicInfo(req.getParameter("first_name"),req.getParameter("last_name"),email,req.getParameter("phone_number"),req.getParameter("address"),needsToBeREmoved);
		System.out.println(req.getParameter("first_name")+req.getParameter("last_name")+email+req.getParameter("address")+req.getParameter("phone_number")+needsToBeREmoved);
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

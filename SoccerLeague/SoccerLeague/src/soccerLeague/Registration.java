package soccerLeague;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.List;

import com.google.appengine.api.users.User;

public class Registration {
	public static void createUser(String typeofUser,String first,String last, String phoneNumber, String addr, List<String> pos ){
		Class<RegisteredUser> userClass = null;
		try {
		userClass = (Class<RegisteredUser>) Class.forName(typeofUser);
		} catch (ClassNotFoundException e) {
			System.out.println("sorry this is not a sport we support");
		}
		RegisteredUser user=null;
		System.out.println("was able to recognize sport");
		
		try {
			user= (RegisteredUser) userClass.newInstance();
			System.out.println("creating new instance");
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = getEmail();
		user.setBasicInfo(first, last, email,phoneNumber, addr,pos);
		user.putRegisteredUserData();
	}
	public static void registerTeam(){
	//need to do it
	}
	public static String getEmail(){
//		  UserService userService = UserServiceFactory.getUserService();
//	        User user = userService.getCurrentUser();
//	        if (user != null) {
//	            System.out.println("Hello, " + user.getNickname());
//	        } else {
//	        	System.out.println("wow no email");
//	        }
	        //return user.getEmail();
			return "test@example.com";
	    }
	
}

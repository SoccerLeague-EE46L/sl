package soccerLeague;

import java.util.ArrayList;

//public class Registration {
//	public static makePlayer(){
//		Class<RegisteredUser> userClass = null;
//		try {
//			System.out.println(req.getParameter("sport"));
//		userClass = (Class<RegisteredUser>) Class.forName(req.getParameter("sport"));
//		System.out.println("it recognized the sport correctly from request");
//		} catch (ClassNotFoundException e) {
//			System.out.println("sorry this is not a sport we support");
//		}
//		RegisteredUser user=null;
//		System.out.println("was able to recognize sport");
//		
//		try {
//			user= userClass.newInstance();
//			System.out.println("creating new instance");
//		} catch (InstantiationException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String email = getEmail();
//        ArrayList needsToBeREmoved= new ArrayList();
//		user.setBasicInfo(req.getParameter("first_name"),req.getParameter("last_name"),email,req.getParameter("address"),req.getParameter("phone_number"),needsToBeREmoved);
//		System.out.println(req.getParameter("first_name")+req.getParameter("last_name")+email+req.getParameter("address")+req.getParameter("phone_number")+needsToBeREmoved);
//		user.putRegisteredUserData();
//	}
//
//}

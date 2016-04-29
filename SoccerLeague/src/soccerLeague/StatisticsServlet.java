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

public class StatisticsServlet extends HttpServlet{
	DataTransfer myData = DataTransfer.getDataTransfer();
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException{
		
	 }
}

package soccerLeague;


import com.google.appengine.api.datastore.DatastoreService;

import com.google.appengine.api.datastore.DatastoreServiceFactory;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import com.google.appengine.api.users.User;

import com.google.appengine.api.users.UserService;

import com.google.appengine.api.users.UserServiceFactory;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.LoadResult;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;

public class DataTransfer {
	
	//DatastoreService datastore= DatastoreServiceFactory.getDatastoreService();
	private static DataTransfer myDataBase= new DataTransfer();
	private DataTransfer(){
	}
	public static DataTransfer getDataTransfer(){
		return myDataBase;
	}
	
	public void putRegisteredUserData(RegisteredUser x){
		ofy().save().entity(x).now();
		
	}
	public void updateRegisteredUserName(RegisteredUser x, String update){
		x.setFirstName(update);
		ofy().save().entity(x).now();	
	}
	public RegisteredUser getRegisteredUserData(String email){
		RegisteredUser bar=ofy().load().type(RegisteredUser.class).id(email).now();
		return bar;
	}
	public void putSoccerPlayerData(SoccerPlayer x){
		System.out.println("about to safe");
		ofy().save().entity(x).now();
		System.out.println("heres the problem");
	}
	public void updateSoccerPlayerName(SoccerPlayer x, String update){
		x.setFirstName(update);
		ofy().save().entity(x).now();	
	}
	public SoccerPlayer getSoccerPlayerData(String email){
		SoccerPlayer bar=ofy().load().type(SoccerPlayer.class).id(email).now();
		return bar;
	}

}

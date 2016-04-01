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
		Ref<RegisteredUser> foo=ofy().load().type(RegisteredUser.class).id(x.getEmail());
		RegisteredUser bar=foo.getValue();
		bar.setFirstName(update);
		ofy().save().entity(bar).now();	
	}
	public RegisteredUser getRegisteredUserData(String email){
		Ref<RegisteredUser> foo=ofy().load().type(RegisteredUser.class).id(email);
		RegisteredUser bar=foo.getValue();
		return bar;

	}

}

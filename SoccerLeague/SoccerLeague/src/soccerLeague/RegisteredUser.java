package soccerLeague;


import com.google.appengine.api.users.User;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;

import com.googlecode.objectify.annotation.Id;

@Entity
public class RegisteredUser {
	static {
        ObjectifyService.register(SoccerPlayer.class);
        ObjectifyService.register(SoccerPosition.class);
        ObjectifyService.register(PersonalSoccerStats.class);

    }
	private String firstName;
	private String lastName;
	@Id private String email;
	private String phoneNumber;
	private String address;
	//needed for objectify//
	private RegisteredUser(){}
	RegisteredUser(String v,String w, String x, String y, String z){
		firstName=v;
		lastName=w;
		email=x;
		phoneNumber=y;
		address=z;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String  phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}

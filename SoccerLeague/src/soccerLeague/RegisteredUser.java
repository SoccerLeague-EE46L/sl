package soccerLeague;


import com.google.appengine.api.users.User;

import com.googlecode.objectify.annotation.Entity;

import com.googlecode.objectify.annotation.Id;

@Entity
public class RegisteredUser {
	private String firstName;
	private String lastName;
	@Id private String email;
	private String phoneNumber;
	//needed for objectify//
	private RegisteredUser(){}
	RegisteredUser(String w, String x, String y, String z){
		firstName=w;
		lastName=x;
		email=y;
		phoneNumber=z;
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

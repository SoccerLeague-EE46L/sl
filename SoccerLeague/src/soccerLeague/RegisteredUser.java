package soccerLeague;


import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;

import com.googlecode.objectify.annotation.Id;

@Entity
public abstract class RegisteredUser {
	static{
        ObjectifyService.register(RegisteredUser.class); 
	}
	private String firstName;
	private String lastName;
	@Id private String email;
	private String phoneNumber;
	private String address;
	//needed for objectify//
	protected RegisteredUser(){}
	public RegisteredUser(String v,String w, String x, String y, String z){
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
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String addr) {
		this.address=addr;	
	}
	public void setBasicInfo(String first, String last, String email, String phoneNumber, String addr,List<String>pos) {
		this.setFirstName(first);
		this.setLastName(last);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setAddress(addr);	
		this.setPosition(pos);
		this.setStats();
	}
	public abstract void setPosition(List<String> pos);
	public abstract void setStats();

	public void putRegisteredUserData(){
		DataTransfer myData= DataTransfer.getDataTransfer();
		myData.putRegisteredUserData(this);
	}
	public void updateRegisteredUserName(String update){
		DataTransfer myData= DataTransfer.getDataTransfer();
		myData.updateRegisteredUserName(this, update);
	}
	public RegisteredUser getRegisteredUserData(String email){
		DataTransfer myData= DataTransfer.getDataTransfer();
		return myData.getRegisteredUserData(email);
	}
	public void makeTeam(String teamName){}

}

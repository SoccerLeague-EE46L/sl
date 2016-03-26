package soccerLeague;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisteredUser extends HttpServlet {
	private int height,age;
	private String address,name,phoneNumber, email;
	private boolean coach;
	public void dummy(){
		JSONObject x= new JSONObject();
		System.out.println(x.names());
	}
	
	RegisteredUser(int a, int h, String address, String name,String ph,String e){	
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setAddres(String a) {
		address=a;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAge(int a) {
		age=a;
	}
	public void setHeight(int h) {
		height=h;
	}
	public void setPhoneNumber(String ph) {
		phoneNumber=ph;	
	}
	public void setEmail(String e) {
		email=e;
	}
	
}

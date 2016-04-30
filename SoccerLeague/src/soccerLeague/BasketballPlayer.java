package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Subclass;
@Subclass
public class BasketballPlayer extends RegisteredUser{
	static{
		ObjectifyService.register(BasketballPlayer.class); 
	}
	//	private SoccerPosition position;
		private Integer jerseyNumber;
	//	@Container private SoccerTeam team;
	//	private PersonalSoccerStats myStats;
		private boolean isCoach;
		public BasketballPlayer(){
			System.out.println("in basketball player constructor");
					
		}

	@Override
	public void setPosition(List<String> pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStats() {
		// TODO Auto-generated method stub
		
	}
	public void putRegisteredUserData(){
		DataTransfer myData= DataTransfer.getDataTransfer();
		myData.putBasketballPlayer(this);
	}

	@Override
	public String[] getSportPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeTeam(String teamName) {
		// TODO Auto-generated method stub
		
	}

}

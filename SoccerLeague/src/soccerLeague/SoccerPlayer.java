package soccerLeague;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import javax.persistence.Embedded;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class SoccerPlayer extends RegisteredUser{
	static {
        ObjectifyService.register(SoccerPlayer.class); 
    }
	private SoccerPosition position;
	private Integer jerseyNumber;
//	private Team team;
	private PersonalSoccerStats myStats;
	public SoccerPlayer(){
		super(null,null,null,null,null);
};

	public List<String> getPositionsPlayed() {
		return position.getPositionsPlayed();
	}
	public void setPosition(SoccerPosition position) {
		this.position = position;
	}
	public Integer getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(Integer jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
//	public Team getTeam() {
//		return team;
//	}
//	public void setTeam(Team team) {
//		this.team = team;
//	}
	public PersonalStats getMyStats(){
		return myStats;
	}
	//may not need this one//
	public void setMyStats(PersonalSoccerStats myStats) {
		this.myStats = myStats;
	}
	public void updateStats(PersonalSoccerStats tempStats){
		this.myStats.setGoals(tempStats.getGoals());
		this.myStats.setAssists(tempStats.getAssists());
		this.myStats.setRedCards(tempStats.getRedCards());
		this.myStats.setYellowCards(tempStats.getYellowCards());
		this.myStats.setCleanSheets(tempStats.getCleanSheets());
		this.myStats.setGamesPlayed(tempStats.getGamesPlayed());
	}
	public void setPosition(List<String> pos) {
		position= new SoccerPosition(pos);
		System.out.println("it created a position");
	}
	public void setStats(){
		myStats= new PersonalSoccerStats();
	}
	public void putRegisteredUserData(){
		DataTransfer myData= DataTransfer.getDataTransfer();
		myData.putSoccerPlayerData(this);
	}
	public void updateRegisteredUserName(String update){
		DataTransfer myData= DataTransfer.getDataTransfer();
		myData.updateSoccerPlayerName(this, update);
	}
	public SoccerPlayer getRegisteredUserData(String email){
		DataTransfer myData= DataTransfer.getDataTransfer();
		return myData.getSoccerPlayerData(email);
	}

	

}

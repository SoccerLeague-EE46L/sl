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
	private SoccerPlayer(){
		super(null,null,null,null,null);
};
	public SoccerPlayer(String first, String last, String email, String phone, String addr,List<String> pos) {
		super(first,last,email,phone,addr);
		System.out.println("ok its good so far");
		System.out.println(pos.get(0));
		System.out.println(email);
		position= new SoccerPosition(pos,email);
		System.out.println("it created a position");
		myStats= new PersonalSoccerStats(email);
		System.out.println("it created stats");
	}
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
	public void putRegisteredUserData(){
		System.out.println("about to safe");
		System.out.println("were in soccerPlayer class");
		ofy().save().entity(this).now();
		System.out.println("heres the problem");
	}
	public void updateRegisteredUserName(String update){
		this.setFirstName(update);
		ofy().save().entity(this).now();	
	}
	public SoccerPlayer getSoccerPlayerData(String email){
		SoccerPlayer bar=ofy().load().type(SoccerPlayer.class).id(email).now();
		return bar;
	}

}

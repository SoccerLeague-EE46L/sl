package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class SoccerPlayer extends RegisteredUser{
	static {
        ObjectifyService.register(SoccerPlayer.class);
        ObjectifyService.register(SoccerPosition.class);
        ObjectifyService.register(PersonalSoccerStats.class);

        
    }
	private SoccerPosition position;
	private Integer jerseyNumber;
//	private Team team;
	private PersonalSoccerStats myStats;
	private SoccerPlayer(){
		super(null,null,null,null,null);
};
	SoccerPlayer(String first, String last, String email, String phone, String addr,List<String> pos) {
		super(first,last,email,phone,addr);
		position= new SoccerPosition(pos,email);
		myStats= new PersonalSoccerStats(email);
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

}

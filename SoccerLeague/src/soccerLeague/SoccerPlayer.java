package soccerLeague;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import javax.persistence.Embedded;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Stringify;
import com.googlecode.objectify.annotation.Subclass;

@Entity
public class SoccerPlayer extends RegisteredUser{   
	static {
        ObjectifyService.register(SoccerPlayer.class); 
    }
	private static DataTransfer myData= DataTransfer.getDataTransfer();
	private SoccerPosition position;
	private Integer jerseyNumber;
	private String team;
	private PersonalSoccerStats myStats;
	private boolean isCoach;
	public SoccerPlayer(){
		setCoach(false);
		team="not a team";
	}
	public boolean isCoach() {
		return isCoach;
	}
	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
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
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public PersonalSoccerStats getMyStats(){
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
		myData.putSoccerPlayerData(this);
	}
	public void updateRegisteredUserName(String update){
		myData.updateSoccerPlayerName(this, update);
	}
	public SoccerPlayer getRegisteredUserData(String email){
		return myData.getSoccerPlayerData(email);
	}
	/////////////////////////////
	public void makeTeam(String name){
		if(this.getTeam()!=null){
			leaveTeam();
		}
		SoccerTeam newTeam=new SoccerTeam( this,name);
		this.setCoach(true);
		this.team=newTeam.getTeamName();
		System.out.println("testing print statement: checking to see if it puts team on database");
		myData.putSoccerTeam(newTeam);
		System.out.println("testing print statement: successfully puts team on database");	
	}
	public void leaveTeam(){
		if(this.getTeam()==null){return;}
		SoccerTeam team=myData.getSoccerTeam(this.team);
		team.removePlayer(this.getEmail());
	}
	//need a way to remove a teammate but only if you are the coach
	public void removeTeamMate(){}
	public void lookForTeam(){}


	

}
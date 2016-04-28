package soccerLeague;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;
@Entity
//classes that implement an interface are saved as entities
public class SoccerTeam {
	static {
        ObjectifyService.register(SoccerTeam.class); 
    }
	@Id protected String teamName;
	private static DataTransfer myDataBase = DataTransfer.getDataTransfer();
	private SoccerPlayer Coach;
	private int NumOfPlayers;
	private List<SoccerPlayer> Roster= new ArrayList<SoccerPlayer>();
	private  int NumMidFielder=0;
	private int NumDefender=0;
	private int NumAttacker=0;
	private int NumGoalie=0;
	private SoccerTeamStats teamStats;
	private SoccerTeam(){}
	public SoccerTeam(SoccerPlayer  Coach, String teamName){
		if(teamName.equals("not a team")){
			teamName="abcd";
		}
		else{
			this.teamName=teamName;
			this.Coach = Coach;
			System.out.println("inside soccerteam constructor");
			if(this.Coach.getPositionsPlayed()!=null)
			{
				NumOfPlayers++;
				System.out.println("is getting the positions a problem");
				List<String> coachPosition = Coach.getPositionsPlayed();
				System.out.println("gettimg positions is not a problem");
				for(int i = 0; i<coachPosition.size();i++ )
				{
					if(coachPosition.get(i).equals("MidFielder"))
						NumMidFielder++;
					if(coachPosition.get(i).equals("Attacker"))
						NumAttacker++;
					if(coachPosition.get(i).equals("Defender"))
						NumDefender++;
					if(coachPosition.get(i).equals("Goalie"))
						NumGoalie++;
				}
				Roster.add(Coach);
			}
		}
		System.out.println("made it to the end ");
	}
	//should we have this??? using teamname as ID so maybe dont want to change name
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getWins(){
		return teamStats.getWins();
	}
	public String getTeamName() {
		return teamName;
	}
	public RegisteredUser getCoach(){
		return Coach;
	}
	public List<SoccerPlayer> getRoster(){
		return Roster;
	}
	public  int getNumOfPlayers(){
		return NumOfPlayers;
	}
	public int getNumMidFielder() {
		return NumMidFielder;
	}
	public int getNumDefender() {
		return NumDefender;
	}
	public int getNumAttacker() {
		return NumAttacker;
	}
	public int getNumGoalie() {
		return NumGoalie;
	}
	public void addPlayer(SoccerPlayer player){
		Roster.add(player);
		NumOfPlayers++;
		incRosterAvailability(player);
	}
	private void incRosterAvailability(SoccerPlayer x){
		List<String> playerPosition = x.getPositionsPlayed();
		for(int i = 0; i<playerPosition.size();i++ )
		{
			if(playerPosition.get(i).equals("MidFielder"))
				NumMidFielder++;
			if(playerPosition.get(i).equals("Attacker"))
				NumAttacker++;
			if(playerPosition.get(i).equals("Defender"))
				NumDefender++;
			if(playerPosition.get(i).equals("Goalie"))
				NumGoalie++;
		}
	}
	private void decRosterAvailability(SoccerPlayer x){
		List<String> playerPosition = x.getPositionsPlayed();
		for(int i = 0; i<playerPosition.size();i++ )
		{
			if(playerPosition.get(i).equals("MidFielder"))
				NumMidFielder--;
			if(playerPosition.get(i).equals("Attacker"))
				NumAttacker--;
			if(playerPosition.get(i).equals("Defender"))
				NumDefender--;
			if(playerPosition.get(i).equals("Goalie"))
				NumGoalie--;
		}
	}

	public void removePlayer(String email) {
		SoccerPlayer player=myDataBase.getSoccerPlayerData(email);
		if(getCoach().getEmail().equals(email)){
			this.removeCoach(email);
		}
		decRosterAvailability(player);
		this.NumOfPlayers--;
		Roster.remove(player);
	
	}
	public void removeCoach(String email) {
		SoccerPlayer player=myDataBase.getSoccerPlayerData(email);
		player.setCoach(false);
		this.Coach=null;
		
	}
}



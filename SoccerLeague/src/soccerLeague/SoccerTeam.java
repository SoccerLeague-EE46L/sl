package soccerLeague;
import java.util.ArrayList;
import java.util.Arrays;
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
	private String Coach;
	private String[][] schedule = new String[12][31];
	private List<String> testSched = new ArrayList<String>(); 
	private int NumOfPlayers;
	private List<String> Roster= new ArrayList<String>();
	private  int NumMidFielder=0;
	private int NumDefender=0;
	private int NumAttacker=0;
	private int NumGoalie=0;
	private SoccerTeamStats teamStats;
	private List<String> posNeeded;
	private boolean needsPlayer;

	private SoccerTeam(){}
	public SoccerTeam(SoccerPlayer  coach, String teamName){
		for(int i = 0; i<12;i++)
		{
			testSched.add("game");
		}
		this.teamStats= new SoccerTeamStats();
		this.teamName=teamName;
		this.Coach = coach.getEmail();
		this.needsPlayer=false;
		System.out.println("team should have zero players");
		if(coach.getPosition().getPositionsPlayed()!=null)
		{
			NumOfPlayers++;
			System.out.println(NumOfPlayers);
			List<String> coachPosition = coach.getPosition().getPositionsPlayed();
			System.out.println("gettimg positions is not a problem");
			for(int i = 0; i<coachPosition.size();i++ )
			{
				if(coachPosition.get(i).equals("midFielder"))
					NumMidFielder++;
				if(coachPosition.get(i).equals("attacker"))
					NumAttacker++;
				if(coachPosition.get(i).equals("defender"))
					NumDefender++;
				if(coachPosition.get(i).equals("goalie"))
					NumGoalie++;
			}
			Roster.add(Coach);
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
	public String getCoach(){
		return Coach;
	}
	public List<String> getRoster(){
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
	public void addPlayer(List<String> players, String user){
		System.out.println("am i going to return??");
		System.out.println(user);
		if(!user.equals(this.Coach)){return;}
		System.out.println("no im not ");
		for(int i=0;i<players.size();i++){
		if(!Roster.contains(players.get(i))){
		Roster.add(players.get(i));
		SoccerPlayer player= myDataBase.getSoccerPlayerData(players.get(i));
		player.setNeedsTeam(false);
		player.setTeam(this.teamName);
		myDataBase.putRegisteredUserData(player);
		NumOfPlayers++;
		incRosterAvailability(players.get(i));
		}
		}

	}
	public String[][] getSchedule(){
		return schedule;

	}
	public List<String> getTestSched(){
		return testSched;
	}
	private void incRosterAvailability(String x){
		List<String> playerPosition = myDataBase.getSoccerPlayerData(x).getPosition().getPositionsPlayed();
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
	private void decRosterAvailability(String x){
		List<String> playerPosition = myDataBase.getSoccerPlayerData(x).getPosition().getPositionsPlayed();
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
		if(this.Coach.equals(email)){
			this.removeCoach(email);
		}
		if(Roster.remove(email)){
		decRosterAvailability(email);
		this.NumOfPlayers--;
		}
		
	}
	public void removeCoach(String email) {
		SoccerPlayer player=myDataBase.getSoccerPlayerData(email);
		player.setCoach(false);
		this.Coach=null;
		player.putRegisteredUserData();
		
	}
	public void addWin(){
		teamStats.setWins(1);
	}
	public void addLoss(){
		teamStats.setLosses(1);
	}
	public int getLosses(){
		return teamStats.getLosses();
	}
	public List<String> getPosNeeded() {
		return posNeeded;
	}
	public void setPosNeeded(List<String> posNeeded) {
		this.posNeeded = posNeeded;
	}
	public boolean needsPlayers(){
		return needsPlayer;
	}
	public void setNeedsPlayers(boolean flag){
		this.needsPlayer=flag;
	}
	public void setSchedule(String month, int day, String time){
		int monthint;
		switch (month) {
        case "January":  monthint = 0;
                 break;
        case "February":  monthint = 1;
                 break;
        case "March":  monthint = 2;
                 break;
        case "April":  monthint = 3;
                 break;
        case "May":  monthint = 4;
                 break;
        case "June":  monthint = 5;
                 break;
        case "July":  monthint = 6;
                 break;
        case "August":  monthint = 7;
                 break;
        case "September":  monthint = 8;
                 break;
        case "October":  monthint = 9;
                 break;
        case "November":  monthint = 10;
                 break;
        case "December":  monthint = 11;
                 break;
        default: monthint = 12;
                 break;
    }
		schedule[monthint][day] = time;
		schedule[monthint][day].concat("game at:");
	}
	public String getHighestGoalScorer(){
		
		String curHighestEmail = Roster.get(0);
		DataTransfer myDataBase= DataTransfer.getDataTransfer();
	    SoccerPlayer curHighestPlayer=myDataBase.getSoccerPlayerData(curHighestEmail);
		
		for(int i=1; i<Roster.size(); i++){
			String nextUser = Roster.get(i);
			SoccerPlayer nextPlayer = myDataBase.getSoccerPlayerData(nextUser);
			
			if(nextPlayer.getMyStats().getGoals() > curHighestPlayer.getMyStats().getGoals()){
				curHighestEmail = nextUser;
				curHighestPlayer=nextPlayer;
			}
			
		}
		
		return curHighestEmail;
		
	}
	
public SoccerTeamStats getTeamStats() {
		return teamStats;
	}
	public void setTeamStats(SoccerTeamStats teamStats) {
		this.teamStats = teamStats;
	}
public String getHighestAssistScorer(){
		
		String curHighestEmail = Roster.get(0);
		DataTransfer myDataBase= DataTransfer.getDataTransfer();
	    SoccerPlayer curHighestPlayer=myDataBase.getSoccerPlayerData(curHighestEmail);
		
		for(int i=1; i<Roster.size(); i++){
			String nextUser = Roster.get(i);
			SoccerPlayer nextPlayer = myDataBase.getSoccerPlayerData(nextUser);
			
			if(nextPlayer.getMyStats().getAssists() > curHighestPlayer.getMyStats().getAssists()){
				curHighestEmail = nextUser;
				curHighestPlayer=nextPlayer;
			}
			
		}
		
		
		return curHighestEmail;
		
		
	}
}



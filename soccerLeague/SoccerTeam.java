package soccerLeague;
import java.util.List;
public class SoccerTeam implements Team{
private SoccerPlayer Coach;
private int NumOfPlayers;
private List<SoccerPlayer> Roster;
private  int NumMidFielder=0;
private int NumDefender=0;
private int NumAttacker=0;
private int NumGoalie=0;
public SoccerTeam(SoccerPlayer  Coach){
	this.Coach = Coach;
	if(this.Coach.getPositionsPlayed()!=null)
	{
		NumOfPlayers++;
		List<String> coachPosition = Coach.getPositionsPlayed();
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
	}
	Roster.add(Coach);
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
public void addPlayer(SoccerPlayer player){
	Roster.add(player);
	NumOfPlayers++;
	List<String> playerPosition = player.getPositionsPlayed();
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
}



package soccerLeague;

import java.util.ArrayList;
import java.util.List;

public class SoccerLeague implements League {
	
private List<SoccerTeam> Teams;

public SoccerLeague(){
	
}
public List<SoccerTeam> getSoccerTeams(){
	return Teams;
}



public void  addTeam(SoccerTeam soccerteam){
	Teams.add(soccerteam);
}

public List<SoccerPlayer> getTopStats(){
	int topgoals = 0;
	int topsaves = 0;
	int topfouls = 0;
	int toptackles = 0;
	int topassists = 0;
	int topgamesPlayed = 0;
	ArrayList<SoccerPlayer> topPlayers = new ArrayList<SoccerPlayer>();
	
	for(int i = 0; i < Teams.size(); i++)
	{
		for(int j = 0; j< Teams.get(i).getRoster().size();j++)
		{
			if(Teams.get(i).getRoster().get(j).getMyStats().getAssists() > topassists)
			{
				topassists = Teams.get(i).getRoster().get(j).getMyStats().getAssists();
				 topPlayers.add( Teams.get(i).getRoster().get(j));
				
			}
			if(Teams.get(i).getRoster().get(j).getMyStats().getGoals()> topgoals)
			{
				topgoals = Teams.get(i).getRoster().get(j).getMyStats().getGoals();
				topPlayers.add( Teams.get(i).getRoster().get(j));
			}
			if(Teams.get(i).getRoster().get(j).getMyStats().getYellowCards() > topfouls)
			{
				topfouls = Teams.get(i).getRoster().get(j).getMyStats().getYellowCards();
				topPlayers.add( Teams.get(i).getRoster().get(j));
			}
			if(Teams.get(i).getRoster().get(j).getMyStats().getGamesPlayed()> topgamesPlayed)
			{
				topgoals = Teams.get(i).getRoster().get(j).getMyStats().getGoals();
				topPlayers.add( Teams.get(i).getRoster().get(j));
			}
		}
	}
	return topPlayers;
}
public List<SoccerTeam> getStandings(){
	int j = -1;
	ArrayList<SoccerTeam> Standings = new ArrayList<SoccerTeam>();
	while(Standings.size() < Teams.size()){
	for(int i =0; i < Teams.size();i++)
	{
		if(Standings.isEmpty())
		{
			Standings.add(Teams.get(i));
			j++;
		}
		else if(Teams.get(i).getWins()> Standings.get(j).getWins() )
		{
			Standings.remove(j);
			Standings.add(Teams.get(i));
		}
		else
		{
			Standings.add(Teams.get(i));
			j++;
		}
	}
	}
	return Standings;
}
}


package soccerLeague;

import java.util.ArrayList;
import java.util.List;

public class SoccerTeamStats implements TeamStats {
	
private int Wins;
private int Losses;

	@Override
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> Stats = new ArrayList<Integer>();
		Stats.add(Wins);
		Stats.add(Losses);
		return Stats;
	}

}

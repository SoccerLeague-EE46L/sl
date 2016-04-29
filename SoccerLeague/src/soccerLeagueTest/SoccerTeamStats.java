package soccerLeagueTest;

import java.util.ArrayList;
import java.util.List;

import soccerLeague.TeamStats;

public class SoccerTeamStats implements TeamStats {
	
private int wins;
private int losses;

	@Override
	public Integer getLosses() {
		return losses;
	}

	public void setWins(int wins) {
		this.wins = this.wins + wins;
	}

	public void setLosses(int losses) {
		this.losses = this.losses + losses ;
	}

	@Override
	public Integer getWins() {
		return wins;
	}

}

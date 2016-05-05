package soccerLeague;

import java.util.ArrayList;
import java.util.List;

public class SoccerTeamStats implements TeamStats {

private int wins;
private int losses;
private int ties;
private int points;
private int leagueRank;
private int gamesPlayed;
private int goalsScored;
private int goalsReceived;
private int goalDifference;
public int getTies() {
	return ties;
}

public void setTies(int ties) {
	this.ties += ties;
}

public int getPoints() {
	return points;
}

public void setPoints(int points) {
	this.points += points;
}

public int getLeagueRank() {
	return leagueRank;
}

public void setLeagueRank(int leagueRank) {
	this.leagueRank += leagueRank;
}

public int getGamesPlayed() {
	return gamesPlayed;
}

public void setGamesPlayed(int gamesPlayed) {
	this.gamesPlayed += gamesPlayed;
}

public int getGoalsScored() {
	return goalsScored;
}

public void setGoalsScored(int goalsScored) {
	this.goalsScored += goalsScored;
}

public int getGoalsReceived() {
	return goalsReceived;
}

public void setGoalsReceived(int goalsReceived) {
	this.goalsReceived += goalsReceived;
}

public int getGoalDifference() {
	return goalDifference;
}

public void setGoalDifference(int goalDifference) {
	this.goalDifference += goalDifference;
}





	@Override
	public Integer getLosses() {
		return losses;
	}

	public void setWins(int wins) {
		this.wins += wins;
	}

	public void setLosses(int losses) {
		this.losses += losses;
	}

	@Override
	public Integer getWins() {
		return wins;
	}

}

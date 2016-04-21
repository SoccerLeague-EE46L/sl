package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

public class PersonalSoccerStats implements PersonalStats{
	private Integer gamesPlayed;
	private Integer assists;
	private Integer goals;
	private Integer redCards;
	private Integer yellowCards;
	private Integer cleanSheets;
	public PersonalSoccerStats(){
	}
	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = this.assists+ assists;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = this.goals+ goals;
	}

	public Integer getRedCards() {
		return redCards;
	}

	public void setRedCards(Integer redCards) {
		this.redCards = this.redCards+ redCards;
	}

	public Integer getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(Integer yellowCards) {
		this.yellowCards = this.yellowCards+yellowCards;
	}
	public Integer getCleanSheets() {
		return cleanSheets;
	}
	public void setCleanSheets(Integer cleanSheets) {
		this.cleanSheets = cleanSheets;
	}
	public void setGamesPlayed(Integer games) {
		this.gamesPlayed= this.gamesPlayed+games;
		
	}


}

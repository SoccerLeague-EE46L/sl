package soccerLeague;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


public abstract class Team {
	public abstract RegisteredUser getCoach();
	public abstract String getTeamName();
	public abstract void removePlayer(String email);
	public abstract void removeCoach(String email);

}


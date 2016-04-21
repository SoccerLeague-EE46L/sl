package soccerLeague;

public interface Team {
public RegisteredUser getCoach();
public String getTeamName();
public void removePlayer(String email);
public void removeCoach(String email);

}
 	

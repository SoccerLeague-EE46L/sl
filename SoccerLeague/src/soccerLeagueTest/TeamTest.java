package soccerLeagueTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import soccerLeague.SoccerPlayer;
import soccerLeague.SoccerTeam;

public class TeamTest {
	SoccerPlayer testPlayer = new SoccerPlayer();
	@Test
	public void testGetWins() {
		
		SoccerTeam testTeam = new SoccerTeam(testPlayer, "team");
		testTeam.addWin();
		assertTrue(testTeam.getWins() == 1);
		testTeam.addLoss();
		assertTrue(testTeam.getLosses() == 1);
	}

	@Test
	public void testGetTeamName() {
		SoccerTeam testTeam = new SoccerTeam(testPlayer, "Team");
		assertTrue(testTeam.getTeamName().equals("Team"));
		testTeam.setTeamName("Team2");
		assertTrue(testTeam.getTeamName().equals("Team2"));
		
	}

	@Test
	public void testGetCoach() {
		SoccerTeam testTeam = new SoccerTeam(testPlayer,"team");
		assertTrue(testTeam.getCoach().equals(testPlayer.getEmail()));
		
		
	}







}

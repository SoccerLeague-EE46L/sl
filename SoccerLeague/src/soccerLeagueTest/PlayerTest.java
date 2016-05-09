package soccerLeagueTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import soccerLeague.DataTransfer;
import soccerLeague.PersonalSoccerStats;
import soccerLeague.SoccerPlayer;
import soccerLeague.SoccerPosition;

public class PlayerTest {
	private static DataTransfer myData = DataTransfer.getDataTransfer();
	@Test
	public void testIsCoach() {
		SoccerPlayer testPlayer = new SoccerPlayer();
		assertEquals(testPlayer.isCoach(), false);
		testPlayer.setCoach(true);
		assertEquals(testPlayer.isCoach(), true);
		
	}


	@Test
	public void testGetJerseyNumber() {
		SoccerPlayer testPlayer = new SoccerPlayer();
		testPlayer.setJerseyNumber(11);
		assertEquals((Integer)11, testPlayer.getJerseyNumber());
	}


	@Test
	public void testGetTeam() {
		SoccerPlayer testPlayer = new SoccerPlayer();
		testPlayer.setTeam("WildCats! Get your Head in the Game");
		assertEquals("WildCats! Get your Head in the Game",testPlayer.getTeam());
	}


	@Test
	public void testGetMyStats() {
		PersonalSoccerStats myStats = new PersonalSoccerStats();
		myStats.setAssists(10);
		myStats.setCleanSheets(1);
		myStats.setGamesPlayed(4);
		myStats.setGoals(300);
		SoccerPlayer testPlayer = new SoccerPlayer();
		testPlayer.setMyStats(myStats);
		assertEquals(testPlayer.getMyStats(), myStats);
	}




	@Test
	public void testLeaveTeam() {
		SoccerPlayer testPlayer = new SoccerPlayer();
		testPlayer.setTeam("My Team");
		String team = testPlayer.getTeam();
		testPlayer.leaveTeam();
		assertFalse(team.equals(testPlayer.getTeam()));
	}





}

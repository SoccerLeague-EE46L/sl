package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;


public class SoccerPosition implements Position {
	private List<String> positionsPlayed;
	private SoccerPosition(){}
	public SoccerPosition(List<String> pos){
		System.out.println("constructor about to run");
		positionsPlayed=pos;
		//dummyID=email+"b";
		System.out.println("it made it to the end");
	}
	public List<String> getPositionsPlayed(){
		return positionsPlayed;
	}
}

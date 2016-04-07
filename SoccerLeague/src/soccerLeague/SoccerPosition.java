package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class SoccerPosition implements Position {
//	static {
//        ObjectifyService.register(SoccerPosition.class); 
//    }
	private List<String> positionsPlayed;
	//@Id private String dummyID;
	//private SoccerPosition(){}
	public SoccerPosition(List<String> pos,String email){
		System.out.println("constructor about to run");
		positionsPlayed=pos;
		//dummyID=email+"b";
		System.out.println("it made it to the end");
	}
	public List<String> getPositionsPlayed(){
		return positionsPlayed;
	}
}

package soccerLeague;

import java.util.List;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class SoccerPosition implements Position {
	static {
        ObjectifyService.register(SoccerPlayer.class);
        ObjectifyService.register(SoccerPosition.class);
        ObjectifyService.register(PersonalSoccerStats.class);
 
    }
	private List<String> positionsPlayed;
	@Id private String dummyID;
	private SoccerPosition(){}
	public SoccerPosition(List<String> pos,String email){
		positionsPlayed=pos;
		dummyID=email;
		
	}
	public List<String> getPositionsPlayed(){
		return positionsPlayed;
	}
}

package soccerLeague;

public class SoccerPlayer extends RegisteredUser{
	Position position;
	Integer jerseyNumber;
	SoccerPlayer(String first, String last, String email, String phone,Integer number,String pos) {
		super(first,last,email,phone);
		if(pos.equals("goalie")){
			position= new GoaliePosition(pos);
		}
		else{
			position= new FieldPosition(pos);
		}
	}

}

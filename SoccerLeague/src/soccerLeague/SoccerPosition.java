package soccerLeague;

public class SoccerPosition implements Position {
	private String positionPlayed;
	public SoccerPosition(String pos){
		positionPlayed=pos;
	}
	public String getPositionPlayed(){
		return positionPlayed;
	}
	
	
	@Override
	public void getStats() {
		// TODO Auto-generated method stub
		
	}

}

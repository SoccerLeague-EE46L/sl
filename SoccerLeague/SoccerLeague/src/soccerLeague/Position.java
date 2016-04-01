package soccerLeague;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
@Entity 
public interface Position {
	public List<String> getPositionsPlayed();
}

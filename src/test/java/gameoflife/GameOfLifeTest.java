package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.*;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void singleLivePositionDies() {
		List<Position> livePositionsT0 = list(new Position(10, 10));
		
		List<Position> livePositionsT1 = transition(livePositionsT0);
		
		assertThat(livePositionsT1, is(Collections.<Position>emptyList()));
 	}

	@Test
	public void threeCornerNeighbours() {
		List<Position> livePositionsT0 = list(
				new Position(10, 9), 	new Position(11, 9), 
				new Position(11, 10) );
		
		List<Position> livePositionsT1 = transition(livePositionsT0);
		
		assertThat(livePositionsT1, is(list(new Position(10, 10))));
	}

	@Test
	public void threeStraightLineNeighbours() {
		List<Position> livePositionsT0 = list(
				new Position(9, 10), new Position(10, 10), new Position(11, 10) );
		
		List<Position> livePositionsT1 = transition(livePositionsT0);
		
		assertThat(livePositionsT1, is(list(new Position(10, 9), new Position(10, 11))));
	}

	private List<Position> list(Position... positions) {
		return Arrays.<Position>asList(positions);
	}
	
	private List<Position> transition(List<Position> livePositionsT0) {
		GameOfLife game = new GameOfLife();
		List<Position> livePositionsT1 = game.transition(livePositionsT0);
		return livePositionsT1;
	}
	
}

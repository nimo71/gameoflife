package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LiveNeighbourCounterTest {

	@Test
	public void zeroLiveNeighbours() {
		List<Position> livePositions = new ArrayList<Position>();
		LiveNeighbourCounter counter = new LiveNeighbourCounter(livePositions);
		Position pos = new Position(10, 10);
		
		assertThat(counter.liveNeighbourCount(pos), is(0));
	}

	@Test
	public void oneLiveCornerNeighbour() {
		List<Position> livePositions = Arrays.asList(new Position[] {new Position(9, 9)});
		LiveNeighbourCounter counter = new LiveNeighbourCounter(livePositions);
		Position pos = new Position(10, 10);
		
		assertThat(counter.liveNeighbourCount(pos), is(1));
	}

	@Test
	public void oneLiveNeighbourInY() {
		List<Position> livePositions = Arrays.asList(new Position[] {new Position(10, 9)});
		LiveNeighbourCounter counter = new LiveNeighbourCounter(livePositions);
		Position pos = new Position(10, 10);
		
		assertThat(counter.liveNeighbourCount(pos), is(1));
	}

	@Test
	public void oneLiveNoneNeighbour() {
		List<Position> livePositions = Arrays.asList(new Position[] {new Position(8, 8)});
		LiveNeighbourCounter counter = new LiveNeighbourCounter(livePositions);
		Position pos = new Position(10, 10);
		
		assertThat(counter.liveNeighbourCount(pos), is(0));
	}

	@Test
	public void twoLiveNeighboursInX() {
		List<Position> livePositions = Arrays.asList(new Position[] {new Position(10, 9), new Position(10, 11)});
		LiveNeighbourCounter counter = new LiveNeighbourCounter(livePositions);
		Position pos = new Position(10, 10);
		
		assertThat(counter.liveNeighbourCount(pos), is(2));
	}
	
}

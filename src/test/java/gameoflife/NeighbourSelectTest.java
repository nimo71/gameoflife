package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Set;

import org.junit.Test;

public class NeighbourSelectTest {

	@Test
	public void selectNeighbourPositions() {
		Position pos = new Position(10, 10);
		NeighbourSelect selector = new NeighbourSelect();
		Set<Position> neighbours = selector.neighbours(pos);
		
		Position[] expectedNeighbours = new Position[] { 
				new Position(9, 9), 	new Position(10, 9), 	new Position(11, 9),
			    new Position(9, 10), 							new Position(11, 10), 
			    new Position(9, 11), 	new Position(10, 11), 	new Position(11, 11)
		};
		
		assertThat(neighbours.size(), equalTo(expectedNeighbours.length));
		assertThat(neighbours, hasItems(expectedNeighbours));
	}

}

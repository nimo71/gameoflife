package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CellTest implements Cell.LiveListener {

	private Boolean live;
	
	@Test
	public void cellActivatesLiveListener() {
		Cell cell = new Cell(new Position(0, 0), 0, null);
		cell.addListener(this);
		cell.notifyCellLive();
		
		assertThat(live, is(true));
	}

	@Override
	public void cellLive(Position position) {
		live = true;
	}

}

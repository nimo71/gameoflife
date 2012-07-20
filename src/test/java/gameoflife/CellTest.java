package gameoflife;

import org.junit.Test;

public class CellTest implements Cell.Listener {

	private Boolean live;
	
	@Test
	public void cellActivatesLiveListener() {
		Cell cell = new Cell(null, null);
		cell.addListener(this);
		cell.live();
		
		assertThat(live, is(true));
	}

}

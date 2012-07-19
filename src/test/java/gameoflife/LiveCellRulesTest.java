package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class LiveCellRulesTest {

	@Test
	public void fewerThanTwoLiveNeighboursDies() {
		LiveCellRules liveCellRules = new LiveCellRules();
		Boolean alive = liveCellRules.shouldLive(1);
		assertThat(alive, is(false));
	}

}
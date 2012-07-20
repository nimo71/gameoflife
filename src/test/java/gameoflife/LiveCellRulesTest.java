package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class LiveCellRulesTest {

	private CellRules liveCellRules;

	@Before
	public void beforeEachTest() {
		liveCellRules = new LiveCellRules();
	}

	@Test
	public void fewerThanTwoLiveNeighboursDies() {
		assertThat(liveCellRules.shouldLive(0), is(false));
		assertThat(liveCellRules.shouldLive(1), is(false));
	}

	@Test
	public void twoOrThreeLiveNeighboursLives() {
		assertThat(liveCellRules.shouldLive(2), is(true));
		assertThat(liveCellRules.shouldLive(3), is(true));
	}

	@Test
	public void moreThanThreeLiveNeighboursDies() {
		assertThat(liveCellRules.shouldLive(4), is(false));
		assertThat(liveCellRules.shouldLive(8), is(false));
	}

}
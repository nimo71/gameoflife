package gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class DeadCellRulesTest {

	@Test
	public void cellComesToLifeIfExactlyThreeNeighbours() {
		DeadCellRules deadCellRules = new DeadCellRules();
		assertThat(deadCellRules.shouldLive(-999), is(false));
		assertThat(deadCellRules.shouldLive(2), is(false));
		assertThat(deadCellRules.shouldLive(3), is(true));
		assertThat(deadCellRules.shouldLive(4), is(false));
		assertThat(deadCellRules.shouldLive(999), is(false));
	}

}

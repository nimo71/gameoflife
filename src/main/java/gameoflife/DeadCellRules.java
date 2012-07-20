package gameoflife;

public class DeadCellRules implements CellRules {

	@Override
	public Boolean shouldLive(int neighbourCount) {
		return neighbourCount == 3;
	}

}

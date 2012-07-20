package gameoflife;

public class LiveCellRules implements CellRules {

	@Override
	public Boolean shouldLive(int neigbourCount) {
		if (neigbourCount == 2 || neigbourCount == 3) return true;
		return false;
	}

}

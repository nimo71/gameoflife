package gameoflife;

import java.util.List;

public class LiveCells extends Cells implements CellRules {
	
	public LiveCells(List<Position> positions, Cell.LiveListener listener) {
		super(positions);
		initCells(positions, listener);
	}
	
	@Override
	public Boolean shouldLive(int neigbourCount) {
		if (neigbourCount == 2 || neigbourCount == 3) return true;
		return false;
	}
}

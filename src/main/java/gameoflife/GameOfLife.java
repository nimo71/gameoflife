package gameoflife;

import java.util.*;


public class GameOfLife {

	private final List<Position> livePositions;
	private final CellLiveListener cellListener;

	public GameOfLife(List<Position> livePositions) {
		this.livePositions = Collections.unmodifiableList(livePositions);
		this.cellListener = new CellLiveListener(livePositions);
	}

	public GameOfLife transition() {
		final List<Position> newLivePositions = cellListener.transitionCells();
		return new GameOfLife(newLivePositions);
	}

	public List<Position> getLivePositions() {
		return livePositions;
	}	
	
}

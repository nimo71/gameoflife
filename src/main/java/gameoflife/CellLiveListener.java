package gameoflife;


import java.util.*;

public class CellLiveListener implements Cell.LiveListener {
	private final Cells deadCells;
	private final Cells liveCells;
	private final List<Position> newLivePositions = new ArrayList<Position>();

	public CellLiveListener(List<Position> livePositions) {
		this.liveCells = new LiveCells(livePositions, this);
		this.deadCells = new DeadCells(livePositions, this);
	}

	public List<Position> transitionCells() {
		liveCells.transition();
		deadCells.transition();
		return newLivePositions;
	}
	
	@Override
	public void cellLive(Position position) {
		newLivePositions.add(position);
	}
}
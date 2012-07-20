package gameoflife;

import java.util.List;

public class LiveNeighbourCounter {

	private final List<Position> livePositions;

	public LiveNeighbourCounter(List<Position> livePositions) {
		this.livePositions = livePositions;
	}

	public Integer liveNeighbourCount(Position pos) {
		int count = 0; 
		for (Position livePos : livePositions) {
			if (isNeigbour(pos, livePos)) count++;
		}
		return count;
	}

	private boolean isNeigbour(Position pos1, Position pos2) {
		int dX = Math.abs(pos1.getX() - pos2.getX());
		int dY = Math.abs(pos1.getY() - pos2.getY());

		if (dX > 1) return false;
		if (dY > 1) return false;
		if (dX == 0 && dY == 0) return false;
		return true;
	}

}

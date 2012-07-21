package gameoflife;

import java.util.*;

public class DeadCells extends Cells implements CellRules {
	
	public DeadCells(List<Position> livePositions, Cell.LiveListener listener) {
		super(livePositions);
		List<Position> deadCandidates = findDeadCandiates(livePositions);
		initCells(deadCandidates, listener);
	}

	private List<Position> findDeadCandiates(List<Position> livePositions) {
		Set<Position> candidates = new HashSet<Position>();
		for (Position pos : livePositions) {
			candidates.addAll(neighbours(pos));
		}
		candidates.removeAll(livePositions);
		return new ArrayList<Position>(candidates);
	}
	
	@Override
	public Boolean shouldLive(int neighbourCount) {
		return neighbourCount == 3;
	}

}

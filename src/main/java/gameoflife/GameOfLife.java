package gameoflife;

import java.util.*;


public class GameOfLife {

	public List<Position> transition(List<Position> livePositions) {
		List<Cell> cells = new ArrayList<Cell>();
		Set<Position> deadCandidates = findDeadCandiates(livePositions);	
		
		for (Position live : livePositions) {
			Cell cell = new Cell(live, livePositions);
			cells.add(cell);
			
			cell.addRules(new LiveCellRules());
		}
		
		for (Position dead : deadCandidates) {
			Cell cell = new Cell(dead, livePositions); 
			cells.add(cell);
			
			cell.addRules(new DeadCellRules());
		}
		
		return Collections.<Position>emptyList();
	}

	private Set<Position> findDeadCandiates(List<Position> livePositions) {
		Set<Position> candidates = new HashSet<Position>();
		NeighbourSelect selectNeighbours = new NeighbourSelect();
		for (Position pos : livePositions) {
			candidates.addAll(selectNeighbours.neighbours(pos));
		}
		candidates.removeAll(livePositions);
		return candidates;
	}
	
}

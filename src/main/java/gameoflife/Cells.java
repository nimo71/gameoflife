package gameoflife;

import java.util.*;

public abstract class Cells implements CellRules, LiveNeighbourCounter, NeighbourSelect {

	private final List<Position> livePositions;
	protected final List<Cell> cells = new ArrayList<Cell>();
	
	public Cells(List<Position> livePositions) {
		super();
		this.livePositions = livePositions;
	}
	
	protected void initCells(List<Position> positions, Cell.LiveListener listener) {
		for (Position position : positions) {
			Integer liveNeighbourCount = liveNeighbourCount(position);
			Cell cell = new Cell(position, liveNeighbourCount, this); 
			cell.addListener(listener);
			cells.add(cell);
		}
	}

	public void transition() {
		for (Cell cell : cells) {
			cell.transition();
		}
	}

	@Override
	public abstract Boolean shouldLive(int neigbourCount);
	
	@Override
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
	
	
	@Override
	public Set<Position> neighbours(Position pos) {
		Set<Position> neighbours = new HashSet<Position>();
		
		int minX = pos.getX() - 1;
		int maxX = pos.getX() + 1;
		int minY = pos.getY() - 1;
		int maxY = pos.getY() + 1;
		
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				Position neighbour = new Position(x, y);
				if (neighbour.equals(pos)) continue;
				neighbours.add(neighbour);
			}
		}
		return neighbours;
	}

}

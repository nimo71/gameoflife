package gameoflife;

import java.util.HashSet;
import java.util.Set;

public class NeighbourSelect {

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

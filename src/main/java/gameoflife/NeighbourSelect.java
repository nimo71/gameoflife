package gameoflife;

import java.util.Set;

public interface NeighbourSelect {

	public Set<Position> neighbours(Position pos);
	
}

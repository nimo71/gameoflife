package gameoflife;

public interface CellRules {

	Boolean shouldLive(int neigbourCount);

}
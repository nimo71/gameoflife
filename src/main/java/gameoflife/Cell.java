package gameoflife;


public class Cell {
	private final Position position;
	private final Integer liveNeighbourCount;
	private final CellRules cellRules;

	private LiveListener listener;

	public Cell(Position position, Integer liveNeighbourCount, CellRules cellRules) {
		this.position = position;
		this.liveNeighbourCount = liveNeighbourCount;
		this.cellRules = cellRules;
	}

	public void addListener(LiveListener listener) {
		this.listener = listener;
	}

	public void transition() {
		if (cellRules.shouldLive(liveNeighbourCount)) { 
			notifyCellLive();
		}
	}

	void notifyCellLive() {
		listener.cellLive(this.position);
	}

	public interface LiveListener {
		void cellLive(Position position);
	}

}

package checkers;

public class Piece {
	
	private boolean isPieceRed;
	int X;
	int Y;
	
	public Piece() {
		this.setPieceRed(isPieceRed);
		this.X = X;
		this.Y = Y;
	}

	boolean isPieceRed() {
		return isPieceRed;
	}

	void setPieceRed(boolean isPieceRed) {
		this.isPieceRed = isPieceRed;
	}
	
	
}

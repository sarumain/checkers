package checkers;

public class Piece {
	
	private int pieceType;
	public static final int RED = 1, BLACK = 2;
	private boolean isKing;
	
	public Piece(int pieceType) {
		this.setPieceType(pieceType);
		setKing(false);
	}
	

	int getPieceType() {
		return pieceType;
	}

	void setPieceType(int pieceType) {
		this.pieceType = pieceType;
	}


	public boolean isKing() {
		return isKing;
	}


	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}

}

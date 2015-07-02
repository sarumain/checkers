package checkers;

public class Piece {
	
	private int pieceType;
	public static final int NULL = 0, RED = 1, BLACK = 2, KING = 3;
	
	public Piece(int pieceType) {
		this.setPieceType(pieceType);
	}

	int getPieceType() {
		return pieceType;
	}

	void setPieceType(int pieceType) {
		this.pieceType = pieceType;
	}

}

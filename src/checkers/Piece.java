package checkers;

public class Piece {
	
	private int pieceType; // RED = 0, BLACK = 1, KING = 2;
	
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

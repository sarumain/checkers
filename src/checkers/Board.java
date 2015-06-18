package checkers;

public class Board {
	
	Piece[][] pieces = new Piece[8][8];
	
	Board() {
		specifiyPieces();
	}
	
	public void specifiyPieces() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (x % 2 == y % 2) {
					if (y <= 2) {
						pieces[y][x] = new Piece(true); // creates a red checkers piece
					} else if (y >= 5) {
						pieces[y][x] = new Piece(false); // creates a black checkers piece
					} else {
						pieces[y][x] = null; // no piece here
					}
				} else {
					pieces[y][x] = null; // no piece here
				}
			}
		}
		
	}
	
	public void movePiece(int oldY, int oldX, int newY, int newX) {
		if (isMoveLegal(oldY, oldX, newY, newX) == true) {
			pieces[newY][newX].Red = pieces[oldY][oldX].Red;
			pieces[oldY][oldX] = null;
		}
	}
	
	public boolean isMoveLegal(int oldY, int oldX, int newY, int newX) {
		return true;
	}

}

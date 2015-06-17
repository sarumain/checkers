package checkers;

public class Board {
	
	Piece[][] pieces;
	
	Board() {
		Piece[][] pieces = new Piece[8][8]; // creates 8x8 array, of which the entries are either NULL or represent a checkers piece
	}
	
	public void specifiyPieces() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (x % 2 == y % 2) {
					if (y <= 2) {
						pieces[y][x].isPieceRed = true;
					} else if (y >= 5) {
						pieces[y][x].isPieceRed = false;
					} else {
						pieces[y][x] = null;
					}
				} else {
					pieces[y][x] = null;
				}
			}
		}
	}

}

package checkers;

public class Board {
	
	Board() {
		Piece[][] pieces = new Piece[8][8]; // creates 8x8 array, of which the entries are either NULL or represent a checkers piece
	}
	
	public void specifiyPieces() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == j % 2) {
					pieces[i][j] = 
				}
			}
		}
	}

}

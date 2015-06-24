package checkers;

public class Board {
	
	int black = 0;
	int red = 1;
	private int[][] squares = new int[8][8];
	
	public Board() {
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (x % 2 == y % 2) {
					getSquares()[y][x] = black; // black
				} else {
					getSquares()[y][x] = red; // red
				}
			}
		}
		
	}

	int[][] getSquares() {
		return squares;
	}

	void setSquares(int[][] squares) {
		this.squares = squares;
	}
	
}

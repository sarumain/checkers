package checkers;
import java.util.HashMap;
import java.util.Map;
import java.awt.Point;

public class Game {
	
	Board board;

	protected Piece[] pieces = new Piece[24];
	protected Point[] positions = new Point[24]; 

	Map<Piece, Point> map = new HashMap<>();
	
	int pieceNumber = 24; {
		while(pieceNumber != 0) {
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 8; x++) {
					if (x % 2 == y % 2) {
						if (y <= 2) {
							pieces[pieceNumber].pieceType = 0; // creates a red checkers piece
							positions[pieceNumber].setLocation(y, x);
							map.put(pieces[pieceNumber], positions[pieceNumber]);
							pieceNumber = pieceNumber - 1;
						} else if (y >= 5) {
							pieces[pieceNumber].pieceType = 1; // creates a black checkers piece
							positions[pieceNumber].setLocation(y, x);
							map.put(pieces[pieceNumber], positions[pieceNumber]);
							pieceNumber = pieceNumber - 1;
						} else {
							// no piece here
						}
					} else {
						 // no piece here
					}
				}
			}
		}
	}
}
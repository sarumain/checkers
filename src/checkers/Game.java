package checkers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Point;

public class Game {
	
	Piece[] pieces = new Piece[24];
	Point[] positions = new Point[64];
	
	public Game() {}

	Map<Piece, Point> map = new HashMap<>();
	
	int pieceNumber = 0; { // matching pieces to a position
		while(pieceNumber != 24) {
			for (int y = 0; y < 8; y++) {
				for(int x = 0; x < 8; x++) {
						if (x % 2 == y % 2) {
							if (y <= 2) {
								pieces[pieceNumber] = new Piece(0); // RED piece
								positions[pieceNumber] = new Point(x,y);
								map.put(pieces[pieceNumber], positions[pieceNumber]);
								pieceNumber++;
							} else if (y >= 5) {
								pieces[pieceNumber] = new Piece(1); // BLACK piece
								positions[pieceNumber] = new Point(x,y);
								map.put(pieces[pieceNumber], positions[pieceNumber]);
								pieceNumber++;
							} else {
								// no piece here
							}	
				
						} else {
						 // no piece here
						}
				}
			}
		}
	} // end of matching pieces to a position
	
	public void makeMove(int pieceNumber, Point position) {
		if (legalMove(pieceNumber, position) == true) {
			Point tempPosition = map.get(pieces[pieceNumber]);
			map.put(pieces[pieceNumber], position); // piece to new position
			map.put(null, tempPosition); // old position has null piece
		} else {
			//
		}
		
	}	
	public void makeJump() {
		
	}
	
	public boolean legalMove(int pieceNumber, Point position) {
		if ((squareIsAvailable(position)) && (moveIsDiagonal(pieceNumber, position))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ifLegalJump() {
		return true;
	}
	
	public boolean noPiecesLeft() {
		return false;
	}
	
	public boolean noMovesLeft() {
		return false;
	}
	
	public boolean moveIsDiagonal(int pieceNumber, Point position) {
		if (pieces[pieceNumber].getPieceType() == 0) {
			if ((position.getY() == positions[pieceNumber].getY() + 1) && ((position.getX() == (positions[pieceNumber].getX() - 1)) || (position.getX() == 1))) {
				return true;
			} else {
				return false;
			}
		} else if (pieces[pieceNumber].getPieceType() == 1) {
			if ((position.getY() == positions[pieceNumber].getY() - 1) && ((position.getX() == (positions[pieceNumber].getX() - 1)) || (position.getX() == 1))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	
	public boolean squareIsAvailable(Point position) {
		if (map.get(position) != null) {
			return false;
		} else { 
			return true;
		}
	}

}
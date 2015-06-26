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
		if ((pieces[pieceNumber].getPieceType() == 0) && (squareIsAvailable(position))) {
			if (position.getX() <= 5) {
				
				
			}
		} else if ((pieces[pieceNumber].getPieceType() == 1)  && (squareIsAvailable(position))) {
			
		} else if ((pieces[pieceNumber].getPieceType() == 2)  && (squareIsAvailable(position))) {
			
		}
		
	}	
	public void makeJump() {
		
	}
	
	public boolean ifLegalMove() {
		return true;
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
	
	public boolean squareIsAvailable(Point position) {
		if (map.get(position) != null) {
			return false;
		} else { 
			return true;
		}
	}

}
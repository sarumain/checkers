package checkers;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Point;

public class Game {
		
	private boolean gameIsOn;
	
	public Game(boolean gameIsOn) {
		this.gameIsOn = gameIsOn;
		createPieces();
	}

	Map<Point, Piece> map = new HashMap<>();
	
	public void move(Point oldPosition, Point newPosition) {
		Piece temp = map.get(oldPosition);
		map.remove(oldPosition);
		map.put(newPosition, temp);

	}
	
	public void jump(Point oldPosition, Point newPosition) {
		Piece temp = map.get(oldPosition);
		map.remove(oldPosition);
		map.remove(jumpCheck(oldPosition));
		map.put(newPosition, temp);
		
	}

	public Point jumpCheck(Point oldPosition) { // check if jumping over opponent piece
		if (map.get(oldPosition).getPieceType() == Piece.RED) {
			if (map.get(new Point(oldPosition.x+1, oldPosition.y+1)).getPieceType() == Piece.BLACK) {
				return new Point(oldPosition.x+1, oldPosition.y+1);
			} else if (map.get(new Point(oldPosition.x-1, oldPosition.y+1)).getPieceType() == Piece.BLACK) {
				return new Point(oldPosition.x-1, oldPosition.y+1);
			} else {
				return null;
			}
		} else if (map.get(oldPosition).getPieceType() == Piece.BLACK) {
			if (map.get(new Point(oldPosition.x+1, oldPosition.y-1)).getPieceType() == Piece.BLACK) {
				return new Point(oldPosition.x+1, oldPosition.y-1);
			} else if (map.get(new Point(oldPosition.x-1, oldPosition.y-1)).getPieceType() == Piece.BLACK) {
				return new Point(oldPosition.x+1, oldPosition.y-1);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public boolean diagonalJump(Point oldPosition, Point newPosition) {
		if (map.get(oldPosition).getPieceType() == Piece.RED) {
			if ((newPosition.getY() == oldPosition.getY() + 2) && ((newPosition.getX() == oldPosition.getX() - 2)) || (newPosition.getX() == oldPosition.getX() + 2)) {
				return true;
			} else {
				return false;
			}
		} else if (map.get(oldPosition).getPieceType() == Piece.BLACK) {
			if ((newPosition.getY() == oldPosition.getY() - 2) && ((newPosition.getX() == oldPosition.getX() - 2)) || (newPosition.getX() == oldPosition.getX() + 2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean diagonalMove(Point oldPosition, Point newPosition) {
		if (map.get(oldPosition).getPieceType() == Piece.RED) {
			if ((newPosition.getY() == oldPosition.getY() + 1) && ((newPosition.getX() == oldPosition.getX() - 1)) || (newPosition.getX() == oldPosition.getX() + 1)) {
				return true;
			} else {
				return false;
			}
		} else if (map.get(oldPosition).getPieceType() == Piece.BLACK) {
			if ((newPosition.getY() == oldPosition.getY() - 1) && ((newPosition.getX() == oldPosition.getX() - 1)) || (newPosition.getX() == oldPosition.getX() + 1)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean squareIsAvailable(Point position) {
		if (map.get(position) == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean playerCheck(Player player, Point oldPosition) {
		if ((player.playerType == Piece.BLACK) && (map.get(oldPosition).getPieceType() == Piece.BLACK)) {
			return true;
		} else if ((player.playerType == Piece.RED) && (map.get(oldPosition).getPieceType() == Piece.RED)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayPieces() {
		System.out.println("/////////");
		System.out.println("CHECKERS BOARD: ");
		System.out.println("/////////");
		for(Entry<Point, Piece> entry : map.entrySet()) {
			if (entry.getValue().getPieceType() == Piece.BLACK) {
				System.out.println("BLACK -> (" + entry.getKey().getX() + ", " + entry.getKey().getY() + ")");
			} else if ((entry.getValue().getPieceType() == Piece.RED)) {
				System.out.println("RED -> (" + entry.getKey().getX() + ", " + entry.getKey().getY() + ")");
			}
		}
		System.out.println("/////////");
	}
	
	public void createPieces() {
		for (int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
					if (x % 2 == y % 2) {
						Piece temp = null;
						if (y <= 2) {
							temp = new Piece(Piece.RED);
							map.put(new Point(x,y), temp);
							
						} else if (y >= 5) {
							temp = new Piece(Piece.BLACK);
							map.put(new Point(x,y), temp);
						} else {
							// no piece here
						}

					} else {
					 // no piece here
					}
			}
		}
	}
	public boolean anyPiecesLeft() {
		for(Entry<Point, Piece> entry : map.entrySet()) {
			if (entry.getValue().getPieceType() == Piece.BLACK) {
				return true;
			} else if ((entry.getValue().getPieceType() == Piece.RED)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean anyMovesLeft() {
		return true;
	}
	
	public boolean isGameOn() { // whether the game is on or off
		return true;
	}

	public void setGameOn(boolean gameIsOn) { // setter for game
		this.gameIsOn = gameIsOn;
	}

}
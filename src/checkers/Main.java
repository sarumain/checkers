package checkers;

import java.awt.Point;
import java.util.Scanner;
 
public class Main{
        public static void main(String[] args){
        	
        	Scanner input = new Scanner(System.in);
        	
        	Game g = new Game(true);
        	Player p1 = new Player(Piece.RED);
        	Player p2 = new Player(Piece.BLACK);
        	
        	System.out.println("Welcome to a game of CHECKERS."); // KINGLESS GAME OF CHECKERS
        	System.out.println("Let's start by seeing the BOARD.");
        	int oldX = 0, oldY = 0, newX = 0, newY = 0;
        	Player currentPlayer = p1;
        	
        	while(g.isGameOn() == true) {
        		
        		g.displayPieces();
        		
        		// toggle players
        		if (currentPlayer == p1) {
        			currentPlayer = p2;
        			System.out.println("PLAYER 2: please select the BLACK piece you will move");

        		} else {
        			currentPlayer = p1;
        			System.out.println("PLAYER 1: please select the RED piece you will move");

        		}
        		
        		// check if piece to move is valid
        		boolean selectionGood = false;
        		while(selectionGood == false) {
        			System.out.println("Enter x-value of piece you want to move:"); oldX = input.nextInt();
        			System.out.println("Enter y-value of piece you want to move:"); oldY = input.nextInt();
        			
        			if (!g.squareIsAvailable(new Point(oldX, oldY))) {
        				if(g.playerCheck(currentPlayer, new Point(oldX, oldY))) {
            				selectionGood = true;
            			} else {
            				System.out.println("Please select your own piece!");
            				selectionGood = false;
            			}
        			} else {
        				System.out.println("Nothing there to move!");
        				selectionGood = false;
        			}
        		}
        		
        		// check if valid move
        		boolean validMove = false;
        		boolean validJump = false;
        		while((validMove == false) || (validMove == false)) {
        			System.out.println("Enter new x-value: "); newX = input.nextInt();
        			System.out.println("Enter new y-value:"); newY = input.nextInt();
        			
        			if (g.squareIsAvailable(new Point(newX, newY))) {
        					if (g.diagonalMove(new Point(oldX, oldY), new Point(newX, newY))) {
        						validMove = true;
        					} else if (g.diagonalJump(new Point(oldX, oldY), new Point(newX, newY))) {
        						if (g.jumpCheck(new Point(oldX, oldY)) != null) {
        							validJump = true;
        							validMove = true;
        						} else {
        							System.out.println("ERROR: There's nothing to jump!");
        							validMove = false;
        						}
        					} else {
        						System.out.println("ERROR: Square is available but not a jump!");
        						validMove = false;
        					}
        			} else {
        				System.out.println("ERROR: Square is not available!");
        				validMove = false;
        			}
        		
        		
        		}
        		
        		// finally, make the move
        		if (validJump == true) {
        			g.jump(new Point(oldX, oldY), new Point(newX, newY));
        		} else {
        			g.move(new Point(oldX, oldY), new Point(newX, newY));
        		}
        		
        		if (g.turnsKing(new Point(newX, newY))) { // king functionality
        			g.map.get(new Point(newX, newY)).setKing(true);
        		} else {
        			//
        		}
        		
        		// need a way to check if the game is over
        		// no pieces left

        	}
        }
}
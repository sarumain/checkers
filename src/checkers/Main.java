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
        	int oldX, oldY, newX, newY;
        	Player currentPlayer = p1;
        	
        	while(g.isGameOn()) {
        		
        		g.displayPieces();
        		
        		// toggle players
        		if (currentPlayer == p1) {
        			currentPlayer = p2;
        			System.out.println("PLAYER 2: please select the BLACK piece you will.");

        		} else {
        			currentPlayer = p1;
        			System.out.println("PLAYER 1: please select the RED piece you will.");

        		}
        		
        		// player check
        		while(true) {
        			System.out.println("Enter x-value of piece you want to move:"); oldX = input.nextInt();
        			System.out.println("Enter y-value of piece you want to move:"); oldY = input.nextInt();
        			
        			if (g.playerCheck(currentPlayer, new Point(oldX, oldY))) {
        				break;
        			} else {
        				System.out.println("Please select your own piece!");
        			}
        		}
        		
        		// check if valid move
        		while(true) {
        			System.out.println("Enter new x-value: "); newX = input.nextInt();
        			System.out.println("Enter new y-value:"); newY = input.nextInt();
        			
        			if (g.squareIsAvailable(new Point(newX, newY))) {
        				while(true) {
        					if (g.diagonalMove(new Point(oldX, oldY), new Point(newX, newY))) {
        						break;
        					} else if (g.diagonalJump(new Point(oldX, oldY), new Point(newX, newY))) {
        						if (g.jumpCheck(new Point(oldX, oldY)) != null) {
        							break;
        						} else {
        							System.out.println("ERROR: There's nothing to jump!");
        						}
        					} else {
        						System.out.println("ERROR: Square is available but not a jump!");
        					}
        				}
        			} else {
        				System.out.println("ERROR: Square is not available!");
        			}
        			
        			break;
        		
        		}
        		
        		// finally, make the move
        		g.move(new Point(oldX, oldY), new Point(newX, newY));

        	}
        }
}
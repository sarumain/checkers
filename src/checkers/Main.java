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
 
        	
        	while(g.isGameOn() == true) {
        		
        		g.displayPieces();
        		
        		System.out.println("PLAYER 1: choose the location of the red you'd like to move.");
        		System.out.println("Enter old X: ");
        		oldX = input.nextInt();
        		System.out.println("Enter old Y: ");
        		oldY = input.nextInt();
        		System.out.println("Enter new X: ");
        		newX = input.nextInt();
        		System.out.println("Enter new Y: ");
        		newY = input.nextInt();
        		g.move(new Point(oldX, oldY), new Point(newX, newY), p1);
        		
        		g.displayPieces();
        		
        		System.out.println("PLAYER 2: choose the location of the black piece you'd like to move.");
        		System.out.println("Enter old X: ");
        		oldX = input.nextInt();
        		System.out.println("Enter old Y: ");
        		oldY = input.nextInt();
        		System.out.println("Enter new X: ");
        		newX = input.nextInt();
        		System.out.println("Enter new Y: ");
        		newY = input.nextInt();
        		g.move(new Point(oldX, oldY), new Point(newX, newY), p1);
        		
        		g.setGameOn(false);
        		input.close();
        		
        		
        		
        		
        	}
        	
        	
        	
        }

}
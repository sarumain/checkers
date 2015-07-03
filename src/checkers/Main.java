package checkers;

import java.awt.Point;
import java.util.Map;
import java.util.Scanner;
 
public class Main{
        public static void main(String[] args){
        	
        	Scanner input = new Scanner(System.in);
        	
        	Game g = new Game(true);
        	Player p1 = new Player(Piece.RED);
        	Player p2 = new Player(Piece.BLACK);
        	
        	System.out.println("You're now playing a game of checkers.");
        	int x, y;
        	
    		
    
        	
        	while(g.isGameOn() == true) {
        		
//        		System.out.println("Player 1: choose the location of the Red you'd like to move.");
//        		System.out.println("Enter x (horizontal): ");
//        		x = input.nextInt();
//        		System.out.println("Enter y (vertical): ");
//        		y = input.nextInt();
        		Point p = new Point(0, 0); // piece
        		Point r = new Point(3, 1); // piece
        		System.out.println(g.map.keySet().contains(p)); // So user puts in x, and y, i feed through point.
        														// how do i check if my map contains a piece at this point?
        		
        		g.setGameOn(false);
        		
        		
        		
        		
        	}
        	
        	
        	
        	 g.displayPieces();
        }

}
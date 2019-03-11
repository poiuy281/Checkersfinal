package ass3;
//[Y VAY] [X EIXS]
import java.util.Scanner;

class MyException extends Exception {
	
	public MyException(String message) {
		super(message);
	}
}
//[Y VAY] [X EIXS]
public class assignment3DanielSammy {

	private static void startingBord() {
		String starting = "Mandatory Exercise � Assigment 3 \n"
				+ "02160 � Agile Object-Oriented Software Development \n"
				+ "Made by: s174449 Sammy Steffensen Benomar  and  "
				+ "s171206 Daniel Max Ajsen \n \n"
				+ "Checker classes is on the way to you! \n";
		System.out.println(starting);
		}

	public static void main(String[] args) throws MyException {
		Piece b = new Piece();
		b.newgame();
		startingBord();
		Scanner s = new Scanner(System.in);
		System.out.println("how many rounds do you want to play? ");
		int maxRounds = s.nextInt();
		b.PrintBoard();
		
		
		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 0;

		for (int o=0;o<maxRounds*2;o++) {
			int player = b.getPlayer();
			
//choose part to move			
			System.out.println("Turn of player no. "+b.getPlayer() + "\n");
			System.out.println("Coordinate of piece to move");
			System.out.print("  Enter X:  ");
			fromX = s.nextInt();		
			while (fromX < 0 || fromX > 7) {			
				System.err.println("X have to be in between 0 and 7");
				System.out.println("  Enter X:  ");
				fromX = s.nextInt();	}			
			System.out.print("  Enter Y:  "); 
			fromY = s.nextInt();					
			while (fromY <0 || fromY >7)  {	
				System.err.println("Y have to be in between 0 and 7");
				System.out.println("  Enter Y:  ");
				fromY = s.nextInt();  }
			boolean rightPlayerMoving = b.rightP(fromY, fromX);
	
					if (rightPlayerMoving) { 
			
			System.out.println("player " + player + ", is moving part from X: " + fromX + ", Y: " +  fromY);
			
//choose where to move
			System.out.println("Where to move the pice? ");
			System.out.print("  Enter X:  ");
			toX = s.nextInt();		
			while (toX < 0 || toX > 7) {			
				System.err.println("X have to be in between 0 and 7");
				System.out.println("  Enter X:  ");
				toX = s.nextInt();	}			
			System.out.print("  Enter Y:  "); 
			toY = s.nextInt();					
			while (toY <0 || toY >7)  {	
				System.err.println("Y have to be in between 0 and 7");
				System.out.println("  Enter Y:  ");
				toY = s.nextInt();  }
			}
			boolean move1 = b.Ligal(fromY, fromX, toY, toX); 
					
			if (rightPlayerMoving && move1) {
				System.out.println("moved");
				b.move(fromY, fromX, toY, toX);
				b.PrintBoard();
				System.out.println("player " + player + ", moved part to X: " + toX + ", Y: " +  toY +"\n");
				
				if (player == 1) { b.setPlayer(2);}
				else {b.setPlayer(1);}	
			}
			else {
//				printBord(a);
				b.PrintBoard();
				if (!rightPlayerMoving) 
				{	System.out.println("not right pice, please try again");}
				else if (!move1) 
				{	System.out.println("move is not legal, please try again");	} 
					o= o-1 ;
			}
		} //end loop 
		s.close(); 
		System.out.println("Thank you for playing! See you soon again \n bye bye ");
	} 
}


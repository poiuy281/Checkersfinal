package ass3;

public class Piece {
	protected String [] [] piece;
	protected int player;
	boolean bool;

	
	public void newgame() { //making the new pices in the game
		this.player = 1;
		

		System.out.println("made a pice");
		this.piece = new String [9] [9];
		for (int i=0; i<8 ;i++) {
			for (int j= 0; j<8; j++) {
			piece[i] [j] = " ";
			}
		}
		int p = 0;
		for (int i=0; i<=2 ;i++) {
			for (int j= 0; j<8; j++) {				
			if (p%2==1) {
				piece[i][j]= "1";
				piece[i+5][j+1] = "2";
				j +=1;}
			else {
				piece[i][j+1]= "1";
				piece[i+5][j] = "2";
				j +=1;
				}
			}p +=1;
		}
		
	}

	public void PrintBoard() { //printing the game board with the pices on it
	System.out.println("printing from class");
		String[][] a = this.piece;
		System.out.println("   0 1 2 3 4 5 6 7    <- X axis");
		System.out.println("  +----------------+  ");
		
		for (int i=0; i<8 ;i++) {
			System.out.print(i + " |");
			for (int j=0; j<8;j++) {
				
		System.out.print("" + a[i] [j] + " ");
					} 
			System.out.println("|");
		}
		System.out.println("  +----------------+  ");
		System.out.println("   0 1 2 3 4 5 6 7    ");
	
	}
	
	public int getPlayer() {
		return player;
	}

	public String[][] getpiece() {
		return piece;
	}

//	public boolean RightPlayer1 (String player, int y, int x) {
//		String a [] [] = this.piece;
//		boolean soWhat= true;
//		soWhat = (a[y][x] == (player));
//	
//		return soWhat;
//	}
	
	public boolean Ligal (int fromY, int fromX,int toY, int toX) throws MyException  {
		empty (toY, toX);
		if(!bool) {throw new MyException("Place is taken!!");}
		if (bool) {
		oneJump (fromY, fromX,toY, toX);
		if(!bool) {throw new MyException("Wrong Move");}
		}
		return this.bool;
	}

	public boolean rightP (int y, int x) throws MyException {
		String pl = Integer.toString(player);
		bool= ((piece [y] [x]).equals(pl));
		if(!bool) {throw new MyException("Wrong player");}
		return bool;
		}
	private void empty (int toY, int toX) {
		if (bool) {
		this.bool= ((piece [toY] [toX]).equals(" ")); 	
		}
	}
	private void oneJump (int fromY, int fromX,int toY, int toX) {
		if (bool) {
		int xChange = Math.abs(fromX - toX);
		int yChange = (fromY - toY);
		this.bool= (xChange==1);
		if (bool && this.player == 1) {
			this.bool = yChange==-1;
		}
		else if (bool) {
			this.bool = yChange==1;
		}

		}
	}
	public void move(int y,int x, int toy, int tox) {
		this.piece[y][x]= " " ;
		this.piece[toy][tox]=Integer.toString(player);
		
	}

	public void setPlayer(int i) {
		this.player=i;
		// TODO Auto-generated method stub
		
	}
	
}

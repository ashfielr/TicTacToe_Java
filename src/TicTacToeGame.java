import java.util.Scanner;

public class TicTacToeGame {

	private static char[][] grid;
	private static Scanner scan = new Scanner(System.in);
	private static byte turnCount;
	
	public static void main(String[] args) {
		boolean  gameRunning = true;
		turnCount = 0;
		setupGrid();
		showGrid();
		while(gameRunning) {
			
			takeTurn('X');
			showGrid();
			checkGameWon();
			
			takeTurn('O');
			showGrid();
			checkGameWon();
		}
	}
	
	private static void setupGrid() {
		grid = new char[3][3];
		
		// setting empty cells
		for(int row=0; row<grid.length; row++) {
			for(int col=0; col<grid[row].length; col++) {
				grid[row][col] = ' ';
			}
		}
	}
	
	private static void showGrid() {
		System.out.println();
		System.out.println("     0     1     2  ");
		for(int row=0; row<grid.length; row++) {
			System.out.print(row + " ");
			for(int col=0; col<grid[row].length; col++) {
				System.out.print(" | " + grid[row][col] + " |");
			}
			System.out.println();
		}
	}
	
	private static void takeTurn(char c) {
		boolean cellNotSelected = true;
		try {
			while (cellNotSelected) {
				System.out.println();
				System.out.println(c + " take you turn...");
				System.out.print("Enter column (0,1, or 2): ");
				byte col = scan.nextByte();
				//System.out.println(col);
				System.out.print("Enter row (0,1, or 2): ");
				byte row = scan.nextByte();
				//System.out.println(row);
				//System.out.println("(" + col + "," + row + ")");
				
				if (grid[row][col] == ' ') {
					grid[row][col] = c;
					cellNotSelected = false;
				} else {
					System.out.println("That cell is already used...");
				}
			}
			turnCount++;
		}
		catch (Exception e) {
			System.out.println(e);
			takeTurn(c);
		}

	}
	
	// will display which player won if game is over, otherwise nothing is printed
	private static void checkGameWon() {
		char winningChar = ' ';
		for (int i=0; i<grid.length; i++) {
			// check winning rows and then columns
			if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
				winningChar = grid[i][0];
				break;
			} else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
				winningChar = grid[0][i];
				break;
			}
			// check diagonals
			if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
				winningChar = grid[0][0];
				break;
			} else if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
				winningChar =  grid[0][2];
				break;
			}
		}
		
		if (winningChar != ' ' || turnCount == 9) {
			System.out.println("Game over...");
			
			if (winningChar != ' '){
				System.out.println(winningChar + " WON the game!");
				System.exit(winningChar);
			} else if(turnCount == 9){
				System.out.println("DRAW");
				System.exit(winningChar);
			}
		} 
	}

}

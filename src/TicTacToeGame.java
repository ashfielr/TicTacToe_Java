import java.util.Scanner;

public class TicTacToeGame {

	private static char[][] grid;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean  gameRunning = true;
		setupGrid();
		while(gameRunning) {
			showGrid();
			takeTurn('X');
			checkGameWon();
			showGrid();
			takeTurn('O');
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
		for(int row=0; row<grid.length; row++) {
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
				System.out.println("Enter row (0,1, or 2): ");
				byte row = scan.nextByte();
				System.out.println(row);
				System.out.println("Enter column (0,1, or 2): ");
				byte col = scan.nextByte();
				System.out.println(col);
				System.out.println("(" + row + "," + col + ")");
				
				if (grid[row][col] == ' ') {
					grid[row][col] = c;
					cellNotSelected = false;
				} else {
					System.out.println("That cell is already used...");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
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

		if (winningChar != ' ') {
			System.out.println(winningChar + " won the game!");
			System.exit(winningChar);
		}
	}

}

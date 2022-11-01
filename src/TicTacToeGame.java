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
			showGrid();
			takeTurn('O');
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

}

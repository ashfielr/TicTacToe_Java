
public class TicTacToeGame {

	private static String[][] grid;
	
	public static void main(String[] args) {

		setupGrid();
		showGrid();
	}
	
	private static void setupGrid() {
		grid = new String[3][3];
		
		// setting empty cells
		for(int row=0; row<grid.length; row++) {
			for(int col=0; col<grid[row].length; col++) {
				grid[row][col] = " ";
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

}

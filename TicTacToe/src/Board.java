
public class Board {
	private Field[][] board;
	private Player winner;
	
	Board(Player p1, Player p2) {
		// Fill the board with blank fields
		board = new Field[3][3];
		Blank blank = new Blank();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = blank;
			}
		}
		
		winner = null;
	}
	
	public boolean isFieldEmptyAt(int x, int y) {
		return board[y][x].isBlank();
	}
	
	public void setPlayerAt(int x, int y, Player p) {
		if (isFieldEmptyAt(x, y)) {
			board[y][x] = p;
		}
	}
	
	public boolean isDraw() {
		if (isWin()) { return false; }
		for (Field[] row: this.board) {
			for (Field f: row) {
				if (f.isBlank()) { return false; }
			}
		}
		return true;
	}
	
	public boolean isWin() {
		if (!board[0][0].isBlank() &&           //// Vertical ////
			board[0][0] == board[1][0] &&
			board[1][0] == board[2][0]) {
			this.winner = (Player)board[0][0];
		} else if (!board[0][1].isBlank() &&
			board[0][1] == board[1][1] &&
			board[1][1] == board[2][1]) {
			this.winner = (Player)board[0][1];
		} else if (!board[0][2].isBlank() &&
			board[0][2] == board[1][2] &&
			board[1][2] == board[2][2]) {
			this.winner = (Player)board[0][2];
		}  else if (!board[0][0].isBlank() &&   //// Horizontal ////
			board[0][0] == board[0][1] &&
			board[0][1] == board[0][2]) {
			this.winner = (Player)board[0][0];
		} else if (!board[1][0].isBlank() &&
			board[1][0] == board[1][1] &&
			board[1][1] == board[1][2]) {
			this.winner = (Player)board[1][0];
		} else if (!board[2][0].isBlank() &&
			board[2][0] == board[2][1] &&
			board[2][1] == board[2][2]) {
			this.winner = (Player)board[2][0];
		} else if (!board[0][0].isBlank() && //// Diagonal ////
			board[0][0] == board[1][1] &&
			board[1][1] == board[2][2]) {
			this.winner = (Player)board[1][1];
		} else if (!board[2][0].isBlank() &&
			board[2][0] == board[1][1] &&
			board[1][1] == board[0][2]) {
			this.winner = (Player) board[1][1];
		}
		
		if (winner != null) { return true; }
		return false;
	}
	
	/*
	 * @return Return the name of the winner if there is one else null;
	 */
	public String getWinnerName() {
		if (winner == null) { return null; }
		return this.winner.getName();
	}
	
	public void print() {
		int totalBoardWidth = board[0].length*2 + 1;
		for (int i = 0; i < totalBoardWidth; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (Field[] row: this.board) {
			System.out.print("|");
			for (Field f: row) {
				f.print();
				System.out.print("|");
			}
			System.out.println();
			for (int i = 0; i < totalBoardWidth; i++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
}

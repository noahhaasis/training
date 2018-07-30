import java.util.Scanner;

public class Game {
	static Board board;
	static Player player1;
	static Player player2;
	static Player turn;
	static Scanner scn;
	
	public static void main(String argv[]) throws InterruptedException {
		setupBoard();
		run();
	}
	
	private static void setupBoard() {
		initPlayers();
		board = new Board(player1, player2);
	}
	
	private static void initPlayers() {
		System.out.println("Please enter the first player's name: (You use the cross)");
		String firstPlayerName = scn.nextLine();
		System.out.println("Please enter the second player's name: (You use the circle");
		String secondPlayerName = scn.nextLine();
		player1 = new Player(firstPlayerName, 'x');
		player2 = new Player(secondPlayerName, 'o');
		turn = player1;
		scn = new Scanner(System.in);
	}
	
	private static void run() throws InterruptedException {
		clearScreen();
		board.print();
		while (!board.isWin() && !board.isDraw()) {
			execPlayerTurn();
			clearScreen();
			board.print();
		}
		announceResult();
	}
	
	public static void announceResult() {
		if (board.isDraw()) {
			System.out.println("Draw!");
		} else {
			System.out.println(board.getWinnerName() + " won!");
		}
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	
	public static void execPlayerTurn() {
		int x, y;
		System.out.println(turn.getName() + " which field would you like to mark? (The top field is the origin with x=0 and y=0)");
		do {
			System.out.print("x: ");
			x = scn.nextInt(10);
			System.out.print("y: ");
			y = scn.nextInt(10);
			System.out.println();
		} while (!board.isFieldEmptyAt(x, y));
		board.setPlayerAt(x, y, turn);
		turn = turn == player1 ? player2 : player1;
	}
}

import java.util.Random;
import java.util.Scanner;

public class TicTacToeSolution {

	public static char[][] ticTacToeBoard;
	public static char userXO;
	public static char computerXO;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe - Let's play!\n");
		initializeBoard();
		System.out.println(print(ticTacToeBoard));
		String userRow;
		String userColumn;
		String _userXO;
		boolean unavailableSelection = true;
		boolean userWon = false;
		boolean computerWon = false;

		System.out.print("Please select 'X' or 'O' to play with: ");
		_userXO = keyboard.nextLine();
		while (!isValidChar(_userXO)) {
			System.out.print("Oops! " + _userXO + " is not a valid choice. Try again: ");
			_userXO = keyboard.nextLine();
		}
		userXO = _userXO.toUpperCase().charAt(0);
		computerXO = (userXO == 'X') ? 'O' : 'X';

		System.out.println("Your chosen marker is " + userXO + " and the computer's marker is " + computerXO
				+ ". Humans go first!\n");

		do {
			do {

				System.out.print("Please select a row (0, 1, 2): ");
				userRow = keyboard.nextLine();
				while (!isValidDimension(userRow)) {
					System.out.print("Oops! That's not a valid selection. Try again: ");
					userRow = keyboard.nextLine();
				}

				System.out.print("Please select a column (0, 1, 2): ");
				userColumn = keyboard.nextLine();
				while (!isValidDimension(userColumn)) {
					System.out.print("Oops! That's not a valid selection. Try again: ");
					userColumn = keyboard.nextLine();
				}

				unavailableSelection = !isOpenSpace(userRow, userColumn);
				if (unavailableSelection) {
					System.out.println("Oops - that space is ocupado. Try again.\n");
					System.out.println(print(ticTacToeBoard));
				}
			} while (unavailableSelection);

			userWon = executeUserTurn(userRow, userColumn, userXO);
			System.out.println("\n" + print(ticTacToeBoard));
			if(userWon) {
				System.out.println("Congratulations!! You won!!");
				break;
			}

			System.out.println("\nComputer's turn!\n");
			computerWon = executeComputerTurn();
			System.out.println(print(ticTacToeBoard));
			if(computerWon) {
				System.out.println("Boooo - the computer won. Better luck next time.");
			}

		} while (!userWon && !computerWon);
		System.out.println("Game Over");
	}

	public static void initializeBoard() {
		ticTacToeBoard = new char[][] { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
	}

	public static boolean isValidDimension(String userInput) {
		try {
			return Integer.parseInt(userInput) > -1 && Integer.parseInt(userInput) < 3;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean isGameOver() {
		if (((ticTacToeBoard[0][0] != '_') && ticTacToeBoard[0][0] == ticTacToeBoard[1][1])
				&& (ticTacToeBoard[1][1] == ticTacToeBoard[2][2])
				|| ((ticTacToeBoard[0][2] != '_') && ticTacToeBoard[0][2] == ticTacToeBoard[1][1])
						&& (ticTacToeBoard[1][1] == ticTacToeBoard[2][0])) {
			return true;
		}

		for (int i = 0; i < ticTacToeBoard.length; i++) {
			if (((ticTacToeBoard[i][0] != '_') && (ticTacToeBoard[i][0] == ticTacToeBoard[i][1])
					&& (ticTacToeBoard[i][1] == ticTacToeBoard[i][2]))) {
				return true;
			}
			if ((ticTacToeBoard[0][i] != '_') && (ticTacToeBoard[0][i] == ticTacToeBoard[1][i])
					&& (ticTacToeBoard[1][i] == ticTacToeBoard[2][i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean isOpenSpace(String userRow, String userColumn) {
		try {
			return (ticTacToeBoard[Integer.parseInt(userRow)][Integer.parseInt(userColumn)] == '_');
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean executeUserTurn(String userRow, String userColumn, char userXO) {
		ticTacToeBoard[Integer.parseInt(userRow)][Integer.parseInt(userColumn)] = userXO;
		return isGameOver();
	}

	public static boolean isValidChar(String userXO) {
		return userXO.length() == 1 && (userXO.equalsIgnoreCase("X") || userXO.equalsIgnoreCase("O"));
	}

	public static String print(char[][] board) {
		String result = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				result += board[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	public static boolean executeComputerTurn() {
		Random randomGenerator = new Random();
		int computerRow;
		int computerColumn;
		do {
			computerRow = randomGenerator.nextInt(3);
			computerColumn = randomGenerator.nextInt(3);
		} while (!isOpenSpace(Integer.toString(computerRow), Integer.toString(computerColumn)));
		ticTacToeBoard[computerRow][computerColumn] = computerXO;
		return isGameOver();

	}
}

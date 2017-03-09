import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	/**
	 * public instance variable: ticTacToeBoard
	 * type: two dimensional character array
	 */
	public static char[][] ticTacToeBoard;
	
	/**
	 * public instance variable: userXO
	 * type: character
	 * stores user's playing character X or O
	 */
	public static char userXO;
	
	/**
	 * public instance variable: computerXo
	 * type: character
	 * stores computer's playing character X or O
	 */
	public static char computerXO;

	/**
	 * @param args
	 * @return void
	 * main method: all game play occurs here
	 */
	public static void main(String[] args) {
		// create a new Scanner called 'keyboard'

		// print a welcome message to the user

		// call initializeBoard method to set up a new tic tac toe board

		// print the board using the print method

		// create 3 empty String variables called userRow, userColumn, and _userXO

		// create 3 boolean variables: userWon and computerWon both set to false
		// and unavailableSelection set to true

		// ask the user if they'd like to play with 'X' or 'O'

		// save the user's input using the scanner and the _userXO String
		// variable we created above

		// create a while loop that terminates when the isValidChar method
		// returns true with the _userXO value as an input
	
		// -- inside while loop: print an 'Oops, try again' message to the user
		// -- inside while loop: get the user's input and save it in the _userXO
		// -- variable

		// save the user's input as an uppercase single character in the
		// instance variable called userXO.

		// if the userXO value is 'X', save 'O' into the computerXO instance
		// variable, otherwise, save 'X' into the computerXO instance variable

		// print a message to the user telling them their chosen marker, the
		// computer's chosen marker, and that their turn will be first

		// create a do-while loop that continues while the userWon and
		// computerWon boolean values we created are both false

		// -- inside outer do-while loop: create another do-while loop that continues
		// -- while the unavailableSelection boolean variable we created above is true

		// -- -- inside nested do-while loop: print a message prompting the user
		// -- -- to select a row within the tic tac toe board 0, 1, or 2

		// -- -- inside nested do-while loop: save the user's input using the
		// -- -- scanner into the variable called userRow

		// -- -- inside nested do-while loop: create a while loop that continues
		// -- -- while the function isValidDimensions returns false when given userRow as an
		// -- -- input

		// -- -- -- inside nested while loop: print an 'Ooops!' message to the
		// -- -- -- user telling them their selection was not valid, try again.

		// -- -- -- inside nested while loop: save the user's input using the
		// -- -- -- scanner into the variable called userRow

		// -- -- inside nested do-while loop: print a message to the user
		// -- -- prompting them to select a column within the tic tac toe board 
		// -- -- 0, 1, or 2.

		// -- -- inside nested do-while loop: save the user's input using the
		// -- -- scanner into the variable called userColumn

		// -- -- inside nested do-while loop: create a while loop that continues
		// -- -- while the function isValidDimensions returns false when given 
		// -- -- userColumn as an input

		// -- -- -- inside nested while loop: print a message to the user telling
		// -- -- -- them their selection is not valid, try again.

		// -- -- -- inside nested while loop: save the user's input using the
		// -- -- -- scanner into the variable userColumn

		// -- -- inside nested do-while loop: save the OPPOSITE result of calling
		// -- -- the function isOpenSpace with userRow and userColumn as arguments 
		// -- -- into the variable unavailableSelection that we created above.

		// -- -- inside nested do-while loop: if unavailableSelection is true,
		// -- -- print a message to the user telling them the space they selected is 
		// -- -- occupied - try again. print the tic tac toe board

		// -- -- inside nested do-while loop: while loop terminates here with
		// -- -- condition unavailableSelection == true

		// -- inside outer do-while loop: call the method executeUserTurn with
		// -- the arguments userRow, userColumn, and userXO saving its output to the 
		// -- userWon variable we created above.

		// -- inside outer do-while loop: print the tic tac toe board using the print() method

		// -- inside outer do-while loop: if userWon == true - print a message
		// -- to the user telling them they won and
		// -- write 'break;' to exit the do-while loop

		// -- inside outer do-while loop: print a message the user telling them
		// -- it's the computer's turn

		// -- inside outer do-while loop: execute the method executeComputerTurn
		// -- with no arguments, saving the result to the computerWon variable we created above

		// -- inside outer do-while loop: print the tic tac toe board using the print() method

		// -- inside outer do-while loop: if computerWon == true, print that the
		// -- user lost and better luck next time

		// -- inside outer do-while loop: outer while loop terminates here -
		// -- continues if both userWon and computerWon are false
		
		// print a message to the user telling them the game is over
	}

	/**
	 * Initializes the ticTacToeBoard instance variable to a two dimensional array of empty spaces
	 * represented by the character '_'.
	 * @param none
	 * @return none
	 */
	public static void initializeBoard() {
		ticTacToeBoard = new char[][] { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
	}

	/**
	 * Takes a String called userInput and checks to see if it's a valid row or column. A valid
	 * row or column is 0, 1, or 2.
	 * @param String userInput - column or row selected by the user
	 * @return
	 * @throws a NumberFormatException if the user entered anything that cannot be converted to
	 * an integer and returns false that the userInput is not a valid dimension.
	 */
	private static boolean isValidDimension(String userInput) {
		try {
			return Integer.parseInt(userInput) > -1 && Integer.parseInt(userInput) < 3;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * This function evaluates the spaces on the ticTacToeBoard to see if the last play could end
	 * the game with a 'three in a row' match. This function checks both diagonals, horizontal rows,
	 * and vertical columns.
	 * @param none
	 * @return boolean true or false - true if the game is over, false if it is not
	 */
	private static boolean isGameOver() {
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

	/**
	 * This function takes a VALID userRow and userColumn and checks to see if that space is available
	 * on the board (represented by a '_'. If it is, the function returns true, otherwise returns false;
	 * @param String userRow - user's selected row to place their mark
	 * @param String userColumn - user's selected column to place their mark
	 * @return true or false - true if the space selected is available, false if it is not.
	 * @throws a NumberFormatException if the input given by the user (userRow or userColumn) cannot be
	 * translated into an integer.
	 */
	private static boolean isOpenSpace(String userRow, String userColumn) {
		try {
			return (ticTacToeBoard[Integer.parseInt(userRow)][Integer.parseInt(userColumn)] == '_');
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * This function takes the user's selected row and column (userRow and userColumn) and places their
	 * mark (X or O saved in the userXO instance variable) in their chosen space. We then call the isGameOver()
	 * function which returns true if the user's move won them the game and false if the game continues.
	 * @param String userRow - user's selected row to place their mark
	 * @param String userColumn - user's selected column to place their mark
	 * @return true or false - true if the game is over, false if it is not
	 */
	private static boolean executeUserTurn(String userRow, String userColumn) {
		ticTacToeBoard[Integer.parseInt(userRow)][Integer.parseInt(userColumn)] = userXO;
		return isGameOver();
	}

	/**
	 * This function takes the user's chosen character to play and returns true if it is valid (X or O). Anything
	 * other than X or O will return false.
	 * @param String userXO - user's chosen playing character
	 * @return true or false - true if the character chosen is valid, false if it is not
	 */
	private static boolean isValidChar(String userXO) {
		return userXO.length() == 1 && (userXO.equalsIgnoreCase("X") || userXO.equalsIgnoreCase("O"));
	}

	/**
	 * Calling this function returns a String representation of the current board being played (saved in the
	 * ticTacToeBoard instance variable). This method is function when used with System.out.println();
	 * @param none
	 * @return String representation of the ticTacToeBoard instance variable
	 */
	private static String print() {
		String result = "";
		for (int i = 0; i < ticTacToeBoard.length; i++) {
			for (int j = 0; j < ticTacToeBoard[i].length; j++) {
				result += ticTacToeBoard[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * This function executes the computer's turn and returns true if the computer's move won them the game and
	 * false if it did not. This function randomly generates valid row/column combinations until it finds one that
	 * is free and places the computer's mark there.
	 * @param none
	 * @return true or false - true if the computer has won, false if it hasn't
	 */
	private static boolean executeComputerTurn() {
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

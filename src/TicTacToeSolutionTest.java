import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeSolutionTest {
	public char[][] ticTacToeBoard;
	public char userXO;
	public char computerXO;

	@Before
	public void setUp() throws Exception {
		TicTacToeSolution.initializeBoard();
		ticTacToeBoard = TicTacToeSolution.ticTacToeBoard;
		userXO = 'X';
		computerXO = 'O';
		TicTacToeSolution.computerXO = computerXO;
		TicTacToeSolution.userXO = userXO;
	}

	@Test
	public void testEmptyBoard() {
		for(int i = 0; i < ticTacToeBoard.length; i++) {
			for(int j = 0; j < ticTacToeBoard[i].length; j++) {
				assertEquals(ticTacToeBoard[i][j], '_');
			}
		}
	}
	
	@Test
	public void testGameOver() {
		ticTacToeBoard[0][0] = userXO;
		ticTacToeBoard[0][1] = userXO;
		ticTacToeBoard[0][2] = userXO;
		assertTrue(TicTacToeSolution.isGameOver());
	}
	
	@Test
	public void testisValidDimension() {
		assertTrue(TicTacToeSolution.isValidDimension("0"));
		assertTrue(TicTacToeSolution.isValidDimension("1"));
		assertTrue(TicTacToeSolution.isValidDimension("2"));
		assertFalse(TicTacToeSolution.isValidDimension("72"));
		assertFalse(TicTacToeSolution.isValidDimension("apple"));
	}
	
	@Test
	public void testisOpenSpace() {
		assertTrue(TicTacToeSolution.isOpenSpace("0", "0"));
		ticTacToeBoard[0][0] = userXO;
		assertFalse(TicTacToeSolution.isOpenSpace("0", "0"));
	}
	
	@Test
	public void testisValidChar() {
		assertTrue(TicTacToeSolution.isValidChar("X"));
		assertFalse(TicTacToeSolution.isValidChar("tomatoe"));
	}

	@Test
	public void testPrint() {
		String result = TicTacToeSolution.print(ticTacToeBoard);
		assertFalse(result.equals(""));
		assertTrue(result.equals("_ _ _ \n_ _ _ \n_ _ _ \n"));
	}
	
	@Test
	public void testexecuteUser() {
		assertFalse(TicTacToeSolution.executeUserTurn("0", "0", userXO));
		assertTrue(ticTacToeBoard[0][0] == userXO);
	}
	
	@Test
	public void testexecuteComputerTurn() {
		assertFalse(TicTacToeSolution.executeComputerTurn());
		boolean foundO = false;
		for(int i = 0; i < ticTacToeBoard.length; i++) {
			for(int j = 0; j < ticTacToeBoard[i].length; j++) {
				if(ticTacToeBoard[i][j] == computerXO)
					foundO = true;
			}
		}
		assertTrue(foundO);
	}
}

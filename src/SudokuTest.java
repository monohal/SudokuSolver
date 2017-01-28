import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void testSetCSV(){
		Sudoku sudoku = new Sudoku();
		sudoku.readCSV("sudoku.csv");
		//sudoku.solver.outputVerNumber();

		assertEquals(new HashSet<Integer>(Arrays.asList(9)),
				sudoku.solver.getVerSquare(0, 0).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(2,6,9)),
				sudoku.solver.getVerSquare(2, 2).getSquareSet());

		assertEquals(5, sudoku.solver.getVerSquare(8, 8).getNumber());
		assertTrue(sudoku.solver.getVerSquare(8, 8).isConfirm());
	}

	@Test
	public void testConfirmOnlyNumber(){
		Sudoku sudoku = new Sudoku();
		sudoku.readCSV("sudoku.csv");
		sudoku.solver.outputVerNumber();
		sudoku.solver.solve();

		assertTrue(sudoku.solver.getVerSquare(0, 0).isConfirm());
		assertEquals(9, sudoku.solver.getVerSquare(0, 0).getNumber());

		sudoku.solver.outputVerNumber();
	}

}

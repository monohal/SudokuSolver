import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class SquareTest {

	@Test
	public void testInitSquare(){
		Square square = new Square();
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)),
				square.getSquareSet());
	}

	@Test
	public void testConfirmNumber(){
		Square square = new Square();
		assertFalse(square.isConfirm());

		square.confirmNumber(5);
		assertTrue(square.isConfirm());
		assertEquals(5, square.getNumber());
	}

	@Test
	public void testDeleteSquareNumber(){
		Square square = new Square();
		square.delete(3);
		square.delete(4);

		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,5,6,7,8,9)),
				square.getSquareSet());

		square.delete(Arrays.asList(8,9));
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquareSet());

		square.delete(3);
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquareSet());

		square.delete(Arrays.asList(1,9));
		assertEquals(new HashSet<Integer>(Arrays.asList(2,5,6,7)),
				square.getSquareSet());
	}

	@Test
	public void testInitVerticalLine(){
		VerticalLine verLine = new VerticalLine();
		assertEquals(9, verLine.getSquares().size());
	}

	@Test
	public void testConfirmVerticalLine(){
		VerticalLine verLine = new VerticalLine();
		verLine.confirm(5, 1);

		assertEquals(1, verLine.getSquare(5).getNumber());
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 verLine.getSquare(1).square);
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 verLine.getSquare(8).square);
	}

	@Test
	public void testConfirmHorizonLine(){
		HorizonLine horLine = new HorizonLine();
		horLine.confirm(5, 1);

		assertEquals(1, horLine.getSquare(5).getNumber());
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 horLine.getSquare(1).square);
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 horLine.getSquare(8).square);
	}

	@Test
	public void testConfirmBox(){
		Box box = new Box();
		box.confirm(5, 1);

		assertEquals(1, box.getSquare(5).getNumber());
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 box.getSquare(1).square);
		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 box.getSquare(8).square);
	}

	@Test
	public void testSudokuSolver(){
		SudokuSolver solver = new SudokuSolver();
		assertEquals(9, solver.verLines.size());
		assertEquals(9, solver.horLines.size());
		assertEquals(9, solver.boxes.size());
	}

	@Test
	public void testConfirmNumberOfSolver(){
		SudokuSolver solver = new SudokuSolver();
		solver.confirm(4, 3, 1);
		VerticalLine verLine = solver.getVerLine(4);

		assertTrue(verLine.getSquare(3).isConfirm());
		assertEquals(1, verLine.getSquare(3).getNumber());

		assertEquals(new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				verLine.getSquare(1).getSquareSet());
	}

	@Test
	public void testSync(){
		SudokuSolver solver = new SudokuSolver();
		solver.confirm(0, 0, 1);
		solver.confirm(1, 1, 2);
		solver.confirm(1, 8, 3);
		solver.confirm(8, 1, 4);
		solver.confirm(4, 4, 5);
		solver.sync();

		assertEquals(new HashSet<Integer>(Arrays.asList(3,5,6,7,8,9)),
				solver.getVerSquare(0, 1).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9)),
				solver.getVerSquare(1, 0).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(3,4,5,6,7,8,9)),
				solver.getVerSquare(2, 2).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)),
				solver.getVerSquare(7, 7).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,5,6,7,8,9)),
				solver.getVerSquare(8, 8).getSquareSet());

		assertEquals(new HashSet<Integer>(Arrays.asList(3,5,6,7,8,9)),
				solver.getHorSquare(0, 1).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9)),
				solver.getHorSquare(1, 0).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(3,4,5,6,7,8,9)),
				solver.getHorSquare(2, 2).getSquareSet());

		assertEquals(new HashSet<Integer>(Arrays.asList(3,5,6,7,8,9)),
				solver.getBoxSquare(0, 1).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9)),
				solver.getBoxSquare(1, 0).getSquareSet());
		assertEquals(new HashSet<Integer>(Arrays.asList(3,4,5,6,7,8,9)),
				solver.getBoxSquare(2, 2).getSquareSet());
	}


	@Test
	public void testConfirmOnlyCandidate(){
		SudokuSolver solver = new SudokuSolver();
		solver.confirm(3, 1, 1);
		solver.confirm(6, 2, 1);
		solver.confirm(0, 3, 1);
		solver.confirm(1, 6, 1);

		Boolean flag = solver.findOnlyCandidate();
		assertTrue(flag);
		assertTrue(solver.getVerSquare(2, 0).isConfirm());
		assertEquals(1, solver.getVerSquare(2, 0).getNumber());

		Boolean flag = solver.findOnlyCandidate();
		assertFalse(flag);
	}
}

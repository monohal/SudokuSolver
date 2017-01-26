import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SquareTest {

	@Test
	public void testInitSquare(){
		Square square = new Square();
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)),
				square.getSquareArray());
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

		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7,8,9)),
				square.getSquareArray());

		square.delete(Arrays.asList(8,9));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquareArray());

		square.delete(3);
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquareArray());

		square.delete(Arrays.asList(1,9));
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,5,6,7)),
				square.getSquareArray());
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
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 verLine.getSquare(1).square);
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 verLine.getSquare(8).square);
	}

	@Test
	public void testConfirmHorizonLine(){
		HorizonLine horLine = new HorizonLine();
		horLine.confirm(5, 1);

		assertEquals(1, horLine.getSquare(5).getNumber());
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 horLine.getSquare(1).square);
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 horLine.getSquare(8).square);
	}

	@Test
	public void testConfirmBox(){
		Box box = new Box();
		box.confirm(5, 1);

		assertEquals(1, box.getSquare(5).getNumber());
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 box.getSquare(1).square);
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)),
				 box.getSquare(8).square);
	}

	@Test
	public void testSudokuSolver(){
		SudokuSolver solver = new SudokuSolver();
		assertEquals(9, solver.verLines.size());
		assertEquals(9, solver.horLines.size());
		assertEquals(9, solver.boxes.size());
	}
}

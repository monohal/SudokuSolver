import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SquareTest {

	@Test
	public void checkInitSquare(){
		Square square = new Square();
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)),
				square.getSquare());
	}

	@Test
	public void checkConfirm(){
		Square square = new Square();
		assertFalse(square.isConfirm());

		square.confirmNumber(5);
		assertTrue(square.isConfirm());
		assertEquals(5, square.getNumber());
	}

	@Test
	public void deleteSquareNumber(){
		Square square = new Square();
		square.delete(3);
		square.delete(4);

		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7,8,9)),
				square.getSquare());

		square.delete(Arrays.asList(8,9));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquare());

		square.delete(3);
		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,5,6,7)),
				square.getSquare());

		square.delete(Arrays.asList(1,9));
		assertEquals(new ArrayList<Integer>(Arrays.asList(2,5,6,7)),
				square.getSquare());
	}

	@Test
	public void checkInitVerticalLine(){
		VerticalLine verLine = new VerticalLine();
		assertEquals(9, verLine.getSquares().size());
	}
}

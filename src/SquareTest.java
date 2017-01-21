import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SquareTest {

	@Test
	public void checkInitSquare(){
		  Square square = new Square();
		  assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)), square.getSquare());
	}
}

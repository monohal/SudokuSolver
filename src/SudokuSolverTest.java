import org.junit.Test;

public class SudokuSolverTest {

	@Test
	public void testOutput(){
		SudokuSolver solver = new SudokuSolver();
		solver.confirm(0, 0, 1);
		solver.confirm(1, 1, 2);
		solver.confirm(2, 2, 3);
		solver.confirm(3, 3, 4);
		solver.confirm(4, 1, 4);
		solver.confirm(3, 2, 1);
		solver.confirm(2, 3, 2);
		solver.confirm(1, 4, 3);
		solver.confirm(0, 5, 5);

		solver.outputHorNumber();
		System.out.println("");
		solver.outputVerNumber();
		System.out.println("");
		solver.outputBoxNumber();
	}

}

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.StringArrayListHandler;

public class Sudoku {
	SudokuSolver solver;

	public static void main(String args[]){
		Sudoku sudoku = new Sudoku();
		sudoku.readCSV("sudoku_normal.csv");
		Boolean flag;
		do {
			flag = sudoku.solver.solve();
			sudoku.solver.outputVerNumber();
		} while (flag);
	}

	public Sudoku() {
		solver = new SudokuSolver();
	}

	public void readCSV(String filename){
		try {
			List<String[]> csv;
			csv = Csv.load(new File(filename),
					new CsvConfig(),
					new StringArrayListHandler());

			for(int x = 0; x < 9; x++){
				String[] strArray = csv.get(x);

				for(int y = 0; y < 9; y++){
					String num = strArray[y];

					if(! num.equals("")){
						this.solver.confirm(x, y, Integer.valueOf(num));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		solver.sync();
	}
}
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
		int count;

		for(; ;){
			count = 0;
			do {
				flag = sudoku.solver.solve();
				System.out.println("slove");
				sudoku.solver.outputVerNumber();
				count++;
			} while (flag);

			do{
				flag = sudoku.solver.findOnlyCandidate();
				System.out.println("find");
				sudoku.solver.outputVerNumber();
				count++;
			} while (flag);

			if(count == 2){
				break;
			}
		}

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

			for(int y = 0; y < 9; y++){
				String[] strArray = csv.get(y);

				for(int x = 0; x < 9; x++){
					String num = strArray[x];

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
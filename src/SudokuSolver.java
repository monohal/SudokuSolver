import java.util.ArrayList;

public class SudokuSolver {
	ArrayList<VerticalLine> verLines;
	ArrayList<HorizonLine> horLines;
	ArrayList<Box> boxes;

	public SudokuSolver(){
		verLines = new ArrayList<VerticalLine>();
		horLines = new ArrayList<HorizonLine>();

		boxes = new ArrayList<Box>();

		for(int i = 0; i < 9; i++){
			horLines.add(new HorizonLine());
		}
		for(int i = 0; i < 9; i++){
			verLines.add(new VerticalLine());
		}
		for(int i = 0; i < 9; i++){
			boxes.add(new Box());
		}

	}
}

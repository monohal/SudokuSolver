import java.util.ArrayList;

public class SudokuSolver {
	ArrayList<HorizonLine> horLines;
	ArrayList<VerticalLine> verLines;
	ArrayList<Box> boxes;

	public SudokuSolver(){
		horLines = new ArrayList<HorizonLine>();
		verLines = new ArrayList<VerticalLine>();
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

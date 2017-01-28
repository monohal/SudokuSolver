import java.util.ArrayList;
import java.util.Set;

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

	public void confirm(int x, int y, int num){
		confirmVerLine(x, y, num);
		confirmHorLine(x, y, num);
		confirmBox(x, y, num);

	}

	public void confirmVerLine(int x, int y, int num){
		getVerLine(x).confirm(y, num);
	}

	public void confirmHorLine(int x, int y, int num){
		getHorLine(y).confirm(x, num);
	}

	public void confirmBox(int x, int y, int num){
		getBox(x / 3 + (y / 3) * 3).confirm(x % 3 + ((y % 3)  * 3), num);
	}

	public VerticalLine getVerLine(int pos){
		return verLines.get(pos);
	}

	public HorizonLine getHorLine(int pos){
		return horLines.get(pos);
	}

	public Box getBox(int pos){
		return boxes.get(pos);
	}

	public void outputHorNumber(){
		for(int i = 0; i < 9 ; i++){
			HorizonLine horLine = getHorLine(i);

			for(Square square : horLine.squares){
				if(square.isConfirm()){
					System.out.print("~" + square.number);
				}else{
					for(int num : square.getSquareSet()){
						System.out.print(num);
					}
				}
				System.out.print(",");
			}
			System.out.println();
		}
	}

	public void outputVerNumber(){
		for(int i = 0; i < 9 ; i++){
			VerticalLine verLine = getVerLine(i);

			for(Square square : verLine.squares){
				if(square.isConfirm()){
					System.out.print("~" + square.number);
				}else{
					for(int num : square.getSquareSet()){
						System.out.print(num);
					}
				}
				System.out.print(",");
			}
			System.out.println();
		}
	}

	public void outputBoxNumber(){
		for(int i = 0; i < 9 ; i++){
			Box horLine = getBox(i);

			for(Square square : horLine.squares){
				if(square.isConfirm()){
					System.out.print("~" + square.number);
				}else{
					for(int num : square.getSquareSet()){
						System.out.print(num);
					}
				}
				System.out.print(",");
			}
			System.out.println();
		}
	}
}

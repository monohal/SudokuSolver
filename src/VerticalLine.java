import java.util.ArrayList;

public class VerticalLine {
	ArrayList<Square> squares = new ArrayList<Square>();
	public VerticalLine() {
		for(int i = 0; i < 9; i++){
			squares.add(new Square());
		}
	}

	public ArrayList<Square> getSquares(){
		return this.squares;
	}
}

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

	public void confirm(int pos, int num){
		Square square = getSquare(pos);
		square.confirmNumber(num);
		deleteAllNumberOfSquare(num);
	}

	public void deleteAllNumberOfSquare(int num){
		for(Square square : squares){
			square.delete(num);
		}
	}

	public Square getSquare(int pos){
		return squares.get(pos);
	}
}

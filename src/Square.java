import java.util.ArrayList;

public class Square {
	ArrayList<Integer> square;
	public Square(){
		this.square = initSquare();
	}

	public ArrayList<Integer> initSquare(){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 1; i <= 9; i++){
			array.add(i);
		}
		return array;
	}

	public ArrayList<Integer> getSquare(){
		return this.square;
	}
}

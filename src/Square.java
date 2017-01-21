import java.util.ArrayList;
import java.util.List;

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

	public void delete(int num){
		int pos = square.indexOf(num);
		if(pos == -1) return;

		this.square.remove(pos);
		return;
	}

	public void delete(List<Integer> list){
		for(Integer num : list){
			delete(num);
		}
	}

	public ArrayList<Integer> getSquare(){
		return this.square;
	}
}

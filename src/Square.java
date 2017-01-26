import java.util.ArrayList;
import java.util.List;

public class Square {
	ArrayList<Integer> square;
	int number;

	public Square(){
		this.square = initSquare();
		this.number = -1;
	}

	public void confirmNumber(int num){
		number = num;
	}

	public Boolean isConfirm(){
		if(number == -1) return false;
		return true;
	}

	public int getNumber(){
		return number;
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

		square.remove(pos);
		return;
	}

	public void delete(List<Integer> list){
		for(Integer num : list){
			delete(num);
		}
	}

	public ArrayList<Integer> getSquareArray(){
		return square;
	}
}

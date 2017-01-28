import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Square {
	Set<Integer> square;
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

	public Set<Integer> initSquare(){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i <= 9; i++){
			set.add(i);
		}
		return set;
	}

	public void delete(int num){
		if(! square.contains(num)) return;

		square.remove(num);
		return;
	}

	public void delete(List<Integer> list){
		for(Integer num : list){
			delete(num);
		}
	}

	public Set<Integer> getSquareSet(){
		return square;
	}
}

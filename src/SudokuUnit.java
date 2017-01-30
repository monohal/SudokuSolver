import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SudokuUnit implements Iterable<Square>{
	ArrayList<Square> squares = new ArrayList<Square>();

	public SudokuUnit() {
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

	public ArrayList<Map<String, Integer>> checkOnlyCandidate(){
		ArrayList<Map<String, Integer>> onlyCandidateNums = new ArrayList<Map<String, Integer>>();

		for(int num = 1; num <= 9; num++){
			int count = 0;
			int tempPos = -1;

			for(int pos = 0 ; pos < 9; pos++){
				Square square = getSquare(pos);
				if(square.square.contains(num)){
					count++;
					if(count == 2){
						tempPos = -1;
						break;
					}
					tempPos = pos;
				}
			}

			if(tempPos != -1){
				Map<String, Integer> onlyCandidateNum = new HashMap<String, Integer>();
				onlyCandidateNum.put("pos", tempPos);
				onlyCandidateNum.put("num", num);
				onlyCandidateNums.add(onlyCandidateNum);
			}
		}
		return onlyCandidateNums;
	}

	public Square getSquare(int pos){
		return squares.get(pos);
	}

	public Iterator<Square> iterator() {
		return squares.iterator();
	}
}

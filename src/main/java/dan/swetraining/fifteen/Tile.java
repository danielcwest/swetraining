package dan.swetraining.fifteen;

public class Tile {

	public int index;
	
	public int value;
	
	public Tile(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	public boolean canMove(int toIndex) {
		return (toIndex == index + 1 || toIndex == index - 1 || toIndex == index + 4 || toIndex == index - 4);
	}
	
	public void printTile() {
		if(value == 16) {
			System.out.print("*, ");
		}else {
			System.out.print(this.value + ", ");		
		}
	}
	
	@Override
	public String toString() {
		if(value == 16) {
			return "*";
		}else {
			return this.value + "";		
		}
	}
}

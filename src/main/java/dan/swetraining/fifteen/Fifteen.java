package dan.swetraining.fifteen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fifteen {
		
	Map<Integer,Integer> indexes = new HashMap<Integer, Integer>(); 
	
	Map<Integer, Tile> board = new HashMap<Integer, Tile>();
		
	public void setupBoard() {
		List<Integer> randomList = IntStream.range(1, 17).boxed().collect(Collectors.toList());
		
		Collections.shuffle(randomList);
		
		for(int i = 0; i < randomList.size(); i++) {
			indexes.put(randomList.get(i), i);
			board.put(i, new Tile(i, randomList.get(i)));
		}
		
		System.out.println("Welcome! Here is your board: ");

	}
	
	public void play() {
		 System.out.println("\n\n What would you like to do?\n");
		 
		try {
			  // Enter data using BufferReader
	        BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	 
	        // Reading data using readLine
	        int tile = Integer.valueOf(reader.readLine());
	        	        
	        System.out.println(this.tryMove(tile));
		
			printBoard();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		play();
	}
	
	public String tryMove(int toValue) {
		int index = (int)indexes.get(toValue);
		System.out.println();
		
		Tile fromTile = this.board.get(this.indexes.get(16));
		
		if(fromTile.canMove(index)) {
			Tile toTile = this.board.get(index);
			toTile.index = fromTile.index;				
			fromTile.index = index;
			
			this.move(fromTile, toTile);
			
	        return "You chose the " + toValue + " tile! Here is your board: ";

		}else {
			return "Invalid move! Here is your board:";
		}
		
	}
	
	public void move(Tile fromTile, Tile toTile) {

		this.board.put(toTile.index, toTile);
		this.indexes.put(toTile.value, toTile.index);
		
		this.board.put(fromTile.index, fromTile);
		this.indexes.put(fromTile.value, fromTile.index);

	}
	
	public void printBoard() {
	
		for(int i = 0; i < 16; i++) {
			if(i%4 == 0) {
				System.out.print('\n');
			}			
			this.board.get(i).printTile();			
		}
	}
	
	public List<String> toArray(){
		return this.board.values().stream()
				.map(t -> t.toString())
				.collect(Collectors.toList());
	}

}

package dan.swetraining.fifteen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FifteenTest {

	Fifteen f = new Fifteen();
	
	@Test
	void testBoardSize() {
		
		f.setupBoard();
		
		f.printBoard();
		
		System.out.println(f.tryMove(6));
		
		assertEquals(f.board.size(), 16);
	}
	
	@Test
	void testBoard2() {
	//	f.setupBoard();
		//f.printBoard2();
	}

}

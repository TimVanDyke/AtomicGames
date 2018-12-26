import static org.junit.Assert.*;

import org.junit.Test;

import com.atomicobject.othello.Albert;
import com.atomicobject.othello.GameState;


public class AITest {

	@Test
	public void isLegal() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 1, 2, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {2,4}));
		assertTrue(albert.legalMove(state, new int[] {3,5}));
		assertTrue(albert.legalMove(state, new int[] {4,2}));
		assertTrue(albert.legalMove(state, new int[] {5,3}));

		// all illegal moves
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				if (y == 2 && x == 4 || y == 3 && x == 5 || y == 4 && x == 2 || y == 5 && x == 3) {
				}
				else {
					assertFalse(albert.legalMove(state, new int[] {y, x}));
				}
			}
		}
	}

	@Test
	public void isLegalp2() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(2);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 1, 2, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {2,3}));
		assertTrue(albert.legalMove(state, new int[] {3,2}));
		assertTrue(albert.legalMove(state, new int[] {5,4}));
		assertTrue(albert.legalMove(state, new int[] {4,5}));

		// all illegal moves
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				if (y == 2 && x == 3 || y == 3 && x == 2 || y == 4 && x == 5 || y == 5 && x == 4) {
				}
				else {
					assertFalse(albert.legalMove(state, new int[] {y, x}));
				}
			}
		}
	}

	
//	@Test
//	public void isLegalCurrentlyBroken() {
//		Albert albert = new Albert();
//		GameState state = new GameState();
//		state.setPlayer(1);
//		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
//				                   {0, 0, 0, 0, 0, 2, 0, 0},
//				                   {0, 0, 0, 2, 0, 2, 0, 0},
//				                   {0, 0, 0, 2, 2, 2, 0, 1},
//				                   {0, 1, 0, 2, 2, 0, 1, 0},
//				                   {0, 1, 1, 2, 2, 1, 1, 1},
//				                   {0, 1, 0, 2, 0, 2, 1, 0},
//				                   {0, 1, 0, 2, 1, 1, 1, 1}});
//		
//		// all legal moves
//		assertTrue(albert.legalMove(state, new int[] {1,6}));
//		assertTrue(albert.legalMove(state, new int[] {2,4}));
//		assertTrue(albert.legalMove(state, new int[] {2,2}));
//		assertTrue(albert.legalMove(state, new int[] {6,4}));
//		assertTrue(albert.legalMove(state, new int[] {7,2}));
//	}
	
	@Test
	public void isLegalCurrentlyBroken1() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 1, 0, 2, 2, 0, 1, 0},
				                   {0, 1, 1, 2, 2, 1, 1, 1},
				                   {0, 1, 0, 2, 0, 2, 1, 0},
				                   {0, 1, 0, 2, 1, 1, 1, 1}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {1,6}));
	}
	
	@Test
	public void isLegalCurrentlyBroken2() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 1, 0, 2, 2, 0, 1, 0},
				                   {0, 1, 1, 2, 2, 1, 1, 1},
				                   {0, 1, 0, 2, 0, 2, 1, 0},
				                   {0, 1, 0, 2, 1, 1, 1, 1}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {2,4}));
	}
	@Test
	public void isLegalCurrentlyBroken3() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 1, 0, 2, 2, 0, 1, 0},
				                   {0, 1, 1, 2, 2, 1, 1, 1},
				                   {0, 1, 0, 2, 0, 2, 1, 0},
				                   {0, 1, 0, 2, 1, 1, 1, 1}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {2,2}));
		
	}

	@Test
	public void isLegalCurrentlyBroken4() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 1, 0, 2, 2, 0, 1, 0},
				                   {0, 1, 1, 2, 2, 1, 1, 1},
				                   {0, 1, 0, 2, 0, 2, 1, 0},
				                   {0, 1, 0, 2, 1, 1, 1, 1}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {6,4}));
	}
	
	@Test
	public void isLegalCurrentlyBroken5() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 0, 2, 0, 0},
				                   {0, 0, 0, 2, 2, 2, 0, 1},
				                   {0, 1, 0, 2, 2, 0, 1, 0},
				                   {0, 1, 1, 2, 2, 1, 1, 1},
				                   {0, 1, 0, 2, 0, 2, 1, 0},
				                   {0, 1, 0, 2, 1, 1, 1, 1}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {7,2}));
	}



	@Test
	public void isLegalTwoPieces() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 0, 0, 0, 0},
				                   {0, 0, 0, 2, 1, 1, 0, 0},
				                   {0, 0, 0, 2, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 2, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0},
				                   {0, 0, 0, 0, 0, 0, 0, 0}});
		
		// all legal moves
		assertTrue(albert.legalMove(state, new int[] {6,4}));
	}
	
	@Test
	public void legalList() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 1, 2, 0, 0, 0},
									{0, 0, 0, 2, 1, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
            						{0, 0, 0, 0, 0, 0, 0, 0},
            						{0, 0, 0, 0, 0, 0, 0, 0}});
		
		// all legal moves
		assertEquals(albert.makeLegalList(state, 1).size(), 4);
	}
	@Test
	public void movePicked() {
		Albert albert = new Albert();
		GameState state = new GameState();
		state.setPlayer(1);
		state.setBoard(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
									{0, 0, 0, 1, 2, 0, 0, 0},
									{0, 0, 0, 2, 1, 0, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0},
            						{0, 0, 0, 0, 0, 0, 0, 0},
            						{0, 0, 0, 0, 0, 0, 0, 0}});
		
		// all legal moves
		assertNotNull(albert.computeMove(state));
	}
}

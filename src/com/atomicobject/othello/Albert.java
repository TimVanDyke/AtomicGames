package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class Albert {
	
	ListIterator<int[]> moveList;

	public Albert(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		System.out.println("AI returning canned move for game state - " + state);
		return moveList.next();
	}
	
	/*
	 * 
	 */
	public boolean legalMove() {
		Boolean legal;
		legal = true;
		return legal;
	}
}

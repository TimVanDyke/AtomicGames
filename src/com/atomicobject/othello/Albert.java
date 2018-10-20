package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class Albert {
	
	ListIterator<int[]> moveList;

	public Albert(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		System.out.println();
		System.out.println("AI returning canned move for game state - " + state);
		if (legalMove(state)) {
			return moveList.next();
		}
		//FIXME
		return moveList.next();
	}
	
	/*
	 * checks if a move is legal
	 */
	private boolean legalMove(GameState state) {
		Boolean legal;
		if (moveList.next() == !null) {
			return legal;
		}
		return legal;
	}
	
	/*
	 * iterates through all moves for the best one
	 */
	private int[] findBest(ListIterator<int[]> legalMoves) {
		for (int i = 0; i < legalMoves.; i++) {
			
		}
		int[] bestMove = new int[2];
		bestMove[0] = 1;
		bestMove[1] = 1;
		return bestMove;
	}
}

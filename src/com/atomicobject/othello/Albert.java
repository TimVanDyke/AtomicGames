package com.atomicobject.othello;

import java.util.ArrayList;

public class Albert {
	
	ArrayList<int[]> moveList;
	int[] move;

//	public Albert(int[] move) {
//		//this.moveList = moveList;
//		this.move = move;
//	}
	
	public Albert() {

	}

	public int[] computeMove(GameState state) {
		ArrayList<int[]> legalMoves;
		int[] bestMove;
		legalMoves = makeLegalList(state, state.getPlayer());
		bestMove = findBest(legalMoves);
		return bestMove;
	}
	
	/*
	 * checks if a move is legal
	 */
	public boolean legalMove(GameState state, int[] move) {
		int[][] board = state.getBoard();
		int y = move[0];
		int x = move[1];
		int player = state.getPlayer();
		int oppPlayer;
		boolean open = false;
		if(player == 1) {
			oppPlayer = 2;
		}
		else {
			oppPlayer = 1;
		}
		Boolean legal = false;
		
		//checking if the space is open
		if (board[y][x] == 0) {
			open = true;
		}
		
		Boolean leftUp = false;
		Boolean up = false;
		Boolean rightUp = false;
		Boolean left = false;
		Boolean right = false;
		Boolean leftDown = false;
		Boolean down = false;
		Boolean rightDown = false;
		
		for(int yi = -1; yi <= 1; yi++) {
			for(int xj = -1; xj <= 1; xj++) {
				if (y+yi < 0 || y+yi > 7 || x+xj < 0 || x+xj > 7) {
				}
				else {
					if(board[y+yi][x+xj] == oppPlayer) {
						if (yi == -1 && xj == -1) {
							leftUp = true;
						}else if (yi == -1 && xj == 0) {
							up = true;
						}else if (yi == -1 && xj == 1) {
							rightUp = true;
						}else if (yi == 0 && xj == -1) {
							left = true;
						}else if (yi == 0 && xj == 1) {
							right = true;
						}else if (yi == 1 && xj == -1) {
							leftDown = true;
						}else if (yi == 1 && xj == 0) {
							down = true;
						}else if (yi == 1 && xj == 1) {
							rightDown = true;
						}
					}
				}
			}
		}
		
		if (leftUp) {
			int tempX = move[1];
			int tempY = move[0];
			

			tempY--;
			tempX--;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 0 || tempX == 0) {
					break;
				}
				tempY--;
				tempX--;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (up) {
			int tempX = move[1];
			int tempY = move[0];

			tempY--;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 0) {
					break;
				}
				tempY--;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (rightUp) {
			int tempX = move[1];
			int tempY = move[0];

			tempY--;
			tempX++;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 0 || tempX == 7) {
					break;
				}
				tempY--;
				tempX++;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (left) {
			int tempX = move[1];
			int tempY = move[0];

			tempX--;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempX == 0) {
					break;
				}
				tempX--;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (right) {
			int tempX = move[1];
			int tempY = move[0];

			tempX++;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempX == 7) {
					break;
				}
				tempX++;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (leftDown) {
			int tempX = move[1];
			int tempY = move[0];

			tempY++;
			tempX--;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 7 || tempX == 0) {
					break;
				}
				tempY++;
				tempX--;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (down) {
			int tempX = move[1];
			int tempY = move[0];
			
			tempY++;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 7) {
					break;
				}
				tempY++;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}if (rightDown) {
			int tempX = move[1];
			int tempY = move[0];

			tempY++;
			tempX++;
			while(board[tempY][tempX] == oppPlayer) {
				if(tempY == 7 || tempX == 7) {
					break;
				}
				tempY++;
				tempX++;
			}
			if(board[tempY][tempX] == player) {
				legal = true;
			}
		}

		boolean fullyLegal = false;
		if (legal == true && open == true) {
			fullyLegal = true;
		}
		return fullyLegal;
	}
	
	/*
	 * Makes a list of all legal moves given a board and a player
	 */
	public  ArrayList<int[]> makeLegalList(GameState state, int player) {
		ArrayList<int[]> legalMoves = new ArrayList<int[]>();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (legalMove(state, new int[] {y, x})) {
					legalMoves.add(new int[] {y, x});
				}
			}
		}
		return legalMoves;
	}
	
	/*
	 * iterates through all moves for the best one
	 */
	private int[] findBest(ArrayList<int[]> legalMoves) {
		int[] bestMove = new int[2];
		bestMove = legalMoves.get(0);
		//corners
		boolean a00 = false;
		boolean a07 = false;
		boolean a70 = false;
		boolean a77 = false;
		
//		//next to top left corner
//		boolean a01 = false;
//		boolean a10 = false;
//		boolean a11 = false;
//		
//		//next to top right corner
//		boolean a06 = false;
//		boolean a16 = false;
//		boolean a17 = false;
//		
//		//next to bottom left corner
//		boolean a60 = false;
//		boolean a61 = false;
//		boolean a71 = false;
//		
//		//next to bottom right corner
//		boolean a66 = false;
//		boolean a76 = false;
//		boolean a67 = false;
		
		for (int i = 0; i < legalMoves.size(); i++) {
			
			//corners
			if(legalMoves.get(i)[0] == 0 && legalMoves.get(i)[1] == 0) {
				a00 = true;
			}else if(legalMoves.get(i)[0] == 0 && legalMoves.get(i)[1] == 7) {
				a07 = true;
			}else if(legalMoves.get(i)[0] == 7 && legalMoves.get(i)[1] == 0) {
				a70 = true;
			}else if(legalMoves.get(i)[0] == 7 && legalMoves.get(i)[1] == 7) {
				a77 = true;
			}
		}
		int[] deleteMeArray = new int[100];
		int counter = 0;
		for (int[] move: legalMoves) {
			if(move[0] == 1 && move[1] == 0) {
				int temp = legalMoves.indexOf(move);
				deleteMeArray[counter] = temp;
				counter++;
			}else if(move[0] == 1 && move[1] == 1) {
				int temp = legalMoves.indexOf(move);
				deleteMeArray[counter] = temp;
				counter++;
			}else if(move[0] == 0 && move[1] == 1) {
				int temp = legalMoves.indexOf(move);
				deleteMeArray[counter] = temp;
				counter++;
			}
			
//			//next to 07
//			else if(move[0] == 0 && move[1] == 6) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 1 && move[1] == 6) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 1 && move[1] == 7) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}
//			
//			//next to 70
//			else if(move[0] == 6 && move[1] == 0) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 6 && move[1] == 1) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 7 && move[1] == 1) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}
//			
//			//next to 77
//			else if(move[0] == 7 && move[1] == 6) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 6 && move[1] == 6) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			}else if(move[0] == 6 && move[1] == 7) {
//				int temp = legalMoves.indexOf(move);
//				deleteMeArray[counter] = temp;
//				counter++;
//			
//			}
//		}
//		counter = 0; 
//		for (int i = 0; i < deleteMeArray.length + 1; i++) {
//			if (legalMoves.size() > 1) {
//				legalMoves.remove(deleteMeArray[counter]);
//			}
//			counter++;
		}
		
		if (a00) {
			return new int[] {0,0};
		}else if (a07) {
			return new int[] {0,7};
		}else if (a70) {
			return new int[] {7,0};
		}else if (a77) {
			return new int[] {7,7};
		}
		return bestMove;
	}
}
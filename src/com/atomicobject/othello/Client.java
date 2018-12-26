package com.atomicobject.othello;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class Client {

	BufferedReader input;
	OutputStreamWriter out;
	Gson gson = new Gson();
	Albert albert;
	int numTurns = 1;

//	public Client(Socket socket, int[][] moves) {
	public Client(Socket socket) {
		try {
			//albert = new Albert(moves);
			albert = new Albert();
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new OutputStreamWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		System.out.println("Starting client processing ...");
		GameState trueState;
		//GameState albertsBrain;
//		try {
//			while ((trueState = readStateFromServer()) != null) {
//				int[] move = albert.computeMove(trueState);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		closeStreams();
//		albertsBrain = trueState;
//		for (int i = 0; i < numTurns; i++) {
//			int[] move = albert.computeMove(albertsBrain);
//			respondWithMoveLocal(move);
//		}
		try {
			while ((trueState = readStateFromServer()) != null) {
				int[] move = albert.computeMove(trueState);
				respondWithMove(move);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeStreams();
	}
	
//	private void respondWithMoveLocal(int[] move) {
//		
//	}

	private GameState readStateFromServer() throws IOException {
		System.out.println("Reading from server ...");
		String nextLine = input.readLine();
		System.out.println("Read data: " + nextLine);
		if (nextLine == null) return null;
		return gson.fromJson(nextLine.trim(), GameState.class);
	}

	private void respondWithMove(int[] move) throws IOException {
		String encoded = gson.toJson(move);
		System.out.println("Sending response: " + encoded);
		out.write(encoded);
		out.write("\n");
		out.flush();
	}

	private void closeStreams() {
		closeQuietly(input);
		closeQuietly(out);
	}

	private void closeQuietly(Closeable stream) {
		try {
			stream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

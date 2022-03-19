package chess;

import pieces.Pawn;
import pieces.Piece;

public class Chess {
	private static int boardSideLength = 8;
	private static BoardSpace board [][];
	
	public static void displayBoard () {		
		//Displaying the top part of the chess board		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].getPiece() != null)
					System.out.print(board[i][j].getPiece().getPieceName());
				else
					//Blank spaces
					if (i%2 == 0 && j%2 == 1 || i%2 == 1 && j%2 == 0)
						System.out.print("##");
					else
						System.out.print("  ");
				System.out.print(" ");
			}
			System.out.print(boardSideLength - i + "\n");
		}
		
		//Displaying the bottom row
		System.out.println(" a  b  c  d  e  f  g  h");
	}
	
	public static void initializeBoard() {
		board = new BoardSpace[boardSideLength][boardSideLength];
		
		/*
		//Black Pieces
		for (int i = 0; i < board.length; i++) 
			board[1][i] = new BoardSpace(new Pawn("bp"));
		
		//White Pieces
		for (int i = 0; i < board.length; i++)
			board[6][i] = new BoardSpace(new Pawn("wp"));
		
		//Everything else
		for (int i = 0; i < board.length; i++)
			if (i != 1 && i != 6)
				for (int j = 0; j < board.length; j++)
					board[i][j] = new BoardSpace(null);
		*/
		
		//Big Pieces
		String string = "RNBQK";
		for (int i = 0; i < string.length(); i++) {
			board[0][i]
					= new BoardSpace(new Pawn("b" + string.charAt(i)));
			board[board.length - 1][i]
					= new BoardSpace(new Pawn("w" + string.charAt(i)));
			
			//Copying piece on other side of the board
			if (i != string.length() - 1) {
				board[0][board.length - 1 - i]
						= new BoardSpace(new Pawn("b" + string.charAt(i)));
				board[board.length - 1][board.length - 1 - i]
						= new BoardSpace(new Pawn("w" + string.charAt(i)));
			}
		}
		
		//Pawns
		for (int i = 0; i < board.length; i++) {
			board[1][i] = new BoardSpace(new Pawn("bp"));
			board[board.length - 2][i] = new BoardSpace(new Pawn("wp"));
		}
		
		//Blank Spaces
		for (int i = 2; i < board.length - 2; i++)
			for (int j = 0; j < board.length; j++)
				board[i][j] = new BoardSpace(null);
	}
	
	public static void main (String[] args) {
		//Initialize
		initializeBoard();
		
		//Load Game
		displayBoard();
	}
}
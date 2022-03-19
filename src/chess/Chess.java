package chess;

import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import pieces.Queen;
import pieces.King;


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
			
		//Rook
		board[0][0] 			   = new BoardSpace(new Rook("bR"));
		board[0][board.length - 1] = new BoardSpace(new Rook("bR"));
		board[board.length - 1][0] = new BoardSpace(new Rook("wR"));
		board[board.length-1][board.length-1]
				= new BoardSpace(new Rook("wR"));
		
		//Knight
		board[0][1] 				   = new BoardSpace(new Knight("bN"));
		board[0][board.length - 1 - 1] = new BoardSpace(new Knight("bN"));
		board[board.length - 1][1] 	   = new BoardSpace(new Knight("wN"));
		board[board.length-1][board.length - 1 - 1]
				= new BoardSpace(new Knight("wN"));
		
		//Bishop
		board[0][2] 				   = new BoardSpace(new Bishop("bB"));
		board[0][board.length - 1 - 2] = new BoardSpace(new Bishop("bB"));
		board[board.length - 1][2] 	   = new BoardSpace(new Bishop("wB"));
		board[board.length-1][board.length - 1 - 2]
				= new BoardSpace(new Bishop("wB"));
		
		//Queen and King
		board[0][3] 				   = new BoardSpace(new Queen("bQ"));
		board[board.length - 1][3] 	   = new BoardSpace(new Queen("wQ"));
		board[0][4] 				   = new BoardSpace(new King("bK"));
		board[board.length - 1][4] 	   = new BoardSpace(new King("wK"));
		
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
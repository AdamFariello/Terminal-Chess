package chess;

import java.util.Scanner;

import chess.BoardSpace;
import chess.rankFileConversion;
import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import pieces.Queen;
import pieces.King;
import chess.ruleBook;

public class Chess {
	private static final int boardSideLength = 8;
	private static BoardSpace board [][];
	private static boolean draw, illegalMove;
	private static int turncount;
	
	public static void displayBoard () {		
		//Displaying the top part of the chess board	
		System.out.print("\n");
		int i = 0, j = 0;
		try {
			for (i = 0; i < board.length; i++) {
				for (j = 0; j < board.length; j++) {
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
			System.out.println(" a  b  c  d  e  f  g  h\n");
			
		} catch (Exception e) {
			System.out.printf("\nError is in: (%d,%d)", i, j);
		}
	}
	
	public static void initializeBoard() {
		board = new BoardSpace[boardSideLength][boardSideLength];	
		
		//Black created first, then white.
		//Rook
		board[0][0] 			   			  = new BoardSpace(new Rook("bR", "a8"));
		board[0][board.length - 1] 			  = new BoardSpace(new Rook("bR", "h8"));
		board[board.length - 1][0] 			  = new BoardSpace(new Rook("wR", "a1"));
		board[board.length-1][board.length-1] = new BoardSpace(new Rook("wR", "h1"));
		
		//Knight
		board[0][1] 				   				= new BoardSpace(new Knight("bN", "b8"));
		board[0][board.length - 1 - 1] 				= new BoardSpace(new Knight("bN", "g8"));
		board[board.length - 1][1] 	   				= new BoardSpace(new Knight("wN", "h1"));
		board[board.length-1][board.length - 1 - 1] = new BoardSpace(new Knight("wN", "g1"));
		
		//Bishop
		board[0][2] 				   				= new BoardSpace(new Bishop("bB", "c8"));
		board[0][board.length - 1 - 2] 				= new BoardSpace(new Bishop("bB", "f8"));
		board[board.length - 1][2] 	   				= new BoardSpace(new Bishop("wB", "c1"));
		board[board.length-1][board.length - 1 - 2] = new BoardSpace(new Bishop("wB", "f8"));
		
		//Queen and King
		board[0][3] 			   = new BoardSpace(new Queen("bQ","d8"));
		board[board.length - 1][3] = new BoardSpace(new Queen("wQ","d1"));
		
		board[0][4] 			   = new BoardSpace(new King("bK", "e8"));
		board[board.length - 1][4] = new BoardSpace(new King("wK", "e1"));
		
		//Pawns
		String spots = "abcdefgh";
		for (int i = 0; i < board.length; i++) {
			board[1][i] = new BoardSpace(new Pawn("bp", spots.charAt(i) + "7"));
			board[board.length - 2][i] = new BoardSpace(new Pawn("wp", spots.charAt(i) + "2"));
		}
		
		//Blank Spaces
		for (int i = 2; i < board.length - 2; i++)
			for (int j = 0; j < board.length; j++) 
				board[i][j] = new BoardSpace(null);
		
		//TODO Insert test code here
		board[7][1].setPiece(null);
		board[7][2].setPiece(null);
		board[7][3].setPiece(null);
		board[7][5].setPiece(null);
		board[7][6].setPiece(null);
		
		board[0][1].setPiece(null);
		board[0][2].setPiece(null);
		board[0][3].setPiece(null);
		board[0][5].setPiece(null);
		board[0][6].setPiece(null);
		
		board[6][0].setPiece(null);
		board[6][7].setPiece(null);
	}
	
	public static void main (String[] args) {
		//Initialize
		initializeBoard();
		draw = false;
		illegalMove = true;
		turncount = 0;
	
		displayBoard();
		board[6][1].getPiece().prepareMoveList(board);
		System.out.println("(6,1): " +board[6][1].getPiece().getMoveList());
		
		board[1][1].getPiece().prepareMoveList(board);
		System.out.println("(1,1): " +board[1][1].getPiece().getMoveList());
		
		/*
		//Game Begin
		while (true) {
			//Setup turn
			displayBoard();
			illegalMove = true;
			turncount++;
			
			if (turncount % 2 == 1) 
				System.out.print("White's move: ");
			else		   
				System.out.print("Black's move: ");
			
			while (illegalMove) {
				//Taking an entry
				//Also no need to check for illegal input
				Scanner sc = new Scanner(System.in);
				String entry = sc.nextLine();
				String [] entrySplit = entry.split(" ");
				String entry1 = entrySplit[0];
				
				//Checking other inputs
				String entry2 = null, entry3 = null;
				if (entrySplit.length > 1)
					entry2 = entrySplit[1];
				if (entrySplit.length > 2)
					entry3 = entrySplit[2];
				
				//Handling entries
				//TODO 
				if (entry1 != null && entry2 != null) {
					draw = false;
				
					//General
					int [] pos = rankFileConversion.RankFiletoArray(entry1);
					Piece piece = board[pos[0]][pos[1]].getPiece();
					piece.setMoveList(board);
					
					if (piece.contains(entry2)) {
						char c = piece.getPieceName().charAt(1);
						if (c == 'p' && piece.getMoveList().get(1).contains(entry2))
							//TODO: Enpassant
							ruleBook.enpassant();
						else if (c == 'p' && piece.getMoveList().get(2).contains(entry2))
							//TODO: Promotion
							ruleBook.promition();		
						else if (c == 'K' && piece.getMoveList().get(1).contains(entry2))
							//TODO Castling
							ruleBook.Casteling();
						else
							//TODO General Move
							ruleBook.generalMove(board, entry1, entry2);
						
						illegalMove = false;
						if (entry3 == "draw?")
							draw = true;
					} else {
						System.out.println("Illegal move, try again");
					}
				} else {
					//Conceding to a draw
					if (draw)
						System.exit(0);
					else
						System.out.println("Illegal move, try again");
				}
			}
		}
		*/
	}
}
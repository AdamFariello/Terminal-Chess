/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package pieces;

import java.util.LinkedList;
import java.util.Scanner;

import chess.BoardSpace;
import chess.rankFileConversion;
import chess.ruleBook;

public class temp {
	private static final int boardSideLength = 8;
	private static BoardSpace board [][];
	private static boolean draw, illegalMove;
	private static int turncount;
	
	/**
	 * Method to display the board
	 */
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
	
	/**
	 * Creates the board
	 */
	public static void initializeBoard() {
		board = new BoardSpace[boardSideLength][boardSideLength];	
		
		//Black created first, then white.
		//Rook
		//TODO change back after move list is fine
		
		board[0][0] 			   			  = new BoardSpace(new Rook("bR", "a8")); 
		//board[0][0] = new BoardSpace(null);

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
		

		//TODO fix 
		board[0][4] 			   = new BoardSpace(new King("bK", "e8"));
		board[0][4] 			   = new BoardSpace(null);
		board[2][3] 			   = new BoardSpace(new King("bK", "d6"));
		

		board[0][4] 			   = new BoardSpace(new King("bK", "e8"));

		board[board.length - 1][4] = new BoardSpace(new King("wK", "e1"));
		
		//Pawns
		String spots = "abcdefgh";
		for (int i = 0; i < board.length; i++) { //change to i = 0 later
			board[1][i] = new BoardSpace(new Pawn("bp", spots.charAt(i) + "7"));
			board[board.length - 2][i] = new BoardSpace(new Pawn("wp", spots.charAt(i) + "2"));
		}
		

		board[1][0] = new BoardSpace(null);
		//board[1][4] = new BoardSpace(null);
		//board[6][3] = new BoardSpace(null);
		//Blank Spaces
		for (int i = 2; i < board.length - 2; i++)
			for (int j = 0; j < board.length; j++) 
					board[i][j] = new BoardSpace(null);
		
		//board[3][2] = new BoardSpace(new Pawn("bp", spots.charAt(2)+"5"));
		//board[3][4] = new BoardSpace(new Pawn("bp", spots.charAt(4)+"5"));
		//board[4][3] = new BoardSpace(new Pawn("wp", spots.charAt(3)+"4"));

		//board[i][j] = new BoardSpace(null);
		
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
	
	/**
	 * main method, displays board and takes input
	 * @param args
	 */
	public static void main (String[] args) {
		//Initialize
		initializeBoard();

		
		//White will always make the first move
		boolean whiteTurn = true;
		//displayBoard(); //uncomment later

		board[7][7].getPiece().prepareMoveList(board);
		//board[3][0].getPiece().setMoveList(board);
		//board[4][3].getPiece().setMoveList(board);
		for(int i =0 ; i<board.length; i++) {
			for(int j = 0; j<board.length; j++) {
				if(board[i][j].getPiece()==null) {
					break;
				}

			}
		}
		
		//System.out.println("Pawn Move List: " +board[6][1].getPiece().getMoveList());
		//System.out.println("Black Pawn Move List: " +board[3][0].getPiece().getMoveList());
		//System.out.println("White Rook Move List: " +board[7][7].getPiece().getMoveList());
		// TODO uncomment

		draw = false;
		illegalMove = true;
		turncount = 0;
		//Game Begin
		while (true) {
			/*Setup turn*/
			displayBoard(); //comment out later
			illegalMove = true;
			turncount++;
			
			if (turncount % 2 == 1) 
				System.out.print("White's move: ");
			else		   
				System.out.print("Black's move: ");
			
			while (illegalMove) {
				/*Taking an entry*/
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
				/*TODO*/ 
				if (entry1 != null && entry2 != null) { //
					draw = false;
				
					//General
					int [] pos = rankFileConversion.RankFiletoArray(entry1);
					Piece piece = board[pos[0]][pos[1]].getPiece();
					piece.prepareMoveList(board);
					
					//check opponents moves
					
					
					//piece.setMoveList(board);
					//System.out.println("Move list: "+ piece.getMoveList()); //comment out later
					
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
				LinkedList<LinkedList <String>> currentPlayerMoves = new LinkedList<LinkedList<String>>();
				// if current player is White
				if (turncount % 2 == 1) {
					Piece blackKing;
					for (int x = 0; x < board.length; x++) {
						for (int y = 0; y < board.length; y++) {
							if (board[x][y].getPiece() != null && board[x][y].getPiece().getPieceName().charAt(0) == 'w') {
								currentPlayerMoves.addAll(board[x][y].getPiece().getMoveList());
							}
							if (board[x][y].getPiece() != null && board[x][y].getPiece().getPieceName() == "bK") {
								blackKing = board[x][y].getPiece();
							}
						}
					}
					//CheckMate Condition: find all moves of blackKing
					LinkedList<LinkedList <String>> blackKingMoves = new LinkedList<LinkedList<String>>();
					blackKingMoves = blackKing.getMoveList();
					
					// if black King current position, and all possible move positions, are in current player moveset, then Check mate end game
					
					
					// check if opponent king in currentPlayerMoveSet
					if (currentPlayerMoves.contains(blackKing)) {
						System.out.println("Check");
					}
					
				// current player is Black
				} else {
					Piece whiteKing;
					for (int x = 0; x < board.length; x++) {
						for (int y = 0; y < board.length; y++) {
							if (board[x][y].getPiece() != null && board[x][y].getPiece().getPieceName().charAt(0) == 'b') {
								currentPlayerMoves.addAll(board[x][y].getPiece().getMoveList());
							}
							if (board[x][y].getPiece() != null && board[x][y].getPiece().getPieceName() == "wK") {
								whiteKing = board[x][y].getPiece();
							}
						}
					}
					//CheckMate Condition: find all moves of whiteKing
					LinkedList<LinkedList <String>> whiteKingMoves = new LinkedList<LinkedList<String>>();
					whiteKingMoves = whiteKing.getMoveList();
					
					// if black King current position, and all possible move positions, are in current player moveset, then Check mate end game
		
					
					// check if opponent king in currentPlayerMoveSet
					if (currentPlayerMoves.contains(whiteKing)) {
						System.out.println("Check");
					}
				}
				
			}
		}
	}
}

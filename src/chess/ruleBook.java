/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package chess;

import pieces.Pawn;

public class ruleBook {
	/**
	 * List of general moves that can be made. 
	 * @param board
	 * @param entry1 inputs
	 * @param entry2 inputs
	 */
	public static void generalMove(BoardSpace[][] board, String entryOld, String entryNew) {
		//This will cover:regularMove, Pawns two space move, Capturing
		int [] pos1 = rankFileConversion.RankFiletoArray(entryOld);
		int [] pos2 = rankFileConversion.RankFiletoArray(entryNew);
		
		//Aproach:
		//   1) replace new spot with old piece
		//   2) update old spot to new spot name
		//   3) Make old spot null
		board[pos2[0]][pos2[1]].setPiece(board[pos1[0]][pos1[1]].getPiece());
		board[pos2[0]][pos2[1]].getPiece().setFileRank(entryNew);
		board[pos1[0]][pos1[1]].setPiece(null);
	}
	
	public static void speedMove(BoardSpace[][] board, String entryOld, String entryNew) {
		/*
		int [] pos1 = rankFileConversion.RankFiletoArray(entryOld);
		int [] pos2 = rankFileConversion.RankFiletoArray(entryNew);
		board[pos1[0]][pos[1]].
		*/
	}
	
	public static void enpassant (BoardSpace[][] board, String entryOld, String entryNew) {
		int [] pos1 = rankFileConversion.RankFiletoArray(entryOld);
		int [] pos2 = rankFileConversion.RankFiletoArray(entryNew);
		Pawn pawn = (Pawn) board[pos1[0]][pos1[1]].getPiece();
		
		//Aproach:
		//   1) replace new spot with old piece
		//   2) update old spot to new spot name
		//   3) Make old spot null
		//   4) Changing piece that you're enpassing to null
		board[pos2[0]][pos2[1]].setPiece(board[pos1[0]][pos1[1]].getPiece());
		board[pos2[0]][pos2[1]].getPiece().setFileRank(entryNew);
		board[pos1[0]][pos1[1]].setPiece(null);
		board[pos2[0] + (pawn.getDirection() * -1)][pos2[1]].setPiece(null); 
	}
	
	/**
	 * When a pawn can be promoted
	 */
	public static void promition () {
		
	}
	
	/**
	 * When a king can castle
	 */
	public static void Casteling() {
		
		
	}
	
	

}

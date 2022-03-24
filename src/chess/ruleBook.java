/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package chess;
public class ruleBook {
	
	/**
	 * List of general moves that can be made. 
	 * @param board
	 * @param entry1 inputs
	 * @param entry2 inputs
	 */
	public static void generalMove(BoardSpace[][] board, String entry1, String entry2) {
		//This will cover:
		//	 regularMove 
		//   Pawns two space move
		//   Capturing
		int [] pos2 = rankFileConversion.RankFiletoArray(entry2);
		int [] pos1 = rankFileConversion.RankFiletoArray(entry1);
		
		board[pos2[0]][pos2[1]].setPiece(board[pos1[0]][pos1[1]].getPiece());
		board[pos2[0]][pos2[1]].getPiece().setFileRank(entry2);
		board[pos1[0]][pos1[1]].setPiece(null);
	}
	
	/**
	 * When a pawn can enpassant
	 */
	public static void enpassant () {
		
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

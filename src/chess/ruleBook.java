/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package chess;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class ruleBook {
	/**
	 * List of general moves that can be made. 
	 * @param board
	 * @param entry1 inputs
	 * @param entry2 inputs
	 */
	private static ArrayList<String> pawnPromotions;
	
	public static void initalize() {
		pawnPromotions = new ArrayList<String>();
		pawnPromotions.add("R");
		pawnPromotions.add("K");
		pawnPromotions.add("B");
		pawnPromotions.add("Q");
	}
	
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
	
	public static Piece promition (Piece oldPiece, String promotion) {
		switch (promotion) {
			case "R":
				if (pawnPromotions.contains("R")) {
					pawnPromotions.remove("R");
					return new Rook(oldPiece.getPieceName().charAt(0) + "R", oldPiece.getFileRank());
				}
				break;
			
			case "K":
				if (pawnPromotions.contains("K")) {
					pawnPromotions.remove("K");
					return new Knight(oldPiece.getPieceName().charAt(0) + "K", oldPiece.getFileRank());
				}
				break;
				
			case "B":
				if (pawnPromotions.contains("B")) {
					pawnPromotions.remove("B");
					return new Bishop(oldPiece.getPieceName().charAt(0) + "B", oldPiece.getFileRank());
				}
				break;
				
			default:
				if (pawnPromotions.contains("Q")) {
					pawnPromotions.remove("Q");
					return new Queen(oldPiece.getPieceName().charAt(0) + "Q", oldPiece.getFileRank());
				}
				break;
		}
		
		return null;
	}
	
	/*When a king can castle */
	public static void Casteling() {
		
		
	}
}
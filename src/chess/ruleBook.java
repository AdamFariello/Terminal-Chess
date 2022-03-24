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
	
	public static BoardSpace promition (BoardSpace boardSpace, Piece piece, String promotion) {
		switch (promotion) {
			case "R":
				String string = piece.getPieceName().charAt(0) + "R";
				boardSpace.setPiece(new Rook(string, piece.getFileRank()));
				pawnPromotions.remove("R");
				break;
			case "K":
				string = piece.getPieceName().charAt(0) + "K";
				boardSpace.setPiece(new Knight(string, piece.getFileRank()));
				pawnPromotions.remove("K");
				break;
			case "B":
				string = piece.getPieceName().charAt(0) + "B";
				boardSpace.setPiece(new Bishop(string, piece.getFileRank()));
				pawnPromotions.remove("B");
				break;
			default:
				string = piece.getPieceName().charAt(0) + "Q";
				boardSpace.setPiece(new Queen(string, piece.getFileRank()));
				pawnPromotions.remove("Q");
				break;
		}
		
		return boardSpace;
	}
	
	/**
	 * When a king can castle
	 */
	public static void Casteling() {
		
		
	}
	
	

}

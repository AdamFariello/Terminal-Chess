package chess;

public class ruleBook {

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
	
	public static void enpassant () {
		
	}
	
	public static void promition () {
		
	}
	
	public static void Casteling() {
		
		
	}
}

package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Queen extends Piece{
	public Queen(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}

	// Legal Moves:
	//	1) Regular Move := Move same: column, row, or diagonal space.

	@Override
	public void setMoveList(BoardSpace[][] board) {
		this.getMoveList().add(regularMove(board));
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board) {
		LinkedList<String> moves = new LinkedList<String>();
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		Rook rook = new Rook(this.getPieceName(), this.getFileRank());
		moves.addAll(rook.regularMove(board));
		
		Bishop bishop = new Bishop(this.getPieceName(), this.getFileRank());
		moves.addAll(bishop.regularMove(board));
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
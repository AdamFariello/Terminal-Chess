package pieces;

import java.util.LinkedList;

import chess.BoardSpace;

public class Bishop extends Piece{
	public Bishop(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}

	// Legal Moves:
	// 	1) Regular Move := Move anywhere in the same diagonal space
	@Override
	void setMoveList(BoardSpace[][] board, String newfileRank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board, String fileRank) {
		// TODO Auto-generated method stub
		return null;
	}
}
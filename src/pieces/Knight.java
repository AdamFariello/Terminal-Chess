package pieces;

import java.util.LinkedList;

import chess.BoardSpace;

public class Knight extends Piece{
	public Knight(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}
	
	// Legal Moves:
	// 	1) Regular Move := Move 2 spaces in the same column then 
	// 					   move 1 space in the same row, and vice-versa.
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
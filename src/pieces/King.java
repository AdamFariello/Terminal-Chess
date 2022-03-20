package pieces;

import java.util.LinkedList;

import chess.BoardSpace;

public class King extends Piece{
	public King(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}
		
	//Legal moves:
	//	1) Regular Move := Can move one space in any direction
	//	2) Castling		:= If the rook and king has not made a move, and 
	//					   there's no pieces in between the two, you can
	//					   move the king piece two pieces and move the rook
	//					   to the other side of the king.
	//					   https://en.wikipedia.org/wiki/Chess#Castling
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
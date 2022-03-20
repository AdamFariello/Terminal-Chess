package pieces;

import java.util.LinkedList;

public class King extends Piece{

	public King(String pieceName) {
		super(pieceName);
	}
		
	//Legal moves:
	//	1) Regular Move := Can move one space in any direction
	//	2) Castling		:= If the rook and king has not made a move, and 
	//					   there's no pieces in between the two, you can
	//					   move the king piece two pieces and move the rook
	//					   to the other side of the king.
	//					   https://en.wikipedia.org/wiki/Chess#Castling
	@Override
	LinkedList<String> legalMoves(String fileRank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	LinkedList<String> regularMove(String fileRank) {
		// TODO Auto-generated method stub
		return null;
	}
}

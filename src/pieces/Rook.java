package pieces;

//Castle == Rook 
public class Rook extends Piece{
	Rook(String pieceName) {
		super(pieceName);
		// TODO Auto-generated constructor stub
	}

	//List of legal move:
	//	1) Regular Move := Move to a space that's on it's same row or column
	//	2) Castling		:= If the rook and king has not made a move, and 
	//					   there's no pieces in between the two, you can
	//					   move the king piece two pieces and move the rook
	//					   to the other side of the king.
	//					   https://en.wikipedia.org/wiki/Chess#Castling
	@Override
	boolean legalMoves(String startSpace, String endSpace) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean regularMove(String startSpace, String endSpace) {
		// TODO Auto-generated method stub
		return false;
	}
}
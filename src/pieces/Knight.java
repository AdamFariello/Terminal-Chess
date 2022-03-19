package pieces;

public class Knight extends Piece{
	Knight(String pieceName) {
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	
	// Legal Moves:
	// 	1) Regular Move := Move 2 spaces in the same column then 
	// 					   move 1 space in the same row, and vice-versa.
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

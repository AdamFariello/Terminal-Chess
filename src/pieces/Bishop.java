package pieces;

public class Bishop extends Piece{

	public Bishop(String pieceName) {
		super(pieceName);
		// TODO Auto-generated constructor stub
	}

	// Legal Moves:
	// 	1) Regular Move := Move anywhere in the same diagonal space
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

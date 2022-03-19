package pieces;

public class Queen extends Piece{
	Queen(String pieceName) {
		super(pieceName);
		// TODO Auto-generated constructor stub
	}

	// Legal Moves:
	//	1) Regular Move := Move same: column, row, or diagonal space.
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

package pieces;

public class King extends Piece{

	public King(String pieceName) {
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	
	
	//Legal moves:
	//	1) Can move one space in any direction
	//	2) Can not be killed, any situation where the king can be captured
	//	   must be fixed, if it can;t be fixed, the user loses the game
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

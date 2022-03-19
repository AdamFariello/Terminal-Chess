package pieces;

//Using name from: https://en.wikipedia.org/wiki/Chess#Movement
public abstract class Piece {
	private String pieceName;
	
	Piece (String pieceName) {
		this.pieceName = pieceName;
	}
	public String getPieceName () {
		return pieceName;
	}
	
	//List of legal moves:
	abstract boolean legalMoves (String startSpace, String endSpace);
	abstract boolean regularMove (String startSpace, String endSpace);
}

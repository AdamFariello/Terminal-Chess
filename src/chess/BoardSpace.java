package chess;

import pieces.Piece;

public class BoardSpace {
	//(piece == null) := empty space
	private Piece piece;
	
	public BoardSpace(Piece piece) {
		this.piece = piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Piece getPiece() {
		return piece;
	}
}
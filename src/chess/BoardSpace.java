/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */
package chess;

import pieces.Piece;

public class BoardSpace {
	//(piece == null) := empty space
	private Piece piece;
	
	/**
	 * Gets piece from Board
	 * @param piece
	 */
	public BoardSpace(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * Sets piece
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * Getter for piece
	 * @return
	 */
	public Piece getPiece() {
		return piece;
	}
}
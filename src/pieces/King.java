/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class King extends Piece {
	private boolean moved;
	
	/**
	 * King constructor
	 * @param pieceName file/rank
	 * @param fileRank file/rank where it will be moved
	 */
	public King(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		moved = false;
	}
	/**
	 * returns moved if true
	 * @return
	 */
	public boolean isMoved() {
		return moved;
	}
	/**
	 * initializes moved to true
	 */
	public void hasMoved() {
		moved = true;
	}
		
	//Legal moves:
	//	1) Regular Move := Can move one space in any direction
	//	2) Castling		:= If the rook and king has not made a move, and 
	//					   there's no pieces in between the two, you can
	//					   move the king piece two pieces and move the rook
	//					   to the other side of the king.
	//					   https://en.wikipedia.org/wiki/Chess#Castling
	@Override
	/*
	 * makes the move list from board. 
	 * adds moves
	 */
	public void setMoveList(BoardSpace[][] board) {
		this.getMoveList().add(regularMove(board));
		this.getMoveList().add(castling(board));
	}

	@Override
	
	/**
	 * list of regular moves able to be made
	 */
	LinkedList<String> regularMove(BoardSpace[][] board) {
		LinkedList<String> moves = new LinkedList<String>();
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		for (int i = position[0] - 1; i < position[0] + 2; i++) {
			for (int j = position[1] - 1; j < position[1] + 2; j++) {
				String temp = checkSpace(board, i, j);
				if (temp != null && (i != position[0] || j != position[1]))
					moves.add(temp);
			}
		}
		
		return moves;
	}
	/**
	 * checks if king can castle or not
	 * @param board
	 * @return
	 */
	LinkedList<String> castling(BoardSpace[][] board) {
		if (moved)
			return null;

		LinkedList<String> moves = new LinkedList<String>();
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		//Left Rook 
		Rook leftRook = (Rook) board[position[0]][position[1] + 3].getPiece();
		if (leftRook.isMoved() == false && 
			board[position[0]][position[1] - 3].getPiece() == null && 
			board[position[0]][position[1] - 2].getPiece() == null &&
			board[position[0]][position[1] - 1].getPiece() == null) {
			
			int[] temp = {position[0], position[1] - 3};
			moves.add(rankFileConversion.ArraytoRankFile(temp));
		}
			
		//Right Rook
		Rook rightRook = (Rook) board[position[0]][position[1] + 3].getPiece();
		if (leftRook.isMoved() == false && 
			board[position[0]][position[1] + 2].getPiece() == null &&
			board[position[0]][position[1] + 1].getPiece() == null) {
			
			int[] temp = {position[0], position[1] + 2};
			moves.add(rankFileConversion.ArraytoRankFile(temp));
		}
		
		return moves;
	}
}
package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class King extends Piece {
	private boolean moved;
	
	public King(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		moved = false;
	}
		
	//Legal moves:
	//	1) Regular Move := Can move one space in any direction
	//	2) Castling		:= If the rook and king has not made a move, and 
	//					   there's no pieces in between the two, you can
	//					   move the king piece two pieces and move the rook
	//					   to the other side of the king.
	//					   https://en.wikipedia.org/wiki/Chess#Castling
	@Override
	public void setMoveList(BoardSpace[][] board) {
		this.getMoveList().add(regularMove(board));
	}

	@Override
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
	
	LinkedList<String> castling(BoardSpace[][] board) {
		if (moved)
			return null;
		
		
		
		return null;
	}
}
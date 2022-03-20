package pieces;

import java.util.LinkedList;

import chess.BoardSpace;

//Castle == Rook == Train
public class Rook extends Piece {
	Rook(String pieceName, String fileRank) {
		super(pieceName, fileRank);
	}

	//List of legal move:
	//	1) Regular Move := Move to a space that's on it's same row or column
	//  Note: The king handles castling, not the rook/Castle/train
	@Override
	void setMoveList(BoardSpace[][] board, String fileRank) {
		// TODO Auto-generated method stub
		this.getMoveList().add(regularMove(board, fileRank));
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board, String fileRank) {
		LinkedList<String> moves = new LinkedList<String>();
		
		//Calculation vertical spaces
		for (int i = 0; i < board.length; i++) {
			
		}
		
		//Calculation horizontal spaces
		for (int i = 0; i < board.length; i++) {
			
		}
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
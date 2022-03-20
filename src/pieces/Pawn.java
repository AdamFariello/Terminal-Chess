package pieces;

import java.util.LinkedList;

import chess.BoardSpace;

public class Pawn extends Piece{
	public Pawn(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}
	
	//List of legal move:
	//	1) Regular Move := Move one space in any point of the game    
	//	2) Speed Move   := Move two spaces in the start of the game   
	//	3) EnPassant    := Capture move left or right of it 
	//					   :first 4 turns
	//  4) Capture      := Take a pawn diagonal to it 
	//	5) Promotion    := Pawn hits end of the board, it gets traded 
	//					   for a: Queen, Rook, Bishop, or a castle
	@Override
	void setMoveList(BoardSpace[][] board, String newfileRank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board, String fileRank) {
		// TODO Auto-generated method stub
		return null;
	}
}

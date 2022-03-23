package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Pawn extends Piece{
	private boolean hasMoved;
	public Pawn(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		hasMoved = false;
	}
	
	public void updateMoved() {
		hasMoved = true;
	}
	public boolean hasMoved() {
		return hasMoved;
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
	public void setMoveList(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		this.getMoveList().add(regularMove(board));
		this.getMoveList().add(EnPassant(board));
	}

	public String checkSpace (BoardSpace[][] board, int x, int y) {
		try {
			//[DEBUG] System.out.printf("Calculating pawn (%d,%d) \n", x, y);
			//[DEBUG] System.out.println("Piece: " +board[x][y].getPiece());
			if (board[x][y].getPiece() == null) {
				int [] temp = {x,y};
				return rankFileConversion.ArraytoRankFile(temp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	public String checkCapture (BoardSpace[][] board, int x, int y) {
		try {
			//Piece piece = board[x][y].getPiece();
			char a = board[x][y].getPiece().getPieceName().charAt(0);
			char b = this.getPieceName().charAt(0);
			if (a != b)
				return board[x][y].getPiece().getFileRank();
		} catch (Exception e) {}
		
		return null;
	}
	
	@Override
	LinkedList<String> regularMove(BoardSpace[][] board) {
		//Will cover:
		//   1) Regular Move
		//   2) Speed Move
		//   3) Capture (Maybe)
		
		LinkedList<String> moves = new LinkedList<String>();
		int[] pos = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		//Black goes down array; +1
		//White goes up   array; -1
		int direction; 
		if (board[pos[0]][pos[1]].getPiece().getPieceName().charAt(0) == 'w')
			direction = -1;
		else
			direction = 1;
		
		//Move
		String temp = checkSpace(board, pos[0] + direction, pos[1]);
		if(temp != null)
			moves.add(temp);
			
		//Speed Move
		if (this.hasMoved() == false) {
			temp = checkSpace(board, pos[0] + (direction * 2), pos[1]);
			if(temp != null)
				moves.add(temp);
		}
		
		//Left Capture
		temp = checkCapture(board, pos[0] + direction, pos[1] - 1);
		if (temp != null)
			moves.add(temp);
		
		//Right Capture
		temp = checkCapture(board, pos[0] + direction, pos[1] + 1);
		if (temp != null)
			moves.add(temp);
		
		return moves;
	}
	
	LinkedList<String> EnPassant(BoardSpace[][] board) {
		
		
		return null;
	}
	
}
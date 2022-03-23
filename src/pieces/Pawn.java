package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Pawn extends Piece{
	private boolean hasMoved, justUsedSpeedMove;
	private int direction;
	public Pawn(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		hasMoved = false;
		justUsedSpeedMove = false;
		
		//Black goes down array; +1
		//White goes up   array; -1
		if (pieceName.charAt(0) == 'w')
			this.direction = -1;
		else
			this.direction = 1;
	}	
		
	public int getDirection() {
		return direction;
	}
	public void setJustUsedSpeedMove(boolean bool) {
		justUsedSpeedMove = bool;
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
		this.getMoveList().add(speedMove(board));
		this.getMoveList().add(EnPassant(board));
	}

	public String checkSpace (BoardSpace[][] board, int x, int y) {
		try {
			//[DEBUG] System.out.printf("Calculating pawn (%d,%d) \n", x, y);
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
		//   2) Capture
		LinkedList<String> moves = new LinkedList<String>();
		int[] pos = rankFileConversion.RankFiletoArray(this.getFileRank());
		pos[0] += direction;
		
		//Move
		String temp = checkSpace(board, pos[0], pos[1]);
		if(temp != null)
			moves.add(temp);
					
		//Left Capture
		temp = checkCapture(board, pos[0], pos[1] - 1);
		if (temp != null)
			moves.add(temp);
		
		//Right Capture
		temp = checkCapture(board, pos[0], pos[1] + 1);
		if (temp != null)
			moves.add(temp);
		
		return moves;
	}
	LinkedList<String> speedMove(BoardSpace[][] board) {
		//Speed Move
		LinkedList<String> moves = new LinkedList<String>();
		int[] pos = rankFileConversion.RankFiletoArray(this.getFileRank());
		pos[0] += (direction * 2);
		
		if (this.hasMoved == false) {
			String temp = checkSpace(board, pos[0], pos[1]);
			temp = checkSpace(board, pos[0], pos[1]);
			if(temp != null)
				moves.add(temp);
		}
		
		return moves;
	}	

	LinkedList<String> EnPassant(BoardSpace[][] board) {
		//Limits:
		//   1) turn players 3 ranks away exactly to 
		//      accomplish
		//	 2) opponent must move piece two spaces on 1 turn
		//	 3) Must make the move immedetly after
		LinkedList<String> moves = new LinkedList<String>();
		int[] pos = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		//Left Piece
		Pawn pawn = (Pawn) board[pos[0]][pos[1] - 1].getPiece();
		int i = (this.getFileRank().charAt(1) - '0') + (direction*3);
		if (pawn != null &&
			pawn.justUsedSpeedMove == true && (i == 7 || i == 2) && 
			pawn.getPieceName().charAt(0) != this.getPieceName().charAt(0)) {
			int [] temp = {pos[0] + direction, pos[1] - 1};
			moves.add(rankFileConversion.ArraytoRankFile(temp));
		}
		
		//Right Piece
		pawn = (Pawn) board[pos[0]][pos[1] + 1].getPiece();
		i = (this.getFileRank().charAt(1) - '0') + (direction*3);
		if (pawn != null &&
			pawn.justUsedSpeedMove == true && (i == 7 || i == 2) &&
			pawn.getPieceName().charAt(0) != this.getPieceName().charAt(0)) {
			int [] temp = {pos[0] + direction, pos[1] + 1};
			moves.add(rankFileConversion.ArraytoRankFile(temp));
		}
		
		return moves;
	}
	
}
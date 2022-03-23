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
	}

	public String checkSpace (BoardSpace[][] board, int x, int y, int direction) {
		//[DEBUG] System.out.printf("Calculating (%d,%d) \n", x, y);
		//Checks if the variables are in bound
		if (x >= board.length || x < 0 || y >= board.length || y < 0) {
			//Got tired of long looking code
			Piece piece = board[x][y].getPiece();
			char a = piece.getPieceName().charAt(0);
			char b = this.getPieceName().charAt(0);
			
			//Checks for: 
			//   1) Empty Space
			//   2) Diagonal Space has enemy
			if (piece == null || (piece != null && a != b)){
				int [] temp = {x, y};
				return rankFileConversion.ArraytoRankFile(temp);
			}
		}
		
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
		
		//Capture
		String temp = checkSpace(board, pos[0] + direction, pos[1]);
		if(temp != null)
			moves.add(temp);
			
		//Speed Capture
		if (!this.hasMoved()) {
			temp = checkSpace(board, pos[0] + (direction * 2), pos[1]);
			if(temp != null)
				moves.add(temp);
		}
		
		//Capture
		/*
		x += direction;
		Piece leftPiece  = board[x][y + (direction * -1)].getPiece();
		Piece rightPiece = board[x][y + direction].getPiece();
		*/
		
		/*
		if(color == 'w'){
			//System.out.print("Space in front of pawn a4: ");
			//System.out.println(board[position[0]-1][position[1]].getPiece().getPieceName().charAt(0));
			//v --  prevents from pawn being able to take the other pawn right in front of it
			if(position[0]<6){//|| board[position[0]-1][position[1]].getPiece().getPieceName().charAt(0)!='b' && board[position[0]-1][position[1]].getPiece().getPieceName().charAt(0)!='w') {
				//can only move one spot
			for(int i = position[0]-1; i>position[0]-2; i--){
				String temp = checkSpace(board, i, position[1]);
				if(temp !=null) {
					if(Character.isUpperCase(temp.charAt(0))==true) {
						moves.add(temp.toLowerCase());
						//moved = true;
						break;
					}
					else {
						moves.add(temp);
					}
				}
				else {
					break;
				}
			}
		}
			if(position[0]==6){// || board[position[0]-1][position[1]].getPiece().getPieceName().charAt(0)!='b' && board[position[0]-1][position[1]].getPiece().getPieceName().charAt(0)!='w') {
			//can move two spots
			for(int i = position[0]-1; i>position[0]-3; i--) {
				String temp = checkSpace(board, i, position[1]);
				if(temp!=null) {
					if(Character.isUpperCase(temp.charAt(0))==true) {
						moves.add(temp.toLowerCase());
						break;
					}
					else {
						moves.add(temp);
					}
				}
				else {
					break;
					}
				}
		}
		//check if pawn can be captured
		
			
	} //bracket of if white statement
		//if color is black
		if(color == 'b') {
			if(position[0]>1 && position[0]<6 && board[position[0]+1][position[1]].getPiece().getPieceName().charAt(0)!='b' && board[position[0]+1][position[1]].getPiece().getPieceName().charAt(0)!='w') {
				//can only move one spot
			for(int i = position[0]+1; i<position[0]+2; i++){
				String temp = checkSpace(board, i, position[1]);
				if(temp !=null) {
					if(Character.isUpperCase(temp.charAt(0))==true) {
						moves.add(temp.toLowerCase());
						//moved = true;
						break;
					}
					else {
						moves.add(temp);
					}
				}
				else {
					break;
				}
			}
		}
		if(position[0]==1 && position[0]<6 && board[position[0]+1][position[1]].getPiece().getPieceName().charAt(0)!='b' && board[position[0]+1][position[1]].getPiece().getPieceName().charAt(0)!='w') {
			//can move two spots
			//i = 2, i<4; i++
			for(int i = position[0]+1; i<position[0]+3; i++) {
				String temp = checkSpace(board, i, position[1]);
				if(temp!=null) {
					if(Character.isUpperCase(temp.charAt(0))==true) {
						moves.add(temp.toLowerCase());
						break;
					}
					else {
						moves.add(temp);
					}
				}
				else {
					break;
					}
				}
			}
		//example: 4,3 (row, column) = d4
		//enemy on diagonals 
		} //end of if black color
		*/
		
		return moves;
	}
	
	LinkedList<String> EnPassant() {
		return null;
	}
	
	LinkedList<String> promotion(BoardSpace[][] board) {
		//Not actually sure if this'll be a method...
		return null;
	}
}
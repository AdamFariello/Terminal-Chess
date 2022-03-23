package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Pawn extends Piece{

	
	boolean moved = false;
	
	public Pawn(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}
	String temp = getPieceName();
	char color = temp.charAt(0);
	

	@Override
	public void setMoveList(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		this.getMoveList().add(regularMove(board));
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		
		LinkedList<String> moves = new LinkedList<String>();
		int[] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		System.out.println("");
		System.out.println("Hello");
		for(int i = 0; i<position.length; i++)
		{
			System.out.println(position[i]);
		}
		
		System.out.println(this.getFileRank());
		
		if(color == 'w'){
			if(position[0]<6) {
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
		if(position[0]==6) {
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
			
	} //bracket of if white statement
		//if color is black
		if(color == 'b') {
			if(position[0]>1) {
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
		if(position[0]==1) {
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
		}
		
		
		if(moves.isEmpty()) return null;
		else return moves;
	}

	
	/*public boolean hasMoved()
	{
		moved = true;
		return moved;
	}*/
		
	//List of legal move:
	//	1) Regular Move := Move one space in any point of the game    
	//	2) Speed Move   := Move two spaces in the start of the game   
	//	3) EnPassant    := Capture move left or right of it 
	//					   :first 4 turns
	//  4) Capture      := Take a pawn diagonal to it 
	//	5) Promotion    := Pawn hits end of the board, it gets traded 
	//					   for a: Queen, Rook, Bishop, or a castle

}

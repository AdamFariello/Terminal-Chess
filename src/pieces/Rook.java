package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

//Castle == Rook == Train
public class Rook extends Piece {
	public Rook(String pieceName, String fileRank) {
		super(pieceName, fileRank);
	}

	//List of legal move:
	//	1) Regular Move := Move to a space that's on it's same row or column
	//  Note: The king handles castling, not the rook/Castle/train
	@Override
	public void setMoveList(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		this.getMoveList().add(regularMove(board));
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board) {
		LinkedList<String> moves = new LinkedList<String>();
		
		//(vertical, horizontal)
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		/*Calculation vertical spaces*/
		//Going Up
		//the "-1" is to skip checking the same space the piece it's on
<<<<<<< HEAD
		/*
		for (int i = position[0] - 1; i > -1; i--) {
			System.out.printf("Calculating (%d,%d) ", i, position[1]);
			if (board[i][position[1]].getPiece() == null) {
				//Blank Space, free spot
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
			} else if (board[i][position[1]].getPiece() != null && 
					   board[i][position[1]].getPiece().getPieceName().charAt(0) != 
					   this.getPieceName().charAt(0)) {
				//Space is an enemy spot, can take, but can't go beyond
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
				break;
			} else {
				//Friendly piece detected, can't move there or anywhere else
				break;
<<<<<<< HEAD
			}
		}
		System.out.print("\n");
		*/
		for (int i = position[0] - 1; i > -1; i--) {
			String temp = checkSpace(board, i, position[1]);
			if (temp != null) {
				if (Character.isUpperCase(temp.charAt(0)) == true) {
					moves.add(temp.toLowerCase());
					break;
				} else {
					moves.add(temp);
				}
			} else { 
=======
			}
		}
		System.out.print("\n");
		*/
=======
>>>>>>> a99e845 (go through)
		for (int i = position[0] - 1; i > -1; i--) {
			String temp = checkSpace(board, i, position[1]);
			if (temp != null) {
				if (Character.isUpperCase(temp.charAt(0)) == true) {
					moves.add(temp.toLowerCase());
					break;
				} else {
					moves.add(temp);
				}
			} else { 
				break;
			}
		}
		System.out.print("\n");
		
		//Going Down
		//the "+ 1" is to skip checking the same space the piece it's on
		for (int i = position[0] + 1; i < 8; i++) {
			System.out.printf("Calculating (%d,%d) ", i, position[1]);
			if (board[i][position[1]].getPiece() == null) {
				//Blank Space, free spot
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
			} else if (board[i][position[1]].getPiece() != null && 
					   board[i][position[1]].getPiece().getPieceName().charAt(0) != 
					   this.getPieceName().charAt(0)) {
				//Space is an enemy spot, can take, but can't go beyond
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
				break;
			} else {
				//Friendly piece detected, can't move there or anywhere else
>>>>>>> 341b3af (Updated: Piece to have a method to handle space legality)
				break;
			}
		}
		System.out.print("\n");
		
<<<<<<< HEAD
		//Going Down
		//the "+ 1" is to skip checking the same space the piece it's on
		for (int i = position[0] + 1; i < 8; i++) {
			System.out.printf("Calculating (%d,%d) ", i, position[1]);
			if (board[i][position[1]].getPiece() == null) {
				//Blank Space, free spot
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
			} else if (board[i][position[1]].getPiece() != null && 
					   board[i][position[1]].getPiece().getPieceName().charAt(0) != 
					   this.getPieceName().charAt(0)) {
				//Space is an enemy spot, can take, but can't go beyond
				int [] temp = {i, position[1]};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
				break;
			} else {
				//Friendly piece detected, can't move there or anywhere else
				break;
			}
		}
		System.out.print("\n");
		
=======
>>>>>>> 341b3af (Updated: Piece to have a method to handle space legality)
		/*Calculation horizontal spaces*/
		//Left 
		for (int i = position[1] - 1; i > -1; i--) {
			System.out.printf("Calculating (%d,%d) ", position[1], i);
			if (board[position[1]][i].getPiece() == null) {
				//Blank Space, free spot
				int [] temp = {position[1], i};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
			} else if (board[position[1]][i].getPiece() != null && 
					   board[position[1]][i].getPiece().getPieceName().charAt(0) != 
					   this.getPieceName().charAt(0)) {
				//Space is an enemy spot, can take, but can't go beyond
				int [] temp = {position[1],i};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
				break;
			} else {
				//Friendly piece detected, can't move there or anywhere else
				break;
			}
		}
		System.out.print("\n");
		
		//Right 
		for (int i = position[1] + 1; i < board.length; i++) {
			System.out.printf("Calculating (%d,%d) ", position[1], i);
			if (board[position[1]][i].getPiece() == null) {
				//Blank Space, free spot
				int [] temp = {position[1], i};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
			} else if (board[position[1]][i].getPiece() != null && 
					   board[position[1]][i].getPiece().getPieceName().charAt(0) != 
					   this.getPieceName().charAt(0)) {
				//Space is an enemy spot, can take, but can't go beyond
				int [] temp = {position[1],i};
				moves.add(rankFileConversion.ArraytoRankFile(temp));
				break;
			} else {
				//Friendly piece detected, can't move there or anywhere else
				break;
			}
		}
		System.out.print("\n");
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
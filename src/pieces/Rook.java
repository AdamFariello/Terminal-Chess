package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

//Castle == Rook == Train
public class Rook extends Piece {
	private boolean moved;
	public Rook(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		moved = false;
	}

	public boolean isMoved() {
		return moved;
	}
	public void hasMoved() {
		moved = true;
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
		
		//Going Down
		//the "+ 1" is to skip checking the same space the piece it's on
		for (int i = position[0] + 1; i < board.length; i++) {
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
		
		/*Calculation horizontal spaces*/
		//Left 
		for (int i = position[1] - 1; i > -1; i--) {
			String temp = checkSpace(board, position[1], i);
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
		
		//Right 		
		for (int i = position[1] + 1; i < board.length; i++) {
			String temp = checkSpace(board, position[1], i);
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
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
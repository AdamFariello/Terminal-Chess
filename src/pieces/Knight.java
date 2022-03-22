package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Knight extends Piece{

	public Knight(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}
	
	// Legal Moves:
	// 	1) Regular Move := Move 2 spaces in the same column then 
	// 					   move 1 space in the same row, and vice-versa
	@Override
	public void setMoveList(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		this.getMoveList().add(regularMove(board));
	}

	@Override
	LinkedList<String> regularMove(BoardSpace[][] board) {
		LinkedList<String> moves = new LinkedList<String>();
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());
		
		//Top and Bottom
		for (int i = position[0] - 2; i < position[0] + 4; i += 4) {
			for (int j = position[1] - 1; j < position[1] + 2; j += 2) {
				System.out.printf("test (%d,%d)\n", i,j);
				String temp = checkSpace(board, i, j);
				if (temp != null) {
					if (Character.isUpperCase(temp.charAt(0)) == true) {
						moves.add(temp.toLowerCase());
					} else {
						moves.add(temp);
					}
				} else { 
					break;
				}
			}
		}
		
		//Left and Right
		for (int i = position[0] - 1; i < position[0] + 2; i += 2) {
			for (int j = position[1] - 2; j < position[1] + 4; j += 4) {
				String temp = checkSpace(board, i, j);
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
		}
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
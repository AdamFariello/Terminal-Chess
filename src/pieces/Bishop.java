/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */


package pieces;

import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

public class Bishop extends Piece{
	
	/**
	 * bishop constructor
	 * @param pieceName file/rank of piece
	 * @param fileRank where piece will move to
	 */
	public Bishop(String pieceName, String fileRank) {
		super(pieceName, fileRank);
		// TODO Auto-generated constructor stub
	}

	// Legal Moves:
	// 	1) Regular Move := Move anywhere in the same diagonal space
	@Override
	/**
	 * sets moves to list
	 */
	public void setMoveList(BoardSpace[][] board) {
		this.getMoveList().add(regularMove(board));
	}

	@Override
	/**
	 * list of regular moves
	 */
	LinkedList<String> regularMove(BoardSpace[][] board) {
		// TODO Auto-generated method stub
		LinkedList<String> moves = new LinkedList<String>();
		int [] position = rankFileConversion.RankFiletoArray(this.getFileRank());

		//Going up right
		for (int i = position[0] - 1, j = position[1] + 1; 
				 i > -1 && j < board.length; i--, j++) {
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
		
		//Going up left
		for (int i = position[0] - 1, j = position[1] - 1; 
				 i > -1 && j > -1; i--, j--) {
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
		
		//Going down right		
		for (int i = position[0] + 1, j = position[1] + 1; 
				 i < board.length && j < board.length; i++, j++) {
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
		
		//Going down left		
		for (int i = position[0] + 1, j = position[1] - 1; 
				 i < board.length && j < board.length; i++, j--) {
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
		
		if (moves.isEmpty()) return null;
		else return moves;
	}
}
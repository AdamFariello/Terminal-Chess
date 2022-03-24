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

//Using name from: https://en.wikipedia.org/wiki/Chess#Movement
public abstract class Piece {
	public static Object getPieceName;

	private String pieceName, fileRank;
	
	//Multi-list of spaces that a piece can be placed
	//according to each move the piece can make. 
	//If there is no space all moves will be null. 
	private LinkedList<LinkedList <String>> moveList;
	
	/**
	 * constructor for general piece
	 * @param pieceName rank/file
	 * @param fileRank rank/file where piece will go
	 */
	public Piece (String pieceName, String fileRank) {
		this.pieceName = pieceName;
		this.fileRank  = fileRank;
		moveList 	   = new LinkedList<LinkedList<String>>();
	}
	
	/**
	 * Sets the file rank (where piece will be put)
	 * @param fileRank
	 */
	public void setFileRank(String fileRank) {
		this.fileRank = fileRank;
	}

	/**
	 * creates move list
	 * @param board
	 */
	public abstract void setMoveList (BoardSpace [][] board);
	
	/**
	 * resets move list
	 * @param board
	 */
	public void prepareMoveList(BoardSpace[][] board) {
        this.getMoveList().clear();
        setMoveList(board);
    }
	
	/**
	 * Checks the space where it will go
	 * Avoids going out of bounds
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	public String checkSpace (BoardSpace[][] board, int x, int y) {
		//[DEBUG] System.out.printf("Calculating (%d,%d) \n", x, y);
		
		//Checks if the variables are in bound
		if (x >= board.length || x < 0 || y >= board.length || y < 0)
			return null;
		
		//Checks for:
		//   1) Empty space
		//   2) Space with enemy piece
		//	 3) Space with friendly piece (return null)
		if (board[x][y].getPiece() == null) {
			int [] temp = {x, y};
			return rankFileConversion.ArraytoRankFile(temp);
		} else if (board[x][y].getPiece() != null && 
				   board[x][y].getPiece().getPieceName().charAt(0) != 
				   this.getPieceName().charAt(0)) {
			int [] temp = {x, y};
			return rankFileConversion.ArraytoRankFile(temp).toUpperCase();
		} else {
			return null;
		}
	}
	abstract LinkedList<String> regularMove (BoardSpace [][] board);
	
	/**
	 * getter for piece name
	 * @return
	 */
	public String getPieceName () {
		return pieceName;
	}
	
	/**
	 * getter for file Rank
	 * @return
	 */
	public String getFileRank() {
		return fileRank;
	}
	
	/**
	 * Gets the move list of piece
	 * @return
	 */
	public LinkedList<LinkedList<String>> getMoveList() {
		return moveList;
	}
	
	/**
	 * Checks if there is a valid move in the move list. 
	 * @param fileRank
	 * @return Returns false if input is not in the move list
	 */
	public boolean contains(String fileRank) {
		for (int i = 0; i < this.moveList.size(); i++)
			if (this.moveList.get(i).contains(fileRank))
				return true;
			
		return false;
	}

}
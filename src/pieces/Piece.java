package pieces;
import java.util.LinkedList;

import chess.BoardSpace;
import chess.rankFileConversion;

//Using name from: https://en.wikipedia.org/wiki/Chess#Movement
public abstract class Piece {
	private String pieceName, fileRank;
	
	//Multi-list of spaces that a piece can be placed
	//according to each move the piece can make. 
	//If there is no space all moves will be null. 
	private LinkedList<LinkedList <String>> moveList;
	
	public Piece (String pieceName, String fileRank) {
		this.pieceName = pieceName;
		this.fileRank  = fileRank;
		moveList 	   = new LinkedList<LinkedList<String>>();
	}
	
	//Setting Variables
	public void setFileRank(String fileRank) {
		this.fileRank = fileRank;
	}
	public void prepareMoveList(BoardSpace[][] board) {
		this.getMoveList().clear();
		setMoveList(board);
	}
	public abstract void setMoveList (BoardSpace [][] board);
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
	
	//Get methods
	public String getPieceName () {
		return pieceName;
	}
	public String getFileRank() {
		return fileRank;
	}
	public LinkedList<LinkedList<String>> getMoveList() {
		return moveList;
	}
	
	//check
	public boolean contains(String fileRank) {
		for (int i = 0; i < this.moveList.size(); i++)
			if (this.moveList.get(i).contains(fileRank))
				return true;
			
		return false;
	}

}
package pieces;
import java.util.LinkedList;

import chess.BoardSpace;

//Using name from: https://en.wikipedia.org/wiki/Chess#Movement
public abstract class Piece {
	private String pieceName, fileRank;
	
	//Multi-list of spaces that a piece can be placed
	//according to each move the piece can make. 
	//If there is no space all moves will be null. 
	private LinkedList<LinkedList <String>> moveList;
	
	Piece (String pieceName, String fileRank) {
		this.pieceName = pieceName;
		this.fileRank  = fileRank;
		moveList 	   = new LinkedList<LinkedList<String>>();
	}
	
	//Setting Variables
	public void setFileRank(String fileRank) {
		this.fileRank = fileRank;
	}
	abstract void setMoveList (BoardSpace [][] board, String newfileRank);
	abstract LinkedList<String> regularMove (BoardSpace [][] board, String fileRank);
	
	//Getting variables
	public String getPieceName () {
		return pieceName;
	}
	public String getfileRank() {
		return fileRank;
	}
	public LinkedList<LinkedList<String>> getMoveList() {
		return moveList;
	}
}
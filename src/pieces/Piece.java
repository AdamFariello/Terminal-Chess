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
	public abstract void setMoveList (BoardSpace [][] board);
	public String checkSpace (BoardSpace[][] board, int x, int y) {
		//This combines regular move and capture, pawn will override this
		//[DEBUG] System.out.printf("Calculating (%d,%d) ", x, y);
		if (board[x][y].getPiece() == null) {
			//Blank Space, free spot
			int [] temp = {x, y};
			return rankFileConversion.ArraytoRankFile(temp);
			
		} else if (board[x][y].getPiece() != null && 
				   board[x][y].getPiece().getPieceName().charAt(0) != 
				   this.getPieceName().charAt(0)) {
			//Space is not empty
			//and the space is occupied by a enemy piece
			int [] temp = {x, y};
			return rankFileConversion.ArraytoRankFile(temp).toUpperCase();
			
		} else {
			return null;
		}
	}
	abstract LinkedList<String> regularMove (BoardSpace [][] board);
	
	//Getting variables
	public String getPieceName () {
		return pieceName;
	}
	public String getFileRank() {
		return fileRank;
	}
	public LinkedList<LinkedList<String>> getMoveList() {
		return moveList;
	}
	
	//toString
	public void printMoveList() {
		for (int i = 0; i < moveList.size(); i++) {
			System.out.printf("MoveList %d: ", i);
			if (moveList.get(i) == null)
				for (int j = 0; j < moveList.get(i).size(); j++)
					System.out.print(moveList.get(i).get(j) + ", ");
			else
				System.out.print("empty");
			System.out.print("\n");
		}
	}
}
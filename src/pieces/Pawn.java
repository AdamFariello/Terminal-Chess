package pieces;

public class Pawn extends Piece{
	public Pawn(String pieceName) {
		super(pieceName);
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
	boolean legalMoves(String startSpace, String endSpace) {
		if (regularMove(startSpace, endSpace))
			return true;
		return false;
	}

	@Override
	boolean regularMove(String startSpace, String endSpace) {
		//Debug
		System.out.println("Pawn's LegalMoves");
		System.out.println(this.getPieceName() + " legalName");
		
		//Checking
		int difference = (startSpace.charAt(1) - '0') - (endSpace.charAt(1) - '0');
		if (difference == 1 || difference == -1)
			return true;
		return false;
	}
}

package chess;

public class rankFileConversion {
	private static final String file = "abcdefgh";
	private static final String rank = "87654321";
	
	public static int[] RankFiletoArray (String fileRank) {
		//String[0] := File
		//String[1] := Rank
		//e6 -> [6, e] -> [2,4]
		return new int[] {
			rank.indexOf(fileRank.charAt(1)),
			file.indexOf(fileRank.charAt(0))
		};
	}
	
	public static String ArraytoRankFile (int [] fileRank) {
		//int [1] := Rank
		//int [0] := File 
		//[2,4] -> [4,2] -> e6
		return "" + file.charAt(fileRank[1]) + rank.charAt(fileRank[0]);
	}
}
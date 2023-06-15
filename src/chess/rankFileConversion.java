/**
 * 
 * @author Edison Flores
 * @author Adam Fariello
 * 
 */

package chess;
public class rankFileConversion {
	
	private static final String file = "abcdefgh";
	private static final String rank = "87654321";
	/**
	 * Converts Rank/File to an array
	 * String[0] := File
	 * String[1] := Rank
	 * e6 -> [6, e] -> [2,4]
	 * @param fileRank
	 * @return
	 */
	public static int[] RankFiletoArray (String fileRank) {
		return new int[] {
			rank.indexOf(fileRank.charAt(1)),
			file.indexOf(fileRank.charAt(0))
		};
	}
	
	/**
	 * Converts Array to Rank/File
	 * int [1] := Rank
	 * int [0] := File 
	 * [2,4] -> [4,2] -> e6
	 * @param fileRank
	 * @return
	 */
	public static String ArraytoRankFile (int [] fileRank) {
		return "" + file.charAt(fileRank[1]) + rank.charAt(fileRank[0]);
	}
}
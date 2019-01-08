import java.util.ArrayList;

public abstract class Piece {
	boolean isWhite;
	String pieceName;
	int x;
	int y;
	
	/**
	 * Returns an arraylist with all possible legal moves of the piece
	 * @param board
	 * @return Arraylist LegalMoves
	 */
	public abstract ArrayList<String> getLegalMoves(Square[][] board);
	
	public abstract ArrayList<String> getAttackingSquares(Square[][] board);
}

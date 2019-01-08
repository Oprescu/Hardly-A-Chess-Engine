import java.util.ArrayList;

public abstract class Piece {
	boolean isWhite;
	String pieceName;
	int x;
	int y;
	
	public abstract ArrayList<String> getLegalMoves(Square[][] board);
	
	public abstract ArrayList<String> getAttackingSquares(Square[][] board);
}

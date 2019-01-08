import java.util.ArrayList;

public abstract class Piece {
	boolean isWhite;
	String pieceName;
	
	public abstract ArrayList<String> getLegalMoves();
	
	public abstract ArrayList<String> getAttackingSquares();
}

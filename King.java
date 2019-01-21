import java.util.ArrayList;

public class King extends Piece implements CoordinateLookupTable{

	public King(boolean isWhite,int x, int y) {
		pieceName="King";
		this.isWhite=isWhite;
		this.x=x;
		this.y=y;
	}
	
	@Override
	public ArrayList<String> getLegalMoves(Square[][] board) {
		ArrayList<String> legalMoves = new ArrayList<String>();
		if(x+1<8)
			if(board[x+1][y].isEmpty())
				legalMoves.add(board[x+1][y].name);
			else {
				if(board[x+1][y].piece.isWhite!=isWhite)
				legalMoves.add(board[x+1][y].name);
			}
		if(x-1>=0)
			if(board[x-1][y].isEmpty())
				legalMoves.add(board[x-1][y].name);
			else {
				if(board[x-1][y].piece.isWhite!=isWhite)
				legalMoves.add(board[x-1][y].name);
			}
		if(y+1<8)
			if(board[x][y+1].isEmpty())
				legalMoves.add(board[x][y+1].name);
			else {
				if(board[x][y+1].piece.isWhite!=isWhite)
				legalMoves.add(board[x][y+1].name);
			}
		if(y-1>=0)
			if(board[x][y-1].isEmpty())
				legalMoves.add(board[x][y-1].name);
			else {
				if(board[x][y-1].piece.isWhite!=isWhite)
				legalMoves.add(board[x][y-1].name);
			}
		if((y-1>=0)&&(x-1>=0))
			if(board[x-1][y-1].isEmpty())
				legalMoves.add(board[x-1][y-1].name);
			else {
				if(board[x-1][y-1].piece.isWhite!=isWhite)
				legalMoves.add(board[x-1][y-1].name);
			}
		if((y+1<8)&&(x+1<8))
			if(board[x+1][y+1].isEmpty())
				legalMoves.add(board[x+1][y+1].name);
			else {
				if(board[x+1][y+1].piece.isWhite!=isWhite)
				legalMoves.add(board[x+1][y+1].name);
			}
		if((x+1<8)&&(y-1>=0))
			if(board[x+1][y-1].isEmpty())
				legalMoves.add(board[x+1][y-1].name);
			else {
				if(board[x+1][y-1].piece.isWhite!=isWhite)
				legalMoves.add(board[x+1][y-1].name);
			}
		if((x-1>=0)&&(y+1<8))
			if(board[x-1][y+1].isEmpty())
				legalMoves.add(board[x-1][y+1].name);
			else {
				if(board[x-1][y+1].piece.isWhite!=isWhite)
				legalMoves.add(board[x-1][y+1].name);
			}
		return legalMoves;
	}

	@Override
	public ArrayList<String> getAttackingSquares(Square[][] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	boolean inCheck() {
		return false;
	}

}

import java.util.ArrayList;

public class Pawn extends Piece implements CoordinateLookupTable{
	
	
	public static int counter=1;
	
	public Pawn(boolean isWhite,int x, int y) {
		pieceName="Pawn "+ counter;
		counter++;
		this.isWhite=isWhite;
		this.x=x;
		this.y=y;
	}
	
	
	@Override
	public ArrayList<String> getLegalMoves(Square[][] board) {
		ArrayList<String> legalMoves = new ArrayList<String>();
		
		if(isWhite) {
			if(board[x][y+1].isEmpty()) {
				legalMoves.add(board[x][y+1].name);
			}
			if(board[x][y+2].isEmpty()&&moveNr==0) {
				legalMoves.add(board[x][y+2].name);
			}
			if((x>0)&&(!board[x-1][y+1].isEmpty()))
				if(board[x-1][y+1].piece.isWhite!=isWhite)
					legalMoves.add(board[x-1][y+1].name);
			if((x<7)&&(!board[x+1][y+1].isEmpty()))
				if(board[x+1][y+1].piece.isWhite!=isWhite)
					legalMoves.add(board[x+1][y+1].name);
		}
		else {
			if(board[x][y-1].isEmpty()) {
				legalMoves.add(board[x][y-1].name);
			}
			if(board[x][y-2].isEmpty()&&moveNr==0) {
				legalMoves.add(board[x][y-2].name);
			}
			if((x>0)&&(!board[x-1][y-1].isEmpty()))
				if(board[x-1][y-1].piece.isWhite!=isWhite)
					legalMoves.add(board[x-1][y-1].name);
			if((x<7)&&(!board[x+1][y-1].isEmpty()))
				if(board[x+1][y-1].piece.isWhite!=isWhite)
					legalMoves.add(board[x+1][y-1].name);
		}
		return legalMoves;
	}

	@Override
	public ArrayList<String> getAttackingSquares(Square[][] board) {
		// TODO Auto-generated method stub
		return null;
	}

}

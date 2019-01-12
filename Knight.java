import java.util.ArrayList;

public class Knight extends Piece implements CoordinateLookupTable{

	public static int counter=1;
	
	public Knight(boolean isWhite,int x, int y) {
		pieceName="Knight " + counter;
		counter++;
		this.isWhite=isWhite;
		this.x=x;
		this.y=y;
	}
		
	@Override
	public ArrayList<String> getLegalMoves(Square[][] board) {
		ArrayList<String> legalMoves = new ArrayList<String>();
		if((x+1<8)&&(y+2<8)&&((board[x+1][y+2].isEmpty())||(board[x+1][y+2].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x+1][y+2].name);
		}
		if((x-1>0)&&(y+2<8)&&((board[x-1][y+2].isEmpty())||(board[x-1][y+2].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x-1][y+2].name);
		}
		if((x+1<8)&&(y-2>=0)&&((board[x+1][y-2].isEmpty())||(board[x+1][y-2].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x+1][y-2].name);
		}
		if((x-1>=0)&&(y-2>=0)&&((board[x-1][y-2].isEmpty())||(board[x-1][y-2].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x-1][y-2].name);
		}
		if((x+2<8)&&(y+1<8)&&((board[x+2][y+1].isEmpty())||(board[x+2][y+1].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x+2][y+1].name);
		}
		if((x-2>=0)&&(y+1<8)&&((board[x-2][y+1].isEmpty())||(board[x-2][y+1].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x-2][y+1].name);
		}
		if((x+2<8)&&(y-1>=0)&&((board[x+2][y-1].isEmpty())||(board[x+2][y-1].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x+2][y-1].name);
		}
		if((x-2>=0)&&(y-1>=0)&&((board[x-2][y-1].isEmpty())||(board[x-2][y-1].piece.isWhite!=isWhite))) {
			legalMoves.add(board[x-2][y-1].name);
		}
		return legalMoves;
	}

	@Override
	public ArrayList<String> getAttackingSquares(Square[][] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

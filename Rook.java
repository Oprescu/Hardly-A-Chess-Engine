import java.util.ArrayList;
public class Rook extends Piece implements CoordinateLookupTable{
	
	public static int counter=1;
	
	public Rook(boolean isWhite,int x, int y) {
		pieceName="Rook " + counter;
		counter++;
		this.isWhite=isWhite;
		this.x=x;
		this.y=y;
	}
	
	@Override
	public ArrayList<String> getLegalMoves(Square[][] board) {
		int x;
		int y=this.y;
		ArrayList<String> legalMoves = new ArrayList<String>();
		//Check the x axis going right for legal moves
		for(x=this.x+1;x<=7;x++) {
			if(board[x][y].isEmpty()) {
				legalMoves.add(board[x][y].name);
			}
			else {
				legalMoves.add(board[x][y].name);
				break;
			}
		}
		//Check the x axis going left for legal moves
				for(x=this.x-1;x>=0;x--) {
					if(board[x][y].isEmpty()) {
						legalMoves.add(board[x][y].name);
					}
					else {
						legalMoves.add(board[x][y].name);
						break;
					}
				}
		//Check the Y axis going up for legal moves
		x=this.x; //reset x
				for(y=this.y+1;y<=7;y++) {
					if(board[x][y].isEmpty()) {
						legalMoves.add(board[x][y].name);
					}
					else {
						legalMoves.add(board[x][y].name);
						break;
					}
				}
		//Check the y axis going down for legal moves
				for(y=this.y-1;y>=0;y--) {
					if(board[x][y].isEmpty()) {
						legalMoves.add(board[x][y].name);
					}
					else {
						legalMoves.add(board[x][y].name);
						break;
					}
				}

		return legalMoves;
	}

	@Override
	public ArrayList<String> getAttackingSquares(Square[][] board) {
		// TODO Auto-generated method stub
		return null;
	}

}

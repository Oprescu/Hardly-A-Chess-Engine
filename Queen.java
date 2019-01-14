import java.util.ArrayList;

public class Queen extends Piece implements CoordinateLookupTable{
	
	public Queen(boolean isWhite,int x, int y) {
		pieceName="Queen";
		this.isWhite=isWhite;
		this.x=x;
		this.y=y;
	}
	
	@Override
	public ArrayList<String> getLegalMoves(Square[][] board) {
		ArrayList<String> legalMoves = new ArrayList<String>();
		//Check the
		//x axis going right for legal moves
		for(int i=1;x+i<8;i++) {
			if(board[x+i][y].isEmpty())
				legalMoves.add(board[x+i][y].name);
			else {
				if (board[x+i][y].piece.isWhite!=isWhite)
					legalMoves.add(board[x+i][y].name);
				break;
			}
		}
		//Check the x axis going left for legal moves
		for(int i=1;x-i>=0;i++) {
			if(board[x-i][y].isEmpty())
				legalMoves.add(board[x-i][y].name);
			else {
				if (board[x-i][y].piece.isWhite!=isWhite)
					legalMoves.add(board[x-i][y].name);
				break;
			}
		}
		//Check the y axis going up for legal moves
		for(int i=1;y+i<8;i++) {
			if(board[x][y+i].isEmpty())
				legalMoves.add(board[x][y+i].name);
			else {
				if (board[x][y+i].piece.isWhite!=isWhite)
					legalMoves.add(board[x][y+i].name);
				break;
			}
		}
		//Check the y axis going down for legal moves
		for(int i=1;y-i>=0;i++) {
			if(board[x][y-i].isEmpty())
				legalMoves.add(board[x][y-i].name);
			else {
				if (board[x][y-i].piece.isWhite!=isWhite)
					legalMoves.add(board[x][y-i].name);
				break;
			}
		}
		//Check the
		//x,y axis going right and up for legal moves
		for(int i=1;((x+i<8)&&(y+i<8));i++) {
			if(board[x+i][y+i].isEmpty())
				legalMoves.add(board[x+i][y+i].name);
			else {
				if(board[x+i][y+i].piece.isWhite!=isWhite)
					legalMoves.add(board[x+i][y+i].name);
				break;
			}
		}
		//Check the x,y axis going left and up for legal moves
		for(int i=1;((x-i>=0)&&(y+i<8));i++) {
			if(board[x-i][y+i].isEmpty())
				legalMoves.add(board[x-i][y+i].name);
			else { 
				if(board[x-i][y+i].piece.isWhite!=isWhite)
					legalMoves.add(board[x-i][y+i].name);
				break;				}
			}
		//Check the x,y axis going left and down for legal moves
		for(int i=1;((x-i>=0)&&(y-i>=0));i++) {
			if(board[x-i][y-i].isEmpty())
				legalMoves.add(board[x-i][y-i].name);
			else{
				if(board[x-i][y-i].piece.isWhite!=isWhite)
					legalMoves.add(board[x-i][y-i].name);
				break;
			}
		}
		//Check the x,y axis going right and down for legal moves
		for(int i=1;((x+i<8)&&(y-i>=0));i++) {
			if(board[x+i][y-i].isEmpty())
				legalMoves.add(board[x+i][y-i].name);
			else { 
				if(board[x+i][y-i].piece.isWhite!=isWhite)
					legalMoves.add(board[x+i][y-i].name);
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


public class Chessboard implements CoordinateLookupTable{
	public static int turn = 1;
	Square[][] board = new Square[8][8];
	
	public static void main(String args[]) {
		Chessboard test = new Chessboard();
		System.out.println(test);
		System.out.println(test.getSquare(E2).piece.getLegalMoves(test.board).toString());
	}	
	
	public Chessboard() {
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				board[i][j] = new Square();
			}
		}
		
		for(int i=0;i<8;i++) {
			board[i][1].piece=new Pawn(true,i,1);
		}
		
		
		int iterator=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				board[i][j].name=squareNames[iterator];
				iterator++;
			}
		}
		
	}
	
	/**
	 * get the square based on piece name and color
	 * for example getSquare(Rook, true) will return 
	 * the square that the white Rook is on
	 * 				WILL return null if white rook is not present on board
	 * @param pieceName
	 * @param isWhite
	 * @return
	 */
	public Square getSquare(String pieceName, boolean isWhite) {
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(board[i][j].piece.pieceName.equals(pieceName) && (board[i][j].piece.isWhite==isWhite))
				return board[i][j];
			}
		}
		return null;
	}
	
	/**
	 * get the square based on name
	 * for example getSquare(E4) will return the E4 square
	 * @param name
	 * @return square
	 */
	public Square getSquare(String name) {
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(board[i][j].name.equalsIgnoreCase(name))
				return board[i][j];
			}
		}
		return null;
	}
	
	public String toString() {
	String chess="";	
		
		for(int i=7;i>=0;i--) {
			for(int j=0;j<=7;j++) {
				chess+=board[j][i].toString() + " ";
			}
			chess+='\n';
		}
	return chess;
	}
}

public class Chessboard implements CoordinateLookupTable{
	public static int turn = 1;
	Square[][] board = new Square[8][8];
	
	public static void main(String args[]) {
		Chessboard test = new Chessboard();
		System.out.println(test);
		System.out.println(test.getSquare("Rook 1", true).piece.getLegalMoves(test.board).toString());
	}	
	
	public Chessboard() {
		
		//Declare squares objects
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				board[i][j] = new Square();
			}
		}
		
		//White Pawns
		for(int i=0;i<8;i++) {
			board[i][1].piece=new Pawn(true,i,1);
		}
		Pawn.counter=1; //Reset Pawn counter
		//Black Pawns
		for(int i=0;i<8;i++) {
			board[i][6].piece=new Pawn(false,i,6);
		}
		
		//White&Black Rooks
		board[0][0].piece=new Rook(true,0,0);
		board[7][0].piece=new Rook(true,7,0);
		Rook.counter=1;
		board[0][7].piece=new Rook(false,0,7);
		board[7][7].piece=new Rook(false,7,7);
		
		//White&Black Knights
		board[1][0].piece=new Knight(true,1,0);
		board[6][0].piece=new Knight(true,6,0);
		Knight.counter=1;
		board[1][7].piece=new Knight(false,1,7);
		board[6][7].piece=new Knight(false,6,7);
		
		//White&Black Bishops
		board[2][0].piece=new Bishop(true,2,0);
		board[5][0].piece=new Bishop(true,5,0);
		Bishop.counter=1;
		board[2][7].piece=new Bishop(true,2,7);
		board[5][7].piece=new Bishop(true,5,7);
		
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
				if(!board[i][j].isEmpty())
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
	
	/**
	 * Returns chessboard visually as a string
	 */
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

public class Chessboard implements CoordinateLookupTable{
	public static int turn = 1;
	Square[][] board = new Square[8][8];
	
//	public static void main(String args[]) {
//		Chessboard test = new Chessboard();
//		System.out.println(test);
//		test.makeMove(test.getSquare(E2),test.getSquare(E3));
//		System.out.println(test);
//	}	
	
	public Chessboard() {
		
		//Declare squares objects
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				board[i][j] = new Square();
 				board[i][j].x=i;
				board[i][j].y=j;
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
		board[2][7].piece=new Bishop(false,2,7);
		board[5][7].piece=new Bishop(false,5,7);
		
		//White&Black Queens
		board[3][0].piece=new Queen(true,3,0);
		board[3][7].piece=new Queen(false,3,7);
		
		//White&Black King
		board[4][0].piece= new King(true,4,0);
		board[4][7].piece= new King(false,4,7);
		
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
	 * Returns Chessboard visually as a string
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
	
	public boolean makeMove(Square from, Square to) {
		if(from.piece.getLegalMoves(board).contains(to.name)) {
			System.out.println("Legal Move");
			from.piece.x=to.x;
			from.piece.y=to.y;
			if(!to.isEmpty()) {
				to.GUI_Piece.setOpacity(0);
				to.GUI_Piece.setDisable(true);
			}
			to.GUI_Piece=from.GUI_Piece;
			to.piece=from.piece;
			System.out.println("Changed piece to, with piece from");
			from.GUI_Piece=null;
			from.piece=null;
			System.out.println("Nulled from piece");
			//System.out.println(this);
			return true;
		}
		else
			return false;
	}
}
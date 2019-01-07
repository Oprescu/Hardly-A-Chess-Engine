

public class Chessboard {
	Square[][] Chessboard = new Square[8][8];
	String gameStatus;
	
	public Chessboard(){
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				Chessboard[i][j] = new Square();
		getSquare("A2").state="W_Pawn";
		getSquare("B2").state="W_Pawn";
		getSquare("C2").state="W_Pawn";
		getSquare("D2").state="W_Pawn";
		getSquare("E2").state="W_Pawn";
		getSquare("F2").state="W_Pawn";
		getSquare("G2").state="W_Pawn";
		getSquare("H2").state="W_Pawn";
		
		getSquare("A7").state="B_Pawn";
		getSquare("B7").state="B_Pawn";
		getSquare("C7").state="B_Pawn";
		getSquare("D7").state="B_Pawn";
		getSquare("E7").state="B_Pawn";
		getSquare("F7").state="B_Pawn";
		getSquare("G7").state="B_Pawn";
		getSquare("H7").state="B_Pawn";
		
		getSquare("A1").state="W_Rook";
		getSquare("B1").state="W_Knight";
		getSquare("C1").state="W_Bishop";
		getSquare("D1").state="W_Queen";
		getSquare("E1").state="W_King";
		getSquare("F1").state="W_Bishop";
		getSquare("G1").state="W_Knight";
		getSquare("H1").state="W_Rook";
		
		getSquare("A8").state="B_Rook";
		getSquare("B8").state="B_Knight";
		getSquare("C8").state="B_Bishop";
		getSquare("D8").state="B_Queen";
		getSquare("E8").state="B_King";
		getSquare("F8").state="B_Bishop";
		getSquare("G8").state="B_Knight";
		getSquare("H8").state="B_Rook";
		
		gameStatus="first_move";
	}
	
	public Square getSquare(String squareID) {
		for(int i=0;i<8;i++) 
			for(int j=0;j<8;j++)
				if(squareID.equals(Chessboard[i][j].squareID))
				return Chessboard[i][j];
		
		return Chessboard[0][0];
	}
	
	public String toString() {
		String board="";
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++)
				board+=Chessboard[i][j].toString()+" ";
			board+="\n";
		}
		return board;
	}
}

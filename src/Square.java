package chessOG;

public class Square implements CoordinateLookupTable{
	String state;
	String squareID;
	int objectID;
	public static int counter=0;
	
	public Square(){
		state="Empty";
		objectID=counter;
		counter++;
		squareID=squareNames[objectID];
	}
	
	public boolean isEmpty() {
		if(state.equals("Empty")) return true;
		else					  return false;
	}
	
	public String toString(){
		switch(state) {
			case "W_Pawn" :
				return "p";
			case "W_Rook" :
				return "r";
			case "W_Knight":
				return "k";
			case "W_Bishop":
				return "b";
			case "W_Queen" :
				return "q";
			case "W_King" :
				return "x";
			case "B_Pawn" :
				return "P";
			case "B_Rook" :
				return "R";
			case "B_Knight":
				return "K";
			case "B_Bishop":
				return "B";
			case "B_Queen" :
				return "Q";
			case "B_King" :
				return "X";
			default :
				return "-";
		}
	}	

}

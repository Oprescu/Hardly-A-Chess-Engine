
public class Square implements CoordinateLookupTable{
		Piece piece;
		String name;
		static int counter=0;
		
		public Square() {
			piece = null;
			name = null;
		}
		
		public boolean isEmpty() {
			if(piece==null)
				return true;
			else 
				return false;
		}
		
		public String toString() {
			if(isEmpty()) {
				return "-";
			}
			if(piece.getClass().getName().equals("Pawn"))
				return"p";
			if(piece.getClass().getName().equals("Rook"))
				return"r";
			if(piece.getClass().getName().equals("Knight"))
				return"n";
			if(piece.getClass().getName().equals("Bishop"))
				return"b";
			
			else return null;
		}
}

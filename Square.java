
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
			
			else return null;
		}
}

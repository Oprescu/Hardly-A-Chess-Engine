
public class Square implements CoordinateLookupTable{
		Piece piece;
		boolean hasPiece;
		String name;
		static int counter=0;
		
		public Square() {
			piece = null;
			hasPiece=false;
			name = null;
		}
		
		public boolean isEmpty() {
			if(piece==null)
				return true;
			else 
				return false;
		}
}

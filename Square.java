import javafx.scene.image.ImageView;

public class Square implements CoordinateLookupTable{
		Piece piece;
		String name;
		static int counter=0;
		ImageView GUI_Piece;
		int x;
		int y;
		
		public Square() {
			piece = null;
			name = null;
			GUI_Piece=null;
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
			if(piece.getClass().getName().equals("Queen"))
				return"q";
			if(piece.getClass().getName().equals("King"))
				return"k";
			else return null;
		}
}

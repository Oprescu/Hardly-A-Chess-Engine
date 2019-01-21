import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Square implements CoordinateLookupTable{
		Piece piece;
		String name;
		static int counter=0;
		static boolean is_square1_selected=false;
		static boolean is_square2_selected=false;
		static String square1_selected;
		static String square2_selected;
		ImageView GUI_Piece;
		ImageView selection_Square;
		int x;
		int y;
		
		public Square() {
			piece = null;
			name = null;
			GUI_Piece=null;
			selection_Square=null;
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
		
		public void initializeSelectionSquare() {
			selection_Square.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				if(is_square1_selected&&is_square2_selected) {
					is_square1_selected=false;
					is_square2_selected=false;
					System.out.println("Both square selected");
					return;
					
				}
				else if(is_square1_selected) {
					square2_selected=name;
					System.out.println("square " + square2_selected);
					is_square2_selected=true;
				}
				else if(!is_square1_selected) {
					if(!this.isEmpty())
					{
						square1_selected=name;
						System.out.println("square " + square1_selected);
						is_square1_selected=true;
					}
				}				
		});
		}
		
}

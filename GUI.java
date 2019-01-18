import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GUI extends Application implements CoordinateLookupTable{
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("HCE 1.0");
		//hello
		//*******************Pane Declarations*******************
		BorderPane main_Window = new BorderPane();	
		Pane ChessPane = new Pane();
		MenuBar top_Menu = new MenuBar();
		 	Menu menu_File = new Menu("File");
		 		MenuItem menu_Open = new MenuItem("Open PGN");
		 		MenuItem menu_Save = new MenuItem("Save PGN");
		 		MenuItem menu_Exit = new MenuItem("Exit");
		 		menu_File.getItems().addAll(menu_Open,menu_Save,menu_Exit);
		 	Menu menu_Edit = new Menu("Edit");
		        
		    Menu menu_View = new Menu("View");
		top_Menu.getMenus().addAll(menu_File, menu_Edit, menu_View);
		TextField inputBox = new TextField();
		inputBox.setText("Enter move here ex:e2,e4 ");
		Button submitButton = new Button("Submit");
		
		//*******************Asset Declaration*******************
		
		Chessboard chessboard = new Chessboard();
		
		Image chessboard_backgroundImage = new Image("File:chessicons/board.png");
		ImageView chessboard_backgroundImageV = new ImageView(chessboard_backgroundImage);
		Image chessboard_W_Pawn = new Image("File:chessicons/wpawn.png");
		Image chessboard_B_Pawn = new Image("File:chessicons/bpawn.png");
		Image chessboard_W_Rook = new Image("File:chessicons/wrook.png");
		Image chessboard_B_Rook = new Image("File:chessicons/brook.png");
		Image chessboard_W_Knight = new Image("File:chessicons/wknight.png");
		Image chessboard_B_Knight = new Image("File:chessicons/bknight.png");
		Image chessboard_W_Bishop = new Image("File:chessicons/wbishop.png");
		Image chessboard_B_Bishop = new Image("File:chessicons/bbishop.png");
		Image chessboard_W_Queen = new Image("File:chessicons/wqueen.png");
		Image chessboard_B_Queen = new Image("File:chessicons/bqueen.png");
		Image chessboard_W_King = new Image("File:chessicons/wking.png");
		Image chessboard_B_King = new Image("File:chessicons/bking.png");
		Image selection_Square_Image = new Image("File:chessicons/SelectionSquare.png");
		//16 pawns on board. 0 is white, 1 is black
		ImageView[][] chessboard_Pawns = new ImageView[8][2];
		for(int i=0;i<8;i++) {
			chessboard_Pawns[i][0]= new ImageView(chessboard_W_Pawn);
			chessboard_Pawns[i][1]= new ImageView(chessboard_B_Pawn);
			chessboard_Pawns[i][0].setScaleX(0.8);
			chessboard_Pawns[i][0].setScaleY(0.8);
			chessboard_Pawns[i][1].setScaleX(0.8);
			chessboard_Pawns[i][1].setScaleY(0.8);
			chessboard_Pawns[i][0].setY(yCoordinates_PP[6]);
			chessboard_Pawns[i][0].setX(xyCoordinates_MP[i]);
			chessboard_Pawns[i][1].setY(yCoordinates_PP[1]);
			chessboard_Pawns[i][1].setX(xyCoordinates_MP[i]);
		}
		//4 rooks
		ImageView[][] chessboard_Rooks = new ImageView[2][2];
		for(int i=0;i<2;i++) {
			chessboard_Rooks[i][0]= new ImageView(chessboard_W_Rook);
			chessboard_Rooks[i][1]= new ImageView(chessboard_B_Rook);
			chessboard_Rooks[i][0].setY(xyCoordinates_MP[7]);
			chessboard_Rooks[i][0].setX(xyCoordinates_MP[0+(i*7)]);
			chessboard_Rooks[i][1].setY(xyCoordinates_MP[0]);
			chessboard_Rooks[i][1].setX(xyCoordinates_MP[0+(i*7)]);
			chessboard_Rooks[i][0].setScaleX(0.74);
			chessboard_Rooks[i][0].setScaleY(0.70);
			chessboard_Rooks[i][1].setScaleX(0.74);
			chessboard_Rooks[i][1].setScaleY(0.70);
		}
		//4 knights
		ImageView[][] chessboard_Knights = new ImageView[2][2];
		for(int i=0;i<2;i++) {
			chessboard_Knights[i][0]= new ImageView(chessboard_W_Knight);
			chessboard_Knights[i][1]= new ImageView(chessboard_B_Knight);
			chessboard_Knights[i][0].setY(xyCoordinates_MP[7]);
			chessboard_Knights[i][0].setX(xyCoordinates_MP[1+(i*5)]);
			chessboard_Knights[i][1].setY(xyCoordinates_MP[0]);
			chessboard_Knights[i][1].setX(xyCoordinates_MP[1+(i*5)]);
			chessboard_Knights[i][0].setScaleX(0.74);
			chessboard_Knights[i][0].setScaleY(0.70);
			chessboard_Knights[i][1].setScaleX(0.74);
			chessboard_Knights[i][1].setScaleY(0.70);
		}
		//4 bishops
		ImageView[][] chessboard_Bishops = new ImageView[2][2];
		for(int i=0;i<2;i++) {
			chessboard_Bishops[i][0]= new ImageView(chessboard_W_Bishop);
			chessboard_Bishops[i][1]= new ImageView(chessboard_B_Bishop);
			chessboard_Bishops[i][0].setY(xyCoordinates_MP[7]);
			chessboard_Bishops[i][0].setX(xyCoordinates_MP[2+(i*3)]);
			chessboard_Bishops[i][1].setY(xyCoordinates_MP[0]);
			chessboard_Bishops[i][1].setX(xyCoordinates_MP[2+(i*3)]);
			chessboard_Bishops[i][0].setScaleX(0.74);
			chessboard_Bishops[i][0].setScaleY(0.70);
			chessboard_Bishops[i][1].setScaleX(0.74);
			chessboard_Bishops[i][1].setScaleY(0.70);
		}
		//2 queens
		ImageView[] chessboard_Queens = new ImageView[2];
			chessboard_Queens[0]= new ImageView(chessboard_W_Queen);
			chessboard_Queens[1]= new ImageView(chessboard_B_Queen);
			chessboard_Queens[0].setY(xyCoordinates_MP[7]);
			chessboard_Queens[0].setX(xyCoordinates_MP[3]);
			chessboard_Queens[1].setY(xyCoordinates_MP[0]);
			chessboard_Queens[1].setX(xyCoordinates_MP[3]);
			chessboard_Queens[0].setScaleX(0.74);
			chessboard_Queens[0].setScaleY(0.70);
			chessboard_Queens[1].setScaleX(0.74);
			chessboard_Queens[1].setScaleY(0.70);
			
		//2 Kings
			ImageView[] chessboard_Kings = new ImageView[2];
			chessboard_Kings[0]= new ImageView(chessboard_W_King);
			chessboard_Kings[1]= new ImageView(chessboard_B_King);
			chessboard_Kings[0].setY(xyCoordinates_MP[7]);
			chessboard_Kings[0].setX(xyCoordinates_MP[4]);
			chessboard_Kings[1].setY(xyCoordinates_MP[0]);
			chessboard_Kings[1].setX(xyCoordinates_MP[4]);
			chessboard_Kings[0].setScaleX(0.74);
			chessboard_Kings[0].setScaleY(0.70);
			chessboard_Kings[1].setScaleX(0.74);
			chessboard_Kings[1].setScaleY(0.70);
			
		//64 Image Selection Squares, these are used to detect where a mouse pressed
		//on the Chesssboard 
			ImageView[] selection_Square = new ImageView[64];
			int iterator=0;
			
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
				selection_Square[iterator] = new ImageView(selection_Square_Image);
				selection_Square[iterator].setX(xyCoordinates_MP[i]);
				selection_Square[iterator].setY(xyCoordinates_MP[j]);
				selection_Square[iterator].setScaleX(0.74);
				selection_Square[iterator].setScaleY(0.70);
				iterator++;
				}
			}
			
		/********************Associating GUI with Chess Class pieces*******/
		chessboard.getSquare(A2).GUI_Piece=chessboard_Pawns[0][0];	
		chessboard.getSquare(B2).GUI_Piece=chessboard_Pawns[1][0];		
		chessboard.getSquare(C2).GUI_Piece=chessboard_Pawns[2][0];	
		chessboard.getSquare(D2).GUI_Piece=chessboard_Pawns[3][0];	
		chessboard.getSquare(E2).GUI_Piece=chessboard_Pawns[4][0];	
		chessboard.getSquare(F2).GUI_Piece=chessboard_Pawns[5][0];	
		chessboard.getSquare(G2).GUI_Piece=chessboard_Pawns[6][0];	
		chessboard.getSquare(H2).GUI_Piece=chessboard_Pawns[7][0];	
		
		chessboard.getSquare(A7).GUI_Piece=chessboard_Pawns[0][1];	
		chessboard.getSquare(B7).GUI_Piece=chessboard_Pawns[1][1];		
		chessboard.getSquare(C7).GUI_Piece=chessboard_Pawns[2][1];	
		chessboard.getSquare(D7).GUI_Piece=chessboard_Pawns[3][1];	
		chessboard.getSquare(E7).GUI_Piece=chessboard_Pawns[4][1];	
		chessboard.getSquare(F7).GUI_Piece=chessboard_Pawns[5][1];	
		chessboard.getSquare(G7).GUI_Piece=chessboard_Pawns[6][1];	
		chessboard.getSquare(H7).GUI_Piece=chessboard_Pawns[7][1];	
		
		chessboard.getSquare(A1).GUI_Piece=chessboard_Rooks[0][0];	
		chessboard.getSquare(H1).GUI_Piece=chessboard_Rooks[1][0];	
		chessboard.getSquare(A8).GUI_Piece=chessboard_Rooks[0][1];	
		chessboard.getSquare(H8).GUI_Piece=chessboard_Rooks[1][1];	
		
		chessboard.getSquare(B1).GUI_Piece=chessboard_Knights[0][0];	
		chessboard.getSquare(G1).GUI_Piece=chessboard_Knights[1][0];	
		chessboard.getSquare(B8).GUI_Piece=chessboard_Knights[0][1];	
		chessboard.getSquare(G8).GUI_Piece=chessboard_Knights[1][1];	
		
		chessboard.getSquare(C1).GUI_Piece=chessboard_Bishops[0][0];	
		chessboard.getSquare(F1).GUI_Piece=chessboard_Bishops[1][0];	
		chessboard.getSquare(C8).GUI_Piece=chessboard_Bishops[0][1];	
		chessboard.getSquare(F8).GUI_Piece=chessboard_Bishops[1][1];	
		
		chessboard.getSquare(D1).GUI_Piece=chessboard_Queens[0];	
		chessboard.getSquare(D8).GUI_Piece=chessboard_Queens[1];	
		chessboard.getSquare(E1).GUI_Piece=chessboard_Kings[0];
		chessboard.getSquare(E8).GUI_Piece=chessboard_Kings[1];
		
		//*******************Pane settings*******************
		ChessPane.getChildren().add(chessboard_backgroundImageV);
		//Add pawns to pane
		for(int i=0;i<8;i++) {
			ChessPane.getChildren().add(chessboard_Pawns[i][1]);
			ChessPane.getChildren().add(chessboard_Pawns[i][0]);
		}
		//Add rooks to pane
		for(int i=0;i<2;i++) {
			ChessPane.getChildren().add(chessboard_Rooks[i][0]);
			ChessPane.getChildren().add(chessboard_Rooks[i][1]);
		}
		//Add Knights to pane
		for(int i=0;i<2;i++) {
			ChessPane.getChildren().add(chessboard_Knights[i][0]);
			ChessPane.getChildren().add(chessboard_Knights[i][1]);
		}
		//Add bishops to pane
		for(int i=0;i<2;i++) {
			ChessPane.getChildren().add(chessboard_Bishops[i][0]);
			ChessPane.getChildren().add(chessboard_Bishops[i][1]);
		}
		//Add queens to pane
			ChessPane.getChildren().add(chessboard_Queens[0]);
			ChessPane.getChildren().add(chessboard_Queens[1]);
		//Add kings to pane
			ChessPane.getChildren().add(chessboard_Kings[0]);
			ChessPane.getChildren().add(chessboard_Kings[1]);
			
//			for(int i=0;i<64;i++)
//				ChessPane.getChildren().add(selection_Square[i]);

			
		main_Window.setTop(top_Menu);
		main_Window.setLeft(ChessPane);
		ChessPane.getChildren().add(inputBox);
		ChessPane.getChildren().add(submitButton);
		inputBox.setTranslateY(600);
		submitButton.setTranslateY(600);
		submitButton.setTranslateX(150);
		//Scene scene = new Scene(main_Window, 1000,800);
		Scene scene = new Scene(main_Window, 600,650);
		primaryStage.setScene(scene);
		primaryStage.show();		
		
		submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
	         Thread task = new Thread(new Runnable(){
	 	        @Override
	 	        public void run() {
	 	            try {
	 	            String moves[] = inputBox.getText().toUpperCase().split(",");
	 	            if(chessboard.getSquare(moves[0]).piece.getClass().getName().equals("Pawn"))
	 	            	animatePiece(chessboard.getSquare(moves[0]).GUI_Piece,xyCoordinates_MP[moves[1].charAt(0)-'A'],yCoordinates_PP[8-(moves[1].charAt(1)-'0')]);
	 	            else
	 	            	animatePiece(chessboard.getSquare(moves[0]).GUI_Piece,xyCoordinates_MP[moves[1].charAt(0)-'A'],xyCoordinates_MP[8-(moves[1].charAt(1)-'0')]);
	 	            chessboard.makeMove(chessboard.getSquare(moves[0]), chessboard.getSquare(moves[1]));
	 	            System.out.println(moves[1].charAt(0)-'A');
	 	            System.out.println(moves[1].charAt(1));
	 	            System.out.println(chessboard);
	 	            System.out.println(chessboard.getSquare(moves[1]).piece.getLegalMoves(chessboard.board).toString());
	 	            } catch (InterruptedException e) {
	 	                e.printStackTrace();
	 	            }
	 	       }
	 	    });
	 		task.setDaemon(true);;
	 		task.start();
	     });
	}
	
	public void animatePiece(ImageView Piece, double x, double y) throws InterruptedException {	
		while(Piece.getX()!=x||Piece.getY()!=y) {
				if(Piece.getX()<x)
					Platform.runLater(() -> Piece.setX(Piece.getX()+1));
				if(Piece.getX()>x)
					Platform.runLater(() -> Piece.setX(Piece.getX()-1));
				if(Piece.getY()>y)
					Platform.runLater(() -> Piece.setY(Piece.getY()-1));
				if(Piece.getY()<y)
					Platform.runLater(() -> Piece.setY(Piece.getY()+1));
				Thread.sleep(2);
			}
	}
	
	
	
}

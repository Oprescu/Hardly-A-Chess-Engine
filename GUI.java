import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
		
		
		//*******************Asset Declaration*******************
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
		//16 pawns on board. 0 is white, 1 is black
		ImageView[][] chessboard_Pawns = new ImageView[8][2];
		for(int i=0;i<8;i++) {
			chessboard_Pawns[i][0]= new ImageView(chessboard_W_Pawn);
			chessboard_Pawns[i][1]= new ImageView(chessboard_B_Pawn);
			chessboard_Pawns[i][0].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
		         ImageView current = (ImageView) event.getSource();
		         Thread task = new Thread(new Runnable(){
		 	        @Override
		 	        public void run() {

		 	            try {
		 	            animatePiece(current,current.getX(),current.getY()-75);
		 	            } catch (InterruptedException e) {
		 	                e.printStackTrace();
		 	            }

		 	            //do something.........

		 	           

		 	       }
		 	    });
		 		task.setDaemon(true);;
		 		task.start();
		 		
		         //event.consume();
		     });
			chessboard_Pawns[i][1].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
		        
		         ImageView current = (ImageView) event.getSource();
		         Thread task = new Thread(new Runnable(){
		 	        @Override
		 	        public void run() {

		 	            try {
		 	            animatePiece(current,current.getX(),current.getY()+75*2);
		 	            } catch (InterruptedException e) {
		 	                e.printStackTrace();
		 	            }

		 	            //do something.........

		 	           

		 	       }
		 	    });
		 		task.setDaemon(true);;
		 		task.start();
		 		
		         //event.consume();
		     });
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
		main_Window.setTop(top_Menu);
		main_Window.setLeft(ChessPane);
		//ChessPane.getChildren().add(inputBox);
		inputBox.setTranslateY(400);
		//Scene scene = new Scene(main_Window, 1000,800);
		Scene scene = new Scene(main_Window, 600,625);
		primaryStage.setScene(scene);
		primaryStage.show();
		//Thread.sleep(2000);
		Chessboard test = new Chessboard();
		System.out.println(test);
		Thread task = new Thread(new Runnable(){
	        @Override
	        public void run() {

	            try {
	            animatePiece(chessboard_Pawns[1][0],xyCoordinates_MP[1],yCoordinates_PP[3]);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            //do something.........

	           

	       }
	    });
		task.setDaemon(true);
		//task.start();
		
		
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

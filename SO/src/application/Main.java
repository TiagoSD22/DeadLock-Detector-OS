package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Main extends Application {
	
	private double xOffset,yOffset;
	private Relogio relogio;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			FXML_Menu_Controlador menu = new FXML_Menu_Controlador();
			menu.set_Controlador(menu);
			loader.setController(menu);
			Pane root = loader.load();
			relogio = new Relogio();
			relogio.set_Controller(menu);
			Thread data_hora = new Thread(relogio);
			data_hora.start();
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
	        root.setBackground(null);
			Scene tela = new Scene(root,1080,640);
			tela.setFill(Color.TRANSPARENT);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(tela);
			primaryStage.setTitle("MENU");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Fontes/Imagens/icon.jpg")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

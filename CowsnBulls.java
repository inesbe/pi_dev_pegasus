package CowsAndBulls;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CowsnBulls{
    static Stage s;
	
	public void start(Stage primaryStage) throws IOException {
            s=primaryStage;
             Parent root = FXMLLoader.load(getClass().getResource("/CowsAndBulls/SplashScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
		/*try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/CowsAndBulls/SplashScreen.fxml"));
                        System.out.println("done");
			Scene scene = new Scene(root,423,668);
			scene.setFill(Color.BLACK);
			scene.getStylesheets().add(getClass().getResource("/CowsAndBulls/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Cows and Bulls");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		
	}*/
        }
	

}

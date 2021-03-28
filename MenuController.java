/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flaw.Game;

//import flaw.Game.Main;
import game3d.Game3d;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author Saif
 */
public class MenuController implements Initializable {
    @FXML public AnchorPane menuPane;
    @FXML public ImageView Menu;
    @FXML public ImageView Exit;
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        System.out.println("aaa");
        Exit.setOnMouseClicked((MouseEvent e) -> {
                  Stage stage=(Stage)Exit.getScene().getWindow();
Game3d g=new Game3d();
g.start(stage);
     //  Scene scene=new Scene(root);
     // stage.setScene(scene);
     // stage.show();
        }); 
    }
    public void loadScene(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Menu2.fxml"));
        menuPane.getChildren().setAll(pane);
    }

    @FXML
    private void initialize(MouseEvent event) {
    }

    @FXML
    private void loadScene(MouseEvent event) throws IOException {
                AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Menu2.fxml"));
        menuPane.getChildren().setAll(pane);
    }
}

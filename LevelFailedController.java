/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flaw.Game;

import static flaw.Game.Menu2Controller.score;
import static flaw.Game.Menu2Controller.streak;
import static flaw.Game.Menu2Controller.streak5;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Saif
 */
public class LevelFailedController implements Initializable {
    @FXML
    public AnchorPane pane;
    @FXML
    public Button tryagain;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("dkhal");
        // TODO
    }    
    @FXML
    public void loadSceneFailed() throws IOException{
              

        score=0;
        streak=0;
        AnchorPane pane3 =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Menu2.fxml"));
        pane.getChildren().setAll(pane3);
        streak5.setVisible(false);
        
    }
    
}

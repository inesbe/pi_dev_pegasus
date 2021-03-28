/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class PagenotfoundController implements Initializable {

    @FXML
    private JFXButton back_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
          Stage stage=(Stage)this.back_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}

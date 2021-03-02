/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import services.ServiceJeu;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Ajouter_jeuController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private TextField idg;
    @FXML
    private TextField titleg;
    @FXML
    private TextField descriptiong;
    @FXML
    private TextField idcourseg;
    @FXML
    private TextField diffg;
    @FXML
    private JFXButton addg;
    @FXML
    private TextField sourceg;
    @FXML
    private ImageView upsource;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
   
    }

    @FXML
    private void AddGame(ActionEvent event) throws SQLException {
      int id=Integer.parseInt(idg.getText());
       int c=Integer.parseInt(idcourseg.getText());
        Jeu j = new Jeu(id,titleg.getText(),descriptiong.getText(),c,diffg.getText(),sourceg.getText());
       


       ServiceJeu sj= new ServiceJeu();
try {
       sj.add(j);
    } catch (SQLException ex) {
           ex.getErrorCode();
        }
                                                                }

    @FXML
    private void Loadimg(MouseEvent event) {
        Stage stage=(Stage)upsource.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open Resource File");
fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Images","*.png","*.jpg","*.gif"));
File f=fileChooser.showOpenDialog(stage);
sourceg.setText(f.getAbsolutePath());
    }
    
}

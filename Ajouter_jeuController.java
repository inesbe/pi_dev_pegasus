/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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

        
        
    }    

  
    @FXML
    private void AddGame(ActionEvent event) throws SQLException {
        
        if(idg.getText().isEmpty() || idcourseg.getText().isEmpty())
        {
                               Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("");
      alert.setHeaderText("Empty Field!!!");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
            return;
        }
        
        
      int id=Integer.parseInt(idg.getText());
       int c=Integer.parseInt(idcourseg.getText());
       
        Jeu j = new Jeu(id,titleg.getText(),descriptiong.getText(),c,diffg.getText(),sourceg.getText().replace("\\","$"));
        
       
       


       ServiceJeu sj= new ServiceJeu();
try {
       sj.add(j);
       //INFO
              Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("");
      alert.setHeaderText("ADDED SUCCESSFULLY !");
            Optional<ButtonType> option = alert.showAndWait();
            
            
            //clear
            idg.clear();
            titleg.clear();
            descriptiong.clear();
            diffg.clear();
            sourceg.clear();
            idcourseg.clear();

    } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("");
      alert.setHeaderText("ADD FAILED");
      Optional<ButtonType> option = alert.showAndWait();
        }
                                                                }

    @FXML
    private void Loadimg(MouseEvent event) throws IOException {
        Stage stage=(Stage)upsource.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        
fileChooser.setTitle("Open Resource File");
fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Images","*.png","*.jpg","*.gif"));
File f=fileChooser.showOpenDialog(stage);
sourceg.setText(f.getName());
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
                Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
                       Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void Onlynumbers(KeyEvent event) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
         String c=event.getCharacter();
    
            if(pattern.matcher(c).matches())
            {
     
         System.out.println("Not number");

            }
            else 
                 event.consume();
               
    
               
        
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServiceJeu;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Modifier_jeuController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private TextField titleg;
    @FXML
    private TextField descriptiong;
    @FXML
    private TextField idcourseg;
    @FXML
    private JFXButton updateg;
    @FXML
    private TextField diffg;
    @FXML
    private JFXComboBox<Integer> comboidg;

    /**
     * Initializes the controller class.
     */
            ServiceJeu sj=new ServiceJeu();
    @FXML
    private TextField sourceg;
    @FXML
    private ImageView upsource;
    @FXML
    private ImageView upsource1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //INTIALIZE COMBOBOX
             ArrayList<Integer> lid;

            try {
                //combobox
                lid = (ArrayList<Integer>) sj.getId();
            comboidg.getItems().addAll(lid);
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
            
      
    }
    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void UpdateGame(ActionEvent event) throws SQLException, IOException {
       
       if(showalert()) 
       { int c=Integer.parseInt(idcourseg.getText());
        Jeu j=new Jeu(comboidg.getValue(),titleg.getText(),descriptiong.getText(),c,diffg.getText(),sourceg.getText());
        
        sj.update(j);
       }   
        
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
                 Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
    
    
     

    private void fillmodgame(InputMethodEvent event) {
            
   
        
    }

    @FXML
    private void fillmodgame(ActionEvent event) {
        
        
                                  Jeu jl;

        if(comboidg.getValue()!=null)
        try {
              System.out.println("CAAA VAA");
            jl= sj.searchgame(comboidg.getValue());
                      

            String cours=String.valueOf(jl.getCours());
                  titleg.setText(jl.getTitre());
            descriptiong.setText(jl.getDescription());
           idcourseg.setText(cours);
           diffg.setText(jl.getDiff());
           sourceg.setText(jl.getSource());
        } catch (SQLException ex) {
            Logger.getLogger(Modifier_jeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           private boolean showalert() throws IOException {
        
          
         Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("");
      alert.setHeaderText("do you really want to update the id "+comboidg.getValue()+" ?");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
 
            return option.get() == ButtonType.OK;
    
        
        
    }
    
}

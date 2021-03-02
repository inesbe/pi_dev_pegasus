/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private void UpdateGame(ActionEvent event) throws SQLException {
        int c=Integer.parseInt(idcourseg.getText());
        Jeu j=new Jeu(comboidg.getValue(),titleg.getText(),descriptiong.getText(),c,diffg.getText(),sourceg.getText());
        
        sj.update(j);
        
        
    }
    
}

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.ServiceJeu;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Afficher_jeuController implements Initializable {

    /**
     * Initializes the controller class.
     */
 
        ServiceJeu sj = new ServiceJeu();
                
      
    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton deleteg;
    @FXML
    private JFXComboBox<Integer> cjeux;
    @FXML
    private TableView<Jeu> affijeux;
    @FXML
    private TableColumn<?, ?> cidgame;
    @FXML
    private TableColumn<?, ?> ctitlegame;
    @FXML
    private TableColumn<?, ?> cdescriptiongame;
    @FXML
    private TableColumn<?, ?> ctopscoregame;
    @FXML
    private TableColumn<?, ?> ccoursegame;
    @FXML
    private TableColumn<?, ?> cdiffgame;
    @FXML
    private TableColumn<?, ?> csourcegame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
     
        
        //afficherr
        
        ArrayList<Jeu> lj;
       
        try {
            lj = (ArrayList<Jeu>) sj.read();
       
            ObservableList<Jeu> data = FXCollections.observableArrayList(lj);

            cidgame.setCellValueFactory(new PropertyValueFactory<>("id"));
            ctitlegame.setCellValueFactory(new PropertyValueFactory<>("titre"));
             cdescriptiongame.setCellValueFactory(new PropertyValueFactory<>("description"));
            ccoursegame.setCellValueFactory(new PropertyValueFactory<>("cours"));
            cdiffgame.setCellValueFactory(new PropertyValueFactory<>("diff"));
            ctopscoregame.setCellValueFactory(new PropertyValueFactory<>("topscore"));
                        csourcegame.setCellValueFactory(new PropertyValueFactory<>("source"));


            affijeux.setItems(data);
                    } catch (SQLException ex) {
            Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            ArrayList<Integer> lid;
        
            try {
                //combobox
                lid = (ArrayList<Integer>) sj.getId();
            cjeux.getItems().addAll(lid);
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void DeleteGame(ActionEvent event) throws SQLException {
     sj.delete(cjeux.getValue());   
     affijeux.refresh();


    }


  
   
    }
    
       
   


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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
        
        afficher();
    }

    

    @FXML
    private void DeleteGame(ActionEvent event) throws SQLException, IOException {
    if(showalert())
    {     
        
       try{ 
        sj.delete(cjeux.getValue());  
                 Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("");
      alert.setHeaderText("DELETED SUCCESSFULLY !");
      Optional<ButtonType> option = alert.showAndWait();
       }catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("");
      alert.setHeaderText("DELETE FAILED");
      Optional<ButtonType> option = alert.showAndWait();
        }
      cjeux.getItems().removeAll(cjeux.getItems()); 
     afficher();
     affijeux.refresh();
     
        System.out.println("kkkkkkkkkkkk");
    }


    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
                Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
        
    }

    private void afficher() {
   


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
    
    
    
       private boolean showalert() throws IOException {
        
          
         Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("");
      alert.setHeaderText("do you really want to delete the id "+cjeux.getValue()+" ?");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
 
            return option.get() == ButtonType.OK;
    
        
        
    }
    
    
    
    
    
}
    
       
   


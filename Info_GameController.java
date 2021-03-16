/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import Entités.Scores;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projet.Projet;
import services.ServiceScore;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Info_GameController implements Initializable {

    @FXML
    private TableColumn<?, ?> auser;
   /* @FXML
    private TableColumn<?, ?> agame;*/
    @FXML
    private TableColumn<?, ?> asource;

    ServiceScore ss=new ServiceScore();
    @FXML
    private TableView<Scores> affiscore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        afficher();
        
    }    
    
    
    
    
     private void afficher() {
   


  ArrayList<Scores> lj =new ArrayList();
  ArrayList<Integer>rnk =new ArrayList();
      for(int i=0;i<lj.size();i++)
       {
           lj.get(i).setRank(i+1);
       }  
        try {
            lj = (ArrayList<Scores>) ss.readgame(Projet.gameid);
      
            ObservableList<Scores> data = FXCollections.observableArrayList(lj);
                ObservableList<Integer> data2 = FXCollections.observableArrayList(rnk);

                  
            auser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
             asource.setCellValueFactory(new PropertyValueFactory<>("score"));
           //  agame.setCellValueFactory(new PropertyValueFactory<>("rank"));


            affiscore.setItems(data);
           
                    } catch (SQLException ex) {
            Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            ArrayList<Integer> lid;
        
          
   
    }
    
    
    
    
    
    
    
}

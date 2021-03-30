/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projet.entity.Forum;
import projet.services.Serviceforum;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Afficher_classe_frontController implements Initializable {

    @FXML
    private JFXListView<String> forum_id;
    @FXML
    private JFXButton button_send;
    @FXML
    private JFXTextField txt_field;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   Serviceforum sf=new Serviceforum();
   Serviceutilisateur su =new Serviceutilisateur();
        try {
            ArrayList<Forum> list=(ArrayList<Forum>) sf.get_all_message();
            
            
            ArrayList<String> list2=new ArrayList<>();
            
            for(Forum i : list)
            {
              list2.add(su.getU(i.getId_utilisateur()).getNom_utilisateur()+" : "+i.getMessage());
            }
            
             ObservableList<String> data2=FXCollections.observableArrayList(list2);
           this.forum_id.setItems(data2);
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_classe_frontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void add(MouseEvent event) throws SQLException {
        
          Serviceforum sf=new Serviceforum();
   Serviceutilisateur su =new Serviceutilisateur();
   
   sf.add(this.txt_field.getText(),Projet.id_utilisateur);
   
        try {
            ArrayList<Forum> list=(ArrayList<Forum>) sf.get_all_message();
            
            
            ArrayList<String> list2=new ArrayList<>();
            
            for(Forum i : list)
            {
              list2.add(su.getU(i.getId_utilisateur()).getNom_utilisateur()+" : "+i.getMessage());
            }
            
             ObservableList<String> data2=FXCollections.observableArrayList(list2);
           this.forum_id.setItems(data2);
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_classe_frontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void enter(KeyEvent event) throws SQLException {
        if(event.getCode()==event.getCode().ENTER)
       {
               Serviceforum sf=new Serviceforum();
   Serviceutilisateur su =new Serviceutilisateur();
   
   sf.add(this.txt_field.getText(),Projet.id_utilisateur);
   
        try {
            ArrayList<Forum> list=(ArrayList<Forum>) sf.get_all_message();
            
            
            ArrayList<String> list2=new ArrayList<>();
            
            for(Forum i : list)
            {
              list2.add(su.getU(i.getId_utilisateur()).getNom_utilisateur()+" : "+i.getMessage());
            }
            
             ObservableList<String> data2=FXCollections.observableArrayList(list2);
           this.forum_id.setItems(data2);
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_classe_frontController.class.getName()).log(Level.SEVERE, null, ex);
        }
          this.txt_field.clear();   
       }
      
        
    }
    
    
}

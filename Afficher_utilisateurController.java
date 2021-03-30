/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projet.entity.Cours;
import projet.entity.Enfant;
import projet.entity.Enseignant;
import projet.entity.Parents;
import projet.entity.Utilisateur;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Afficher_utilisateurController implements Initializable {
     static Utilisateur user;
    @FXML
    private JFXButton id_back1;
    @FXML
    private TableView<Utilisateur> tab_user;
    @FXML
    private TableColumn<Utilisateur,Integer> row_id;
    @FXML
    private TableColumn<Utilisateur,String> row_username;
    @FXML
    private TableColumn<Utilisateur,String> row_name;
    @FXML
    private TableColumn<Utilisateur,String> row_surname;
    @FXML
    private TableColumn<Utilisateur,Integer> row_age;
    @FXML
    private TableColumn<Utilisateur,String> row_email;
    @FXML
    private JFXButton id_affich;
    @FXML
    private Button modify_id;
    @FXML
    private AnchorPane comb;
    @FXML
    private JFXComboBox<Integer> combo_usr;
    @FXML
    private Button id_delete;
    @FXML
    private TableColumn<Utilisateur,Integer> role_id;
    @FXML
    private Button modify_id1;
    @FXML
    private TableColumn<Utilisateur, Integer> id_status;
    @FXML
    private TableColumn<Enseignant, Integer> id_salaire;
    @FXML
    private TableColumn<Parents, String> id_metier;
    @FXML
    private TableColumn<Enfant, Integer> id_moyenne;
    @FXML
    private Button id_block;
    @FXML
    private JFXTextField id_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             Serviceutilisateur sc=new Serviceutilisateur();
ArrayList<Utilisateur> list;
        try {
            
            
            ArrayList<Integer> list2=(ArrayList<Integer>) sc.get_id();
            ObservableList<Integer> data2 = FXCollections.observableArrayList(list2);
            this.combo_usr.setItems(data2);
            
            
            
            list =  (ArrayList<Utilisateur>) sc.getUtilisateur();
            System.out.println(list+"123");
         
ObservableList<Utilisateur> data = FXCollections.observableArrayList(list);
System.out.println(data);
this.row_id.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
this.row_username.setCellValueFactory(new PropertyValueFactory<>("nom_utilisateur"));
 
this.row_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
this.row_surname.setCellValueFactory(new PropertyValueFactory<>("prénom"));
this.row_age.setCellValueFactory(new PropertyValueFactory<>("age"));

this.id_status.setCellValueFactory(new PropertyValueFactory<>("status"));
this.row_email.setCellValueFactory(new PropertyValueFactory<>("email"));
this.id_salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
this.id_moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
this.id_metier.setCellValueFactory(new PropertyValueFactory<>("metier"));
this.tab_user.setItems(data);

}
catch (SQLException ex) {
            Logger.getLogger(Afficher_utilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back(MouseEvent event) throws SQLException, IOException {
  
       Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();

        
        
    }

    @FXML
    private void affich(MouseEvent event) throws IOException {
           Stage stage=(Stage)this.id_affich.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("ajouter_utilisateur.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void modify(MouseEvent event) throws IOException {
         user=this.tab_user.getSelectionModel().getSelectedItem();
        Projet.id_sav=user.getId_utilisateur();
              Stage stage=(Stage)this.modify_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("modifier_utilisateur.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      
      stage.setScene(scene);
      stage.show();
      
    }
    
    
    
    void affich() throws IOException
    {
        
        Stage stage=(Stage)this.id_delete.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_utilisateur.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException, IOException {
        Serviceutilisateur su=new Serviceutilisateur();
        Utilisateur u=new Utilisateur(this.combo_usr.getSelectionModel().getSelectedItem());
        su.delete(u);
        affich();
        
        
    }

    @FXML
    private void confirm(MouseEvent event) throws SQLException, IOException {
         Serviceutilisateur su=new Serviceutilisateur();
        Utilisateur u=new Utilisateur(this.combo_usr.getSelectionModel().getSelectedItem());
        su.confirm(u);
          affich();
    }

    @FXML
    private void bloquer(MouseEvent event) throws SQLException, IOException {
           Serviceutilisateur su=new Serviceutilisateur();
        Utilisateur u=new Utilisateur(this.combo_usr.getSelectionModel().getSelectedItem());
        su.block(u);
          affich();
    }

    @FXML
    private void search(KeyEvent event) throws SQLException {
             Serviceutilisateur su=new Serviceutilisateur();

       ArrayList<Utilisateur> list =(ArrayList<Utilisateur>) su.searchUtilisateur(this.id_search.getText());
       ObservableList<Utilisateur> data = FXCollections.observableArrayList(list);
System.out.println(data);
this.row_id.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
this.row_username.setCellValueFactory(new PropertyValueFactory<>("nom_utilisateur"));

this.row_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
this.row_surname.setCellValueFactory(new PropertyValueFactory<>("prénom"));
this.row_age.setCellValueFactory(new PropertyValueFactory<>("age"));

this.id_status.setCellValueFactory(new PropertyValueFactory<>("status"));


this.row_email.setCellValueFactory(new PropertyValueFactory<>("email"));
this.id_salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
this.id_moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
this.id_metier.setCellValueFactory(new PropertyValueFactory<>("metier"));
this.tab_user.setItems(data);
    }

    
    
    
    }

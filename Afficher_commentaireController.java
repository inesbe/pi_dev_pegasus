/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Utilisateur;
import projet.entity.commentaire;
import projet.services.ServiceClass;
import projet.services.ServiceCommentaire;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Afficher_commentaireController implements Initializable {

    @FXML
    private JFXButton id_ajout;
    @FXML
    private Button delete_id;
    @FXML
    private Button modify_butt;
    @FXML
    private JFXButton id_back1;
 
    @FXML
    private TableColumn<commentaire,Integer> row_id_com;
    @FXML
    private TableColumn<commentaire,LocalDate> row_date;
    @FXML
    private TableColumn<commentaire,String> row_email;
    @FXML
    private TableColumn<commentaire,String> row_contenu;
    @FXML
    private JFXComboBox<Integer> combo_commentaire;
    @FXML
    private TableView<commentaire> tab_commentaire;
    @FXML
    private Button stat;

    /**
     * Initializes the controller class.
     */
    void afficher(ServiceCommentaire sc) throws SQLException
    {
        ObservableList<Integer> data2 = FXCollections.observableArrayList(sc.getId_commentaire());
             
            ObservableList<commentaire> data = FXCollections.observableArrayList(sc.getcommentaire());
            row_id_com.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
            row_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            row_email.setCellValueFactory(new PropertyValueFactory<>("age"));
            row_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            
            this.tab_commentaire.setItems(data);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   ServiceCommentaire sc=new ServiceCommentaire();
ArrayList<commentaire> list;
        try {
            
            
            ArrayList<Integer> list2=(ArrayList<Integer>) sc.getId_commentaire();
            ObservableList<Integer> data2 = FXCollections.observableArrayList(list2);
            this.combo_commentaire.setItems(data2);
            
            
            
            list =  (ArrayList<commentaire>) sc.getcommentaire();
            System.out.println(list);
         
ObservableList<commentaire> data = FXCollections.observableArrayList(list);
System.out.println(data);
this.row_id_com.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
this.row_date.setCellValueFactory(new PropertyValueFactory<>("date"));
this.row_email.setCellValueFactory(new PropertyValueFactory<>("email")); 
this.row_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));

this.tab_commentaire.setItems(data);
}
catch (SQLException ex) {
            Logger.getLogger(Afficher_commentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajout(MouseEvent event) throws IOException {
          Stage stage=(Stage)id_ajout.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("ajouter_commentaire.fxml"));
       Scene scene=new Scene(root);
       Projet.Curseur(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException, IOException {
        ServiceCommentaire su=new ServiceCommentaire();
        commentaire u=new commentaire(this.combo_commentaire.getSelectionModel().getSelectedItem());
        su.delete(u);
        affich();
    }

    @FXML
    private void modifier(MouseEvent event) throws IOException {
         Projet.id_sav=this.combo_commentaire.getSelectionModel().getSelectedItem();
              Stage stage=(Stage)this.modify_butt.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("modifier_commentaire.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
          Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    private void affich() throws IOException {
           Stage stage=(Stage)this.delete_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_commentaire.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void stat(MouseEvent event) throws IOException {
              Stage stage=(Stage)this.delete_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("stat_comments.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
        
    }
    
}

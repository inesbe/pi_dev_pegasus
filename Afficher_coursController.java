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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projet.entity.Cours;
import projet.services.Servicecours;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Afficher_coursController implements Initializable {
           
    @FXML
    private JFXButton id_baack3;
    @FXML
    private Label label;
    @FXML
    private TableView<Cours> tab_cours;
    @FXML
    private TableColumn<Cours,Integer> row_id;
    @FXML
    private TableColumn<Cours,String> row_nom;
    @FXML
    private TableColumn<Cours,String> row_domain;
    @FXML
    private TableColumn<Cours,String> row_link;
    @FXML
    private Button id_delete;
    @FXML
    private JFXComboBox<Integer> combo_box;
    @FXML
    private JFXButton id_modifi;
    @FXML
    private ImageView plus;
    @FXML
    private TableColumn<Cours, String> row_link1;
    @FXML
    private JFXTextField id_search;

    /**
     * Initializes the controller class.
     */
    void afficher()
    {
        Servicecours sc = new Servicecours();
        
        try {
            ObservableList<Integer> data2=FXCollections.observableArrayList(sc.get_id());
           combo_box.setItems(data2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
           ArrayList<Cours> lv;
       
        try {
            lv = (ArrayList<Cours>) sc.getCours();
       
            sc.get_id();
            ObservableList<Cours> data = FXCollections.observableArrayList(lv);
     

            row_id.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            row_nom.setCellValueFactory(new PropertyValueFactory<>("nom_cours"));
             row_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
             row_link.setCellValueFactory(new PropertyValueFactory<>("lien"));
             row_link1.setCellValueFactory(new PropertyValueFactory<>("lien2"));
            tab_cours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    Servicecours sc = new Servicecours();
        
        try {
            ObservableList<Integer> data2=FXCollections.observableArrayList(sc.get_id());
           combo_box.setItems(data2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
           ArrayList<Cours> lv;
       
        try {
            lv = (ArrayList<Cours>) sc.getCours();
       
            sc.get_id();
            ObservableList<Cours> data = FXCollections.observableArrayList(lv);
            System.out.println("id_categorie"+data);

            row_id.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            row_nom.setCellValueFactory(new PropertyValueFactory<>("nom_cours"));
             row_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
                 row_link.setCellValueFactory(new PropertyValueFactory<>("lien"));
             row_link1.setCellValueFactory(new PropertyValueFactory<>("lien2"));
            tab_cours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

  

    @FXML
    private void back(ActionEvent event) throws IOException {
       Stage stage=(Stage)id_baack3.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException {
            int id=combo_box.getSelectionModel().getSelectedItem();
       Cours c=new Cours(id);
       Servicecours sc=new Servicecours();
       sc.delete(c);
       afficher();
    }
    

    @FXML
    private void modifier(MouseEvent event) throws IOException {
        Projet.id_sav=combo_box.getSelectionModel().getSelectedItem();
            Stage stage=(Stage)id_modifi.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Modifier_cours.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void add(MouseEvent event) throws IOException {
                Stage stage=(Stage)this.plus.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("ajout_cours.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void search(KeyEvent event) throws SQLException {
        Servicecours sc = new Servicecours();
        ArrayList<Cours> list=(ArrayList<Cours>) sc.searchCours(this.id_search.getText());
         ObservableList<Cours> data = FXCollections.observableArrayList(list);
               row_id.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            row_nom.setCellValueFactory(new PropertyValueFactory<>("nom_cours"));
             row_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
                 row_link.setCellValueFactory(new PropertyValueFactory<>("lien"));
             row_link1.setCellValueFactory(new PropertyValueFactory<>("lien2"));
            tab_cours.setItems(data);
        
        
    }

    @FXML
    private void search1(KeyEvent event) throws SQLException {
            Servicecours sc = new Servicecours();
        ArrayList<Cours> list=(ArrayList<Cours>) sc.searchCours(this.id_search.getText());
         ObservableList<Cours> data = FXCollections.observableArrayList(list);
               row_id.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            row_nom.setCellValueFactory(new PropertyValueFactory<>("nom_cours"));
             row_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
                 row_link.setCellValueFactory(new PropertyValueFactory<>("lien"));
             row_link1.setCellValueFactory(new PropertyValueFactory<>("lien2"));
            tab_cours.setItems(data);
    }

    @FXML
    private void search2(KeyEvent event) throws SQLException {
            Servicecours sc = new Servicecours();
        ArrayList<Cours> list=(ArrayList<Cours>) sc.searchCours(this.id_search.getText());
         ObservableList<Cours> data = FXCollections.observableArrayList(list);
               row_id.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            row_nom.setCellValueFactory(new PropertyValueFactory<>("nom_cours"));
             row_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
                 row_link.setCellValueFactory(new PropertyValueFactory<>("lien"));
             row_link1.setCellValueFactory(new PropertyValueFactory<>("lien2"));
            tab_cours.setItems(data);
    }
    
}

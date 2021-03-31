    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package     projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.services.Service_concours;
import projet.entity.Concours;

/**
 * FXML Controller class
 *
 * @author CHEYMA Farhat
 */
public class Afficher_concoursController implements Initializable {

    @FXML
    private TableColumn<Concours,LocalDate> date_debut;
    @FXML
    private TableColumn<Concours,Integer> id_concours;
    @FXML
    private TableColumn<Concours,String> concours_nom;
    @FXML
    private TableColumn<Concours,LocalDate> date_fin;
    private TableColumn<Concours,Integer> id_class;
    @FXML
    private TableColumn<Concours,Integer> prix;
    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXComboBox<Integer> combo_concours;
    @FXML
    private Button delete_id;
    @FXML
    private TableView<Concours> tab_concours;
    @FXML
    private Button id_add;
    @FXML
    private Button modif_id;
    @FXML
    private JFXTextField id_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
                Service_concours sc = new Service_concours();
        
        try {
            ObservableList<Integer> data2=FXCollections.observableArrayList(sc.get_id());
           this.combo_concours.setItems(data2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
           ArrayList<Concours> lv;
       
        try {
            lv = (ArrayList<Concours>) sc.getConcours();
       
            sc.get_id();
            ObservableList<Concours> data = FXCollections.observableArrayList(lv);
           

            this.id_concours.setCellValueFactory(new PropertyValueFactory<>("id_concours"));
            this.concours_nom.setCellValueFactory(new PropertyValueFactory<>("nom_concours"));
         
             this.date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
              this.date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
              this.prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            this.tab_concours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException {
                  int id=this.combo_concours.getSelectionModel().getSelectedItem();
       Concours c=new Concours(id);
       Service_concours sc=new Service_concours();
       sc.delete(c);
                      
        
        try {
            ObservableList<Integer> data2=FXCollections.observableArrayList(sc.get_id());
           this.combo_concours.setItems(data2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
           ArrayList<Concours> lv;
           
           
    }
       


    @FXML
    private void add(MouseEvent event) throws IOException {
                   Stage stage=(Stage)this.combo_concours.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("ajouter_concours.fxml"));
 
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
        
    }

    @FXML
    private void modif(MouseEvent event) {
    }

    @FXML
    private void search1(KeyEvent event) {
        Service_concours sc=new Service_concours();
             ArrayList<Concours> lv;
                try {
            lv = (ArrayList<Concours>) sc.SearchConcours(this.id_search.getText());
       
    
            ObservableList<Concours> data = FXCollections.observableArrayList(lv);
         
            this.id_concours.setCellValueFactory(new PropertyValueFactory<>("id_concours"));
            this.concours_nom.setCellValueFactory(new PropertyValueFactory<>("nom_concours"));
             this.id_class.setCellValueFactory(new PropertyValueFactory<>("id_class"));
             this.date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
              this.date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
              this.prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            this.tab_concours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    

    @FXML
    private void search2(KeyEvent event) {
              Service_concours sc=new Service_concours();
             ArrayList<Concours> lv;
                try {
            lv = (ArrayList<Concours>) sc.SearchConcours(this.id_search.getText());
       
  
            ObservableList<Concours> data = FXCollections.observableArrayList(lv);
         

            this.id_concours.setCellValueFactory(new PropertyValueFactory<>("id_concours"));
            this.concours_nom.setCellValueFactory(new PropertyValueFactory<>("nom_concours"));
             this.id_class.setCellValueFactory(new PropertyValueFactory<>("id_class"));
             this.date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
              this.date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
              this.prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            this.tab_concours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void search3(KeyEvent event) {
              Service_concours sc=new Service_concours();
             ArrayList<Concours> lv;
                try {
         lv = (ArrayList<Concours>) sc.SearchConcours(this.id_search.getText());
       
         
            ObservableList<Concours> data = FXCollections.observableArrayList(lv);
         

            this.id_concours.setCellValueFactory(new PropertyValueFactory<>("id_concours"));
            this.concours_nom.setCellValueFactory(new PropertyValueFactory<>("nom_concours"));
             this.id_class.setCellValueFactory(new PropertyValueFactory<>("id_class"));
             this.date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
              this.date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
              this.prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            this.tab_concours.setItems(data);
             } catch (SQLException ex) {
            Logger.getLogger(Afficher_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}

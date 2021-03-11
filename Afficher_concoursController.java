/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package     project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import project.Service.Service_concours;
import project.entities.Concours;

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
    @FXML
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
       
        try {
            lv = (ArrayList<Concours>) sc.getConcours();
       
            sc.get_id();
            ObservableList<Concours> data = FXCollections.observableArrayList(lv);
            System.out.println("id_categorie"+data);

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

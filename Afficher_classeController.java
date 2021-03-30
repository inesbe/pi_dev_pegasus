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
import projet.entity.Classe;
import projet.entity.Cours;
import projet.services.ServiceClass;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Afficher_classeController implements Initializable {

    @FXML
    private JFXButton id_ajout;
    @FXML
    private JFXButton id_back1;
    @FXML
    private TableColumn<Classe,Integer> row_id;
    @FXML
    private TableColumn<Classe,String> row_name;
    @FXML
    private TableColumn<Classe,Integer> row_age;
    @FXML
    private TableColumn<Classe,Integer> row_teacher;
    @FXML
    private TableView<Classe> tab_class;
    @FXML
    private JFXComboBox<Integer> combo_clas;
    @FXML
    private Button modify_butt;
    @FXML
    private Button delete_id;

    /**
     * Initializes the controller class.
     */
    
    
    
    void afficher(ServiceClass sc) throws SQLException
    {
        ObservableList<Integer> data2 = FXCollections.observableArrayList(sc.getId_Class());
             this.combo_clas.setItems(data2);
            ObservableList<Classe> data = FXCollections.observableArrayList(sc.getclasse());
            row_id.setCellValueFactory(new PropertyValueFactory<>("id_class"));
            row_name.setCellValueFactory(new PropertyValueFactory<>("nom_class"));
            this.row_age.setCellValueFactory(new PropertyValueFactory<>("age"));
       
            
            tab_class.setItems(data);  
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceClass sc=new ServiceClass();
        
        try {
            
           
            afficher(sc);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_classeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajout(MouseEvent event) throws IOException {
         Stage stage=(Stage)id_ajout.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("ajouter_classe.fxml"));
       Scene scene=new Scene(root);
       Projet.Curseur(root);
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

    @FXML
    private void modifier(MouseEvent event) throws IOException {
        Projet.id_sav=this.combo_clas.getSelectionModel().getSelectedItem();
              Stage stage=(Stage)this.modify_butt.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("modifier_classe.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException {
         ServiceClass sc=new ServiceClass();
         
         Classe c=new Classe(this.combo_clas.getSelectionModel().getSelectedItem());
         sc.delete(c);
         afficher(sc);
         
         
    }
    
}

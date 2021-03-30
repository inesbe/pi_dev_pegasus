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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Classe;
import projet.entity.Utilisateur;
import projet.services.ServiceClass;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Modifier_classeController implements Initializable {

    @FXML
    private JFXButton id_affich;
    @FXML
    private TextField classname_id;
    @FXML
    private JFXComboBox<Integer> teacher_id;
    @FXML
    private TextField ageclass_id;
    
    @FXML
    private JFXButton but_modif_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceClass sc = new ServiceClass();
     
            ObservableList<Integer> data2;
       
        try {
            data2 = FXCollections.observableArrayList(sc.getTeacher());
            this.teacher_id.setItems(data2);
        } catch (SQLException ex) {
            Logger.getLogger(Modifier_classeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void affich(MouseEvent event) throws IOException {
        Stage stage=(Stage)this.id_affich.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_classe.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void modifierclass(MouseEvent event) throws SQLException {
        ServiceClass cl=new ServiceClass();
        Classe t=new Classe(Projet.id_sav,this.teacher_id.getSelectionModel().getSelectedItem(),this.classname_id.getText(),Integer.parseInt(this.ageclass_id.getText()));
        System.out.println(t);
        cl.update(t);
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import projet.entity.commentaire;
import projet.services.ServiceClass;
import projet.services.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Ajouter_commentaireController implements Initializable {

    @FXML
    private JFXButton id_add_com;
    @FXML
    private JFXButton id_affich_comm;
    @FXML
    private TextField id_email;
    @FXML
    private JFXDatePicker id_combo_date;
    @FXML
    private TextField id_contenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
       
           
    }    

    @FXML
    private void add(MouseEvent event) throws SQLException {
           ServiceCommentaire sc = new ServiceCommentaire();
     commentaire c=new commentaire(this.id_email.getText(),this.id_contenu.getText(),this.id_combo_date.getValue());
     System.out.println(c);
     sc.add(c);
    }

    @FXML
    private void affich(MouseEvent event) throws IOException {
               Stage stage=(Stage)this.id_affich_comm.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_commentaire.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void back(MouseEvent event) {
    }
    
}

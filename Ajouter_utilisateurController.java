/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Utilisateur;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Ajouter_utilisateurController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton id_affich;
    @FXML
    private TextField id_user;
    @FXML
    private TextField id_name;
    @FXML
    private TextField id_surname;
    @FXML
    private TextField id_age;
    @FXML
    private PasswordField id_pass;
    @FXML
    private JFXButton id_add;
    @FXML
    private TextField id_email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void affich(MouseEvent event) throws IOException {
         Stage stage=(Stage)id_affich.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_utilisateur.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void add(MouseEvent event) throws SQLException {
        Serviceutilisateur su=new Serviceutilisateur();
        Utilisateur u=new Utilisateur(id_user.getText(),this.id_pass.getText(),this.id_name.getText(),this.id_surname.getText(),Integer.parseInt(this.id_age.getText()),this.id_email.getText());
        
        su.add(u);
    }
    
}

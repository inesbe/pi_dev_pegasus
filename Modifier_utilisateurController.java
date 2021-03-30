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
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Utilisateur;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Modifier_utilisateurController implements Initializable {

    @FXML
    private JFXButton modif_id;
    @FXML
    private JFXButton id_affich;
    @FXML
    private JFXButton id_back1;
    @FXML
    private TextField id_username;
    @FXML
    private TextField id_name;
    @FXML
    private TextField id_surname;
    @FXML
    private TextField id_age;
    @FXML
    private TextField id_email;
    @FXML
    private PasswordField id_password;
    @FXML
    private ImageView bird2;
    @FXML
    private ImageView bird1;
    @FXML
    private ImageView pen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ;
        
        this.id_age.setText(String.valueOf(Afficher_utilisateurController.user.getAge()));
        this.id_email.setText(Afficher_utilisateurController.user.getEmail());
        this.id_name.setText(Afficher_utilisateurController.user.getNom());
        this.id_surname.setText(Afficher_utilisateurController.user.getPrénom());
        this.id_username.setText(Afficher_utilisateurController.user.getNom_utilisateur());
       
        
        
        
        System.out.println(Projet.id_sav);
        bird1.relocate(32,111);
        bird1.setLayoutX(11);
        bird1.setLayoutY(346);
        TranslateTransition transition4 = new TranslateTransition(); 
        transition4.setDuration(javafx.util.Duration.seconds(3));
        transition4.setToX(100);
        transition4.setToY(100);
        transition4.setAutoReverse(true);
        transition4.setCycleCount(Animation.INDEFINITE);
        transition4.setNode(bird1);
        transition4.play();
        bird2.relocate(982,112);
        bird2.setLayoutX(982);
        bird2.setLayoutY(112);
        TranslateTransition transition5 = new TranslateTransition(); 
        transition5.setDuration(javafx.util.Duration.seconds(3));
        transition5.setToX(100);
        transition5.setToY(100);
        transition5.setAutoReverse(true);
        transition5.setCycleCount(Animation.INDEFINITE);
        transition5.setNode(bird2);
        transition5.play();
        pen.relocate(414,118);
        pen.setLayoutX(414);
        pen.setLayoutY(118);
        TranslateTransition transition6 = new TranslateTransition(); 
        transition6.setDuration(javafx.util.Duration.seconds(3));
        transition6.setToX(100);
        transition6.setAutoReverse(true);
        transition6.setCycleCount(Animation.INDEFINITE);
        transition6.setNode(pen);
        transition6.play();
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
    private void back(MouseEvent event) {
    }
   

    private void modif_user(MouseEvent event) throws SQLException {
      
        
    }

    @FXML
    private void modify(MouseEvent event) throws SQLException {
          Serviceutilisateur su=new Serviceutilisateur();
        Utilisateur u=new Utilisateur(Projet.id_sav,crypt.encrypt(this.id_username.getText()),this.id_password.getText(),this.id_name.getText(),this.id_surname.getText(),Integer.parseInt(this.id_age.getText()),this.id_email.getText());
        System.out.println(u);
            su.update(u);
    }
}

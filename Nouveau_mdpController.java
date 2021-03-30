/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Nouveau_mdpController implements Initializable {

    @FXML
    private JFXButton id_back;
    @FXML
    private JFXButton id_ok;
    private PasswordField id_confirm_new;
    @FXML
    private Text new_pass_titre;
    @FXML
    private ImageView pen;
    @FXML
    private CheckBox show_id;
    @FXML
    private PasswordField pass_hidden;
    @FXML
    private TextField pass_text;
    @FXML
    private TextField new_txt;
    @FXML
    private PasswordField id_new;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pen.relocate(397,136);
        pen.setLayoutX(397);
        pen.setLayoutY(136);
        TranslateTransition transition6 = new TranslateTransition(); 
        transition6.setDuration(javafx.util.Duration.seconds(3));
        transition6.setToX(90);
        transition6.setAutoReverse(true);
        transition6.setCycleCount(Animation.INDEFINITE);
        transition6.setNode(pen);
        transition6.play();
    }    

    @FXML
    private void go_login(MouseEvent event) throws IOException {
                Stage stage=(Stage)this.id_ok.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("sign_in.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
                Stage stage=(Stage)this.id_back.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("sign_in.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void nouveau_mdp(MouseEvent event) throws SQLException, IOException {
                

        
        if(this.id_new.getText().equals(this.pass_hidden.getText()))
                {
        Serviceutilisateur su=new Serviceutilisateur();
        
       su.update_password(crypt.encrypt(this.id_new.getText()),Recuperation_mdpController.mail_S); 
       
       
            Stage stage=(Stage)this.id_ok.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("sign_in.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
                }
        
    else
        {
            
              Alert a=new Alert(Alert.AlertType.WARNING); a.setContentText("The passwords you wrote are not the same "); a.setHeaderText(null); a.showAndWait();
        }
    }

    @FXML
    private void login(ActionEvent event) throws SQLException, IOException {

}

    @FXML
    private void show_passw(MouseEvent event) {
      if (show_id.isSelected())
      {
          this.id_new.setVisible(false);
          this.new_txt.setVisible(true);
          this.new_txt.setText(this.id_new.getText());
          
          
          
          
   this.pass_hidden.setVisible(false);
   this.pass_text.setVisible(true);
  this.pass_text.setText(this.pass_hidden.getText());
      }
      else
      {
           this.id_new.setVisible(true);
          this.new_txt.setVisible(false);
         this.pass_hidden.setVisible(true);
   this.pass_text.setVisible(false);    
      }
      
    }





}
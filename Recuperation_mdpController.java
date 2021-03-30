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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projet.entity.Utilisateur;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Recuperation_mdpController implements Initializable {

    @FXML
    private ImageView id_sun;
    @FXML
    private JFXButton id_back2;
    @FXML
    private ImageView id_send;
    @FXML
    private Label id_lab;
    @FXML
    private TextField code_id;
    @FXML
    private JFXButton confirm_id;
    @FXML
    private TextField mail;
static String mail_S;
    @FXML
    private JFXComboBox<?> combo_lang;
    @FXML
    private JFXButton id_set;
    @FXML
    private Text forgot_txt;
    @FXML
    private Label email_txt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          id_sun.relocate(32,111);
        id_sun.setLayoutX(32);
        id_sun.setLayoutY(120);
        TranslateTransition transition3 = new TranslateTransition(); 
        transition3.setDuration(javafx.util.Duration.seconds(3));
        transition3.setToX(100);
        transition3.setToY(100);
        transition3.setToZ(100);
        transition3.setAutoReverse(true);
        transition3.setCycleCount(Animation.INDEFINITE);
        transition3.setNode(id_sun);
        transition3.play();
    }    

    @FXML
    private void back2(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
              Stage stage=(Stage)this.id_back2.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("sign_in.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    int random()
    {
    int max=9999;
    int min=1000;
    int rand=(int) (Math.random() * (max-min+1) + min);
        return rand;
    } 
    
    @FXML
    private void send_mail(MouseEvent event) throws SQLException {
     mail m =new mail();
     int n=random();
     String s="Your confirmation code is : "+n;
     System.out.println(s);
   mail_S=mail.getText();
     m.message(mail.getText(),s);
        Utilisateur u=new Utilisateur(mail.getText());
     Serviceutilisateur su=new Serviceutilisateur();
     
     
     su.forget_password(u,n);
        this.id_lab.setOpacity(1);  
      this.code_id.setOpacity(1);
      this.confirm_id.setOpacity(1);
      
    } 

    @FXML
    private void confirm_cod(MouseEvent event) throws SQLException, IOException {
     Serviceutilisateur su=new Serviceutilisateur();  
         Utilisateur u=new Utilisateur(mail.getText());
     if(Integer.parseInt(this.code_id.getText())==su.getcode(u))
     {
         
        System.out.println("Your code is correct");
        
         Stage stage=(Stage)this.confirm_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("nouveau_mdp.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
         
     }
            
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.gtranslate.Language;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JProgressBar;
import projet.entity.Enfant;
import projet.entity.Utilisateur;
import projet.entity.Parents;
import projet.services.Serviceutilisateur;
/**
 * FXML Controller class
 *
 * @author Espace Info
 */

public class RegisterController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     */
    
    
     @FXML
JFXButton id_back1;
    @FXML
    private TextField id_user;
    @FXML
    private TextField id_name;
    @FXML
    private TextField id_age;
    @FXML
    private TextField id_email;
    @FXML
    private JFXButton id_add;
    @FXML
    private TextField id_surname;
    @FXML
    private PasswordField id_pass;
    @FXML
    private ImageView sun2;
    @FXML
    private JFXComboBox<String> id_role;
    @FXML
    private TextField id_user1;
    @FXML
    private Label log_id;
    @FXML
    private ProgressBar progBar;
    @FXML
    private JFXComboBox<String> combo_langue;
    @FXML
    private Label email_txt;
    @FXML
    private Label surname_txt;
    @FXML
    private Label age_txt;
    @FXML
    private Label user_txt;
    @FXML
    private Label name_txt;
    @FXML
    private Label account_txt;
    @FXML
    private Label password_txt;
    @FXML
    private JFXButton id_set;
    @FXML
    private JFXTextField photo_id;

     

       @FXML
    void back(MouseEvent event) throws IOException
    {
 Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
     
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        ArrayList<String> list=new ArrayList<>();
        list.add("Enfant");
        list.add("Enseignant");
          list.add("Parent");
            ObservableList<String> data=FXCollections.observableArrayList(list);
        this.id_role.setItems(data);
        
        
        sun2.relocate(32,120);
        sun2.setLayoutX(32);
        sun2.setLayoutY(120);
        TranslateTransition transition8 = new TranslateTransition(); 
        transition8.setDuration(javafx.util.Duration.seconds(3));
        transition8.setToX(100);
        transition8.setToY(100);
        transition8.setToZ(100);
        transition8.setAutoReverse(true);
        transition8.setCycleCount(Animation.INDEFINITE);
        transition8.setNode(sun2);
        transition8.play();
           ArrayList<String> list1=new ArrayList<>();
         list1.add("francais");
         list1.add("العربية");
         list1.add("Deutsche");
         list1.add("English");
         ObservableList<String> data1 = FXCollections.observableArrayList(list1);
    
        
        this.combo_langue.setItems(data1); 
    }    

    @FXML
    private void add(ActionEvent event) throws SQLException {
        if(id_user.getText().equals("") || this.id_age.getText().equals("") || this.id_name.getText().equals("") || this.id_surname.getText().equals("") || this.id_pass.getText().equals("") || this.id_user.getText().equals(""))
        {
           
            Alert a=new Alert(Alert.AlertType.WARNING); a.setContentText("Please fill all fields "); a.setHeaderText(null); a.showAndWait();
        }
        else
        {
          Serviceutilisateur su=new Serviceutilisateur();
          if(this.id_role.getSelectionModel().getSelectedIndex()==2)
          {
        Parents u=new Parents(this.id_user1.getText(),id_user.getText(),crypt.encrypt(this.id_pass.getText()),this.id_name.getText(),this.id_surname.getText(),Integer.parseInt(this.id_age.getText()),this.id_email.getText(),2);
          su.add2(u);
          }
          else if(this.id_role.getSelectionModel().getSelectedIndex()==0)
          {
           Enfant u=new Enfant(this.photo_id.getText(),id_user.getText(),crypt.encrypt(this.id_pass.getText()),this.id_name.getText(),this.id_surname.getText(),Integer.parseInt(this.id_age.getText()),this.id_email.getText(),0);   
              su.add3(u);
          }
          
          else
          {
           Utilisateur u1=new Utilisateur(id_user.getText(),crypt.encrypt(this.id_pass.getText()),this.id_name.getText(),this.id_surname.getText(),Integer.parseInt(this.id_age.getText()),this.id_email.getText(),this.id_role.getSelectionModel().getSelectedIndex());
          su.add(u1);
          }
      
                
                }}

    @FXML
    private void combo(MouseEvent event) {
   
    }

    @FXML
    private void combo2(Event event) {
     
    }

    @FXML
    private void combo4(Event event) {
        System.out.println( this.id_role.getSelectionModel().getSelectedIndex());
        if(this.id_role.getSelectionModel().getSelectedIndex()==2)
        {
            this.id_user1.setOpacity(1);
            
            
        }
        else
        {
          this.id_user1.setOpacity(0);
        }
    }

    @FXML
    private void combo3(Event event) {
  
    }

    @FXML
    private void log(MouseEvent event) throws IOException {
                 Stage stage=(Stage)this.log_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("sign_in.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    } 
   
    @FXML
    private void prog(KeyEvent event) {
        
        if(this.id_pass.getText().length()<=4 )
        {
           this.progBar.setStyle("-fx-accent :red;");
       this.progBar.setProgress(0.3);
        }
        else if(this.id_pass.getText().length()> 4 && this.id_pass.getText().length() <= 8  )
        {
         this.progBar.setStyle("-fx-accent :yellow;");
       this.progBar.setProgress(0.6);   
        }
        else
        {
           this.progBar.setStyle("-fx-accent :green;");
       this.progBar.setProgress(1);    
            
        }
    
    }

    @FXML
    private void prog3(KeyEvent event) {
            if(this.id_pass.getText().length()<=4 )
        {
           this.progBar.setStyle("-fx-accent :red;");
       this.progBar.setProgress(0.3);
        }
        else if(this.id_pass.getText().length()> 4 && this.id_pass.getText().length() <= 8  )
        {
         this.progBar.setStyle("-fx-accent :yellow;");
       this.progBar.setProgress(0.6);   
        }
        else
        {
           this.progBar.setStyle("-fx-accent :green;");
       this.progBar.setProgress(1);    
            
        }
    }

    @FXML
    private void prog2(KeyEvent event) {
            if(this.id_pass.getText().length()<=4 )
        {
           this.progBar.setStyle("-fx-accent :red;");
       this.progBar.setProgress(0.3);
        }
        else if(this.id_pass.getText().length()> 4 && this.id_pass.getText().length() <= 8  )
        {
         this.progBar.setStyle("-fx-accent :yellow;");
       this.progBar.setProgress(0.6);   
        }
        else
        {
           this.progBar.setStyle("-fx-accent :green;");
       this.progBar.setProgress(1);    
            
        }
    }

    @FXML
    private void lang(Event event) {  
        if (this.combo_langue.getSelectionModel().getSelectedIndex()==0)
        {
           this.account_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.account_txt.getText()));
                this.id_user.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_user.getPromptText()));
                 this.name_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.name_txt.getText()));
                 this.id_name.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_name.getPromptText()));
              this.id_surname.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_surname.getPromptText()));
              this.id_age.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_age.getPromptText()));
              this.id_email.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_email.getPromptText()));
              this.id_pass.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_pass.getPromptText()));
                      this.id_role.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_role.getPromptText()));
                      this.combo_langue.setPromptText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.combo_langue.getPromptText()));
                      this.surname_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.surname_txt.getText()));
                      this.age_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.age_txt.getText()));
                      this.email_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.email_txt.getText()));
                      this.password_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.password_txt.getText()));
                      this.account_txt.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.account_txt.getText()));
                      this.log_id.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.log_id.getText()));
                      this.id_back1.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_back1.getText()));
                      this.id_add.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_add.getText()));
                      this.id_set.setText(GoogleTTS_Translate.google_Translate(Language.FRENCH,this.id_set.getText()));
        } 
        else if (this.combo_langue.getSelectionModel().getSelectedIndex()==1)
        {
         this.account_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.account_txt.getText()));
                this.id_user.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_user.getPromptText()));
                 this.name_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.name_txt.getText()));
                 this.id_name.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_name.getPromptText()));
              this.id_surname.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_surname.getPromptText()));
              this.id_age.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_age.getPromptText()));
              this.id_email.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_email.getPromptText()));
              this.id_pass.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_pass.getPromptText()));
                      this.id_role.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_role.getPromptText()));
                      this.combo_langue.setPromptText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.combo_langue.getPromptText()));
                      this.surname_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.surname_txt.getText()));
                      this.age_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.age_txt.getText()));
                      this.email_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.email_txt.getText()));
                      this.password_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.password_txt.getText()));
                      this.account_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.account_txt.getText()));
                      this.log_id.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.log_id.getText()));
                      this.id_back1.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_back1.getText()));
                      this.id_add.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_add.getText()));
                      this.id_set.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.id_set.getText()));
                       this.user_txt.setText(GoogleTTS_Translate.google_Translate(Language.ARABIC,this.user_txt.getText()));
        }
    }

    @FXML
    private void photo(MouseEvent event) {
                   Stage stage = new Stage();
           FileChooser photo = new FileChooser();
            stage.setTitle("File Chooser Sample");
      
        
            File file = photo.showOpenDialog(stage);
            if (file != null) {
                String cwd = System. getProperty("user.dir");
            
                this.photo_id.setText(new File(cwd).toURI().relativize(file.toURI()).getPath());
               
            }
    }


             
             
     
   }

        
      
        
        
        
        
        
        
    
    


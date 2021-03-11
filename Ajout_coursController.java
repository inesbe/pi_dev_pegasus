/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projet.entity.Cours;
import projet.services.Servicecours;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class Ajout_coursController implements Initializable {

    @FXML
    private JFXButton id_back1;
    private TextField id_cours;
    @FXML
    private TextField id_name;
    @FXML
    private TextField id_domain;
    @FXML
    private TextField id_lien;
    @FXML
    private JFXButton afficher;
    @FXML
    private ImageView search;
    @FXML
    private ImageView search1;
    @FXML
    private TextField id_lien1;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void back(ActionEvent event) throws IOException {
       Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        
        
        
        
        if( id_name.getText().equals("") || id_domain.getText().equals("")  )
        {
               Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
         a.setHeaderText(null);
         a.showAndWait();
            
        }
        else if(!(id_domain.getText().equals("Math") ||  id_domain.getText().equals("Francais") || id_domain.getText().equals("anglais") || id_domain.getText().equals("Science")))
        {
             Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText(id_domain.getText()+"  "+"is not a domain ");
         a.setHeaderText(null);
         a.showAndWait(); 
        }
        else
        {
   Cours c=new Cours(1,id_name.getText(),id_domain.getText(),id_lien.getText(),this.id_lien1.getText());
   Servicecours sc=new Servicecours();
   sc.add(c);
        }
    }

    @FXML
    private void show(ActionEvent event) throws IOException {
       Stage stage=(Stage)afficher.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("affiche_cours.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void get_directory(MouseEvent event) {
           Stage stage = new Stage();
           FileChooser photo = new FileChooser();
            stage.setTitle("File Chooser Sample");
      
        
            File file = photo.showOpenDialog(stage);
            if (file != null) {
                String cwd = System. getProperty("user.dir");
            
                this.id_lien.setText(new File(cwd).toURI().relativize(file.toURI()).getPath());
               
            }
                }

    @FXML
    private void get_directory_2(MouseEvent event) {
            Stage stage = new Stage();
           FileChooser photo = new FileChooser();
            stage.setTitle("File Chooser Sample");
      
        
            File file = photo.showOpenDialog(stage);
            if (file != null) {
                String cwd = System. getProperty("user.dir");
            
                this.id_lien.setText(new File(cwd).toURI().relativize(file.toURI()).getPath());
               
            }
    }

    @FXML
    private void get_directory_3(MouseEvent event) {
                  Stage stage = new Stage();
           FileChooser photo = new FileChooser();
            stage.setTitle("File Chooser Sample");
      
        
            File file = photo.showOpenDialog(stage);
            if (file != null) {
                String cwd = System. getProperty("user.dir");
            
                this.id_lien1.setText(new File(cwd).toURI().relativize(file.toURI()).getPath());
               
            }
    }
    
}

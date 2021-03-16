/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Espace Info
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private JFXButton id_signin;
    @FXML
    private JFXButton id_register;
      @FXML
    private ImageView id_hibou;
    
    @FXML
    private ImageView img1_id;
    int occ=0;
    int x=3;
    int j=0;
    @FXML
    private Label label;
    @FXML
    private JFXButton bupdateg;
    @FXML
    private JFXButton pageaffg;
    @FXML
    private JFXButton ADDSTAGE;
    @FXML
    private JFXButton SHOWSTAGE;
    @FXML
    private JFXButton UPDATESTAGE;
    @FXML
    private JFXButton STAGESFRONT;
    
     @FXML
    void register(MouseEvent event) throws IOException
    {  Stage stage=(Stage)id_signin.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Afficher_jeu.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************

      stage.setScene(scene);
      stage.show();
      
      }

    
  
    
        
        
    
    @FXML
    void sign_in(MouseEvent event) throws IOException
    {  Stage stage=(Stage)id_signin.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Ajouter_jeu.fxml"));
       Scene scene=new Scene(root);
          //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
     
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
      
        img1_id.relocate(50,50);
        img1_id.setLayoutX(480);
        img1_id.setLayoutY(100);
        TranslateTransition transition = new TranslateTransition(); 
        transition.setDuration(javafx.util.Duration.seconds(3));
        transition.setToX(100);
        id_hibou.relocate(50,50);
        id_hibou.setLayoutX(500);
        id_hibou.setLayoutY(560);
        TranslateTransition transition2 = new TranslateTransition(); 
        transition2.setDuration(javafx.util.Duration.seconds(3));
        transition2.setToY(100);
       
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(img1_id);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setNode(id_hibou);
        transition.play();
        transition2.play();
     
        
        
        
        
           
        }

    @FXML
    private void updatepage(MouseEvent event) throws IOException {
          Stage stage=(Stage)id_signin.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Modifier_jeu.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void pagegames(ActionEvent event) throws IOException {
            Stage stage=(Stage)id_signin.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void GOADDSTAGE(MouseEvent event) throws IOException {
                Stage stage=(Stage)ADDSTAGE.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Ajouter_Stage.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void GOSHOWSTAGE(MouseEvent event) throws IOException {
                    Stage stage=(Stage)ADDSTAGE.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Afficher_Stage.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void GOUPDATESTAGE(MouseEvent event) throws IOException {
                            Stage stage=(Stage)ADDSTAGE.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Modifier_Stage.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
        
        
    }

    @FXML
    private void GOSTAGES(MouseEvent event) {
    }

    @FXML
    private void GOSTARTSTAGE(ActionEvent event) throws IOException {
                              Stage stage=(Stage)ADDSTAGE.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Play_Stage.fxml"));
       Scene scene=new Scene(root);
    //****************************************************************************   
       //change cursor
       Image image = new Image("/projet/img/srcb.gif"); 
            
root.setCursor(new ImageCursor(image));
  //***************************
      stage.setScene(scene);
      stage.show();
          
    }
    
}


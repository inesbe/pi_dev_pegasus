/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Stages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceJeu;
import services.ServiceStage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Ajouter_StageController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private TextField ids;
    @FXML
    private TextField numbers;
    @FXML
    private TextField texts;
    @FXML
    private TextField trys;
    @FXML
    private JFXButton adds;
    @FXML
    private TextField corrections;
    @FXML
    private TextField sources;
    @FXML
    private ImageView upsource;
    @FXML
    private TextField times;
    @FXML
    private JFXComboBox<Integer> games;

    /**
     * Initializes the controller class.
     * @param url
     */
     ServiceStage ss=new ServiceStage();
     ServiceJeu sj=new ServiceJeu();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
             ArrayList<Integer> lid;

            try {
                //combobox
                lid = (ArrayList<Integer>) sj.getId();
            games.getItems().addAll(lid);
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }    
    
    
    
    
    
    
    
   

    @FXML
    private void back(ActionEvent event) throws IOException {
                Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

  

    @FXML
    private void AddStage(ActionEvent event) throws SQLException {
       //*************
       int tesst=0;

           
           //*****************
            if(ids.getText().isEmpty() || games.getSelectionModel().isEmpty() || numbers.getText().isEmpty())
        {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("");
      alert.setHeaderText("Empty Field!!!");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
            return;
        }
        
       
   
          int id=Integer.parseInt(ids.getText());
           System.out.println("id");
       int n=Integer.parseInt(numbers.getText());
   System.out.println("number");
         

               System.out.println("Hereee");
              ArrayList<Stages> lstg=(ArrayList<Stages>) ss.read();
               System.out.println("Heree2");
       //if(lstg.get(0))
       
       for(int h=0;h<lstg.size();h++)
       {
           if(lstg.get(h).getNumero()==n && lstg.get(h).getJeu()==games.getValue())
           {      System.out.println("Ooops exist");
               Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("");
      alert.setHeaderText("This stage Exist!!!");
                Optional<ButtonType> option = alert.showAndWait();
     
               return;
           }
           System.out.println("NIICE!!");
       }    
           int t=Integer.parseInt(times.getText());
           System.out.println("time");
          
int g=games.getValue();
       
       Stages j = new Stages(id,n,texts.getText(),trys.getText(),corrections.getText(),sources.getText(),t,g);
        
       
       


       ServiceStage sj= new ServiceStage();
try {
       sj.add(j);
       //INFO
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("");
      alert.setHeaderText("ADDED SUCCESSFULLY !");
            Optional<ButtonType> option = alert.showAndWait();
            
            
            //clear
            ids.clear();
            numbers.clear();
            texts.clear();
            trys.clear();
            corrections.clear();
            sources.clear();
            times.clear();
            

    } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("");
      alert.setHeaderText("ADD FAILED");
      Optional<ButtonType> option = alert.showAndWait();
        }
                                                                }

    @FXML
    private void Loadimg(MouseEvent event) throws IOException {
        Stage stage=(Stage)upsource.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        
fileChooser.setTitle("Open Resource File");
fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images","*.png","*.jpg","*.gif"));
File f=fileChooser.showOpenDialog(stage);
sources.setText(f.getName());
    }
    
    
       @FXML
    private void Onlynumbers(KeyEvent event) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
         String c=event.getCharacter();
    
            if(pattern.matcher(c).matches())
            {
     
         System.out.println("Not number");

            }
            else 
                 event.consume();
               
    
               
        
        
        
    }
    
    
    
}

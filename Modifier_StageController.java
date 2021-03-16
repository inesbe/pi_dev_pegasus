/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Stages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.stage.Stage;
import services.ServiceJeu;
import services.ServiceStage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Modifier_StageController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private TextField numbers;
    @FXML
    private TextField texts;
    @FXML
    private TextField trys;
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
    @FXML
    private JFXComboBox<Integer> cids;

    /**
     * Initializes the controller class.
     */
    ServiceStage ss=new ServiceStage();
        ServiceJeu sj=new ServiceJeu();

    @FXML
    private JFXButton updates;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                   ArrayList<Integer> lid,lij;

            try {
                //combobox
                lid = (ArrayList<Integer>) ss.getId();
            cids.getItems().addAll(lid);
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
              try {
                //combobox
                lij = (ArrayList<Integer>) sj.getId();
            games.getItems().addAll(lij);
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
            }   
      
        
    }    

   


    @FXML
    private void Loadimg(MouseEvent event) {
    }
    @FXML
    private void fillmodstage(ActionEvent event) {
        
        
                                  Stages jl;

        if(cids.getValue()!=null)
        try {
              System.out.println("CAAA VAA");
            jl= ss.searchStage(cids.getValue());
                      

                  numbers.setText(String.valueOf(jl.getNumero()));
            texts.setText(jl.getTexte());
           trys.setText(jl.getEssai());
           corrections.setText(jl.getCorrection());
           sources.setText(jl.getSource());
                      times.setText(String.valueOf(jl.getTemps()));
games.setValue(jl.getJeu());

        } catch (SQLException ex) {
            Logger.getLogger(Modifier_jeuController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void UpdateStage(ActionEvent event) throws IOException, SQLException {
          if(cids.getSelectionModel().isEmpty() || games.getSelectionModel().isEmpty())
        {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("");
      alert.setHeaderText("Empty Field!!!");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
            return;
        }
        
        
            if(showalert()) 
       { int n=Integer.parseInt(numbers.getText());
      int t=Integer.parseInt(times.getText());
      
        Stages j=new Stages(cids.getValue(),n,texts.getText(),trys.getText(),corrections.getText(),sources.getText(),t,games.getValue());
                          // System.out.println("DOOOOOOOOOOOONE");

        ss.update(j);

       }   
    }
    
    
           private boolean showalert() throws IOException {
        
          
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("");
      alert.setHeaderText("do you really want to update the id "+cids.getValue()+" ?");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
 
            return option.get() == ButtonType.OK;
    
        
        
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

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServiceStage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Afficher_StageController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton deletes;
    @FXML
    private JFXComboBox<Integer> cstages;
    @FXML
    private TableColumn<?, ?> cidstage;
    @FXML
    private TableColumn<?, ?> cnumerostage;
    @FXML
    private TableColumn<?, ?> ctextestage;
    @FXML
    private TableColumn<?, ?> cessaistage;
    @FXML
    private TableColumn<?, ?> ccorrectionstage;
    @FXML
    private TableColumn<?, ?> csourcestage;
    @FXML
    private TableColumn<?, ?> ctempsstage;
    @FXML
    private TableColumn<?, ?> cjeustage;

    /**
     * Initializes the controller class.
     */
            ServiceStage sj = new ServiceStage();
    @FXML
    private TableView<Stages> affistages;
    @FXML
    private Label lsearch;
    @FXML
    private TextField sg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_StageController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void DeleteStage(ActionEvent event) throws IOException, SQLException {
         if(showalert())
    {     
        
       try{ 
        sj.delete(cstages.getValue());  
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("");
      alert.setHeaderText("DELETED SUCCESSFULLY !");
      Optional<ButtonType> option = alert.showAndWait();
       }catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("");
      alert.setHeaderText("DELETE FAILED");
      Optional<ButtonType> option = alert.showAndWait();
        }
      cstages.getItems().removeAll(cstages.getItems()); 
     afficher();
     affistages.refresh();
     
        System.out.println("kkkkkkkkkkkk");
    }
    }
    
    private void afficher() throws SQLException {
   


  ArrayList<Stages> lj;
       
        try {
            lj = (ArrayList<Stages>) sj.read();
       
            ObservableList<Stages> data = FXCollections.observableArrayList(lj);

            cidstage.setCellValueFactory(new PropertyValueFactory<>("id"));
            cnumerostage.setCellValueFactory(new PropertyValueFactory<>("numero"));
             ctextestage.setCellValueFactory(new PropertyValueFactory<>("texte"));
            cessaistage.setCellValueFactory(new PropertyValueFactory<>("essai"));
            ccorrectionstage.setCellValueFactory(new PropertyValueFactory<>("correction"));
            csourcestage.setCellValueFactory(new PropertyValueFactory<>("source"));
                        ctempsstage.setCellValueFactory(new PropertyValueFactory<>("temps"));
cjeustage.setCellValueFactory(new PropertyValueFactory<>("jeu"));

            affistages.setItems(data);
                    } catch (SQLException ex) {
            Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ArrayList<Integer> lid;
        
         //combobox
         lid = (ArrayList<Integer>) sj.getId();
         cstages.getItems().addAll(lid);
   
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
                   Stage stage=(Stage)id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
          private boolean showalert() throws IOException {
        
          
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("");
      alert.setHeaderText("do you really want to delete the id "+cstages.getValue()+" ?");
   
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
 
            return option.get() == ButtonType.OK;
    
        
        
    }

    @FXML
    private void searchgame(MouseEvent event) throws SQLException {
       if(!sg.getText().isEmpty()) 
       { System.out.println("not vide");
           int x=Integer.parseInt(sg.getText());
      
        

  ArrayList<Stages> lj;
       
        try {
            lj = (ArrayList<Stages>) sj.stageofgame(x);
       
            ObservableList<Stages> data = FXCollections.observableArrayList(lj);

            cidstage.setCellValueFactory(new PropertyValueFactory<>("id"));
            cnumerostage.setCellValueFactory(new PropertyValueFactory<>("numero"));
             ctextestage.setCellValueFactory(new PropertyValueFactory<>("texte"));
            cessaistage.setCellValueFactory(new PropertyValueFactory<>("essai"));
            ccorrectionstage.setCellValueFactory(new PropertyValueFactory<>("correction"));
            csourcestage.setCellValueFactory(new PropertyValueFactory<>("source"));
                        ctempsstage.setCellValueFactory(new PropertyValueFactory<>("temps"));
cjeustage.setCellValueFactory(new PropertyValueFactory<>("jeu"));

            affistages.setItems(data);
                    } catch (SQLException ex) {
            Logger.getLogger(Afficher_jeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* ArrayList<Integer> lid;
        
         //combobox
         lid = (ArrayList<Integer>) sj.getId();
         cstages.getItems().addAll(lid);*/
       }
       else
       { afficher();
           System.out.println("Vide");
       }
    }

   
    
}

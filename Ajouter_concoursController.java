/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.services.Service_concours;
import projet.services.ServiceClass;
import projet.entity.Concours;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Ajouter_concoursController implements Initializable {

    @FXML
    private JFXButton btnshow;
    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton btnADD;
    @FXML
    private TextField nom_concour;
    @FXML
    private JFXDatePicker Date_debut;
    @FXML
    private JFXDatePicker Date_fin;
  
    @FXML
    private TextField Prize_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   
             
    }    

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) throws SQLException, IOException {
        
        
        
           Service_concours sc=new Service_concours();
           System.out.print(sc.date_is_valid()+"   "+sc.get_concours());
           
           if(sc.date_is_valid()==0 && sc.get_concours()==0)
           {
               sc.update2();
        Concours c=new Concours(this.nom_concour.getText(),this.Date_debut.getValue(),this.Date_fin.getValue(),Integer.parseInt(this.Prize_id.getText()));
        sc.add(c);
           Stage stage=(Stage)this.btnshow.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("concours_front.fxml"));
 
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
           }
           else
           {
             Alert a=new Alert(Alert.AlertType.WARNING); a.setContentText("there is ongoing compet "); a.setHeaderText(null); a.showAndWait();     
           }
    }

    @FXML
    private void shoow(MouseEvent event) throws IOException {
            Stage stage=(Stage)this.btnshow.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_concours.fxml"));
 
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}

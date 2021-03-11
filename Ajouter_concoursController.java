/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.Service.Service_concours;
import project.entities.Concours;

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
    private TextField Class_id;
    @FXML
    private TextField Prize_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) throws SQLException {
           Service_concours sc=new Service_concours();
        Concours c=new Concours(1,this.nom_concour.getText(),Integer.parseInt(this.Class_id.getText()),Integer.parseInt(this.Prize_id.getText()),this.Date_debut.getValue(),this.Date_fin.getValue());
        sc.add(c);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projet.entity.Test;
import projet.services.Servicenotification;
import projet.services.Servicetest;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Ajout_testController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton id_confirm;
    @FXML
    private JFXTextField id_q1;
    @FXML
    private JFXTextField id_q2;
    @FXML
    private JFXTextField id_q3;
    @FXML
    private JFXTextField id_q4;
    @FXML
    private JFXTextField id_q5;
    @FXML
    private JFXComboBox<Integer> combo_time;
    @FXML
    private Text nom_class;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Integer> list=new ArrayList();
        this.nom_class.setText(Projet.nom_classe);
        list.add(30);
        list.add(60);
        list.add(25);
        ObservableList<Integer> data=FXCollections.observableArrayList(list);
        this.combo_time.setItems(data);
        
                
      
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
             Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void show(ActionEvent event) throws IOException {
              Stage stage=(Stage)this.afficher.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_test.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        Servicetest st=new Servicetest();
        Serviceutilisateur su=new Serviceutilisateur();
        Servicenotification sn=new Servicenotification();
        ArrayList<Integer> list=su.get_all_id(Projet.id_class);
        System.out.println(list);
        for(Integer i : list)
        {
        Test t=new Test(this.id_q1.getText(),this.id_q2.getText(),this.id_q3.getText(),this.id_q4.getText(),this.id_q5.getText(),i,this.combo_time.getSelectionModel().getSelectedItem());
        st.add(t);
        sn.add2(i);
           mail m =new mail();
           m.message(su.get_all_email(i),"Un nouveau test a été publier merci de le termnier");
        }
     
    }
    
}

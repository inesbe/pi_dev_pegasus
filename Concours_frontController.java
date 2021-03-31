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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Concours;
import projet.entity.Test;
import projet.services.Service_concours;
import projet.services.Servicetest;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author CHEYMA Farhat
 */
public class Concours_frontController implements Initializable {


    @FXML
    private JFXButton id_back;
    private JFXComboBox<String> combo_compi;
    @FXML
    private JFXTextField r1;
    @FXML
    private JFXTextField r2;
    @FXML
    private JFXTextField r3;
    @FXML
    private JFXTextField r4;
    @FXML
    private JFXTextField r5;
    @FXML
    private JFXTextField q1;
    @FXML
    private JFXTextField q2;
    @FXML
    private JFXTextField q3;
    @FXML
    private JFXTextField q4;
    @FXML
    private JFXTextField q5;
    @FXML
    private JFXButton add_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
      if(Projet.concours_status==2)
        {   
           Servicetest st=new Servicetest();
       Test t;
          try {
              t = st.get_compt(Projet.id_utilisateur);
               q1.setText(t.getQuestion_1());
         q2.setText(t.getQuestion_2());
         q3.setText(t.getQuestion_3());
         q4.setText(t.getQuestion_4());
         q5.setText(t.getQuestion_5());
          } catch (SQLException ex) {
              Logger.getLogger(Concours_frontController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        }
        
        
    
        
    }

    @FXML
    private void add(MouseEvent event)throws SQLException, IOException {
        System.out.println(Projet.concours_status);
        if(Projet.concours_status==1)
        {
        Servicetest sc=new Servicetest();
        Service_concours scn=new Service_concours();
        Serviceutilisateur su=new Serviceutilisateur();
        ArrayList<Integer> list=su.get_all_id_admin();
       
        Test t=new Test(q1.getText(),q2.getText(),q3.getText(),q4.getText(),q5.getText(),r1.getText(),r2.getText(),r3.getText(),r4.getText(),r5.getText());
        mail m=new mail();
        try {
            for(Integer i : list)
            {
            m.message(su.getU(i).getEmail(),"A new competition has been added !");
            sc.add_compt(t,i,scn.get_concours_id());
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Concours_frontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
               Stage stage=(Stage)this.add_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_concours.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    
        
    }
        else if(Projet.concours_status==2)
        {   
                   Servicetest st=new Servicetest();
       Test t;
       int note=0;
        
              t = st.get_compt(Projet.id_utilisateur);
              if(r1.getText().equals(t.getReponse_1()))
              {
              note=note+4;    
              }
              if(r2.getText().equals(t.getReponse_2()))
              {
              note=note+4;    
              }
              if(r3.getText().equals(t.getReponse_3()))
              {
              note=note+4;    
              }
              if(r4.getText().equals(t.getReponse_4()))
              {
              note=note+4;    
              }
              if(r5.getText().equals(t.getReponse_5()))
              {
              note=note+4;    
              }
              st.set_note_comp(t.getId_test(),note);
              
                     Stage stage=(Stage)this.add_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    
     
        }
    }
    
    
    
} 

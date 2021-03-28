/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Cours;
import projet.entity.Test;
import projet.services.ServiceClass;
import projet.services.Servicetest;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Afficher_testController implements Initializable {

    @FXML
    private JFXButton id_baack3;
    @FXML
    private Label label;
    @FXML
    private JFXComboBox<Integer> combo_box;
    @FXML
    private TableView<Test> tab_test;
    @FXML
    private TableColumn<Test,Integer> row_id;
    @FXML
    private TableColumn<Test,String> row_q1;
    @FXML
    private TableColumn<Test,String> row_q2;
    @FXML
    private TableColumn<Test,String> row_q3;
    @FXML
    private TableColumn<Test,String> row_q4;
    @FXML
    private TableColumn<Test,String> row_q5;
    @FXML
    private TableColumn<Integer,String> row_note;
    @FXML
    private TableColumn<Integer,String> row_time;
    @FXML
    private JFXButton id_delete;
    @FXML
    private JFXButton id_corrigé;
    @FXML
    private JFXButton id_modifi1;
    @FXML
    private FontAwesomeIconView plus;
    @FXML
    private JFXComboBox<String> combo_class;

    /**
     * Initializes the controller class.
     */
    
       void affich(Servicetest st)
          {
              
              
              
                 try {
            ObservableList<Test> data = FXCollections.observableArrayList(st.getTest());
              
         

            this.row_id.setCellValueFactory(new PropertyValueFactory<>("id_test"));
            this.row_q1.setCellValueFactory(new PropertyValueFactory<>("question_1"));
            this.row_q2.setCellValueFactory(new PropertyValueFactory<>("question_2"));
            this.row_q3.setCellValueFactory(new PropertyValueFactory<>("question_3"));
             this.row_q4.setCellValueFactory(new PropertyValueFactory<>("question_4")); 
        this.row_q5.setCellValueFactory(new PropertyValueFactory<>("question_5")); 
        this.row_note.setCellValueFactory(new PropertyValueFactory<>("note"));
        this.row_time.setCellValueFactory(new PropertyValueFactory<>("temps"));
        this.tab_test.setItems(data);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Afficher_testController.class.getName()).log(Level.SEVERE, null, ex);
        }  
          }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          //ObservableList<Cours> data = FXCollections.observableArrayList(list);
          
       
          
         
          
        
Servicetest st=new Servicetest();
ServiceClass sc=new ServiceClass();
     try {
            ObservableList<Integer> data2=FXCollections.observableArrayList(st.get_id());
           this.combo_box.setItems(data2);
           ObservableList<String> data3=FXCollections.observableArrayList(sc.getnom_Class());
           this.combo_class.setItems(data3);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
affich(st);
   
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
         Stage stage=(Stage)this.id_baack3.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Menu_admin.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void delete(MouseEvent event) throws SQLException {
        Servicetest st=new Servicetest();
        Test t=new Test(this.combo_box.getSelectionModel().getSelectedItem());
        st.delete(t);
        affich(st);
        
    }

    @FXML
    private void modifier(MouseEvent event) {
    }

    @FXML
    private void add(MouseEvent event) throws IOException, SQLException {
        
      
        ServiceClass sc=new ServiceClass();
          Projet.id_class=sc.getcnam(this.combo_class.getSelectionModel().getSelectedItem()).getId_class();
        Projet.nom_classe=this.combo_class.getSelectionModel().getSelectedItem();
        
         Servicetest st=new Servicetest();
        Serviceutilisateur su=new Serviceutilisateur();
        ArrayList<Integer> list=su.get_all_id(Projet.id_class);
        int status=0;
        for(Integer i : list)
        {
            
        if(st.getT2(i)==1)
        {
        status=1;    
        }
        }
        if(status == 1 )
        {
                 Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Not all the class has passed the test ! ");
         a.setHeaderText(null);
         a.showAndWait();   
        }
        else 
        {
         Stage stage=(Stage)this.plus.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Ajout_test.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
        }
    }

    @FXML
    private void correct(MouseEvent event) throws IOException, SQLException {
       
      Projet.id_test=this.combo_box.getSelectionModel().getSelectedItem();
        Servicetest st=new Servicetest();
          Test t=new Test();
          if(st.getstatus(Projet.id_test).getStatus()==1  && st.getstatus(Projet.id_test).getNote()==-1)
          {  
      
      
      
                Stage stage=(Stage)this.plus.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("corrigé.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
          }
          else
          {   
             Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("The test has not been passed yet");
         a.setHeaderText(null);
         a.showAndWait();   
          }
    }

    @FXML
    private void stat(MouseEvent event) throws IOException {
         Stage stage=(Stage)this.id_baack3.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Statistics.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
        
    }
    


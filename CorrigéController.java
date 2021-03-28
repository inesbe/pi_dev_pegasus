/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projet.entity.Test;
import projet.services.Servicetest;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class CorrigéController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton id_confirm;
    @FXML
    private Text question_1;

    @FXML
    private Text question_2;

    @FXML
    private Text question_3;

    @FXML
    private Text question_4;

    @FXML
    private Text question_5;

    @FXML
    private ImageView time;

    @FXML
    private Label id_q1;
    @FXML
    private Label id_q2;
    @FXML
    private Label id_q3;
    @FXML
    private Label id_q4;
    @FXML
    private Label id_q5;
    @FXML
    private JFXTextField id_search;
    @FXML
    private Label id_note;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             Servicetest st=new Servicetest();
    Test t=new Test();

        try {
            t=st.get_correction(Projet.id_test);
                System.out.println(t);
        } catch (SQLException ex) {
            Logger.getLogger(CorrigéController.class.getName()).log(Level.SEVERE, null, ex);
        }
this.id_q1.setText(t.getReponse_1());
this.id_q2.setText(t.getReponse_2());
this.id_q3.setText(t.getReponse_3());
this.id_q4.setText(t.getReponse_4());
this.id_q5.setText(t.getReponse_5());
this.question_1.setText(t.getQuestion_1());
this.question_2.setText(t.getQuestion_2());
this.question_3.setText(t.getQuestion_3());
this.question_4.setText(t.getQuestion_4());
this.question_5.setText(t.getQuestion_5());

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
    private void add(ActionEvent event) throws SQLException, IOException {
        Servicetest st=new Servicetest();
       
        st.set_note(Projet.id_test, Integer.parseInt(this.id_note.getText()));
           Stage stage=(Stage)this.id_confirm.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_test.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }


    @FXML
    private void search(KeyEvent event) {
           this.id_note.setText( this.id_search.getText());
    }

    @FXML
    private void search1(KeyEvent event) {
         this.id_note.setText( this.id_search.getText());
    }

    @FXML
    private void search2(KeyEvent event) {
         this.id_note.setText( this.id_search.getText());
    }
    
}

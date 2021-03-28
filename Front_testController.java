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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static projet.Front_cours2Controller.timeline;
import projet.entity.Test;
import projet.services.Servicecours;
import projet.services.Servicetest;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Front_testController implements Initializable {

    @FXML
    private Text question_1;
    @FXML
    private JFXButton id_back1;
    @FXML
    private JFXButton id_confirm;
    @FXML
    private JFXTextField id_q1;
    @FXML
    private Text question_2;
    @FXML
    private JFXTextField id_q2;
    @FXML
    private Text question_3;
    @FXML
    private JFXTextField id_q3;
    @FXML
    private Text question_4;
    @FXML
    private JFXTextField id_q4;
    @FXML
    private Text question_5;
    @FXML
    private JFXTextField id_q5;
    @FXML
    private ImageView time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    timeline = new Timeline(
            new KeyFrame(Duration.seconds(40), evt ->
                    {
           
                        
       
                try {
                            Servicetest st=new Servicetest();
                        Test t=new Test(Projet.id_utilisateur,this.id_q1.getText(),this.id_q2.getText(),this.id_q3.getText(),this.id_q4.getText(),this.id_q5.getText());
                    try { 
                        st.update(t);
                    } catch (SQLException ex) {
                        Logger.getLogger(Front_testController.class.getName()).log(Level.SEVERE, null, ex);
                    }
             Stage stage=(Stage)this.id_confirm.getScene().getWindow();
       Parent root;
            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
              Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Front_testController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                    }),
                    
            new KeyFrame(Duration.seconds(20), evt2 ->
                    {
                                
     this.time.setOpacity(1);
       
                    }
   
        ));

        timeline.play();
      

        Servicetest st=new Servicetest();
       
        try {
            Test t1=st.getT(Projet.id_utilisateur);
             System.out.println(Projet.id_utilisateur);
             System.out.println(t1);
            this.question_1.setText(t1.getQuestion_1());
            this.question_2.setText(t1.getQuestion_2());
            this.question_3.setText(t1.getQuestion_3());
            this.question_4.setText(t1.getQuestion_4());
            this.question_5.setText(t1.getQuestion_5());
        } catch (SQLException ex) {
            Logger.getLogger(Front_testController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
       
       
       
       
    }    

   
    @FXML
    private void back(MouseEvent event) throws IOException {
                Servicetest st=new Servicetest();
            Test t=new Test(Projet.id_utilisateur,this.id_q1.getText(),this.id_q2.getText(),this.id_q3.getText(),this.id_q4.getText(),this.id_q5.getText());
        try {
            st.update(t);
        } catch (SQLException ex) {
            Logger.getLogger(Front_testController.class.getName()).log(Level.SEVERE, null, ex);
        } 
          Stage stage=(Stage)this.id_confirm.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        Servicetest st=new Servicetest();
     
         Test t=new Test(Projet.id_utilisateur,this.id_q1.getText(),this.id_q2.getText(),this.id_q3.getText(),this.id_q4.getText(),this.id_q5.getText());
        try {
            st.update(t);
        } catch (SQLException ex) {
            Logger.getLogger(Front_testController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
}

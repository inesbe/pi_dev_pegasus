/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import projet.entity.Test;
import projet.services.Servicetest;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Correction_devoirController implements Initializable {

    @FXML
    private JFXButton id_back1;
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
    private Label id_note;
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
    private ImageView panda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   Servicetest st=new Servicetest();
    Test t=new Test();

        try {
            t=st.get_correction2(Projet.id_utilisateur);
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
this.id_note.setText(String.valueOf(t.getNote()));
if(t.getNote() < 10)
          {
                File file = new File("src/projet/img/oie_1022326EV0z6plC.gif");
String localUrl = null;
       try {
           localUrl = file.toURI().toURL().toString();
       } catch (MalformedURLException ex) {
           Logger.getLogger(Correction_devoirController.class.getName()).log(Level.SEVERE, null, ex);
       }
           
            Image img=new Image(localUrl);
          
          this.panda.setImage(img);
          }
else if(t.getNote() < 15)
{          File file = new File("src/projet/img/1c3647552cdd47b9935ada21746f6872.gif");
String localUrl = null;
       try {
           localUrl = file.toURI().toURL().toString();
       } catch (MalformedURLException ex) {
           Logger.getLogger(Correction_devoirController.class.getName()).log(Level.SEVERE, null, ex);
       }
      Image img2=new Image(localUrl);
       this.panda.setImage(img2);
}
else
{
        File file = new File("src/projet/img/good-job-icegif-3.gif");
String localUrl = null;
       try {
           localUrl = file.toURI().toURL().toString();
       } catch (MalformedURLException ex) {
           Logger.getLogger(Correction_devoirController.class.getName()).log(Level.SEVERE, null, ex);
       }
      Image img3=new Image(localUrl);
       this.panda.setImage(img3);
}    
}

        

    @FXML
    private void back(MouseEvent event) {
    }
   

}

   
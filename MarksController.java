package projet;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Test;
import projet.services.Servicetest;




public class MarksController implements Initializable {

    @FXML
    private JFXButton id_baack3;
    @FXML
    private ImageView plus;
    @FXML
    private Label id_mark;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Servicetest st =new Servicetest();
    String s="";
    double moy=0;
    int n=0;
        try {
           List<Test> list= st.getall_mark(Projet.id_utilisateur);
           if (list.isEmpty())
           {
            s= "Aucune saisi n'as était faite !! ";  
           }
           else
           {
           for(Test i : list)
           {
             if(i.getNote() != -1)
             {
             s=s+"Note "+(n+1)+" : "+i.getNote()+"\n";  
             n++;
             moy=moy+i.getNote();
             }
             
               
           }
           moy=moy/n;
           s=s+"Votre moyenne est : "+moy;
           }
           if(n==0)
           {
             s= "Aucune saisi n'as était faite !! ";     
           }
           
           this.id_mark.setText(s);
           
        } catch (SQLException ex) {
            Logger.getLogger(MarksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
                Stage stage=(Stage)this.id_mark.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void add(MouseEvent event) {
    }
    
    
    
}

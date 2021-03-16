/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Stages;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class END_STAGEController implements Initializable {

    
    private Button b2=new Button();
    
    private Button b1=new Button();
    private Stages ss;
    @FXML
    private Button retryb;
    @FXML
    private Button exitb;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTERED END_STAGE !");
        b1.setOnAction(e -> {
           System.out.println("B1 CLICKED !!"); 
   
});
  

        
    }    
    public void setb1(Button b)
    {
        b1=b;
    }
    
      public void setb2(Button b)
    {
        b2=b;
    }
    
      
             public Button getb1()
    {
        return b1;
    }
      
         public Button getb2()
    {
        return b2;
    }
    

    @FXML
    private void b3click(ActionEvent event) {
    }
    /*
    void b2click(MouseEvent event)

    {
                   
            try {
                System.out.println("B2 CLICKED !!");
                Stage stage=(Stage)b2.getScene().getWindow();
                Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
            }
     
    }
    */
    
    public void setStage(Stages s)
    {
        ss=s;
    }
      public Stages getStage()
    {
       return ss;
    }

    public Button getRetryb() {
        return retryb;
    }

    public void setRetryb(Button retryb) {
        this.retryb = retryb;
    }

    public Button getExitb() {
        return exitb;
    }

    public void setExitb(Button exitb) {
        this.exitb = exitb;
    }
      
}

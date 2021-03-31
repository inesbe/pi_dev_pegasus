/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projet.entity.Test;
import projet.entity.Utilisateur;
import projet.services.Service_concours;
import projet.services.Servicetest;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Winner_concoursController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private Label id_nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Service_concours sc=new Service_concours();
       Servicetest st=new Servicetest();
       Serviceutilisateur su=new Serviceutilisateur();
        try {
            int id=sc.get_concours_finish_id();
            Utilisateur u=new Utilisateur();
            System.out.println(su.getU(st.getbest_test(id)).getNom());
            
         this.id_nom.setText(su.getU(st.getbest_test(id)).getNom());
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Winner_concoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

     @FXML
    private void back(MouseEvent event) throws IOException, SQLException, SQLException {
        
        
 
  
          Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
      
    }
}

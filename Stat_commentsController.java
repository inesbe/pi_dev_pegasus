package projet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import projet.entity.commentaire;
import projet.services.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Stat_commentsController implements Initializable {

    @FXML
    private JFXButton id_baack3;
    @FXML
    private PieChart stat_chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceCommentaire sc=new ServiceCommentaire();
   
        int s1=0;
        int s2=0;
        int s3=0;
        int s4=0;
        int s5=0;
        try {
            for(commentaire i : sc.getcommentaire())
            {
                if(i.getContenu().contains("★☆☆☆☆"))
                {
                    s1++;
                }
                if(i.getContenu().contains("★★☆☆☆"))
                {
                    s2++;
                }
                if(i.getContenu().contains("★★★☆☆"))
                {
                    s3++;
                }
                if(i.getContenu().contains("★★★★☆"))
                {
                    s4++;
                }
                if(i.getContenu().contains("★★★★★"))
                {
                    s5++;
                }
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stat_commentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
                 ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
            
                new PieChart.Data("1 Star", s1),
                new PieChart.Data("2 Star", s2),
                  new PieChart.Data("3 Star", s3),
                  new PieChart.Data("4 Star", s4),
                         new PieChart.Data("5 Star", s5)
                );
      
             
      this.stat_chart.setData(pieChartData);
      this.stat_chart.setPrefHeight(600);
            this.stat_chart.setPrefWidth(600);
            this.stat_chart.setAnimated(true);
            this.stat_chart.setLayoutY(100);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
         Stage stage=(Stage)this.id_baack3.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Afficher_commentaire.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}

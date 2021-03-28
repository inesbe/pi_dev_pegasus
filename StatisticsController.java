/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
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
import javafx.scene.control.Label;
import projet.services.Servicetest;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class StatisticsController implements Initializable {

    @FXML
    private PieChart stat_chart;
    @FXML
    private JFXButton id_baack3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Servicetest st = new Servicetest();
        double statics1=0;
       double statics2 = 0;
        try {
            double n=st.test_tot();
            double n1=st.stats();
            
            statics1=(double)(n1/n)*100;
           statics2 = 100-statics1;
            
            
            System.out.println(statics1+"Note > 10 "+statics2);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
            
                new PieChart.Data("Note > 10 ", statics1),
                new PieChart.Data("Note < 10 ", statics2));
      
             
      this.stat_chart.setData(pieChartData);
      this.stat_chart.setPrefHeight(600);
            this.stat_chart.setPrefWidth(600);
            this.stat_chart.setAnimated(true);
            this.stat_chart.setLayoutY(100);
            
    
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
                Stage stage=(Stage)this.id_baack3.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("afficher_test.fxml"));
       Projet.Curseur(root);
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}

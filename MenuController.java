/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceJeu;

/**
 * FXML Controller class
 *
 * @author Espace Info
 */
public class MenuController implements Initializable {

    @FXML
    private TilePane gamestale;

    /**
     * Initializes the controller class.
     */
    
                ServiceJeu sj=new ServiceJeu();
    @FXML
    private JFXButton back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         gamestale.setPrefColumns(5);
        gamestale.setPrefRows(5);
        //tilePane.setStyle("-fx-background-color: rgba(0, 0, 0);");
        gamestale.setHgap(30);
        gamestale.setVgap(60); 
        
     
       ArrayList<String> lid;
        try {
            //lid = (ArrayList<String>) sj.getSource();
                     createElements();
  System.out.println("heeeere2!!!");
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
    }    
    
     private void createElements() throws SQLException {
            gamestale.getChildren().clear();
            int count=0;
             ArrayList<String> lid;

            lid = (ArrayList<String>) sj.getSource();
            for (int i = 0; i <lid.size() ; i++) {
               //for (int j = 0; j < 5; j++) {
                  gamestale.getChildren().add(createPage(i));
                  
                 
 
               // }
            }

        }
     
     
     
    public VBox createPage(int index) throws SQLException {
       //INITS 
        
 ArrayList<String> lid;
  ArrayList<String> ltitle;
  ArrayList<String> lcours;
  ArrayList<String> ldesc;

   ImageView imageView = new ImageView();
 lid = (ArrayList<String>) sj.getSource();
 ltitle= (ArrayList<String>) sj.getTitle();
 lcours= (ArrayList<String>) sj.getCourse();
 ldesc= (ArrayList<String>) sj.getDesc();

 int i=index;
 
 //Add course
 Label course=new Label();
course.setText(lcours.get(i));
course.setStyle("  -fx-font-size: 11px;\n" +
"    -fx-font-weight: italic;\n" +
"    -fx-text-fill:grey;\n" +
"    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );\n" +
 "-fx-text-alignment: left;"+       
"}");
 
 //**************END COURSE
 
//add title
Label title=new Label();
title.setText(ltitle.get(i));
title.setStyle("  -fx-font-size: 18px;\n" +
"    -fx-font-weight: bold;\n" +
"    -fx-text-fill: #333333;\n" +
"    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );\n" +
"}");
//.................................end label...
            

//IMAGE ADD
System.out.println("lid.get("+i+")="+lid.get(i));
           Image image = new Image(lid.get(i));

  Tooltip.install(
    imageView,
    new Tooltip(ldesc.get(i))
);
 imageView.setImage(image);
 
 imageView.setFitWidth(200);
 imageView.setFitHeight(200);
 imageView.setPreserveRatio(true);
 imageView.setSmooth(true);
 imageView.setCache(true);
 
 //***********************END IMAGE ADD*******    
 VBox pageBox = new VBox();
 pageBox.setAlignment(Pos.CENTER);
 pageBox.getChildren().add(title);
 pageBox.getChildren().add(imageView);  
 pageBox.getChildren().add(course);
       
        pageBox.setStyle("-fx-border-color: orange;");
    
  System.out.println("heeeere5!!!");
      
              
 
    return pageBox;
    }   

    @FXML
    private void back(ActionEvent event) throws IOException {
         Stage stage=(Stage)back.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
}

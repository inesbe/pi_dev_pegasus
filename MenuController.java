/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Jeu;
import Entités.Stages;
import com.jfoenix.controls.JFXButton;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.in;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import projet.Projet;
import services.ServiceJeu;
import services.ServiceStage;
import utils.SocialMedia;

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
                                ServiceStage ss=new ServiceStage();

    @FXML
    private JFXButton back;
                          Play_StageController ps=new Play_StageController();  

    
    private ArrayList<ImageView> vlist=new ArrayList();
        private ArrayList<VBox> vbx=new ArrayList();
        private ArrayList<Integer> vid=new ArrayList();
  private ArrayList<Jeu> listj=new ArrayList();
        int j;
        int pi;
    
  Stages startstage;
    @FXML
    private Button facebook;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        

        
        
        
        
        
         gamestale.setPrefColumns(10);
        gamestale.setPrefRows(10);
        //tilePane.setStyle("-fx-background-color: rgba(0, 0, 0);");
        gamestale.setHgap(30);
        gamestale.setVgap(60); 
        
     
       ArrayList<String> lid;
        try {
            //lid = (ArrayList<String>) sj.getSource();
                     createElements();
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
    
        
       
           /* vbx.get(0).setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 System.out.println("THIIIIIIIIIIIIIIIIIIIIIIS");

             }
        
          }*/

           
        
        
    }    
    
     private void createElements() throws SQLException {
            gamestale.getChildren().clear();
            int count=0;
             ArrayList<String> lid;
vid=        (ArrayList<Integer>) sj.getId();
            lid = (ArrayList<String>) sj.getSource();
            VBox vb;
         
            for (int i = 0; i <lid.size() ; i++) {
                pi=i;
                vb=createPage(i);
                  gamestale.getChildren().add(vb);
                  vbx.add(vb);
                 
                  System.out.println("i=="+i);
                                    System.out.println("j=="+j);

             vbx.get(i).setOnMouseClicked((MouseEvent event) -> {
                 System.out.println("Setting ONCLICK!!!");
                 
                 for(int y=0;y<vbx.size();y++)
                 {
                   
                     System.out.println("YYY="+y);
                     if(vbx.get(y).equals((VBox)event.getSource()))
                     {  System.out.println("y="+y);
                     ArrayList<Stages> lstage=new ArrayList();
                     try {
                         lstage = (ArrayList<Stages>) ss.read();
                        // listj=(ArrayList<Jeu>) sj.read();
                      Stage stage=(Stage)back.getScene().getWindow();
                      FXMLLoader loader=new FXMLLoader();
                        
                      loader.setLocation(getClass().getResource("/gui/Play_Stage.fxml"));
                      

       Parent root=loader.load();//FXMLLoader.load(getClass().getResource("/gui/Play_Stage.fxml"));
            System.out.println("BAD !!");

                         Play_StageController controller=loader.getController();
                                           
            //PROOOOOOOOOOOOOOB!!!!!!!!
             
//controller.init_stage(lstage.get(y));
System.out.println("y="+y);
int ii;
boolean testex=false;
for(ii=0;ii<lstage.size();ii++)
{
    if(lstage.get(ii).getJeu()==vid.get(y))
        if(lstage.get(ii).getNumero()==1)
       startstage=lstage.get(ii);
        testex=true;
}
if(testex)
{
   
      //**CODE HERE DIFF
         
   Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Difficulty");
alert.setHeaderText("Do you want to play this game as :                                                                   ");
//alert.setContentText("Do you want to play this game as : ");

ButtonType buttonTypeOne = new ButtonType("Challenger");
ButtonType buttonTypeTwo = new ButtonType("Hero");
ButtonType buttonTypeThree = new ButtonType("Super Hero");
ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);


alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == buttonTypeCancel){
   
} 
else{
if (result.get() == buttonTypeOne) {
   Projet.diff=1;
} 

else if (result.get() == buttonTypeTwo) {
    // ... user chose "Three"
    Projet.diff=2;
} 


else {
   Projet.diff=3;
}
    
      //***********************
       controller.setGameId(vid.get(y));
    controller.stagestart(startstage);
                          Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
}}
else
                             System.out.println("STAGE DOESNT EXIST");

                      //   controller.setLabel(lstage.get(y).getTexte());
                                           

     
      
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                 }
                 }
                });
        
                 
 
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
ArrayList<Stages> lstage=(ArrayList<Stages>) ss.read();
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
 HBox hb=new HBox();
 
 pageBox.setAlignment(Pos.CENTER);
 // TilePane.setAlignment(course,Pos.BOTTOM_LEFT);
  //pageBox.setAlignment(title,Pos.CENTER);
  //LEADER BOOARDDD
  
//imv.setLayoutX(150);

 //LEADER BOOARDDD
  pageBox.getChildren().add(title);
 pageBox.getChildren().add(imageView);  
 pageBox.getChildren().add(course);
 
        pageBox.setStyle("-fx-border-color: orange;");
    
  System.out.println("Create Page() is DONE!!!");
  
        vlist.add(imageView);
      
              
 
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
    
    
    

    @FXML
    private void infogame(MouseEvent event) throws IOException {
    
   
        
        /* imageView.setOnMouseClicked( ( MouseEvent e ) ->
            {
                Play_StageController sc=new Play_StageController();
              sc.setS(lstage.get(i));
            } );*/
        
        
               
          
        
        
        
//Position open
   /*     
        double x=event.getX();
  double y=event.getY();
        System.out.println("x,y="+x+y);
        int xi=(int) x/200;
        int xy=(int)(y/200); 
        int j;
        int i=xi+(5*xy);
        for(j=230;j<260;j++)
        {
            if(x%j==0 || y%j==0)
                i=-1;
        }
        
        System.out.println("your index is "+i);
        
        //
  Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        */
        
        
      }


    /*
  public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
}*/
    
    }


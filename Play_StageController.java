/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Stages;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static javafx.util.Duration.seconds;
import projet.Projet;
import services.ServiceStage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Play_StageController implements Initializable {

    
    //*********************************FXML******************************************
    @FXML
    private GridPane timers;
    @FXML
    private Text mins;
    @FXML
    private Text secs;
    @FXML
    private TextField reponses;
    @FXML
    private Button validers;
    @FXML
    private ImageView sources;
    @FXML
    private Label questions;
    @FXML
    private HBox lane1;
    
   
   //*********************************FXML******************************************
    
     //*********************************VARIABLE GENERALE******************************************
    ServiceStage sj=new ServiceStage();
    private String correction;
    @FXML
    private Label getid;
    private int temps;
    private int testtime=1;
    private Stages Stageaux;
   private int j=0;
   private int paused=0;
           
   private Stages thisstage;     
           private int gameid; 
          private  int done=0;
          private ArrayList<Stages> liststage;
          private int currentnumero=0;
          
           private Image aux;
           int score=0;

       //***************************************************************************
    @FXML
    private ImageView pauseb;
    
  private AudioClip ac;        
          
          
             //*********************************METHODES******************************************
    @FXML
    private AnchorPane panel;
   
    @FXML
    private ImageView gameeover;
    @FXML
    private ImageView whiite;
    @FXML
    private Button retry;
    @FXML
    private Button exit;
          
          
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     URL path;
            timers.setOpacity(0.5);
               sources.setOpacity(1);
               reponses.setOpacity(1);
                reponses.setDisable(false);
               validers.setVisible(true);
               validers.setDisable(false);
               questions.setVisible(true);
                questions.setDisable(false);
                 questions.setVisible(true);
                    secs.setOpacity(1);
                    mins.setOpacity(1);
                   // pauseb.setDisable(false);
                    retry.setOpacity(0);
                    retry.setDisable(true);
                    
 exit.setOpacity(0);
  exit.setDisable(true);
 
                   whiite.setOpacity(0);
                   gameeover.setOpacity(0);
                 

path=getClass().getResource("/projet/img/MUSICBG.mp3");
ac=new AudioClip(path.toString());
ac.play();

        
    }
    public void stagestart(Stages stg) throws SQLException
    {
        System.out.println("Score ="+score);
        pauseb.setDisable(false);
                timers.setOpacity(0.5);
               sources.setOpacity(1);
               reponses.setOpacity(1);
                reponses.setDisable(false);
               validers.setVisible(true);
               validers.setDisable(false);
               questions.setVisible(true);
                questions.setDisable(false);
                 questions.setVisible(true);
                    secs.setOpacity(1);
                    mins.setOpacity(1);
                                        pauseb.setDisable(false);

                    retry.setOpacity(0);
                    retry.setDisable(true);
                    
 exit.setOpacity(0);
  exit.setDisable(true);
 
                   whiite.setOpacity(0);
                   gameeover.setOpacity(0);
                  
        paused=0;
     lane1.getChildren().clear();
    done=0;
testtime=1;    
        init_stage(stg);
        
        reponses.setText("");
        System.out.println("tempsss=="+temps);
        ArrayList<Stages> lj;
        if(Projet.diff==2)
            temps=(int) (temps/1.5);
        if(Projet.diff==3)
        temps=(int) (temps/2);
       // try {
       //     lj = (ArrayList<Stages>) sj.read();
         //   temps=lj.get(0).getTemps();
            int m=temps/60;
      int s=temps%60;
      
        String sm=String.valueOf(m);
              String ss=String.valueOf(s);
                     mins.setText(sm);
        secs.setText(ss);
        
     // String q=lj.get(0).getTexte();
     
   //   questions.setText(q);
              
      //  } catch (SQLException ex) {
            System.out.println("INT TIMEEE!!");
       // }
      
 
      
                 

        
        
        int min=Integer.parseInt(mins.getText());
       int sec=Integer.parseInt(secs.getText());
       
       
       //pause Button
       
     
        
       
       //*********************************
       
        
        /*
       Timer myTimer=new Timer(); 
       TimerTask task=new TimerTask(){
           @Override
           public void run()
               {
                 sec--;
                 //  System.out.println("Time");
                   
               }
       };  
        
        myTimer.scheduleAtFixedRate(task, 1000,-1000);
       
        */
        Timeline fiveSecondsWonder = new Timeline(
                 new KeyFrame(Duration.seconds(1), 
                 new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
           int min=Integer.parseInt(mins.getText());
       int sec=Integer.parseInt(secs.getText());
  
         if(done==0)
                 {
        if(min!=0 || sec!=0){
        
        
        {    System.out.println(min+":"+sec);
        
        
        if(sec==0)
        {     Duration.seconds(1);

            min--;
        score-=150;
        sec=59;
        mins.setText(String.valueOf(min));
            
        }
        else
        {     Duration.seconds(1);

            sec--;
            score-=100;
           
        }
        secs.setText(String.valueOf(sec));

        testtime=0;
        
       
       
                 }
    }
        
        else
                         {
                             System.out.println(" TIME IS OVER !!!");
 /* Dialog dialog = new Dialog<>();
//dialog.setTitle("Time over");


// Set the icon (must be included in the project).
BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
ImageView imagev=new ImageView(this.getClass().getResource("/projet/img/giphy.gif").toString());
 imagev.setFitWidth(400);
         imagev.setPreserveRatio(true);
         imagev.setSmooth(true);
         imagev.setCache(true);


dialog.setGraphic(imagev);

dialog.show();*/
  
               try {
               timers.setOpacity(0);
               pauseb.setDisable(true);
               sources.setOpacity(0);
               reponses.setOpacity(0);
                reponses.setDisable(true);
               validers.setVisible(false);
               validers.setDisable(true);
               questions.setVisible(false);
                questions.setDisable(true);
                 questions.setVisible(false);
                    secs.setOpacity(0);
                    mins.setOpacity(0);
                                      //  pauseb.setDisable(false);

                    retry.setOpacity(1);
                     retry.setDisable(false);
                    
 exit.setOpacity(1);
  exit.setDisable(false);
                   whiite.setOpacity(1);
                   gameeover.setOpacity(1);
                
                    Stage anotherStage = new Stage();
                    FXMLLoader anotherLoader = new FXMLLoader() ; // FXML for second stage
                    
                    
                    anotherLoader.setLocation(getClass().getResource("/gui/END_STAGE.fxml"));
            Parent anotherRoot;
                   anotherRoot = anotherLoader.load();
                   
                    Image image = new Image("/projet/img/gameover.gif");
         ImageView bg = new ImageView();
         bg.setImage(image);
            // bg.setStyle("-fx-background-color: BLACK");
             bg.setFitHeight(anotherStage.getHeight());
             bg.setPreserveRatio(true);
             bg.setSmooth(true);
             bg.setCache(true);
               BorderPane borderPane = new BorderPane();
            borderPane.setCenter(bg);
                    BorderPane bp2 = new BorderPane();
                   anotherStage.initStyle(StageStyle.UNDECORATED);
                                HBox hb=new HBox();
                    bp2.setBottom(hb);
             Button b1x=new Button();
             b1x.setText("Retry");
             Button b2x=new Button();
              b2x.setText("Exit");
              
            END_STAGEController controller=anotherLoader.getController(); 
            controller.setb1(b1x);
            controller.setb2(b2x);
            
            
  
                      
             VBox vb=new VBox();
              vb.getChildren().add(borderPane);
              HBox.setHgrow(b1x, Priority.ALWAYS);
              hb.setSpacing(25);
             hb.getChildren().add(b1x);
                hb.getChildren().add(b2x);    
                vb.getChildren().add(hb);
                
                //CLIIICK EXIT !!!!
                 exit.setOnMouseClicked((MouseEvent event2) -> {
                      if(exit.equals((Button)event2.getSource()))
                      {
                         
                          try {
                              System.out.println("B2 CLICKED !!");
                              Stage anotherstage=(Stage)exit.getScene().getWindow();
                              anotherstage.close();
                              
                              ac.stop();
                              Stage stage=(Stage)timers.getScene().getWindow();
                              
                              Parent root=FXMLLoader.load(getClass().getResource("/gui/menu.fxml"));
                              Scene scene=new Scene(root);
                              stage.setScene(scene);
                              stage.show();
                              //stage.setOnHidden(e -> Platform.exit());
                          } catch (IOException ex) {
                              Logger.getLogger(Play_StageController.class.getName()).log(Level.SEVERE, null, ex);
                          }
                         }
                 });
                 
                 
                
                //CLIIICK RETRY !!!!      
                 retry.setOnMouseClicked((MouseEvent event3) -> {
                      if(retry.equals((Button)event3.getSource()))
                      {
                         
                         try {
                        //      
                              
                                System.out.println("B1 CLICKED !!");
                           Stage anotherStage2 = new Stage();
                    FXMLLoader anotherLoader2 = new FXMLLoader() ; // FXML for second stage
                    anotherLoader2.setLocation(getClass().getResource("/gui/END_STAGE.fxml"));
                           //Stage anotherstage=(Stage)retry.getScene().getWindow();
                            //  anotherstage.close();
                             score-=2000;
                             System.out.println("Score ="+score);
                              stagestart(stg);
                            
                             /* Stage stage=(Stage)timers.getScene().getWindow();
                              
                              
                              Parent root=FXMLLoader.load(getClass().getResource("/gui/Play_Stage.fxml"));
                              Scene scene=new Scene(root);
                              stage.setScene(scene);
                              stage.show();
                              //stage.setOnHidden(e -> Platform.exit());
                          } catch (IOException ex) {
                              Logger.getLogger(Play_StageController.class.getName()).log(Level.SEVERE, null, ex);*/
                          } catch (SQLException ex) {
                              Logger.getLogger(Play_StageController.class.getName()).log(Level.SEVERE, null, ex);
                          }
                         }
                 });
                
                //end click buttons!!!
                
                
                   /* Scene anotherScene = new Scene(vb);
            anotherStage.setScene(anotherScene);
            anotherStage.show();*/
               } catch (IOException ex) {
                   Logger.getLogger(Play_StageController.class.getName()).log(Level.SEVERE, null, ex);
               }
           
  // Image image = new Image("/projet/img/giphy.gif");
//alert.setGraphic(imageView);
//alert.show();   
                         } //if done
return;
                             
                             
                         }
      


    }
}));
        System.out.println("TESTIME=="+testtime);


fiveSecondsWonder.setCycleCount(sec+1);
fiveSecondsWonder.play();

       pauseb.setOnMouseClicked((MouseEvent event9) -> {
            
            Image pausedscreen=new Image("/projet/img/screenpaused.gif");
           if(paused==0)
               {System.out.println("Pause!");
                   fiveSecondsWonder.pause();
           paused=1;
          
           sources.setImage(pausedscreen);
           lane1.setVisible(false);
               }
           else
               { 
                   System.out.println("IS AUX = SOURCE ?? "+aux);
                
             
                sources.setImage(aux);
                
                   System.out.println("Resume!");
                   fiveSecondsWonder.play();
                     
           paused=0;
                          lane1.setVisible(true);

               }
           
        });
    
        
        
        
        
                      Image imagew = new Image(getClass().getResourceAsStream("/projet/img/sheepb.png"));
                      Image imageb = new Image(getClass().getResourceAsStream("/projet/img/sheep.jpg"));
          ImageView view1 = getImageView(imagew, 100, 50, false);
            ImageView view2 = getImageView(imagew, 100, 50, false);
                  ImageView view3 = getImageView(imageb, 100, 50, false);
                ImageView view4 = getImageView(imageb, 100, 50, false);
            ImageView view5 = getImageView(imageb, 100, 50, false);
            ImageView view6 = getImageView(imagew, 100, 50, false);
                      
              List<ImageView>sheeps=Arrays.asList(view1,view2,view3,view4,view5,view6);
                 
                  for(int i = 0; i < sheeps.size(); i++) {
                      double r=Math.random();
                      double x=0.5;
                      System.out.println("random="+r);
         if(r<=x){
             sheeps.get(i).setImage(imageb);
             System.out.println("x<1/2");
             }
         else {
            sheeps.get(i).setImage(imagew);
            System.out.println("x>1/2");
         }
                      System.out.println("i="+i);
        }
                
                 
                  
                 
                      
                      
            
              
                   
        // Add Children to the HBox 
       // lane1.getChildren().addAll(sheeps);
  
                  
                  
                
                  
       
    if(Stageaux!=null)
    {String saux=String.valueOf(Stageaux.getNumero());
           getid.setText("Stage "+saux);
    }
           
           
    }    

        @FXML
    private void validation(ActionEvent event) throws IOException, SQLException {
            System.out.println("Validation");

               if(reponses.getText() == null ? correction == null : reponses.getText().equals(correction))
               {  
                   if(Projet.diff==1)
                 score+=temps*250;  
                   else if(Projet.diff==2)
                           score+=temps*300;
                   else
                       score+=temps*350;
                       
URL pathx;
AudioClip acx;
pathx=getClass().getResource("/projet/img/correctclick.mp3");
acx=new AudioClip(pathx.toString());
acx.play();
    reponses.setText("");                
    done=1;
               
                   System.out.println("Validé!!");
                   
                                Stage anotherStage = new Stage();
                    FXMLLoader anotherLoader = new FXMLLoader() ; // FXML for second stage
                    anotherLoader.setLocation(getClass().getResource("/gui/END_STAGE.fxml"));
            Parent anotherRoot;
                   anotherRoot = anotherLoader.load();
                   
                    Image image = new Image("/projet/img/ezgif-2-727ce930c816.gif");
         ImageView bg = new ImageView();
         bg.setImage(image);
            // bg.setStyle("-fx-background-color: BLACK");
             bg.setFitHeight(anotherStage.getHeight());
             bg.setPreserveRatio(true);
             bg.setSmooth(true);
             bg.setCache(true);
               BorderPane borderPane = new BorderPane();
            borderPane.setCenter(bg);
                    BorderPane bp2 = new BorderPane();
                   anotherStage.initStyle(StageStyle.UNDECORATED);
                                HBox hb=new HBox();
                    bp2.setBottom(hb);
             Button b1x=new Button();
             b1x.setText("Continue");
            
             VBox vb=new VBox();
             vb.getChildren().add(bg);
             
                          Scene anotherScene = new Scene(vb);
            anotherStage.setScene(anotherScene);
            anotherStage.show();
                   
     PauseTransition delay = new PauseTransition(Duration.seconds(2));
delay.setOnFinished( event5 -> {
    System.out.println("5 sec passed");
                       try {
                            
                            anotherStage.close();
                            System.out.println("currentnumero="+currentnumero);
                            System.out.println("LIstSize="+liststage.size());
                            if(liststage.size()>currentnumero)
   
                          {
                           next_stage(thisstage);
                             }
                            else{
                                ac.stop();
                      
                                       Stage stage=(Stage)timers.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/PageScore.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
     
      stage.show();
                        
                            }
                           
                           
                       } catch (SQLException ex) {
                       } catch (IOException ex) {
                       }
                   });




delay.play();
                                 
               }
               else
               {
                      
URL pathxx;
AudioClip acxx;
pathxx=getClass().getResource("/projet/img/wrongclick.mp3");
acxx=new AudioClip(pathxx.toString());
acxx.play();
score-=1000;
               }
   
    }
    
      private ImageView getImageView(Image image, double fitWidth,
            double fitHeight, boolean preserveRation) 
    {
            // Create the ImageView
            ImageView view = new ImageView(image);
            // Set Properties Width, Height, Smooth and PreserveRatio
            view.setFitWidth(fitWidth);
            view.setFitHeight(fitHeight);
            view.setPreserveRatio(preserveRation);
            view.setSmooth(true);
            return view;
    } 
      
      
      
     public Stages getS()
     {
       return Stageaux;
     }
     
      public void setS(Stages s)
     {
      Stageaux=s;
     }
      
         public void setLabel(String s)
     {
      getid.setText(s);
     }
         public void setTemps(int i)
     {
      temps=i;
     } 
      
      public Play_StageController(){
          
      }
      
       public Play_StageController(Stages s) throws SQLException{
          init_stage(s);
      }
      
      
      
      public void init_stage(Stages s) throws SQLException
      {
          System.out.println("Initializing stage");
          thisstage=s;
          System.out.println("Stage V");
          String idstring=String.valueOf(s.getNumero());
          System.out.println(s.getId());
          System.out.println("idstring="+idstring);
          getid.setText("Stage "+idstring);
          System.out.println("id V");
           questions.setText(s.getTexte());
           System.out.println("question V");
           temps=s.getTemps();
             System.out.println("temps V");
           Image im=new Image("projet/img/"+s.getSource());
          
           sources.setImage(im);
           sources.setFitHeight(600);
              sources.setFitWidth(1000);
              sources.setLayoutX(350);
                 sources.setLayoutY(100);
                 questions.setLayoutX(350);
         aux=sources.getImage();
           System.out.println("source V");
   
       //getid.setLayoutX(350);
        correction=s.getCorrection();
          System.out.println("Correction V");
             liststage=sj.stageofgame(gameid);
             Projet.gameid=gameid;
          
                     System.out.println("Stage initialized !");

          
      }
      
         public void next_stage(Stages s) throws SQLException, IOException
      {
          Stages snext=new Stages();
          System.out.println("VOTRE SCORE="+score);
          System.out.println("Charging next Stage !!!");
  ArrayList<Stages> lj;
      currentnumero++;
            lj = (ArrayList<Stages>) sj.read();
            System.out.println("case 0");
            liststage=sj.stageofgame(gameid);
            System.out.println("Currentnum="+currentnumero);
            //System.out.println("liststage.get(currentnumero)="+liststage.get(currentnumero).getId());
            if(liststage.size()>currentnumero)
            {liststage.get(currentnumero);
            System.out.println("CASE0 DONE");
           
                System.out.println("case 1");
                        stagestart(liststage.get(currentnumero));
}
             /*
                           Stage stage=(Stage)timers.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/gui/Play_Stage.fxml"));
          
         //  Stage anotherstage=(Stage)b2x.getScene().getWindow();
                            //  anotherstage.close();
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();*/
  
               
            else
            {  
                  Projet.score=score;
                          System.out.println("score="+score);
                                System.out.println("Projet.score="+Projet.score);
                System.out.println("case2");
                ac.stop();
     Stage stage=(Stage)timers.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/gui/PageScore.fxml"));
          
         //  Stage anotherstage=(Stage)b2x.getScene().getWindow();
                            //  anotherstage.close();
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
            
            }
            
            System.out.println("Charged next stage successfully !");
          
      }
         
         
         
            public void setGameId(int idd)
   {
   System.out.println("Setting id");
       gameid=idd;
       System.out.println("gameid="+gameid);
   }
      
}

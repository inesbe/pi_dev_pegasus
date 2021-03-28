/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game3d;
import CowsAndBulls.CowsnBulls;
import checker.checkers.Checkers;
import chess.chess.Mainchess;
import flaw.Game.Main;
import java.awt.Image;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import flaw.Game.Main;
import static flaw.Game.Main.menu_scene;
import flaw.Game.MenuController;
import game4.A4;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import memoryGame.memory.Memory;
/**
 * @author afsal villan
 * @version 1.0
 *
 * http://www.genuinecoder.com
 */
public class Game3d {
public  static Stage stage3d;
  private static final int WIDTH = 1280;
  private static final int HEIGHT = 768;
 int test=0;
  int r=0;
  int played=0;
  int r2=0;
  int testmouth=-1;
  int exit=0;
 
  public void start(Stage primaryStage) {
      stage3d=primaryStage;
            	FadeTransition fadetransition2 = new FadeTransition(Duration.millis(3000));
			FadeTransition fadetransition = new FadeTransition(Duration.millis(1500));
                           	FadeTransition fadetransitionx = new FadeTransition(Duration.millis(1500));
   exit=0;             
                
    
  
   URL path = getClass().getResource("/game3d/msc1.mp3");
AudioClip ac=new AudioClip(path.toString());
ac.setVolume(0.05);

     URL w1 = getClass().getResource("/game3d/voice.mp3");
AudioClip word1=new AudioClip(w1.toString());

   URL pathbye = getClass().getResource("/game3d/bye.mp3");
AudioClip bye=new AudioClip(pathbye.toString());

                       URL pathtp = getClass().getResource("/game3d/teleport.mp3");
AudioClip tps=new AudioClip(pathtp.toString());


                       URL pathcnb = getClass().getResource("/game3d/cowsnbulls.mp3");
AudioClip cnb=new AudioClip(pathcnb.toString());

                      URL patha4 = getClass().getResource("/game3d/a4.mp3");
AudioClip a4=new AudioClip(patha4.toString());

                      URL pathchk = getClass().getResource("/game3d/Checkers.mp3");
AudioClip chk=new AudioClip(pathchk.toString());

                      URL pathmg = getClass().getResource("/game3d/mg.mp3");
AudioClip mgs=new AudioClip(pathmg.toString());

                     URL pathchss = getClass().getResource("/game3d/chess.mp3");
AudioClip chss=new AudioClip(pathchss.toString());

         URL pathftfs = getClass().getResource("/game3d/ftf.mp3");
AudioClip ftfs=new AudioClip(pathftfs.toString());
        
           URL pathmchk = getClass().getResource("/game3d/morecheckers.mp3");
AudioClip mchk=new AudioClip(pathmchk.toString());
/*
         ImageView trsp=new ImageView("/game3d/Empty.png"); 
  trsp.setFitHeight(HEIGHT*2);
 trsp.setFitWidth(WIDTH*2);
*/

       ImageView eff=new ImageView("/game3d/giphy.gif"); 
   eff.setFitHeight(HEIGHT);
 eff.setFitWidth(WIDTH);
 eff.setX(WIDTH*1.5);
 eff.setOpacity(0.7);


         ImageView src=new ImageView("/game3d/sorcer.gif"); 
   //src.setFitHeight(HEIGHT);
 src.setFitWidth(WIDTH);
 src.setX(WIDTH*1.5);
 //eff.setOpacity(0.5);
 
         ImageView mouth=new ImageView("/game3d/mouth.png"); 
   //src.setFitHeight(HEIGHT);
 mouth.setFitWidth(WIDTH);
 mouth.setX((WIDTH*1.5)+20);
 mouth.setY(mouth.getY()+148);
 mouth.setVisible(false);
     
      ImageView wp=new ImageView("/game3d/bgg.gif"); 
   wp.setFitHeight(HEIGHT);
 wp.setFitWidth(WIDTH);
  //wp.setY(-HEIGHT/2);
     //wp.set(WIDTH*1.5);
     
    /*  ImageView wp2=new ImageView("/game3d/4k.jpg"); 
   wp2.setFitHeight(HEIGHT);
   wp2.setX(wp.getFitWidth());*/

      
      ImageView bg=new ImageView("/game3d/connect 4.png"); 

    bg.setFitHeight(HEIGHT);
   bg.setFitWidth(WIDTH);

   
      ImageView g2=new ImageView("/game3d/ftf.png"); 

    g2.setFitHeight(HEIGHT);
   g2.setFitWidth(WIDTH+20);
   g2.setX(WIDTH*1.5);

     ImageView g3=new ImageView("/game3d/checkers.png"); 

    g3.setFitHeight(HEIGHT);
   g3.setFitWidth(WIDTH);
   g3.setX(WIDTH*-1.5);

   
   
   ImageView g4=new ImageView("/game3d/match-game.png"); 

    g4.setFitHeight(HEIGHT);
   g4.setFitWidth(WIDTH);
   g4.setX(WIDTH*3);
   
   
   ImageView g5=new ImageView("/game3d/chess.jpg"); 

    g5.setFitHeight(HEIGHT);
   g5.setFitWidth(WIDTH);
   g5.setX(WIDTH*-3);

    ImageView g6=new ImageView("/game3d/logo-main.png"); 

    g6.setFitHeight(HEIGHT);
   g6.setFitWidth(WIDTH);
   g6.setX(WIDTH*4.5);
   
   
    
    /*ImageView g7=new ImageView("/game3d/tic.png"); 

    g7.setFitHeight(HEIGHT);
   g7.setFitWidth(WIDTH);
   g7.setX(WIDTH*-4.5);*/
   
       ImageView portal=new ImageView("/game3d/prtl.gif"); 

    portal.setFitHeight(HEIGHT);
   portal.setFitWidth(WIDTH);
   portal.setX(WIDTH*-4.5);
   
        ImageView portalt=new ImageView("/game3d/esc.gif"); 

  portalt.setFitHeight(120);
   portalt.setFitWidth(120);
     ImageView portalt2=new ImageView("/game3d/slct.gif"); 

  portalt2.setFitHeight(120);
   portalt2.setFitWidth(120);
    portalt2.setY(60);
    
    
       ImageView portalt3=new ImageView("/game3d/p.gif"); 

  portalt3.setFitHeight(120);
   portalt3.setFitWidth(120);
    
    
    portalt3.setY(120);
  // portalt.setX(WIDTH);
 //portal.setY(portal.getY()-300);
   
 // g2.translateXProperty().set(WIDTH);
//g2.translateYProperty().set(HEIGHT);
   
  
              URL path2 = getClass().getResource("/game3d/tp.mp3");
AudioClip tp=new AudioClip(path2.toString());


   String active="/game3d/hands2.png";
   String passive="/game3d/hands.png";
    ImageView hands=new ImageView(passive); 
    ImageView hands2=new ImageView(active); 
        ImageView hands3=new ImageView(passive); 
        hands.setFitHeight(HEIGHT/1.7);
  hands.setFitWidth(WIDTH/1.7);
   
  

 
  
    Group group = new Group();
 //   group.getChildren().add(sphere);

  group.getChildren().add(wp);

 group.getChildren().add(bg);
 group.getChildren().add(g2);
  group.getChildren().add(g3);
    group.getChildren().add(g4);
      group.getChildren().add(g5);
        group.getChildren().add(g6);
       group.getChildren().add(eff);
              group.getChildren().add(src);
group.getChildren().add(mouth);
group.getChildren().add(portal);
group.getChildren().add(portalt);
group.getChildren().add(portalt2);
group.getChildren().add(portalt3);


      //          group.getChildren().add(trsp);

 group.getChildren().add(hands);
  

 //group.getChildren().add(magic);
 eff.setVisible(false);
    Camera camera = new PerspectiveCamera();
    
    
    
//INIT Z
      bg.translateZProperty().set(bg.getTranslateZ() + 10650);
           g2.translateZProperty().set(g2.getTranslateZ() + 10650);
              g3.translateZProperty().set(g3.getTranslateZ() + 10650);
                   g4.translateZProperty().set(g4.getTranslateZ() + 10650);
              g5.translateZProperty().set(g5.getTranslateZ() + 10650);
                            g6.translateZProperty().set(g6.getTranslateZ() + 10650);
                            src.translateZProperty().set(src.getTranslateZ()+1800);
                             mouth.translateZProperty().set(mouth.getTranslateZ()+1800);
                                                          portal.translateZProperty().set(portal.getTranslateZ()+10650);


//INNIIIIT
   
    Scene scene = new Scene(group, WIDTH, HEIGHT);
          //  scene.getStylesheets().addAll(this.getClass().getResource("css.css").toExternalForm());

    scene.setFill(Color.TRANSPARENT);
    
    scene.setCamera(camera);
    
    
 //TRANSIIIITON
fadetransition2.setNode(camera);
		fadetransition2.setFromValue(0);
		fadetransition2.setToValue(1);
		fadetransition2.play();
 //TRANNSIIITIONN
 
hands.translateXProperty().set(WIDTH/4);
hands.translateYProperty().set(hands.getY()+400);




//bg.setViewport(new Rectangle2D(197, 572, 98, 143)); 
wp.setRotationAxis(Rotate.Y_AXIS); 
eff.setRotationAxis(Rotate.Y_AXIS); 
bg.setRotationAxis(Rotate.Y_AXIS); 


g2.setRotationAxis(Rotate.Y_AXIS); 


g3.setRotationAxis(Rotate.Y_AXIS); 
g5.setRotationAxis(Rotate.Y_AXIS); 
g6.setRotationAxis(Rotate.Y_AXIS); 
g4.setRotationAxis(Rotate.Y_AXIS); 



int sec=60;






 Timeline fiveSecondsWonder = new Timeline(
                 new KeyFrame(Duration.seconds(0.1), 
                 new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
    if(exit==0)
   {     
     
        
        if(!ac.isPlaying() && exit==0)
        {
            System.out.println("Lahné");
ac.play();
        }
      
r-=7;
eff.setRotate(r);
g2.setRotate(r);
 bg.setRotate(r);     
 g3.setRotate(r); 
  g4.setRotate(r); 
 g5.setRotate(r); 
 g6.setRotate(r); 



      //  System.out.println("r="+r);
if(r==-180)
    r=0;
    }}
}));
        //System.out.println("TESTIME=="+testtime);


fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
fiveSecondsWonder.play();




 
    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{

/*double pg4=g2.getFitWidth()*1.5+g3.getFitWidth()/2;
double pg5=g2.getFitWidth()*1.5+g3.getFitWidth()/2;
double pg6=g2.getFitWidth()*1.5+g3.getFitWidth()/2;*/

/// HOUNIII EL SELECTION
 if(exit==0)
   {
        System.out.println("x="+g2.getTranslateX());
                System.out.println("z="+g2.getTranslateZ());
                        System.out.println("Y="+g2.getTranslateY());


        if(g2.getTranslateX()>=-g2.getFitWidth()/2 && g2.getTranslateX()<=g2.getFitWidth()/2 && g2.getTranslateZ()<=6500)
        {
            
            System.out.println("A4 ");  
              
                  if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
                  hands.setImage(hands2.getImage());
                
               // tp.stop();
               eff.setX(0);
                eff.setTranslateX(bg.getTranslateX());
            eff.setTranslateY(bg.getTranslateY());
              eff.setTranslateZ(bg.getTranslateZ());
            eff.setVisible(true);
  
        }

  
        else  if(g2.getTranslateX()>=-2300 && g2.getTranslateX()<=-1400 && g2.getTranslateZ()<=6500)
        {
     if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
               hands.setImage(hands2.getImage());

        
            System.out.println("flaw");
              eff.setX(WIDTH*1.5);
            eff.setTranslateX(g2.getTranslateX());
             eff.setTranslateY(g2.getTranslateY());
              eff.setTranslateZ(g2.getTranslateZ());
            eff.setVisible(true);
           /*    trsp.setX(WIDTH*1.5);
            trsp.setTranslateX(g2.getTranslateX());
             trsp.setTranslateY(g2.getTranslateY());
              trsp.setTranslateZ(g2.getTranslateZ());*/



        }
        
          else if(g2.getTranslateX()>=1400 && g2.getTranslateX()<=2300 && g2.getTranslateZ()<=6500)
        {
      if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
            System.out.println("Checker");
                 hands.setImage(hands2.getImage());
                eff.setX(WIDTH*-1.5);       
            eff.setTranslateX(g3.getTranslateX());
             eff.setTranslateY(g3.getTranslateY());
              eff.setTranslateZ(g3.getTranslateZ());
            eff.setVisible(true);
        }
     else if(g2.getTranslateX()>=-4300 && g2.getTranslateX()<=-3550 && g2.getTranslateZ()<=6500)
        {
 if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
            System.out.println("Match");
                 hands.setImage(hands2.getImage());
               eff.setX(WIDTH*3);        
            eff.setTranslateX(g4.getTranslateX());
             eff.setTranslateY(g4.getTranslateY());
              eff.setTranslateZ(g4.getTranslateZ());
            eff.setVisible(true);
        }
     
    
    
        
        else if(g2.getTranslateX()>=3500 && g2.getTranslateX()<=4300 && g2.getTranslateZ()<=6500)
        {
    if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
            System.out.println("Chess");
                 hands.setImage(hands2.getImage());
                 
                       eff.setX(WIDTH*-3);        
            eff.setTranslateX(g5.getTranslateX());
             eff.setTranslateY(g5.getTranslateY());
              eff.setTranslateZ(g5.getTranslateZ());
            eff.setVisible(true);
        }
        
         else if(g2.getTranslateX()>=-6200 && g2.getTranslateX()<=-5350 && g2.getTranslateZ()<=6500)
        {
     if(tp.isPlaying()==false && played==0)
                  { tp.play();
                  played=1;
                  }
            System.out.println("Cows");
                hands.setImage(hands2.getImage());
                      eff.setX(WIDTH*4.5);
            eff.setTranslateX(g6.getTranslateX());
             eff.setTranslateY(g6.getTranslateY());
              eff.setTranslateZ(g6.getTranslateZ());
            eff.setVisible(true);
        }
         

    
        else
         { 
             tp.stop();
             played=0;
             System.out.println("ELSE");
         eff.setVisible(false);
          hands.setImage(hands3.getImage());
         }
  
      //Animate mouth
      
    
      
    
            /*
          
            Timeline mouthflick = new Timeline(
                 new KeyFrame(Duration.seconds(1.5), 
                 new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("***********");
              testmouth*=-1;
             if(word1.isPlaying() && testmouth==1)
        {
            
         mouth.setVisible(true);
         
            System.out.println("here1");
         
        
    }
         
         
             else if(word1.isPlaying() && testmouth==-1)
             {
                  mouth.setVisible(false);
          
              System.out.println("here2");
        
             }
             
    }
    }));
    
          mouthflick.setCycleCount(Timeline.INDEFINITE);
mouthflick.play();  
          
           */
       // }   
        
 
  
        //DEFAULT Z
        
     

        
    //// STOPP SELECTION    
        
        
        
        
      switch (event.getCode()) {
        case S:
            if(g2.getTranslateZ()<15750)
            {test++;
     if(test%2==0)
          hands.translateYProperty().set(hands.getTranslateY() + 2); 
     else
          hands.translateYProperty().set(hands.getTranslateY() - 2); 
              
     
          bg.translateZProperty().set(bg.getTranslateZ() + 50);
           g2.translateZProperty().set(g2.getTranslateZ() + 50);
              g3.translateZProperty().set(g3.getTranslateZ() + 50);
                   g4.translateZProperty().set(g4.getTranslateZ() + 50);
              g5.translateZProperty().set(g5.getTranslateZ() + 50);
                            g6.translateZProperty().set(g6.getTranslateZ() + 50);
           src.translateZProperty().set(src.getTranslateZ() + 50); 
           mouth.translateZProperty().set(mouth.getTranslateZ() + 50); 
portal.translateZProperty().set(portal.getTranslateZ() + 50); 

            }
          break;
        case Z:
            if(g2.getTranslateZ()>5950)
            {          test++;
     if(test%2==0)
          hands.translateYProperty().set(hands.getTranslateY() + 2); 
     else
          hands.translateYProperty().set(hands.getTranslateY() - 2); 
  
          bg.translateZProperty().set(bg.getTranslateZ() - 50);
           g2.translateZProperty().set(g2.getTranslateZ() - 50);
           g3.translateZProperty().set(g3.getTranslateZ() - 50);
                      g4.translateZProperty().set(g4.getTranslateZ() - 50);
           g5.translateZProperty().set(g5.getTranslateZ() - 50);
           g6.translateZProperty().set(g6.getTranslateZ() - 50);
           src.translateZProperty().set(src.getTranslateZ() - 50); 
         mouth.translateZProperty().set(mouth.getTranslateZ() - 50); 
portal.translateZProperty().set(portal.getTranslateZ() - 50); 
            }
          break;
        case D:
              if(g2.getTranslateX()>-7950)
                {  
             test++;
     if(test%2==0)
          hands.translateYProperty().set(hands.getTranslateY() + 2); 
     else
          hands.translateYProperty().set(hands.getTranslateY() - 2); 
         //       wp.translateXProperty().set(wp.getTranslateX() - 50); 

          bg.translateXProperty().set(bg.getTranslateX() - 50);
           g2.translateXProperty().set(g2.getTranslateX() - 50); 
           g3.translateXProperty().set(g3.getTranslateX() - 50); 
                  g4.translateXProperty().set(g4.getTranslateX() - 50); 
           g5.translateXProperty().set(g5.getTranslateX() - 50); 
                  g6.translateXProperty().set(g6.getTranslateX() - 50); 
                  src.translateXProperty().set(src.getTranslateX() - 50); 
                    mouth.translateXProperty().set(mouth.getTranslateX() - 50); 
                               portal.translateXProperty().set(portal.getTranslateX() - 50); 
                }
             
          break;
            case Q:
                if(g2.getTranslateX()<7500)
                {    test++;
     if(test%2==0)
          hands.translateYProperty().set(hands.getTranslateY() + 2); 
     else
          hands.translateYProperty().set(hands.getTranslateY() - 2); 
     
           //    wp.translateXProperty().set(wp.getTranslateX() + 50); 
               


          bg.translateXProperty().set(bg.getTranslateX() + 50); 
          g2.translateXProperty().set(g2.getTranslateX() + 50); 
           g3.translateXProperty().set(g3.getTranslateX() + 50); 
                    g4.translateXProperty().set(g4.getTranslateX() + 50); 
           g5.translateXProperty().set(g5.getTranslateX() + 50);      
           g6.translateXProperty().set(g6.getTranslateX() + 50); 
                     src.translateXProperty().set(src.getTranslateX() + 50); 
                     mouth.translateXProperty().set(mouth.getTranslateX() + 50); 
                     portal.translateXProperty().set(portal.getTranslateX() + 50); 

           // g2.translateXProperty().set(g2.getTranslateX() + 50); 
         // r-=10;
                }
          break;
          
          
          
            case P:
                if(g2.getTranslateX()>=-6200 && g2.getTranslateX()<=-5350 && g2.getTranslateZ()<=6500)
        {  word1.stop();
        a4.stop();
        chss.stop();
        chk.stop();
        ftfs.stop();
        mgs.stop();
        mchk.stop();
        if(!cnb.isPlaying())
        cnb.play();
        else
        {
            cnb.stop();
          cnb.play();  
        }
        
        }
                else if(g2.getTranslateX()>=-g2.getFitWidth()/2 && g2.getTranslateX()<=g2.getFitWidth()/2)
        {          word1.stop();
        mchk.stop();
        cnb.stop();
        chss.stop();
        chk.stop();
        ftfs.stop();
        mgs.stop();
        if(!a4.isPlaying())
        a4.play();
        else
        {
            a4.stop();
          a4.play();  
        }
        }
                
                           else if(g2.getTranslateX()>=1400 && g2.getTranslateX()<=2300 && g2.getTranslateZ()<=6500)
        { word1.stop();
        mchk.stop();
        cnb.stop();
        a4.stop();
        chss.stop();
        ftfs.stop();
        mgs.stop();
        if(!chk.isPlaying())
        chk.play();
        else
        {
            chk.stop();
          chk.play();  
        }
                
        }
                
                 else if(g2.getTranslateX()>=3500 && g2.getTranslateX()<=4300 && g2.getTranslateZ()<=6500)
                 {
                word1.stop();
                mchk.stop();
        cnb.stop();
        a4.stop();
        chk.stop();
        ftfs.stop();
        mgs.stop();
        if(!chss.isPlaying())
        chss.play();
        else
        {
            chss.stop();
          chss.play();  
        }
                 }
                
                 else if(g2.getTranslateX()>=-2300 && g2.getTranslateX()<=-1400 && g2.getTranslateZ()<=6500)
                 {
                     word1.stop();
        cnb.stop();
        mchk.stop();
        a4.stop();
        chss.stop();
        chk.stop();
        mgs.stop();
        if(!ftfs.isPlaying())
        ftfs.play();
        else
        {
            ftfs.stop();
          ftfs.play();  
        }
                     
                 }
                 else if(g2.getTranslateX()>=-4300 && g2.getTranslateX()<=-3550 && g2.getTranslateZ()<=6500)
                 {
                                    word1.stop();
        cnb.stop();
        mchk.stop();
        a4.stop();
        chss.stop();
        chk.stop();
        ftfs.stop();
        if(!mgs.isPlaying())
        mgs.play();
        else
        {
            mgs.stop();
          mgs.play();  
        }
                 }
                
               else if(g2.getTranslateX()>=-2450 && g2.getTranslateX()<=-1450 && g2.getTranslateZ()>=7600)
  {
                                     mgs.stop();
        cnb.stop();
        mchk.stop();
        a4.stop();
        chss.stop();
        chk.stop();
        ftfs.stop();
        if(!word1.isPlaying())
        word1.play();
        else
        {
            word1.stop();
          word1.play();  
        }
      
      
      
  }
                break;
          
                
            case M:
                                      if(g2.getTranslateX()>=1400 && g2.getTranslateX()<=2300 && g2.getTranslateZ()<=6500)
        { word1.stop();
        cnb.stop();
        
        a4.stop();
        chss.stop();
        ftfs.stop();
        mgs.stop();
        chk.stop();
        if(!mchk.isPlaying())
        mchk.play();
        else
        {
            mchk.stop();
          mchk.play();  
        }
                
        }
                break;
                
                
                
                
                
                
                
                
                
                
            case ESCAPE:
                 
       exit=1;
                    ac.stop();
                       	
		fadetransition.setNode(group);
            
		fadetransition.setFromValue(1);
		fadetransition.setToValue(0);
                fadetransition.setOnFinished ((ActionEvent e) -> {
           
                         
                    try {
                        Parent root=FXMLLoader.load(getClass().getResource("/gui/menu.fxml"));
                        Scene scenex=new Scene(root);
                        primaryStage.setScene(scenex);
                                   	fadetransitionx.setNode(root);
            
		fadetransitionx.setFromValue(0);
		fadetransitionx.setToValue(1);
                fadetransitionx.play();
                        primaryStage.show();
                   // ac.stop();
             
                        
                        
                        
	
                        
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                
         
		});
                    bye.play();
                tps.play();
	fadetransition.play();
                            

        
         
                
               break;
              
            case ENTER:
            case SPACE:
                if(g2.getTranslateX()>=-2300 && g2.getTranslateX()<=-1400 && g2.getTranslateZ()<=6500)
        {
            ac.stop();
                          try {
                     
            System.out.println("here");
      Media media = new Media(getClass().getResource("/flaw/Game/mi.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //Media musicFile= new Media("file:///‪E:/GameProject/src/lib/audio/menu.mp3");
        //mediaplayer= new MediaPlayer(musicFile);
        //mediaplayer.setAutoPlay(true);
        //mediaplayer.setVolume(0.1);
        primaryStage.setTitle("Find The Flaw");
           AnchorPane root = FXMLLoader.load(getClass().getResource("/flaw/Game/Menu.fxml"));
        exit=1;
         menu_scene = new Scene(root);
        // menu_scene.getChildren().setAll(root);
        primaryStage.setScene(menu_scene);
        primaryStage.show();
        
        
        } catch (IOException ex) {
            Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
        }
          
                           }
                
                
                  else if(g2.getTranslateX()>=-6200 && g2.getTranslateX()<=-5350 && g2.getTranslateZ()<=6500)
        { ac.stop();
            try {
                
                CowsnBulls m=new CowsnBulls();
                exit=1;
                m.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                
                
                 
        else if(g2.getTranslateX()>=3500 && g2.getTranslateX()<=4300 && g2.getTranslateZ()<=6500)
        { ac.stop();
            try {
                System.out.println("Chess");
             exit=1;
                Mainchess mc=new Mainchess();
                mc.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                
                
                    else if(g2.getTranslateX()>=1400 && g2.getTranslateX()<=2300 && g2.getTranslateZ()<=6500)
        { ac.stop();
            try {
                System.out.println("Checker");
                Checkers ch=new Checkers();
                exit=1;
                ch.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
                
                  else if(g2.getTranslateX()>=-4300 && g2.getTranslateX()<=-3550 && g2.getTranslateZ()<=6500)
        { ac.stop();
            try {
                System.out.println("Match");
              //  Memory mm=new Memory();
                exit=1;
              /* Stage S=new Stage();
                mm.start(S);*/
              
                 
       Parent root=FXMLLoader.load(getClass().getResource("/memoryGame/memory/FXMLDocument.fxml"));
       Scene scenex=new Scene(root);
      stage3d.setScene(scenex);
      stage3d.show();
        
                
            } catch (Exception ex) {
                Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                
                            else if(g2.getTranslateX()>=5350 && g2.getTranslateX()<=6200 && g2.getTranslateZ()<=6500)
        {

            
                System.out.println("Portal");
              exit=1;
                    ac.stop();
                       	
		fadetransition.setNode(group);
            
		fadetransition.setFromValue(1);
		fadetransition.setToValue(0);
                fadetransition.setOnFinished ((ActionEvent e) -> {
           
                         
                    try {
                        Parent root=FXMLLoader.load(getClass().getResource("/gui/menu.fxml"));
                        Scene scenex=new Scene(root);
                        primaryStage.setScene(scenex);
                        primaryStage.show();
                           exit=1;
                    ac.stop();
                        	fadetransitionx.setNode(root);
            
		fadetransitionx.setFromValue(0);
		fadetransitionx.setToValue(1);
                fadetransitionx.play();
                        
                        
                        
	
                        
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                
         
		});
                    bye.play();
                tps.play();
	fadetransition.play();
                            

  
      break;
     
    
      
           
      

        }
                
                
                
                
                        if(g2.getTranslateX()>=-g2.getFitWidth()/2 && g2.getTranslateX()<=g2.getFitWidth()/2)
        {
            try { ac.stop();
                System.out.println("A4 ");
                exit=1;
                A4 a4s=new A4();
                a4s.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Game3d.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
                break;
                
                
       
      }}
    });
    
 
    primaryStage.setTitle("Magic Brain World");
    //scene.getStylesheets().addAll(this.getClass().getResource("css.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }


    /**
     * @param args the command line arguments
     */
  
   
    
}

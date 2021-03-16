/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entités.Scores;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import projet.Projet;
import services.ServiceScore;
import utils.SocialMedia;
import static utils.SocialMedia.openWebpage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PageScoreController implements Initializable {

    @FXML
    private Text score;
    @FXML
    private ImageView stars;
    @FXML
    private Button leave;
    @FXML
    private ImageView imagegif;
   // 
    @FXML
    private ImageView s1;
    @FXML
    private ImageView s2;
    @FXML
    private ImageView s3;
    @FXML
    private Text stageclear;
    @FXML
    private ImageView facebook;
    @FXML
    private ImageView ldr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ldr.setLayoutX(1100);
            Projet.idu++;
            ServiceScore ss=new ServiceScore();
            System.out.println("LIGNE1");
            int id=ss.getId()+1;
            Scores p=new Scores(id,Projet.gameid,1,Projet.score);
            System.out.println("LIGNE2");
            
            
            try {
                ss.add(p);
                System.out.println("LIGNE3");
                
            } catch (SQLException ex) {
                Logger.getLogger(PageScoreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.5),
                            new EventHandler<ActionEvent>() {
                                
                                @Override
                                public void handle(ActionEvent event) {
                                    Text t=new Text();
                                    t.setText(stageclear.getText());
                                    t.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                                    score.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                                    stageclear.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                                    
                                    
                                }
                            }
                    ));
            
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            
            ImageView imm =new ImageView();
            String s=String.valueOf(Projet.score);
            score.setText(s);
            Image im = null;
            Image im2=new Image("/projet/img/star.png");
            Image im3=new Image("/projet/img/star2.png");
            s1.setImage(im2);
            
            if(Projet.score>58000)
            { im=new Image("/projet/img/3s.gif");
            s2.setImage(im2);
            s3.setImage(im2);
            }
            else  if(Projet.score<=58000 && Projet.score>52000)
            {  im=new Image("/projet/img/2s.gif");
            s2.setImage(im2);
            s3.setImage(im3);
            
            }
            else
            {
                im=new Image("/projet/img/1s.gif");
                s2.setImage(im3);
                s3.setImage(im3);
                
            }
            
            imm.setImage(im);
            
            
            imagegif.setImage(im);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PageScoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }    
    
    public void setScore(int scores)
    {
        String s=String.valueOf(scores);
        score.setText(s);
    }

    @FXML
    private void leave(ActionEvent event) throws IOException {
           Stage stage=(Stage)leave.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void share(MouseEvent event) throws IOException, AWTException {
  
                //**************************   social media
                        Stage stage=(Stage)facebook.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/projet/FXMLDocument.fxml"));
       Rectangle r=new Rectangle();
      r.setRect(stage.getX(),stage.getY(), stage.getWidth(),stage.getHeight());
            //    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
             BufferedImage image = new Robot().createScreenCapture(r);
                System.out.println("Step1");
ImageIO.write(image, "png", new File("src/projet/img/screenshots/screenshoot.png"));
System.out.println("Step2");
/*
        		SocialMedia sm = new SocialMedia();
    
		Map<String, String> socialmediaargs = new HashMap<String, String>(){{
			put("url", "http://www.earthfluent.com/");
			put("title", "EarthFluent");
		}};
		Map<String, String> socialmediasites = sm.GetSocialMediaSiteLinks_WithShareLinks(socialmediaargs);
 
		for (String socialmedia : sm.GetSocialMediaSites_WithShareLinks_OrderedByPopularity()) {
		if(socialmedia=="facebook")	
                {System.out.println(socialmedia + " : " + socialmediasites.get(socialmedia));
                        openWebpage(socialmediasites.get(socialmedia));
                        
		}
                }
                */
	
        //****************************MEDIAAAAAAAAAAAAAAAAAAAA
        
    
        
    }

    @FXML
    private void leaderboard(MouseEvent event) throws IOException {
              Stage stage=(Stage)ldr.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("/gui/Info_Game.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}

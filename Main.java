/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flaw.Game;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import javafx.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author Saif
 */


public class Main extends Application {
    MediaPlayer mediaplayer;
    public static Scene menu_scene;
    public Stage primaryStage;
    private AnchorPane mainLayout;
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
  /*
       Media media = new Media(getClass().getResource("mi.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();*/
        //Media musicFile= new Media("file:///‪E:/GameProject/src/lib/audio/menu.mp3");
        //mediaplayer= new MediaPlayer(musicFile);
        //mediaplayer.setAutoPlay(true);
        //mediaplayer.setVolume(0.1);
        this.primaryStage= primaryStage;
        this.primaryStage.setTitle("Find The Flaw");
        showMainView();
    }
    public void showMainView() throws IOException{
       // final URL resource = ;
          Media media = new Media(getClass().getResource("mi.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
         menu_scene = new Scene(root);
        // menu_scene.getChildren().setAll(root);
        primaryStage.setScene(menu_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
   /* public static void main(String[] args) {
        launch(args);
    }  */

     
}
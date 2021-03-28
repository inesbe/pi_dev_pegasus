/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flaw.Game;

import static flaw.Game.Main.menu_scene;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author Saif
 */
public class Menu2Controller extends MultiPlayerController implements Initializable {
    static int a,x,y;
    static int scor1=0, scor2=0;
    public static Label streak5=new Label();
    //static int tryo=3;                    
    int timerx=0;  
    int chq=0;
    int end=0;
    static int score=0;
    static int streak=0;
    static ImageView[] imageView;
    static ImageView[] imageView2;
     Media media = new Media(getClass().getResource("/flaw/Game/caf.wav").toString());
     Media media2 = new Media(getClass().getResource("/flaw/Game/wrongclick.mp3").toString());
    Label lbl1 = new Label();
    Label lbl2 = new Label();
    private Label labem=new Label();
    static int startTime =35;
    static int chq1 = 0;
    static int second= startTime;
    Button reset;
    Button tryagain;
    public Label time1 = new Label();
    public static Label score1 = new Label();
    public  static Label streak1 = new Label();
    public Text txt;
    public AnchorPane menu2Pane;
    public ImageView single_player;
    public Button multi_player;
    public ImageView back;
    public ImageView about;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TIME="+second);
        System.out.println("Start="+start);
        end=0;
         
    }
  
     static   DateFormat df = new SimpleDateFormat("ss");
    static Calendar calobj = Calendar.getInstance();
    //System.out.println("time = "+df.format(calobj.getTime()));
    /*static{
         media = new Media(getClass().getResource("caf.wav").toString());
         MediaPlayer mediaPlayer = new MediaPlayer(media);
         mediaPlayer.play();
    }*/
    final TextField display = new TextField("0");
    static{
        imageView = new ImageView[13];
        for(int i=0;i<9;i++){
        Image image = new Image("/flaw/Game/Bird_f.png");
                imageView[i] = new ImageView();
                imageView[i].setImage(image);
                /*imageView[i].setFitWidth(400);
                imageView[i].setSmooth(true);
                imageView[i].setPreserveRatio(true);*/
        }
    } 
    static{
        imageView2 = new ImageView[13];
        for(int i=0;i<9;i++){
        Image image = new Image("/flaw/Game/Bird_fr.png");
                imageView2[i] = new ImageView();
                imageView2[i].setImage(image);
                
        }
    } 
    public void play(){
        MediaPlayer mediaPlayer = new MediaPlayer(media);
                             mediaPlayer.play();
    }
    public void play2(){
        MediaPlayer mediaPlayer = new MediaPlayer(media2);
                             mediaPlayer.play();
    }
    
    @FXML
    public  void loadMultiPlayer() throws IOException{
        
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("/flaw/Game/MultiPlayer.fxml"));
        Group  grp1 = new Group(); 
        grp1.getChildren().add(pane);
        
        lbl1.setText(scor1+"Score");
        lbl1.setFont(new Font("Cambria", 32));
        lbl1.setLayoutX(400);
        lbl1.setLayoutY(60);
        grp1.getChildren().add(lbl1);
        lbl2.setLayoutX(500);
        lbl2.setLayoutY(60);
        lbl2.setText("Score"+scor2);
        lbl2.setFont(new Font("Cambria", 32));
        grp1.getChildren().add(lbl2);
        menu2Pane.getChildren().setAll(pane);
        
    }
    public void loadScene(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Menu.fxml"));
        menu2Pane.getChildren().setAll(pane);
    }
    
    public void loadSceneAbout(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/About.fxml"));
        menu2Pane.getChildren().setAll(pane);
    }
    
    
    public void loadimage(int axix, int randon,Group root){
        
        Random rand = new Random();
        int o;
    if(axix==1){
            
             x= rand.nextInt(1000)+60;
             y= 60;
            
        }
        else if (axix==2){
            
            y= rand.nextInt(500)+60;
            x=60;
            
        }
        int number_of_bird =rand.nextInt(4)+3;
        int  n = rand.nextInt(number_of_bird) + 1;
        switch(randon){
            case 1:
        for(int i = 0 ; i<=number_of_bird ; i++){
            if(i!=n)
            {
                imageView[i].setTranslateX(x);
                imageView[i].setTranslateY(y);
                imageView[i].setFitWidth(400);
                imageView[i].setSmooth(true);
                imageView[i].setPreserveRatio(true);
                root.getChildren().add(imageView[i]);
            }
            else 
            {
                o=rand.nextInt(3)-1;
                System.out.println("o ="+o);
                a=o;
                Image image = new Image("/flaw/Game/Bird_fr.png");
                imageView[i] = new ImageView();
                imageView[i].setImage(image);
                imageView[i].setFitWidth(400);
                imageView[i].setSmooth(true);
                imageView[i].setPreserveRatio(true);
                imageView[i].setTranslateX(x);
                imageView[i].setTranslateY(y);
                imageView[i].setRotate(90*o);
                root.getChildren().add(imageView[i]);
                Image image1 = new Image("/flaw/Game/Bird_f.png");
                imageView[i] = new ImageView();
                imageView[i].setImage(image1);
                
            }
            if(axix==1)
            { 
                y+= 80;
            }
            else if (axix==2){
                
                x+=100;
            }
        }
        break;
            case 2:
                for(int i = 0 ; i<=number_of_bird ; i++){
                if(i!=n)
                {
                    imageView2[i].setTranslateX(x);
                    imageView2[i].setTranslateY(y);
                    imageView2[i].setFitWidth(400);
                    imageView2[i].setSmooth(true);
                    imageView2[i].setPreserveRatio(true);
                    root.getChildren().add(imageView2[i]);
                }
                else 
                    {
                        o=rand.nextInt(3)-1;
                        System.out.println("o="+o);
                        a=o;
                        Image image = new Image("/flaw/Game/Bird_f.png");
                        imageView2[i] = new ImageView();
                        imageView2[i].setImage(image);
                        imageView2[i].setFitWidth(400);
                        imageView2[i].setSmooth(true);
                        imageView2[i].setPreserveRatio(true);
                        imageView2[i].setTranslateX(x);
                        imageView2[i].setTranslateY(y);
                        imageView2[i].setRotate(90*o);
                        root.getChildren().add(imageView2[i]);
                        Image image1 = new Image("/flaw/Game/Bird_fr.png");
                        imageView2[i] = new ImageView();
                        imageView2[i].setImage(image1);
                        
                    }
                    if(axix==1)
                    {
                         y+= 80;
                    }
                    else if (axix==2){
                        x+=100;
                    }
                }
                break;
        }
             menu2Pane.getChildren().setAll(root);
        //  
        
    }
    public void Reset(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("/flaw/Game/SinglePlayer.fxml"));
        System.out.println("Runs");
        score=0;
        streak=0;
        second=startTime;
        start=1;
        /*Random rand = new Random();
        int randon =rand.nextInt(2)+1; 
        int axix = rand.nextInt(2)+1;
        Group  root = new Group(); 
        loadimage(axix, randon,root);*/
        score1.setText("Score: "+score);
        streak1.setText("Streak: "+streak); 
    //menu2Pane.getChildren().setAll(root);        
        //time=;
        //loadSinglePlayer();
        //menu2Pane.getChildren().setAll(pane);
    }
    void  doTime(int po) {
        Timeline  time = new Timeline() ;
        time.setCycleCount(Timeline.INDEFINITE);
        
        KeyFrame frame = new KeyFrame( javafx.util.Duration.millis(po), (ActionEvent event) -> {
            second--;
            chq1++;
            labem.setText("Count down: "+second);
            
                if(second <= 0){
                try {
                    end=1;
                    System.out.println("DKHALNA");
                    second=startTime;
  //labem.setText("Count down: "+second);       
streak5.setVisible(true);
                    
                    time.stop();
                    
                    //ZYYEDAAA
boolean high=false;
                    System.out.println("fich");            
    File f=new File("src/flaw/topscore.txt");
                    System.out.println("Fich");
    
    BufferedReader brTest = new BufferedReader(new FileReader(f));
    String text = brTest .readLine();
   System.out.println("Firstline is : " + text);
   if(score>Integer.parseInt(text))
       {
           high=true;
  FileWriter fw = new FileWriter(f.getAbsoluteFile());
  
   BufferedWriter bw = new BufferedWriter(fw);
   
   bw.write(String.valueOf(score));
   bw.flush();
   bw.close();
  }           
                    
                    //ZYYEDDAA
                    System.out.println("Houni");
                    AnchorPane pane2 =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Level Failed.fxml"));
          System.out.println("Houni2");
                    menu2Pane.getChildren().setAll(pane2);
                    Group ro= new Group();
                    if(high)
                     streak5.setText("New High Score:"+score); 
                    else
                    streak5.setText("Final Score:"+score);
                    streak5.setLayoutX(550);
                    streak5.setLayoutY(350);
                    streak5.setFont(new Font("Cambria", 50));
                    ro.getChildren().add(streak5);
                    menu2Pane.getChildren().add(ro);
                    } catch (IOException ex) {
                    System.out.println("af");
                    
                }
                }
                 
        });
        time.getKeyFrames().add(frame);
        time.play();
    }
    void hello(){
        doTime(1000);
    }
    void breakgame(){
        if(chq1==30){
        
        }
    }
    public  int start=1;
    @FXML
    public void loadSinglePlayer() throws IOException {
        System.out.println("lodsingleplayer");
       //second=startTime;
        //start=1;
       // System.out.println("time="+second);
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/SinglePlayer.fxml"));
        System.out.println("loaded");
        Group  root = new Group(); 
        //labem.setVisible(true);
         
        //labem = new Label();
        //label.setTextFill(Color.BLACK);
        //label.setText("Time "+)
       if(start==1){
        hello();
        }
        System.out.println("STAART="+start);
        start++;
        labem.setFont(new Font("Cambria", 32));
        HBox layout  = new HBox(20);
        layout.getChildren().add(labem);
        
        pane.getChildren().add(layout);
        
        root.getChildren().add(pane);
        Random rand = new Random();
        
        /*time1.setLayoutX(450);
        time1.setLayoutY(70);
        time1.setFont(new Font("Cambria", 32));
        time1.setText("Time: "+df.format(calobj.getTime()));
        root.getChildren().add(time1);*/
    //
        streak1.setLayoutX(1100);
        streak1.setLayoutY(50);
        streak1.setFont(new Font("Cambria", 40));
        streak1.setText("Streak: "+streak);
        root.getChildren().add(streak1);
        score1.setLayoutX(1100);
        score1.setLayoutY(0);
        score1.setFont(new Font("Cambria", 32));
        score1.setText("Score: "+score);
        root.getChildren().add(score1);
        
        int randon =rand.nextInt(2)+1; 
        int axix = rand.nextInt(2)+1;
        loadimage(axix,randon,root);
        switch(randon){       
            case 1:
            /*if(chq1==30|| tryo<=0){
                 AnchorPane pane2 =FXMLLoader.load(getClass().getClassLoader().getResource("Game/Level Failed.fxml"));
            menu2Pane.getChildren().setAll(pane2);
            tryo=3;
            }*/    
            menu_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {   
            if(end==0)
            {
                 streak1.setText("Streak: "+streak);
                switch (event.getCode()) {
                    
                    case UP:    
                        if(a==1){
                            play();
                               
                            streak++;
                            score+=streak;
                            score1.setText("Score: "+score);
                           streak1.setText("Streak: "+streak);
                            try {    
                                loadSinglePlayer();
                                } catch (IOException ex) {
                            System.out.println("up");
                            }
                            //menu2Pane.setEffect(null);
                        }
                        else {
                            play2();
                            try {
                            loadSinglePlayer();
                            } catch (IOException ex) {
                            Logger.getLogger(Menu2Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            streak=0;
                            streak1.setText("Streak: "+streak);
                            System.out.println("Wrong");
                        }
                        break;
                    case DOWN:  
                        if(a==-1){
                            play();
                            //menu2Pane.setEffect(new GaussianBlur());
                            //delay();
                         
                            try {                                  
                         
                                streak++;
                                score+=streak;
                                score1.setText("Score: "+score);
                                streak1.setText("Streak: "+streak);
                                loadSinglePlayer();
                                }catch (IOException ex) {
                                System.out.println("down");
                                }
                           // menu2Pane.setEffect(null);
                        }
                        else {
                            play2(); 
                            try {
                            loadSinglePlayer();
                            } catch (IOException ex) {
                             System.out.println("down");
                            }   
                            
                            streak=0;
                            streak1.setText("Streak: "+streak);
                            System.out.println("Wrong");
                        }
                        break;
                    case LEFT:  
                        if(a==0){
                            System.out.println("left1");
                            play();
                           // menu2Pane.setEffect(new GaussianBlur());
                            //delay();
                             
                        try {
                             System.out.println("left2");                            
                           
                            streak++;
                            score+=streak;
                            score1.setText("Score: "+score);
                            streak1.setText("Streak: "+streak);
                            loadSinglePlayer();
                             } catch (IOException ex) {
                            System.out.println("left");
                            }
                        menu2Pane.setEffect(null);
                            
                        }
                        else {
                            
                            play2();
                    try {
                        loadSinglePlayer();
                    } catch (IOException ex) {
                        System.out.println("down");
                    }
                           
                            streak=0;
                            streak1.setText("Streak: "+streak);
                            System.out.println("Wrong");
                        }
                        break;
                    case RIGHT:
                        play2();
                {
                    try {
                        loadSinglePlayer();
                    } catch (IOException ex) {
                        System.out.println("down");
                    }
                }
                       
                        streak=0;
                        streak1.setText("Streak: "+streak);
                        break;
                }
            }
            }});
            break;
                case 2:
                    /*if(chq1 ==30 || tryo<=0){    
                    
                    tryo=4;
                    }  */
                        menu_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if(end==0)
                            {
                streak1.setText("Streak: "+streak);
                            switch (event.getCode()) {
                                case UP:    
                                if(a==-1){
                                    play();
                                    //menu2Pane.setEffect(new GaussianBlur());
                                    //delay();
                                    
                                                            
                                     
                                    try {
                                    loadSinglePlayer();
                                    //System.out.println(score);
                                     } catch (IOException ex) {
                                    System.out.println("up");
                                    }
                                    //menu2Pane.setEffect(null);
                                }
                                else {
                                        play2();
                                    try {
                                    loadSinglePlayer();
                                    } catch (IOException ex) {
                                    Logger.getLogger(Menu2Controller.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                       
                                        streak=0;
                                       streak1.setText("Streak: "+streak);
                                        System.out.println("Wrong");
                                    }
                                    break;
                                case DOWN:  
                                    if(a==1){
                                        play();     
                                        try {   
                                        
                                        streak++;
                                        score+=streak;
                                        score1.setText("Score: "+score);
                                        streak1.setText("Streak: "+streak);
                                        //System.out.println(score);
                                        loadSinglePlayer();
                                         } catch (IOException ex) {
                                        System.out.println("down");
                                        } 
                                        //menu2Pane.setEffect(null);
                                    }
                                else  {
                                        play2();
                                        
                                        try {
                                            loadSinglePlayer();
                                        } catch (IOException ex) {
                                            Logger.getLogger(Menu2Controller.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        streak=0;
                                       streak1.setText("Streak: "+streak);
                                        System.out.println("Wrong");
                                    }
                                    break;
                                case RIGHT:  
                                    if(a==0){
                                         
                                        play();    
                                        //menu2Pane.setEffect(new GaussianBlur());
                                        //delay();
                                        try {
                                       
                                        streak++;
                                        score+=streak;
                                        score1.setText("Score: "+score);
                                        streak1.setText("Streak: "+streak);
                                        loadSinglePlayer();
                                         } catch (IOException ex) {
                                        System.out.println("left");
                                        } 
                                        //menu2Pane.setEffect(null);
                                    }
                                    else {
                                        play2();
                                        
                                        try {
                                            loadSinglePlayer();
                                            } catch (IOException ex) {
                                            Logger.getLogger(Menu2Controller.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        streak=0;                            
                                        streak1.setText("Streak: "+streak);
                                        System.out.println("Wrong");
                                    }
                                    break;
                                case LEFT:
                                    
                                    play2();
                                    try {
                                    loadSinglePlayer();
                                    } catch (IOException ex) {
                                    Logger.getLogger(Menu2Controller.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    streak=0;    
                                    streak1.setText("Streak: "+streak);
                            }
                    }
               } });
                break;
            }
        //
    }

    @FXML
    private void loadSceneAbout(MouseEvent event) throws IOException {
          AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/About.fxml"));
        menu2Pane.getChildren().setAll(pane);
    }

    @FXML
    private void loadScene(MouseEvent event) throws IOException {
                   AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("flaw/Game/Menu.fxml"));
        menu2Pane.getChildren().setAll(pane);
    }
}
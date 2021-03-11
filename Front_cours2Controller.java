/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


import com.gtranslate.Language;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.transitions.JFXFillTransition;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import marytts.modules.synthesis.Voice;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.AudioInputStream;
import marytts.MaryInterface;

import marytts.util.data.audio.AudioPlayer;
    

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
/**
 * FXML Controller class
 *
 * @author shado
 */
public class Front_cours2Controller implements Initializable {

    
    String voice_french = "upmc-pierre-hsmm";
    String voice="cmu-slt-hsmm";
    String voice_english="cmu-slt-hsmm";
    @FXML
    private Label label;
    @FXML
    private JFXButton id_back1;
    @FXML
    private Label label_id;
     static Timeline timeline;
       String target_translated="";
    	private AudioPlayer tts;
	private MaryInterface marytts;
    @FXML
    private ImageView id_play;
    @FXML
    private Label nom_cours;
    @FXML
    private JFXComboBox<String> combo_lang;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  ArrayList<String> list=new ArrayList<>();
         list.add("francais");
         
         ObservableList<String> data = FXCollections.observableArrayList(list);
      this.combo_lang.setItems(data);
     GoogleTTS_Translate g=new GoogleTTS_Translate();
     target_translated=Projet.S;

    this.label_id.setText(Projet.S);
        this.nom_cours.setText(Projet.nom_cours);
	
    
    
    }
    private void back(ActionEvent event) throws IOException {
       Stage stage=(Stage)this.id_back1.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("Front_cours2Controller.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    @FXML
    private void play(MouseEvent event) {
              TextToSpeech tts = new TextToSpeech();
          tts.setVoice(voice);
        tts.speak(target_translated, 2.0f, false, false);
     
       System.out.println( tts.getAvailableVoices());
       timeline = new Timeline(
            new KeyFrame(Duration.seconds(0), new KeyValue(label_id.textFillProperty(), Color.color(Math.random(), Math.random(), Math.random()))),
            new KeyFrame(Duration.seconds(2), new KeyValue(label_id.textFillProperty(), Color.color(Math.random(), Math.random(), Math.random())))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void chang(Event event) {
        if(this.combo_lang.getSelectionModel().getSelectedIndex()==0)
        {
        target_translated=GoogleTTS_Translate.google_Translate(Language.FRENCH,Projet.S.replaceAll("\\n+","\\s1")).replaceAll("1","\n");
        System.out.print(target_translated);
     this.label_id.setText(target_translated);
     voice=voice_french;
        }
    }
    
    


}
    
              


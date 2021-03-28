/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.gtranslate.Language;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import static projet.Front_cours2Controller.timeline;
import projet.entity.Test;
import projet.entity.Utilisateur;
import projet.services.Servicetest;
import projet.services.Serviceutilisateur;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class Intelligence_artificielController implements Initializable {

    @FXML
    private ImageView ia_id;
    @FXML
    private TextField id_txt;
    
    String spoken_language;
    String translate_language=Language.ARABIC;
   static int change_language=0;
   static String song_output;
   static int transalte_status=0;
   static Application app; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
                       
			Serviceutilisateur su = new Serviceutilisateur();
        try {
            Utilisateur u=su.getU(Projet.id_utilisateur);
             String  uText="Hello "+u.getNom_utilisateur()+" its me nadia magic book personnel assistant what do you need ";
             
				DesktopTask.run(uText);
				String r=Reminder.remind(uText);
                            String s1=Language.ARABIC;
                          TextToSpeech_1.speak(uText);
			
        } catch (SQLException ex) {
            Logger.getLogger(Intelligence_artificielController.class.getName()).log(Level.SEVERE, null, ex);
        }
			
                           
                          // TextToSpeech_1.speak("Hello sir,I am Nadia magic book artifical intelligence how can i help you ?");
                        
                          
                            
                                  
                                 
    }    

    /*@FXML
    private void add_command(MouseEvent event) throws IOException {
             
               TextToSpeech_1.player.close();
            
            if(Intelligence_artificielController.transalte_status==1 && change_language==0)
        {
          TextToSpeech_1.speak(GoogleTTS_Translate.google_Translate( this.translate_language,this.id_txt.getText()));
          transalte_status=0;
          change_language=1;
        }
        
        String  uText=this.id_txt.getText().toLowerCase();
       if(uText.toLowerCase().contains("what does" ))
        {
        uText= uText.replace("what does","");
        uText= uText.replace("mean","");
        uText= uText.replace("?","");
        uText= uText.replace(" ","");
         System.out.println(uText);
         
        }
        
        
         
          
          
          
          
        if(this.id_txt.getText().toLowerCase().contains("arab") && change_language==0)
        {
         this.translate_language  = Language.ARABIC; 
         
          
        }
        else if(this.id_txt.getText().toLowerCase().contains("fr") && change_language==0)
        {
         this.translate_language  = Language.FRENCH;    
        }
       
            
            
            
        if (this.id_txt.getText().toLowerCase().contains("exit") || this.id_txt.getText().toLowerCase().contains("stop") || this.id_txt.getText().toLowerCase().contains("tata") || this.id_txt.getText().toLowerCase().contains("bye"))
  
        {       
      
               TextToSpeech_1.speak("closing magic book, have a great day !");
           
               timeline = new Timeline(
            new KeyFrame(Duration.seconds(3), evt ->
                    {
                  System.exit(0);
              }));            timeline.play();
            
        }
        
        String m=Mathematics.calculation(this.id_txt.getText());
        String g=Grammar.chat(this.id_txt.getText().toLowerCase());
      String d=DateTime.CurrentDateTime(this.id_txt.getText().toLowerCase());
       String dic=DictionaryManagement.InsertFromFile2(uText);
       String t=Translate.translate(this.id_txt.getText().toLowerCase());
         
         
       if(!g.isEmpty())
       {
        TextToSpeech_1.speak(g);
       }
       else if(!t.isEmpty())
       {
        TextToSpeech_1.speak(t);   
       }
       else if(!d.isEmpty())
               {
                TextToSpeech_1.speak(d);    
               }
        else if(!m.isEmpty())
        {
        TextToSpeech_1.speak(m);    
        }
       else if(!dic.isEmpty() && change_language==0)
       {
      TextToSpeech_1.speak(dic);
       }
       
   change_language=0;
      
     
      
    }*/
    void IA(String s) throws IOException
    {
        int dict=0;
    
            
            if(Intelligence_artificielController.transalte_status==1 && change_language==0)
        {
            System.out.println("what does"+this.translate_language+s);
          TextToSpeech_1.speak(GoogleTTS_Translate.google_Translate(this.translate_language,s));
          transalte_status=0;
          change_language=1;
        }
        
        String  uText=s.toLowerCase();
       if(uText.toLowerCase().contains("what does" ))
        {
         dict=1;
        uText= uText.replace("what does","");
        uText= uText.replace("mean","");
        uText= uText.replace(" ","");
         System.out.println(uText);
         
        }
       if(uText.toLowerCase().contains("search" ))
        {
         uText= uText.replace("search","");
          uText= uText.replace(" ","");
          change_language=1;
        }
        
         
          
          
          
          
        if(s.toLowerCase().contains("arab") && change_language==0)
        {
         this.translate_language  = Language.ARABIC; 
         
          
        }
        else if(s.toLowerCase().contains("fr") && change_language==0)
        {
         this.translate_language  = Language.FRENCH;    
        }
       
            
            if (s.toLowerCase().contains("go back") )
  
        { 
            
                    TextToSpeech_1.speak("Going back to menu !");
           
               timeline = new Timeline(
            new KeyFrame(Duration.seconds(3), evt ->
                    {
                       Stage stage=(Stage)this.ia_id.getScene().getWindow();
       Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                             Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();  
                        } catch (IOException ex) {
                            Logger.getLogger(Intelligence_artificielController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
            
              }));            timeline.play();
            
        
            
        }
            
        if (s.toLowerCase().contains("exit") ||s.toLowerCase().contains("stop") || s.toLowerCase().contains("close") || s.toLowerCase().contains("bye"))
  
        {       
      
               TextToSpeech_1.speak("closing magic book, have a great day !");
           
               timeline = new Timeline(
            new KeyFrame(Duration.seconds(3), evt ->
                    {
                  System.exit(0);
              }));            timeline.play();
            
        }
        
        String m=Mathematics.calculation(s);
        String g=Grammar.chat(s.toLowerCase());
      String d=DateTime.CurrentDateTime(s.toLowerCase());
       String dic=DictionaryManagement.InsertFromFile2(uText);
       String t=Translate.translate(s.toLowerCase());
         
         
       if(!g.isEmpty())
       {
        TextToSpeech_1.speak(g);
       }
       else if(!t.isEmpty())
       {
        TextToSpeech_1.speak(t);   
       }
       else if(!d.isEmpty())
               {
                TextToSpeech_1.speak(d);    
               }
        else if(!m.isEmpty())
        {
        TextToSpeech_1.speak(m);    
        }
       else if(!dic.isEmpty() && change_language==0 && dict==1)
       {
           dict=0;
      TextToSpeech_1.speak(dic);
       }
       
   change_language=0;    
        
    }
          
    
    
    
    
    
    
    @FXML
    private void add_command(MouseEvent event) throws IOException {
           TextToSpeech_1.player.close();
        app=new Application(); 
      song_output=new String();
      app.function();
        
      Timeline  timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), evt ->
                    {
           
                
                  
                    }),
                    
            new KeyFrame(Duration.seconds(4), evt2 ->
                    {
                        app.stopSpeechRecognition();
                       
                        System.out.println(Application.output2+"555");
                         
          try {  
              IA(Application.output2);
          } catch (IOException ex) {
              Logger.getLogger(Intelligence_artificielController.class.getName()).log(Level.SEVERE, null, ex);
          }
            
      
                    }
   
        ));

        timeline.play();
   
            
        
             
            
      
     
      
    }

    @FXML
    private void text_comand(KeyEvent event) {
       if(event.getCode()==event.getCode().ENTER)
       {
             try {  
              IA(this.id_txt.getText());
          } catch (IOException ex) {
              Logger.getLogger(Intelligence_artificielController.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
    }
    
}

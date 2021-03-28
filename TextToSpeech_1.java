package projet;

import java.io.IOException;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
import java.util.Locale;
import javax.sound.midi.Synthesizer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class TextToSpeech_1 {
   static AdvancedPlayer player;
  static int status = 0;
	
	static SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
static Thread thread;
	public static void speak(String text) {
		
		thread = new Thread(() -> {
			try {
				if(status == 0)
                                {
				 player = new AdvancedPlayer(synthesizer.getMP3Data(text));
				player.play();
                                }
				
			} catch (IOException | JavaLayerException e) {
				
				e.printStackTrace();
				
			}
		});
		
		thread.setDaemon(false);
		thread.start();
                
		
	}
     
      
}


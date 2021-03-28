package CowsAndBulls;

import game3d.Game3d;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CowsAndBullsController implements Initializable {
	private static int randomInt;
	private static int tries = -1;
	private static Image cow = new Image("/CowsAndBulls/img/cow.png");
	private static Image bull = new Image("/CowsAndBulls/img/ox.png");
	private static Image none = new Image("/CowsAndBulls/img/none.png");
	@FXML
	private AnchorPane rootpane;
	@FXML
	private TextField guessInput;
	@FXML
	private Label statusLine;
	@FXML
	private Label statusText;
	@FXML
	private Label try0;
	@FXML
	private Label try1;
	@FXML
	private Label try2;
	@FXML
	private Label try3;
	@FXML
	private Label try4;
	@FXML
	private Label try5;
	@FXML
	private Label try6;
	@FXML
	private Label try7;
	@FXML
	private Label try8;
	@FXML
	private Label try9;
	@FXML
	private ImageView i03;
	@FXML
	private ImageView i13;
	@FXML
	private ImageView i23;
	@FXML
	private ImageView i33;
	@FXML
	private ImageView i43;
	@FXML
	private ImageView i53;
	@FXML
	private ImageView i63;
	@FXML
	private ImageView i73;
	@FXML
	private ImageView i83;
	@FXML
	private ImageView i93;
	@FXML
	private ImageView i04;
	@FXML
	private ImageView i14;
	@FXML
	private ImageView i24;
	@FXML
	private ImageView i34;
	@FXML
	private ImageView i44;
	@FXML
	private ImageView i54;
	@FXML
	private ImageView i64;
	@FXML
	private ImageView i74;
	@FXML
	private ImageView i84;
	@FXML
	private ImageView i94;
	@FXML
	private ImageView i05;
	@FXML
	private ImageView i15;
	@FXML
	private ImageView i25;
	@FXML
	private ImageView i35;
	@FXML
	private ImageView i45;
	@FXML
	private ImageView i55;
	@FXML
	private ImageView i65;
	@FXML
	private ImageView i75;
	@FXML
	private ImageView i85;
	@FXML
	private ImageView i95;
	@FXML
	private ImageView i06;
	@FXML
	private ImageView i16;
	@FXML
	private ImageView i26;
	@FXML
	private ImageView i36;
	@FXML
	private ImageView i46;
	@FXML
	private ImageView i56;
	@FXML
	private ImageView i66;
	@FXML
	private ImageView i76;
	@FXML
	private ImageView i86;
	@FXML
	private ImageView i96;
	@FXML
	private Button guessButton;
    @FXML
    private Button ngButton;
    @FXML
    private Button exit;
	
	private boolean validateTextField() {
		String guess = guessInput.getText();
		if (guess.length() != 4) {
			return false;
		}
		else {
			char[] chars = guess.toCharArray();
		    for (char c : chars) {
		        if(Character.isLetter(c)) {
		            return false;
		        }
		    }
		    return true;
		}
	}
	private static void generateRandom () {
	    String val = "";
	    List<Integer> arr = new ArrayList<Integer> ();
	    for (int i = 0; i < 10; i++) arr.add(i);
		int index = ThreadLocalRandom.current().nextInt(1, arr.size());
	    for (int i = 0; i < 4; i++) {
	    		val += arr.get(index).toString();
	    		arr.remove(index);
	    		index = ThreadLocalRandom.current().nextInt(0, arr.size()); 
	    }
	    randomInt = Integer.parseInt(val);
	}
	
	private static int[] getCount (String guess) {
		String secret = String.valueOf(randomInt);
		int array[] = new int [2];
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int [10];
		for (int i=0; i<10; i++) numbers[i] = 0;
		for (int i = 0; i<secret.length(); i++) {
		    int s = (int)(secret.charAt(i)) - 48;
		    int g = (int)(guess.charAt(i)) - 48;
		    if (s == g) bulls++;
		    else {
		      if (numbers[s] < 0) cows++;
		      if (numbers[g] > 0) cows++;
		      numbers[s] ++;
		      numbers[g] --;
		    }
		}
		array[0] = cows;
		array[1] = bulls;
		return array;
	}
	
	private void setGradient(String color1, String color2) {
		Stop[] stops = new Stop[] { new Stop(0, Color.web(color1)), new Stop(1, Color.web(color2))};
		LinearGradient green = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
		statusText.setTextFill(green);
	}
	
	@FXML
	public void checkGuess (ActionEvent event) {
		int i = 0;
		String Guess = guessInput.getText();
		if (validateTextField()) {
			System.out.println(randomInt);
			Label guessOp = (Label) rootpane.lookup("#try"+ (++tries));
			guessOp.setText(Guess);
			guessInput.setText("");
			int cows = getCount(Guess)[0];
			int bulls = getCount(Guess)[1];
			while (i < cows) {
				ImageView image = (ImageView) rootpane.lookup("#i" + tries + "" + (3+i));
				image.setImage(cow); 
				i++;
			}
			while (i < (cows + bulls)) {
				ImageView image = (ImageView) rootpane.lookup("#i" + tries + "" + (3+i));
				image.setImage(bull); 
				i++;
			}
			while (i < 4) {
				ImageView image = (ImageView) rootpane.lookup("#i" + tries + "" + (3+i));
				image.setImage(none); 
				i++;
			}
			if ((bulls == 4) && (tries < 10)) {
				guessInput.setEditable(false);
				guessInput.setVisible(false);
				guessButton.setDisable(true);
				guessButton.setVisible(false);
				switch (tries) {
					case 1: case 2: case 3:
						setGradient("#a9ff00","#249000");
						statusText.setText("Feeling Lucky?");
						statusLine.setText("You won with "+ (9 - tries) + " tries to spare!");
						break;
					case 4: case 5: case 6:
						setGradient("#a9ff00","#249000");
						statusText.setText("Great Game!");
						statusLine.setText("You won with "+ (9 - tries) + " tries to spare!");
						break;
					case 7: case 8:
						setGradient("#a9ff00","#249000");
						statusText.setText("Good Game.");
						statusLine.setText("You won with "+ (9 - tries) + " tries to spare!");
						break;
					case 9:
						setGradient("#a9ff00","#249000");
						statusText.setText("That was close!");
						statusLine.setText("You won with "+ (9 - tries) + " tries to spare!");
						break;
				}
			}
			if ((bulls != 4) && (tries == 9)) {
				guessInput.setEditable(false);
				guessInput.setVisible(false);
				guessButton.setDisable(true);
				guessButton.setVisible(false);
				setGradient("#ff5e3a","#ff2a68");
				statusText.setText("Dang!");
				statusLine.setText("You Lost. The number was "+randomInt + ".");
			}
		}
	}
	
	private void initNewGame() throws IOException {
		try {
			Stage stage = (Stage) rootpane.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/CowsAndBulls/SplashScreen.fxml"));
			Scene scene = new Scene(root,423,668);
			scene.setFill(Color.BLACK);
			scene.getStylesheets().add(getClass().getResource("/CowsAndBulls/application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Cows and Bulls");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void FadeOutCurrent () {
		FadeTransition fadetransition = new FadeTransition(Duration.millis(600));
		fadetransition.setNode(rootpane);
		fadetransition.setFromValue(1);
		fadetransition.setToValue(0);
		fadetransition.setOnFinished ((ActionEvent e) -> {
			try {
				initNewGame();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		fadetransition.play();
	}
	
	@FXML
	public void goToSplash (ActionEvent event) {
		FadeOutCurrent();
	}
	
	public void goToHelp (ActionEvent event) {}
	
	@Override
	public void initialize (URL url, ResourceBundle rb) {
		rootpane.setOpacity(0);
		guessInput.setEditable(true);
		guessInput.setVisible(true);
		tries = -1;
		generateRandom();
		makeFadeInTransition();
	}

	private void makeFadeInTransition() {
		FadeTransition fadetransition = new FadeTransition(Duration.millis(1500));
		fadetransition.setNode(rootpane);
		fadetransition.setFromValue(0);
		fadetransition.setToValue(1);
		fadetransition.play();
	}

    @FXML
    private void leave(ActionEvent event) {
        CowsnBulls.s.close();
         Game3d gg=new Game3d();
                    gg.start(CowsnBulls.s);
    }
	

}

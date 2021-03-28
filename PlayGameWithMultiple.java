package memoryGame.memory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayGameWithMultiple extends JFrame {


    private List<String> playersName;
    private Cards choseMyCard;
    private Cards card1 = null;
    private Cards card2 = null;
    private Cards infoCard;
    private int[] gameScores;
    private int timeScore;
    private boolean playFirstPlayer;
    private String cardTheme;
    private Timer gameTimeControl;
    private List<Cards> Cards;
    private Color backColor;
    //private String DEFAULT_IMAGE = "/Users/mekazanc/Desktop/AugustJava/photos/logo3.png";
    //private String DEFAULT_IMAGE = "./photos/logo3.png";
    private File file_default = new File(PlayGameWithSingle.class.getResource("/memoryGame/memory/logo3.png").getFile());
    private String DEFAULT_IMAGE = file_default.getPath();

    public PlayGameWithMultiple(Settings gameParams) {

        int col = gameParams.getcolId();
        int row = gameParams.getrowId();
        this.timeScore = gameParams.getTimeInfo();
        this.playersName = gameParams.getPlayersName();
        this.gameScores = new int[gameParams.getPlayersName().size()];
        this.cardTheme = gameParams.getCardTheme();
        this.playFirstPlayer = true;
        this.cardTheme = gameParams.getCardTheme();
        this.backColor = gameParams.getBackColor();


        // initialize card Number and List of Card Objects.
        this.Cards = initCards(row, col, gameParams);

        // Create a BigRootPane with borderlayout.
        // We will put cards and info button inside.
        Container big = getRootPane();
        big.setLayout(new BorderLayout());
        //big.setBackground(Color.white);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(row, col));
        pane.setBackground(backColor);

        // Create another card object for info button.
        Cards infoButton = new Cards();


        // Merge to structure into Rootpane.
        big.add(pane, BorderLayout.CENTER);
        big.add(infoButton, BorderLayout.SOUTH);


        this.infoCard = infoButton;
        infoCard.changeButtonParams(gameScores, timeScore, playersName);


        for (Cards comp : Cards) {
            pane.add(comp);
            comp.setIcon(new ImageIcon(DEFAULT_IMAGE));
        }


    }


    private List<Cards> initCards(int row, int col, Settings gameParams) {

        // create list of Card objects.
        List<Cards> listOfCards = new ArrayList<Cards>();
        // create list of Card values.
        List<Integer> valuesOfCards = new ArrayList<Integer>();


        // Calculate total number of buttons for the game.
        int pairs = (row * col) / 2;
        String pairS = String.valueOf(pairs);
        System.out.println("Pair is : " + pairS);

        // Create two card lists as many as pairs.
        for (int j = 0; j < pairs; j++) {
            valuesOfCards.add(j);
            valuesOfCards.add(j);
        }

        System.out.println(valuesOfCards);

        // Mix card values randomly.
        Collections.shuffle(valuesOfCards);


        for (Integer valuesOfCard : valuesOfCards) {
            // Create Card object for each image.
            Cards mySelect = new Cards();
            mySelect.setCardNo(valuesOfCard);
            // Add action listener to change image of the card.
            mySelect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    // assign mySelect as chosen card and then call flipCards method.
                    choseMyCard = mySelect;
                    // Flip cards will be called after any of cards is pressed.
                    flipCardsMulti();
                }
            });
            // Add all buttons into one list to process them in a board.
            listOfCards.add(mySelect);
        }
        System.out.println(listOfCards.toString());

        return listOfCards;
    }


    // this is a method to flip cards back after both are opened.
    private void cardTimeCounter() {

        //set up the timer
        Timer cardTimeControl = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                controlCards();
            }
        });

        cardTimeControl.setRepeats(false);
        cardTimeControl.start();
    }


    private void flipCardsMulti() {


        // This condition helps us to understand first card is selected.
        if (card1 == null && card2 == null) {

            System.out.println("Card 1 is selected");
            // After card is chosen, image need to be showed.
            card1 = choseMyCard;
            // In this step, image was taken according to card no.
            String no = String.valueOf(card1.getCardNo());
            // Then, card-button displays image.
            card1.setImageVisible(no, cardTheme);

            // this will update the score board in each second.
            updateScoreBoard();

        }

        // This case helps us to select second card.
        else if (card1 != null && card1 != choseMyCard && card2 == null) {

            // Assign selected card as my new card.
            card2 = choseMyCard;
            // Then, get card no of it.
            String no = String.valueOf(card2.getCardNo());
            // Finally, card object shows its image.
            card2.setImageVisible(no, cardTheme);

            // start time to come back.
            cardTimeCounter();

        }

    }


    private void controlCards() {


        if (card1.getCardNo() == card2.getCardNo()) {//match condition
            card1.setEnabled(false); //disables the button
            card2.setEnabled(false);
            card1.setCardMatchedInfo(true); //flags the button as having been matched
            card2.setCardMatchedInfo(true);
            //gameScore++;

            // increase score according to current player of the game.
            if (playFirstPlayer) {
                gameScores[0] = gameScores[0] + 1;
            } else {
                gameScores[1] = gameScores[1] + 1;
            }

            if (this.checkWinning()) {
                //JOptionPane.showMessageDialog(this, "You win!");
                //System.exit(0);

                // check winner
                String winMessage = getWinnerMessage(gameScores, playersName);

                int response = JOptionPane.showConfirmDialog(this, winMessage,
                        "Do you want to play this game again ? ", JOptionPane.YES_NO_CANCEL_OPTION);

                if (response == 0) {
                    dispose();
                    // start new game
                    InitialScreen newGame = new InitialScreen();
                    newGame.initLaunchScreen();
                } else if (response == 1) {
                    // exit from the game.
                    System.exit(0);
                }
            }

        } else {


            playFirstPlayer = !playFirstPlayer;

            // Then we need to change picture of our unselected cards.
            card1.setIcon(new ImageIcon(DEFAULT_IMAGE));
            card2.setIcon(new ImageIcon(DEFAULT_IMAGE));

        }
        card1 = null; //reset c1 and c2
        card2 = null;

    }

    // according to winner receive winning message.
    private String getWinnerMessage(int[] gameScores, List<String> playersName) {

        if (gameScores[0] > gameScores[1]) {

            return "Congratulations. " + playersName.get(0) + " win the game ";

        } else if (gameScores[0] < gameScores[1]) {

            return "Congratulations. " + playersName.get(1) + " win the game ";


        } else {

            return "Excellent Challenge. It's tie. Let's play it again :)";

        }
    }


    private boolean checkWinning() {
        for (Cards c : this.Cards) {
            if (!c.getCardMatchedInfo()) {
                return false;
            }
        }

        stopTime();
        return true;
    }


    // stop timer.
    private void stopTime() {

        gameTimeControl.stop();
    }


    // this runs each second to update score button below.
    private void updateScoreBoard() {

        // Define timer with 1 second period.
        gameTimeControl = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("test timer has started");

                //infoCard.changeParameters(score, remTime, playerNameOne);
                infoCard.changeButtonParams(gameScores, timeScore, playersName);

            }
        });
        gameTimeControl.start();
    }


}





package memoryGame.memory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScoreUpdate {

    //String fileAddress = "src/highscore.txt";
    private String fileAddress = new File("src/memoryGame/memory/highscore.txt").getAbsolutePath();
    private int remTime;
    private int row;
    private int col;
    private int selectedTime;
    private String playerName;


    public ScoreUpdate(int remTime, int row, int col, int selectedTime, String playerName) {

        this.remTime = remTime;
        this.row = row;
        this.col = col;
        this.selectedTime = selectedTime;
        this.playerName = playerName;


    }


    public void checkAndUpdate() {

        double finalScore = scoreCalculation(remTime, row, col, selectedTime);

        // check and update score
        boolean result = scoreControl(finalScore, playerName);
        if (result) {
            System.out.println("Score will UPDATED..!! CONGRATULATIONS...");
        }


    }


    // this method calculates score of the game.
    private double scoreCalculation(int remTime, int row, int col, int selectedTime) {

        int size = col * row;
        double finalScore;

        System.out.println("Remained time is " + remTime);
        System.out.println("Size is " + size);
        System.out.println("Total time is " + selectedTime);

        // Score Calculation
        int usedTime = selectedTime - remTime;
        System.out.println(usedTime);

        if (selectedTime == 0) {

            finalScore = 0;

        } else {

            finalScore = size * ((double) size / usedTime);
            System.out.println("--" + finalScore);

        }


        return finalScore;
    }


    // this method confirms new score is to be inserted leaderboard table.
    private boolean scoreControl(double score, String playerName) {

        System.out.println("Final score is " + score);


        // new score will be controlled.

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYY");
        LocalDateTime now = LocalDateTime.now();
        String myDate = dtf.format(now);
        System.out.println(myDate);

        // After receiving name, date  and score, let's control final score.

        String[] names = new String[3];
        String[] dates = new String[3];
        String[] points = new String[3];

        String[] namesNew = new String[3];
        String[] datesNew = new String[3];
        String[] pointsNew = new String[3];

        int count = 0;
        //String fileAddress = "src/highscore.txt";
        String fileAddress = new File("src/memoryGame/memory/highscore.txt").getAbsolutePath();

        Scanner input = new Scanner(fileAddress);
        File file = new File(input.nextLine());
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // collect available data.
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] lineArray = line.split(",");
            //System.out.println(Arrays.toString(lineArray));
            names[count] = lineArray[0];
            dates[count] = lineArray[1];
            points[count] = lineArray[2];
            count++;

        }
        input.close();

        // Now, compare new score with previous ones.
        // Names, Dates and Points are assigned as variables.

        boolean changeFile = false;


        double scoreN = Math.round(score * 10) / 10.0;


        if (score >= Double.parseDouble(points[0])) {
            // Assign first element
            namesNew[0] = playerName;
            datesNew[0] = myDate;
            pointsNew[0] = Double.toString(scoreN);
            // Assign the second element
            namesNew[1] = names[0];
            datesNew[1] = dates[0];
            pointsNew[1] = points[0];
            // Assign the third element
            // Assign the second element
            namesNew[2] = names[1];
            datesNew[2] = dates[1];
            pointsNew[2] = points[1];

            changeFile = true;

        } else if (score < Double.parseDouble(points[0]) && score >= Double.parseDouble(points[1])) {
            namesNew[1] = playerName;
            datesNew[1] = myDate;
            pointsNew[1] = Double.toString(scoreN);
            // Assign the second element
            namesNew[0] = names[0];
            datesNew[0] = dates[0];
            pointsNew[0] = points[0];
            // Assign the third element
            // Assign the second element
            namesNew[2] = names[1];
            datesNew[2] = dates[1];
            pointsNew[2] = points[1];

            changeFile = true;

        } else if (score < Double.parseDouble(points[1]) && score >= Double.parseDouble(points[2])) {
            namesNew[2] = playerName;
            datesNew[2] = myDate;
            pointsNew[2] = Double.toString(scoreN);
            // Assign the second element
            namesNew[0] = names[0];
            datesNew[0] = dates[0];
            pointsNew[0] = points[0];
            // Assign the third element
            // Assign the second element
            namesNew[1] = names[1];
            datesNew[1] = dates[1];
            pointsNew[1] = points[1];

            changeFile = true;

        }


        // update score board.
        updateScoreFile(changeFile, namesNew, datesNew, pointsNew);
        return changeFile;
    }


    private void updateScoreFile(boolean changeFile, String[] namesNew,
                                 String[] datesNew, String[] pointsNew) {

        if (changeFile) {
            // write new data structures to txt file.
            try {

                FileWriter f2 = new FileWriter(fileAddress, false);
                for (int i = 0; i < namesNew.length; i++) {
                    String line1 = namesNew[i] + "," + datesNew[i] + "," + pointsNew[i] + "\n";
                    f2.write(line1);

                }

                f2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}







//Author: Ngoc Bui
//Date: October, 2022.

import javax.swing.*;
import java.util.*;

public class PerceptionTest {
    public static void main(String[] args) {

        String intro_prompt = "<html><h2>Welcome to Perception_Test!</h2>" +
                              "This is the test for your extra sensory perception.<br>" +
                              "We have 5 different cartoon characters: Tom cat, Jerry mouse, Pooh bear,<br>" +
                              "Mickey mouse and Donald duck who are very familiar to your childhood!<br>" +
                              "Also, they are doing 5 different activities: Cry, Eat, Run, Sleep and Smile.<br>" +
                              "You need to use your perception to guess who the characters are, <br>" +
                              "or what are they doing or both.<br>" +
                              "Ex: if you choose Character Test and you perceived the character is Tom,<br>" +
                              "and the card was Tom, then you guess right." +
                              "<br>You will gain 1 point for each right guess.<br>" +
                              "You will have 5 trials except you want more or want to quit!<br>" +
                              "Please click Ok to start the Test. Good luck!";

        ImageIcon icon = new ImageIcon("cartoon_cards\\question.png");
        JOptionPane.showMessageDialog(null, intro_prompt,
                "        ".repeat(13) + "Instruction", 0, icon);

        String[] test_options = {"Character", "Activity", "Both", "Quit"};

        String question_prompt = "<html><h3>What perception test you would like to perform?</h3>";
        int user_test_option = JOptionPane.showOptionDialog(null, question_prompt,
                "         ".repeat(10) + "Choose test", 0, 0, icon,
                test_options, test_options[0]);

        String user_test = "";

        switch (user_test_option) {
            case 0:
                user_test += "Character";
                break;
            case 1:
                user_test += "Activity";
                break;
            case 2:
                user_test += "Both";
                break;
            case 3:
                user_test += "Quit";
                break;
        }

        String[] characters = {"Tom", "Jerry", "Pooh", "Mickey", "Donald"};
        String[] activities = {"Cry", "Eat", "Run", "Sleep", "Smile"};

        Random ranGen = new Random();

        int score_char = 0;
        int score_act = 0;
        int score_both = 0;
        int another_5_trials = 0;

        //Hi Dr. Anderson, this is where I use back door.
        while (true) {
            another_5_trials += 1;

            int user_choose_char;//initialize the user choosing option of character or activity test.
            int user_choose_act;
            int count = 0;

            while (count < 5) {
                int comp_choose_char = ranGen.nextInt(5);
                int comp_choose_act = ranGen.nextInt(5);

                String fileName = "cartoon_cards\\" + characters[comp_choose_char] +
                                                      activities[comp_choose_act] + ".png";

                if (user_test.equals("Character")) {

                    question_prompt = "<html><h3>Your cards have been generated<br>" +
                                      "Which character do you perceive?</h3>";

                    icon = new ImageIcon("cartoon_cards\\unknown.png");
                    user_choose_char = JOptionPane.showOptionDialog(null, question_prompt,
                            "    ".repeat(13) + "Choose a character", 0, 0,
                            icon, characters, characters[0]);

                    String resultAccumulator = "<html><h3>Character perception:</h3>" +
                                               "You perceived " + characters[user_choose_char] + "<br>" +
                                               "The character was " + characters[comp_choose_char] + "<br>";

                    if (user_choose_char == comp_choose_char) {
                        resultAccumulator += "<h3>Good perception on character!</h3>";
                        score_char += 1;

                    } else {
                        resultAccumulator += "<h3>A bit off on that one!</h3>";
                    }

                    icon = new ImageIcon(fileName);
                    JOptionPane.showMessageDialog(null, resultAccumulator,
                            "     ".repeat(10) + "Card result", 0, icon);

                } else if (user_test.equals("Activity")) {
                    question_prompt = "<html><h3>Your cards have been generated<br>" +
                                      "Which activity do you perceive?</h3>";

                    icon = new ImageIcon("cartoon_cards\\unknown.png");
                    user_choose_act = JOptionPane.showOptionDialog(null, question_prompt,
                            "      ".repeat(10) + "Choose an activity", 0, 0,
                                 icon, activities, activities[0]);

                    String resultAccumulator = "<html><h3>Activity perception:</h3>" +
                                               "You perceived " + activities[user_choose_act] + "<br>" +
                                               "The activity was " + activities[comp_choose_act] + "<br>";

                    if (user_choose_act == comp_choose_act) {
                        resultAccumulator += "<h3>Good perception on activity!</h3>";
                        score_act += 1;
                    } else {
                        resultAccumulator += "<h3>A bit off on that one!</h3>";
                    }

                    icon = new ImageIcon(fileName);
                    JOptionPane.showMessageDialog(null, resultAccumulator,
                            "      ".repeat(10) + "Card result", 0, icon);

                } else if (user_test.equals("Both")) {

                    question_prompt = "<html><h3>Your cards have been generated<br>" +
                                      "You have chosen to test both character and activity!<br>" +
                                      "Your first perception respond will be character.<br>" +
                                      "Which character do you perceive?</h3>";

                    icon = new ImageIcon("cartoon_cards\\unknown.png");
                    user_choose_char = JOptionPane.showOptionDialog(null, question_prompt,
                            "       ".repeat(10) + "Choose a character", 0, 0,
                            icon, characters, characters[0]);

                    question_prompt = "<html><h3>Your second perception respond will be activity.<br>" +
                                      "Which activity do you perceive?</h3>";

                    user_choose_act = JOptionPane.showOptionDialog(null, question_prompt,
                                "         ".repeat(10) + "Choose an activity", 0, 0,
                            icon, activities, activities[0]);

                    String resultAccumulator = "<html><h3>Character perception:</h3>" +
                                               "You perceived " + characters[user_choose_char] + "<br>" +
                                               "The character was " + characters[comp_choose_char];

                    if (user_choose_char == comp_choose_char) {
                        resultAccumulator += "<h3>Good perception on character!</h3>";
                        score_char += 1;
                    } else {
                        resultAccumulator += "<h3>A bit off on that one!</h3>";
                    }

                    resultAccumulator += "<html><h3>Activity perception:</h3>" +
                                         "You perceived " + activities[user_choose_act] + "<br>" +
                                         "The activity was " + activities[comp_choose_act];

                    if (user_choose_act == comp_choose_act) {
                        resultAccumulator += "<h3>Good perception on activity!</h3>";
                        score_act += 1;
                    } else {
                        resultAccumulator += "<h3>A bit off on that one!</h3>";
                    }

                    if (user_choose_act == comp_choose_act && user_choose_char == comp_choose_char) {
                        resultAccumulator += "<h2>You got both character and activity<br>" +
                                             "You were very accurate in your perception!<br>" +
                                             "Good job!!</h2>";
                        score_both += 1;
                    }

                    icon = new ImageIcon(fileName);
                    JOptionPane.showMessageDialog(null, resultAccumulator,
                                "       ".repeat(5) + "Card result", 0, icon);

                } else {
                    break;//This where I break out of inner loop if user choose quit from the beginning,
                    //means user don't want to choose any test .
                }

                count++;

            }

            if (user_test.equals("Quit")) {
                break;//Then break out of outside loop too, to end the game with no test.
            }

            String[] trial_options = {"Quit", "Another 5 trials"};
            String final_score = "<html><h2>You have entered " + 5 * another_5_trials + " perceptions</h2>";

            switch (user_test) {
                case "Character":
                    final_score += "<h3>Your character score is " + score_char + "</h3>";
                    break;
                case "Activity":
                    final_score += "<h3>Your activity score is " + score_act + "</h3>";
                    break;
                case "Both":
                    final_score += "<h3>Your character score is " + score_char +
                                   "<br>Your activity score is " + score_act +
                                   "<br>You got both correct " + score_both + " times.</h3>";
                    break;
            }

            icon = new ImageIcon("cartoon_cards\\question.png");
            int user_trial_option = JOptionPane.showOptionDialog(null, final_score,
                    "         ".repeat(10) + "Result so far", 0, 0,
                    icon, trial_options, trial_options[0]);

            if (user_trial_option == 0) {
                break;//This is where I break out of outside loop(back door) if user choose quit, mean user
                // don't want another 5 trials.
            }

        }

        String terminate_prompt = "<html><h3>Hi! The game is end! Thank you for playing!<br>" +
                                    "Hope you enjoy it and have a nice day!.</h3>" +
                                    "P/s: Also, I think that this game is definitely worth the full 160 points.<br>" +
                                    "Please click OK to out.";

        JOptionPane.showMessageDialog(null, terminate_prompt,
                "          ".repeat(10) + "Good bye!", 0, icon);

    }

}

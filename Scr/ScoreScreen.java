package Scr;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ScoreScreen extends JPanel{

    //ScoreScreen scoreScreen = new ScoreScreen();
    private String message;

    private JButton ScrMainMenu;
    JPanel ScrScreen = new JPanel();
    JPanel ScorePanel;

    //creation of J//
    public ScoreScreen(int score, int Length){
        
        JLabel Scre = new JLabel("You got:" + score);
        JLabel pcentage = new JLabel("Percentage:" + percentage(score, totalQuestions) + "%");
        ScrMainMenu = new JButton("Main Menu");



        JButton Menu = new JButton("Menu");
        JButton Logout = new JButton("Logout");
        JButton Edit = new JButton("Edit");
        JLabel message = new JLabel(scoreMessage(score));

        JPanel scoreMenu = new JPanel();

        scoreMenu.add(Menu);
        scoreMenu.add(Logout);
        scoreMenu.add(Edit);
        // horizontal
        scoreMenu.setLayout(new java.awt.GridLayout(1, 0));
        ScorePanel.add(scoreMenu);


        ScorePanel.add(Menu);
        ScorePanel.add(Logout);
        ScorePanel.add(Edit);



        ScorePanel.add(Score);
        ScorePanel.add(message);
        ScorePanel.add(percentage);




        //Add to panel section
        ScrScreen.add(Scre);
        ScrScreen.add(pcentage);
        ScrScreen.add(ScrMainMenu);

        //Action Listeners//
        ScrMainMenu.addActionListener(new MenuBActionListener());

        //private class scoreArea{


   }
    public String scoreMessage(int score){
        if(score == 100){
            message ="Excellent!! your on a roll";
        }
        else if(score > 80 && score <= 99){
            message ="Almost perfect, lets do even better next time";
        }
        else if(score > 60 && score < 80 ){
            message = "Good job, ";
        }
        else if(score >50 && score < 60){
            message = "Well a pass is a pass but, lets work on that";
        }
        else{
            message = "Wheel and come again, only your best is good enough!!";
        }
        return message;

    }

    public int percentage(int score, int total) {
        int percentage = (score / total) * 100;
        return percentage;
    }




    private class MenuBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }
}
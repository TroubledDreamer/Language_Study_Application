package scr;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ScoreScreen extends JFrame{

    //ScoreScreen scoreScreen = new ScoreScreen();
    private String message;

    private JButton ScrMainMenu;
    JPanel ScoreScreen = new JPanel();
    JPanel ScorePanel;

    //creation of J//
    public ScoreScreen(int score, int Qlength){
        
        JLabel Score = new JLabel("You got:" + score);
        JLabel pcentage = new JLabel("Percentage:" + percentage(score, Qlength) + "%");
        ScrMainMenu = new JButton("Main Menu");


        JButton Menu = new JButton("Menu");
        JButton Logout = new JButton("Logout");
        JButton Edit = new JButton("Edit");
        JLabel message = new JLabel(scoreMessage(score));

        Menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel scoreMenu = new JPanel();

        scoreMenu.add(Menu);
        scoreMenu.add(Logout);
        scoreMenu.add(Edit);
        // horizontal
        scoreMenu.setLayout(new java.awt.GridLayout(2, 0));
        ScorePanel.add(scoreMenu);


        ScorePanel.add(Menu);
        ScorePanel.add(Logout);
        ScorePanel.add(Edit);


        //Add to panel section
        ScoreScreen.add(Score);
        ScoreScreen.add(pcentage);
        ScoreScreen.add(ScrMainMenu);

        // stacked on top of each other
        ScorePanel.setLayout(new java.awt.GridLayout(0, 1));

        //sjhow the panel
        this.getContentPane().add(ScorePanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);

        //Action Listeners//
       // ScrMainMenu.addActionListener(new MenuBActionListener());

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


/* 

    private class MenuBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }
    */
}
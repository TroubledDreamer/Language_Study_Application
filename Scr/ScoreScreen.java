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

    private String message;

    private JLabel Score;
    private JLabel pcentage;
    private JButton ScrMainMenu;
    JPanel ScrScreen = new JPanel();

    //creation of J//
    public ScoreScreen(){
    JLabel Scr = new JLabel("You got:");
    JLabel pcentage = new JLabel("Percentage:");
    ScrMainMenu = new JButton("Main Menu");

    //Add to panel section
    ScrScreen.add(Scr);
    ScrScreen.add(pcentage);
    ScrScreen.add(ScrMainMenu);

    //Action Listeners//
    ScrMainMenu.addActionListener(new MenuBActionListener());

    private class scoreArea{


    }
    public class scoreMessage(int score){
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

    }
}


    private class MenuBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }
}
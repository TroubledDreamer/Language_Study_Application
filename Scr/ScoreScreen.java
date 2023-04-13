package Scr;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;

public class ScoreScreen {
    private JButton ScrMainMenu;
    


    ScrMainMenu = new JButton("Main Menu");

    ScrScreen.add(ScrMainMenu);

    private class scoreTable{

    }
    private class scoreMessage{
    if(score == 100){
        message ="Excellent!! your on a roll"
    }
    else if(score > 80 && score <= 99){
        message ="Almost perfect, lets do even better next time"
    }
    else if(score > 60 && score < 80 ){
        message = "Good job, "
    }
    else if(score >50 && score < 60){
        message = "Well a pass is a pass but, lets work on that"
    }
    else{
        message = "Wheel and come again, only your best is good enough!!"
    }

    }
}

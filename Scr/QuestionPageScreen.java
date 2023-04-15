package Scr;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.w3c.dom.events.EventException;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuestionPageScreen extends JFrame{
    private ArrayList<Question> questionList;
    private int score;
    private int currentQIndex;
    
    private JLabel qLabel;
    private ButtonGroup answerGroup;
    private JRadioButton[] answerBtons;
    private JPanel ScrGrade;
    

    public QuestionPageScreen(ArrayList<Question> questionList){
        this.questionList = questionList;
        currentQIndex =0;
        score = 0;

        JPanel QPanel = new JPanel();
        JPanel ScrScreen = new JPanel();
        JButton submit = new JButton();

        qLabel = new JLabel();


        //radio button Answers
    }
    //submit.addActionListener(new SubmitBListener());






    private class SubmitBListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                //////

            }
            catch(Exception e){
                dffdff
                
            }
        }
    }

    /*private class questionDisplay{
        for(String question: questionList){
            JPanel questionPanel = new JPanel(new BorderLayout());
            questionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // 
            JLabel questionLabel = new JLabel(question);
            //questionPanel.add(questionLabel, BorderLayout.NORTH);

            // 
            ButtonGroup buttonGroup = new ButtonGroup();
            for (String answer : questions.get(question)) {
                JRadioButton radioButton = new JRadioButton(answer);
                buttonGroup.add(radioButton);
                questionPanel.add(radioButton);
            }

            QPanel.add(questionPanel);
        }
    }

    private class showScore{

    }*/

}

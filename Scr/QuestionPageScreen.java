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
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuestionPageScreen extends JFrame{
    private String questionList;
    private ArrayList<String[]> answerList;
    private ArrayList<String> correctAnswers;
    private int score;
    private int currentQIndex;
    
    private JLabel qLabel;
    private ButtonGroup answerGroup;
    private JRadioButton[] answerBtons;
    private JPanel ScrGrade;
    

    public QuestionPageScreen(String Q){
        this.questionList = Q;
        currentQIndex =0;
        score = 0;

        JPanel QPanel = new JPanel();
        JPanel ScrScreen = new JPanel();
        JButton submit = new JButton();

        qLabel = new JLabel();


        //radio button Answers
    }

    public class addToFile(String Q){
    }
    public class ListQues(){
        
    }
    /* 
    //submit.addActionListener(new SubmitBListener());

    try (BufferedReader Breader = new BufferedReader(new FileReader(questions))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            int difficulty = Integer.parseInt(data[1]);
            String language = data[2];
            String type = data[3];
            String question = data[4];
            String[] answers = new String[] { data[5], data[6], data[7], data[8] };
            String correctAnswer = data[5];
            questions.add(new Question(id, difficulty, language, type, question, answers, correctAnswer));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    */






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

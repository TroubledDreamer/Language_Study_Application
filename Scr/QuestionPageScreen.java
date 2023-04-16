package Scr;


import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.w3c.dom.events.EventException;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.naming.Context;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuestionPageScreen extends JFrame {
    private int numQues;
    private String questionList;
    private ArrayList<String[]> answerList;
    private ArrayList<String> correctAnswers;
    private int score;
    private int currentQIndex;

    private JLabel qLabel;
    private ButtonGroup answerGroup;
    private JRadioButton[] answerBtons;
    private JPanel ScrGrade;

    private JPanel Panel;

    public ArrayList<Question> frenchQuestions = new ArrayList<>();
    public ArrayList<Question> spanishQuestions = new ArrayList<>();
    public ArrayList<Question> chineseQuestions = new ArrayList<>();
    public ArrayList<Question> questions = new ArrayList<>();

    public int HEIGHT = 800;
    public int WIDTH = 600;

    Question question = new Question("22120");

    public QuestionPageScreen(String Q) {
        this.questionList = Q;
        currentQIndex = 0;
        score = 0;

        Panel = new JPanel();

 

        // make the frame

        // make the question panel
        JPanel questionPanel = makeQuestionPanel(questions.toArray(new Question[questions.size()]), 0);
        Panel.add(questionPanel);

        this.makeFooter();
        // make the frame visible
        this.getContentPane().add(Panel);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // this.setLayout(null);
        this.pack();
        setVisible(true);

    }

 

    // make the footer
    public void makeFooter() {
        // make the footer

        Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Panel.setBounds(50, 50, WIDTH, 50);

        // add the back button use icons
        JButton back = new JButton("< Back");
        // add icon to the button

        // listener for the back button
        back.addActionListener(new ActionListener() {
  

        back.setBounds(50, 50, WIDTH, 50);
        Panel.add(back);

    }

    // make the question panel
    public JPanel makeQuestionPanel(Question[] questions, int i) {
        // construct the question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionPanel.setBounds(50, 50, 800, 50);
        questionPanel.setPreferredSize(new Dimension(600, 600));
        // questionPanel.setLayout(null);

        // add each question to the panel

        // multiple choice
        if (questions[i].getType() == 1) {

            // add question label
            JLabel questionLabel = new JLabel("22120");
            questionLabel.setBounds(50, 50, 800, 50);

            questionPanel.add(questionLabel);

            // new line
            JLabel newLine = new JLabel(" ");
            questionPanel.add(newLine);

            // display message if the answer is correct or not
            JLabel message = new JLabel(" ");

            // add answer buttons
            ButtonGroup answerGroup = new ButtonGroup();
            JRadioButton[] answerBtons = new JRadioButton[questions[i].getAnswers().length];
            for (int j = 0; j < questions[i].getAnswers().length; j++) {
                answerBtons[j] = new JRadioButton(questions[i].getAnswers()[j]);

                Integer index = j;
                // listener for the radio buttons
                answerBtons[index].addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        // set Choice
                        questions[i].setChoice(index);

                    }
                });

                answerGroup.add(answerBtons[j]);

                questionPanel.add(answerBtons[j]);

            }

            // add a space above the next button
            JLabel space = new JLabel(" ");
            questionPanel.add(space);

            // questionPanel.add(message);

            JPanel action = new JPanel();
            action.setLayout(new BoxLayout(action, BoxLayout.X_AXIS));

           


    

          
            questionPanel.add(action);
            // stack each component on top of each other
            questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        }

        // fill in the blank
        if (question.getQuestiontype().equals("Blank")) {
            // make the question label
            JLabel questionLabel = new JLabel(questions[i].getQuestion());
            questionLabel.setBounds(50, 50, 800, 50);

            // insert a text field at each {BLANK}
            String[] questionParts = questions[i].getQuestion().split("\\{BLANK\\}");
      
            for (int j = 0; j < questionParts.length; j++) {
                JLabel questionPart = new JLabel(questionParts[j]);
                questionPanel.add(questionPart);
                if (j != questionParts.length - 1) {
                    JTextField answer = new JTextField(questions[i].getCorrectAnswerParts()[j].length());
                    //add a action listener
                    answer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // set Choice
                            questions[i].setChoices(answer.getText(), i);
                        }
                    });

                    questionPanel.add(answer);
                }
            }

      


           

            // add the component
            questionPanel.add(action);
            // stack each component on top of each other
            // questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));




        }

        return questionPanel;
    }

    
package Scr;


import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import org.w3c.dom.events.EventException;

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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuestionPageScreen extends JFrame {
    private int Qlength;
    private String questionList;
    private ArrayList<String[]> answerList;
    private ArrayList<String> correctAnswers;
    private int score;
    private int currentQIndex;

    private JLabel qLabel;
    private ButtonGroup answerGroup;
    private JRadioButton[] answerBtons;
    private JPanel ScrGrade;

    public ArrayList<Question> frenchQuestions = new ArrayList<>();
    public ArrayList<Question> spanishQuestions = new ArrayList<>();
    public ArrayList<Question> chineseQuestions = new ArrayList<>();
    public ArrayList<Question> questions = new ArrayList<>();

    public int HEIGHT = 800;
    public int WIDTH = 600;

    Question question = new Question("22120");

     //Labels
     JLabel Question  = new JLabel(getQuestion());
     JButton Submit = new JButton("Submit");
     JLabel Ans1  = new JLabel(getAnsOptions());
     JLabel Ans2 = new JLabel(getAnsOptions());
     JLabel Ans3 = new JLabel(getAnsOptions());
     JLabel Ans4 = new JLabel(getAnsOptions());
     JButton Skip = new JButton("skip");
     JButton BackB = new JButton("<Back");
     JCheckBox OptionA = new JCheckBox();
     JCheckBox OptionB = new JCheckBox();
     JCheckBox OptionC = new JCheckBox();
     JCheckBox OptionD = new JCheckBox();
     JTextField AnsInput = new JTextField(getAnsInput());
     
 

    public QuestionPageScreen(String Q) {
        this.questionList = Q;
        currentQIndex = 0;
        score = 0;
        Qlength = 0;


        //main panel
        JPanel Panel1 = new JPanel();
        //MCQ panel
        JPanel Panel2 = new JPanel();
        //Fill in Blank panel
        JPanel Panel3 = new JPanel();

        JPanel FooterPanel = new JPanel();


        //Screen view for MCQs
        //Panel1.add(Panel1);
        Panel2.add(BackB);
        Panel2.add(Question);
        Panel2.add(OptionA);
        Panel2.add(Ans1);
        Panel2.add(OptionB);
        Panel2.add(Ans2);
        Panel2.add(OptionC);
        Panel2.add(Ans3);
        Panel2.add(OptionD);
        Panel2.add(Ans4);
        Panel1.add(FooterPanel);
        FooterPanel.add(Skip);
        FooterPanel.add(Submit);

        //Screen view for Fill in Blank
        Panel1.add(Panel3);
        Panel3.add(BackB);
        Panel3.add(Question);
        JTextField AnsInput = new JTextField(getAnsInput());
        Panel1.add(FooterPanel);
        FooterPanel.add(Skip);
        FooterPanel.add(Submit);



        // make the question panel
        //Panel1.add(Panel1);
        // make the frame visible
        this.getContentPane().add(Panel1);
        this.getContentPane().add(Panel2);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // this.setLayout(null);
        this.pack();
        setVisible(true);

    }




    private String getAnsInput() {
        return null;
    }



    private String getAnsOptions() {
        return null;
    }



    private String getQuestion() {
        return null;
    }

    private void showScore(){
        ScoreScreen ScoreScreen = new ScoreScreen(score, Qlength);
    }
    
}
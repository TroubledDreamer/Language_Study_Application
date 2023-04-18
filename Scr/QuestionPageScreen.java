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
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
    private StatusUpdater statusUpdater = new StatusUpdater();


    private int Qlength;
    private ArrayList<String> questionList = new ArrayList<>();
    private ArrayList<String[]> answerList;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> holder;
    private int score;
    private int currentQIndex;
    private String language;

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



     
 

    public QuestionPageScreen(String Language) {
        this.language = Language;
        currentQIndex = 0;
        score = 0;
        Qlength = 0;

        AddCurrentQuestions();
        holder = getFile("CurrentQuestion.txt");
        Collections.shuffle(holder);
        overideCurrentQuestion("CurrentQuestion.txt",  holder);


        //main panel
        JPanel MainPanel = new JPanel();
        //MCQ panel
        JPanel MultiPanel = new JPanel();
        //Fill in Blank panel
        JPanel FillBlankPanel = new JPanel();

        JPanel FooterPanel = new JPanel();

        //Add to ActionListeners
        BackB.addActionListener(new BackBAction());
        Skip.addActionListener(new SkipBAction());
        Submit.addActionListener(new SubmitAction());
        OptionA.addActionListener(new OptionAAction());
        OptionB.addActionListener(new OptionBAction());
        OptionC.addActionListener(new OptionCAction());
        OptionD.addActionListener(new OptionDAction());


        //Screen view for MCQs
        //MainPanel.add(MainPanel);
        MultiPanel.add(BackB);
        MultiPanel.add(Question);
        MultiPanel.add(OptionA);
        MultiPanel.add(Ans1);
        MultiPanel.add(OptionB);
        MultiPanel.add(Ans2);
        MultiPanel.add(OptionC);
        MultiPanel.add(Ans3);
        MultiPanel.add(OptionD);
        MultiPanel.add(Ans4);
        MultiPanel.add(FooterPanel);
        FooterPanel.add(Skip);
        FooterPanel.add(Submit);

        //Screen view for Fill in Blank
        MainPanel.add(FillBlankPanel);
        FillBlankPanel.add(BackB);
        FillBlankPanel.add(Question);
        JTextField AnsInput = new JTextField(getAnsInput());
        MainPanel.add(FooterPanel);
        FooterPanel.add(Skip);
        FooterPanel.add(Submit);



        // make the question panel
        //MainPanel.add(MainPanel);
        // make the frame visible
        this.getContentPane().add(MainPanel);
        this.getContentPane().add(MultiPanel);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // this.setLayout(null);
        this.pack();
        setVisible(true);

    }



    



  /*   private String languageChecker(String language)
    {
        if (language.equals("Spanish"))
        {

            return "1";

        }
        if (language.equals("French"))
        {
            return "2";
        }

        return "1";
  

  
    }*/

    private void AddCurrentQuestions()
    {

        getQuestion("Questions.txt", 0, 1, "CurrentQuestion");
        AddCurrentQuestion("CurrentQuestion.txt", "CurrentQuestion.txt");

    }

    public void getQuestion(String file, int start, int stop, String unwantedDups){
 
         try {
             FileReader fileReader = new FileReader(file);
             
             BufferedReader reader = new BufferedReader(fileReader);
 
             String line;
             while ((line = reader.readLine()) != null) {
                 try{
                    Question question = new Question(getFileQuestionID(line));
                    
                   

 
                    if (leveQualified(question) && question.getLanguage().equals(language)  && !getFile(unwantedDups).contains(line))
                    {
                         questionList.add(line);
 
                     }
                     /*else{
                         fileHolder.add(line);
                     }*/
                 }
                 catch(Exception e){
 
                    // fileHolder.add(line);
                 }
             }
 
             reader.close();
             fileReader.close();
             
             
         } catch (IOException e) {
             // TODO: handle exception
         }   
     }

     public void AddCurrentQuestion(String fileOut, String fileIn){


        try {
            FileWriter writer;
            /*  = new FileWriter(fileOut, false);
            writer.write("");
            writer.close();*/


            writer = new FileWriter(fileIn, true);
            for (String m : questionList){
                writer.write(m);
            }
            writer.close();



        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public void overideCurrentQuestion(String file,  ArrayList<String> list){


        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write("");
            writer.close();


            writer = new FileWriter(file, true);
            for (String m : questionList){
                writer.write(m);
            }
            writer.close();



        } catch (Exception e) {
            // TODO: handle exception
        }


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
    public int isCorrect(){
        return (Integer) null;
    }

    private class BackBAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }
    private class SkipBAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    private class SubmitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    private class OptionAAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    private class OptionBAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    private class OptionCAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    private class OptionDAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }


    private ArrayList getFile(String file)
    {
        ArrayList<String> infile = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                try{
                    infile.add(line);



  
                }
                catch(Exception e){

                   // fileHolder.add(line);
                }
            }

            reader.close();
            fileReader.close();

            
        } catch (IOException e) {
            // TODO: handle exception
        }   

        return infile;



    }

    public String getFileQuestionID (String line)
    {

        return line.split("-")[0];
    }

    public boolean leveQualified(Question question)
    {
        return Integer.parseInt(question.getDifficultyLevel()) >= statusUpdater.getScore();
    }


}
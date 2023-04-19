package scr;


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
import java.io.BufferedWriter;
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


    private ArrayList<String> questionList = new ArrayList<>();
    private ArrayList<String> holder;
    private int score;
    private String language;




    public int HEIGHT = 800;
    public int WIDTH = 600;

    Question question;

     //Labels
     JLabel QuestionStr  = new JLabel();
     JLabel QuestionStrBack  = new JLabel();

     JButton Submit = new JButton("Submit");
     JLabel Ans1  = new JLabel();
     JLabel Ans2 = new JLabel();
     JLabel Ans3 = new JLabel();
     JLabel Ans4 = new JLabel();
     JButton Skip = new JButton("skip");
     JButton BackB = new JButton("<Back");
     JCheckBox OptionA = new JCheckBox();
     JCheckBox OptionB = new JCheckBox();
     JCheckBox OptionC = new JCheckBox();
     JCheckBox OptionD = new JCheckBox();
     JTextField AnsInput = new JTextField(getAnsInput());

    public QuestionPageScreen(String language) {
        this.language = language;
     

        AddCurrentQuestions();

        holder = getFile("CurrentQuestion.txt");



        Collections.shuffle(holder);


        overideCurrentQuestion("CurrentQuestion.txt",  holder);


        getQuestion1();
        


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



        question.getQuestiontype();

        System.out.print("love------------------");

        System.out.println( "hhhhhh" +  question.getQuestionID());
       
        if (question.getQuestiontype() == "Multi")
        {

            
            MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question.getQuestionID());
            QuestionStr.setText(multipleChoiceQuestion.getQuestionString());
            System.out.println( "hhhhhh" +  multipleChoiceQuestion.getQuestionID());

            Ans1.setText(multipleChoiceQuestion.getOption1());
            Ans1.setText(multipleChoiceQuestion.getOption1());
            Ans1.setText(multipleChoiceQuestion.getOption1());
            Ans1.setText(multipleChoiceQuestion.getOption1());

            MultiPanel.add(BackB);
            MultiPanel.add(QuestionStr);
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


            System.out.println("sddds");
        }



        else{
            System.out.println("sddds");
            FillBlankQuestion fillBlankQuestion = new FillBlankQuestion(question.getQuestionID());
            

            QuestionStrBack.setText(fillBlankQuestion.getFrontString());
            QuestionStr.setText(fillBlankQuestion.getBackString());

            //Screen view for Fill in Blank
            MainPanel.add(FillBlankPanel);
            FillBlankPanel.add(QuestionStr);
            JTextField AnsInput = new JTextField(getAnsInput());
            FillBlankPanel.add(AnsInput);
            FillBlankPanel.add(QuestionStrBack);
    
        
        }


        MainPanel.add(FooterPanel);
        FooterPanel.add(Skip);
        FooterPanel.add(Submit);
        FillBlankPanel.add(BackB);




        // make the question panel
        // make the frame visible
        this.add(MainPanel);
        this.add(MultiPanel);
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

    /**
     * 
     * 
     * * 
     * 
    */

    public void getQuestion(String file, int start, int stop, String unwantedDups){
 
         try {
             FileReader fileReader = new FileReader(file);
             
             BufferedReader reader = new BufferedReader(fileReader);
 
             String line;
             while ((line = reader.readLine()) != null) {
                 try{
                    Question question = new Question(getFileQuestionID(line));
                    
                   //leveQualified(question) && question.getLanguage().equals(language)  &&

 
                    if ( !getFile(unwantedDups).contains(line))
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
            BufferedWriter write1 = new BufferedWriter(writer);


            for (String m : questionList){
                

                writer.write(m + "\n");
             
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
            BufferedWriter write1 = new BufferedWriter(writer);


            for (String m : questionList){
                

             
                writer.write(m + "\n");
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

    public void getQuestion1(){
        


 
         try {
             FileReader fileReader = new FileReader("CurrentQuestion.txt");
             BufferedReader reader = new BufferedReader(fileReader);


 
             String line;
             while ((line = reader.readLine()) != null && question == null) {
                 String[] spitter = line.split("-");
                 try{

                    


 
                    question = new Question(spitter[0]);
                    
                 }
                 catch(Exception e){
 
                 }
             }
 
             reader.close();
             fileReader.close();
             
             
         } catch (IOException e) {
             // TODO: handle exception
         }

        }


}
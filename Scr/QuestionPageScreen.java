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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuestionPageScreen extends JPanel {
    GridLayout experimentLayout = new GridLayout(4,0);
    private StatusUpdater statusUpdater = new StatusUpdater();
    private JPanel mainPanel = new JPanel();
    private JPanel blackQuestionPanel = new JPanel();
    private JTextField AnsInput = new JTextField(8);
    private JPanel questionOptionPanel = new JPanel();
    private ButtonGroup buttonGroup = new ButtonGroup();
    Question subQuestion;


    String selectedOption;

    


    private ArrayList<String> questionList = new ArrayList<>();
    private int currentIndex;
    private ArrayList<String> holder;
    private int score;
    private String language;





    public int HEIGHT = 800;
    public int WIDTH = 600;

    Question question;

     //Labels
     JLabel QuestionStr  = new JLabel("full live");
     JLabel QuestionStrBack  = new JLabel();

     JButton Submit = new JButton("Submit");
     JLabel Ans1  = new JLabel();
     JLabel Ans2 = new JLabel();
     JLabel Ans3 = new JLabel();
     JLabel Ans4 = new JLabel();
     JButton Skip = new JButton("skip");
     JButton BackB = new JButton("<Back");
     JRadioButton OptionA = new JRadioButton();
     JRadioButton OptionB = new JRadioButton();
     JRadioButton OptionC = new JRadioButton();
     JRadioButton OptionD = new JRadioButton();


    public QuestionPageScreen(String language) {
        this.language = language;

        this.setSize(14, 14);
        questionOptionPanel.setSize(14, 14);


     

        AddCurrentQuestions();

        holder = getFile("CurrentQuestion.txt");
        Collections.shuffle(holder);
        overideCurrentQuestion("CurrentQuestion.txt",  holder);
        question = getQuestion1();

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
        
        OptionA.addActionListener(new OptionAction());
        OptionB.addActionListener(new OptionAction());
        OptionC.addActionListener(new OptionAction());
        OptionD.addActionListener(new OptionAction());
        




/*
        // create a CardLayout for the main panel
        CardLayout cardLayout = new CardLayout();
        MainPanel.setLayout(cardLayout);
        // add the question panels to the main panel
        MainPanel.add(MultiPanel, "multiPanel");
        MainPanel.add(FillBlankPanel, "fillBlankPanel");
        // show the question panel based on the question type
        if (question.getQuestiontype() == "Multi") {
            cardLayout.show(MainPanel, "multiPanel");
        } else {
            cardLayout.show(MainPanel, "fillBlankPanel");
        }*/



       
        if (question.getQuestiontype().equals("Multi"))
        {
            

            
            MultipleChoiceQuestion subQuestion = new MultipleChoiceQuestion(question.getQuestionID());
            QuestionStr.setText(subQuestion.getQuestionString());

            OptionA.setText(subQuestion.getOption1());
            OptionB.setText(subQuestion.getOption2());
            OptionC.setText(subQuestion.getOption3());
            OptionD.setText(subQuestion.getOption4());
            mainPanel.add(MultiPanel);

            //FooterPanel.add(BackB);
            MultiPanel.add(QuestionStr);
            questionOptionPanel.add(OptionA);
            questionOptionPanel.add(Ans1);
            questionOptionPanel.add(OptionB);
            questionOptionPanel.add(Ans2);
            questionOptionPanel.add(OptionC);
            questionOptionPanel.add(Ans3);
            questionOptionPanel.add(OptionD);
            questionOptionPanel.add(Ans4);
            MultiPanel.add(questionOptionPanel);
            //MultiPanel.add(FooterPanel);
            //FooterPanel.add(Skip);
            //FooterPanel.add(Submit);


            


            
            GridLayout experimentLayout1 = new GridLayout(4,1);
            GridLayout experimentLayout11 = new GridLayout(4,1);

            MultiPanel.setLayout(experimentLayout);


        }



        else{
            FillBlankQuestion subQuestion = new FillBlankQuestion(question.getQuestionID());
            
            try {
                QuestionStrBack.setText(subQuestion.getBackString());
            } catch(Exception e){}


            QuestionStr.setText(subQuestion.getFrontString());

            //Screen view for Fill in Blank
            mainPanel.add(FillBlankPanel);
            
           
            FillBlankPanel.add(QuestionStr);
            FillBlankPanel.add(AnsInput);
            FillBlankPanel.add(QuestionStrBack);
    
        
        }


        
        //FooterPanel.add(Skip);
        //FooterPanel.add(Submit);
        //FooterPanel.add(BackB);


        buttonGroup.add(OptionA);
        buttonGroup.add(OptionB);
        buttonGroup.add(OptionC);
        buttonGroup.add(OptionD);






        // make the question panel
        // make the frame visible
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // this.setLayout(null);



        
        //mainPanel.add(FooterPanel);
        mainPanel.setLayout(experimentLayout);

        this.add(mainPanel);



        this.setVisible(true);

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

 
                    if ( !getFile(unwantedDups).contains(line) && !Arrays.asList(statusUpdater.getQuestionID()).contains(getFileQuestionID(line)))
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
            writer = new FileWriter(fileIn, false);
            writer.write("");
            writer.close();
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


            for (String m : list){
                

             
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

    public boolean isCorrect()
    {


        boolean correct = false;
        if (question.getCorrectAnswer().equals(selectedOption))
        {
            correct = true;
        }

        if (question.getCorrectAnswer().equals(AnsInput.getText()))
        {
            correct = true;
        }




        statusUpdater.scoreUpdator(question.getDifficultyLevel(), question.getQuestionID()); 


        return correct;



    }

  /*  private boolean isCorrect(FillBlankQuestion Q)
    {
        boolean correct = false;
        if (question.getCorrectAnswer().equals(AnsInput.getText()))
        {
            correct = true;
        }
        System.out.println("==============blank==question=================");
        return correct;
    }*/



    private class SubmitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Wrong nigga-" + question.getCorrectAnswer());

            if (isCorrect())
            {

                
                System.out.println("correct nigga" );
               


                AddCurrentQuestions();

                holder = getFile("CurrentQuestion.txt");
                Collections.shuffle(holder);
                overideCurrentQuestion("CurrentQuestion.txt",  holder);
                question = getQuestion1();
                getQuestion("Questions.txt", 0, 1, "CurrentQuestion");


                if (question.getQuestiontype().equals("Blank"))
                
                {
                    
                    FillBlankQuestion subQuestion = new FillBlankQuestion(question.getQuestionID());
                    QuestionStr.setText(subQuestion.getFrontString());
                    try {
                        QuestionStrBack.setText(subQuestion.getBackString());
                    } catch(Exception s){}

                } else 
                {
                    
                    MultipleChoiceQuestion subQuestion = new MultipleChoiceQuestion(question.getQuestionID());

                    QuestionStr.setText(subQuestion.getQuestionString());


                    OptionA.setText(subQuestion.getOption1());
                    OptionB.setText(subQuestion.getOption2());
                    OptionC.setText(subQuestion.getOption3());
                    OptionD.setText(subQuestion.getOption4());




                }
           
             



            }

        }

    }


    
    
    
    private class OptionAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            System.out.println("slckvmskcvmxokmvoxm");
            selectedOption = selectedButton.getText();
          

        }

    }/*
    private class OptionBAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class OptionCAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }*/



    private ArrayList getFile(String file)
    {
        ArrayList<String> infile = new ArrayList<String>();
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

    public Question getQuestion1(){
 
         try {
             FileReader fileReader = new FileReader("CurrentQuestion.txt");
             BufferedReader reader = new BufferedReader(fileReader);


 
             String line;
             while ((line = reader.readLine()) != null && question == null) {
                 String[] splitter = line.split("-");
                 try{

                    if (!Arrays.asList(statusUpdater.getQuestionID()).contains(splitter[0]))
                    {
                        question = new Question(splitter[0]);


                    }

 
                    
                 }
                 catch(Exception e){
 
                 }
             } 
            reader.close();
            fileReader.close();
             
             
         } catch (IOException e) {
             // TODO: handle exception
         }
        
        System.out.println(question.getQuestionID());
        return question;

        }

        


}
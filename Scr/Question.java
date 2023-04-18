package Scr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Question {

    public static String IDQuestion;
    private String difficultyLevel;
    private String language;
    private String questionType;
    private String nextID;
    private String questionString;
    private String correctAnswer;

    private ArrayList<String> fileList = new ArrayList<>();
    private ArrayList<String> fileHolder = new ArrayList<>();




  


    public Question (String IDQuestion)
    {
        this.IDQuestion = IDQuestion;
        getQuestion(IDQuestion);

        
        this.IDQuestion = fileList.get(0);
        this.difficultyLevel = fileList.get(1);
        this.language = fileList.get(2);
        this.questionType = fileList.get(3);
        this.questionString = fileList.get(4);
        this.correctAnswer = fileList.get(5);

        



    }

    public void addQuestion(String IDQuestion, String difficultyLevel, String language, String questionType, String questionString, String  correctAnswer){
        try {
            FileWriter writer = new FileWriter("Question.txt", true);
            writer.write(IDQuestion + "-" + IDQuestion);
            writer.write(IDQuestion + "-" + difficultyLevel);
            writer.write(IDQuestion + "-" + language);
            writer.write(IDQuestion + "-" + questionType);
            writer.write(IDQuestion + "-" + questionString);
            writer.write(IDQuestion + "-" + correctAnswer);

            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void getQuestion(String IDQuestion){



       this.IDQuestion = IDQuestion;

        try {
            FileReader fileReader = new FileReader("Qestions.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] spitter = line.split("-");
                try{

                    if (IDQuestion.equals(spitter[0]))
                    {
                        fileList.add(spitter[1]);

                    }else{
                        fileHolder.add(line);
                    }
                }
                catch(Exception e){

                    fileHolder.add(line);
                }
            }

            reader.close();
            fileReader.close();
            
            
        } catch (IOException e) {
            // TODO: handle exception
        }

        


        
    }


    public void removeHelper(){

        getQuestion(IDQuestion);

        try {
            FileWriter writer = new FileWriter("Question.txt", true);
            for (String m : fileHolder){
                writer.write(m);
            }
            writer.close();



        } catch (Exception e) {
            // TODO: handle exception
        }

    }



    public void editQuestion(String IDQuestion, String difficultyLevel, String language, String questionType, String questionString, String answersString, String  correctAnswer)
    {

        removeHelper();
        addQuestion(IDQuestion, difficultyLevel, language, questionType, questionString,  correctAnswer);


    }

    public String getFileQuestionID (String line)
    {

        return line.split("-")[0];
    }




    



  
    public String getQuestionID(){
        return IDQuestion;
    }

    public String getDifficultyLevel(){
        return difficultyLevel;
    }
    public String getLanguage(){
        return language;
    }
    public String getQuestiontype(){
        return questionType;
    }

    public String getQuestionString(){
        return questionString;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public ArrayList<String> getFileList()
    {
        return fileList;

    }


}
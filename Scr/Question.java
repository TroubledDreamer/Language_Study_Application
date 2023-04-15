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



    public Question (String IDQuestion, String difficultyLevel, String language, String questionType)
    {
        this.IDQuestion = IDQuestion;
        this.difficultyLevel = difficultyLevel;
        this.language = language;
        this.questionType = questionType;





    }

    public void addQuestion(String IDQuestion, String difficultyLevel, String language, String questionType, String questioString, String answerString){
        try {
            FileWriter writer = new FileWriter("Question.txt", true);
            writer.write(IDQuestion + "-" + IDQuestion);
            writer.write(IDQuestion + "-" + difficultyLevel);
            writer.write(IDQuestion + "-" + language);
            writer.write(IDQuestion + "-" + questionType);
            writer.write(IDQuestion + "-" + questioString);
            writer.write(IDQuestion + "-" + answerString);

            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void removeQuestion(){



        ArrayList<String> fileHolder = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("Qestions.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] spitter = line.split("-");
                try{

                    if (IDQuestion.equals(spitter[0]))
                    {
    
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

        
        removeHelper(fileHolder);


        
    }


    public void removeHelper(ArrayList<String> FileHolder){

        try {
            FileWriter writer = new FileWriter("Question.txt", true);
            for (String m : FileHolder){
                writer.write(m);
            }


        } catch (Exception e) {
            // TODO: handle exception
        }





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
}
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

    private String[] fileList;
    private ArrayList<String> fileHolder = new ArrayList<>();




  


    public Question (String IDQuestion)
    {
        this.IDQuestion = IDQuestion;
        getQuestion(IDQuestion);

        
        this.IDQuestion = fileList[1];
        this.difficultyLevel = fileList[2];
        this.language = fileList[3];
        this.questionType = fileList[4];
        this.questionString = fileList[5];
        this.correctAnswer = fileList[6];

        



    }

    public void addQuestion(String IDQuestion, String difficultyLevel, String language, String questionType, String questionString,  String  correctAnswer){
        try {
            FileWriter writer = new FileWriter("Question.txt", true);
            writer.write(IDQuestion + "-" + IDQuestion);
            writer.write("-" + difficultyLevel);
            writer.write("-" + language);
            writer.write("-" + questionType);
            writer.write("-" + questionString);
            writer.write("-" + correctAnswer);

            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    public void getQuestion(String IDQuestion)
    {
        
       

        ArrayList<String> FileHolder = new ArrayList<>();

        try {
         
            
            FileReader fileReader = new FileReader("Questions.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {

                String[] spitter = line.split("-");
                

            


            try{ 
                    

                    if (IDQuestion.equals(spitter[0]))
                    {

                        fileList = spitter;
                        System.out.println(spitter[0]);



                    }
                    
                    else{
                        fileHolder.add(line);
                    }
                }

                catch (Exception e){

                }
            }
            
          

                    


     
            reader.close();
            fileReader.close();
            
                
            } catch (IOException e) {
                // TODO: handle exception
            }
            }

    public void mQuestion(String IDQuestion){



       this.IDQuestion = IDQuestion;

        try {

            FileReader fileReader = new FileReader("Questions.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {

                String[] spitter = line.split("-");
            

                System.out.print("quest 44444----------444444410" + spitter);

                try{ 
                    

                    if (IDQuestion.equals(spitter[0]))
                    {

                        fileList = spitter;



                    }
                    
                    else{
                        fileHolder.add(line);
                    }
                }
                catch(Exception e){

                    System.out.print("quest 210");
                    fileHolder.add(line);
                }
                reader.close();
                fileReader.close();
            }

            
            
            
        } catch (IOException e) {
            // TODO: handle exception
            System.out.print("quest 110");
            

            
        }

        


        
    }


    public void removeHelper(){

        mQuestion(IDQuestion);

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
        addQuestion(IDQuestion, difficultyLevel, language, questionType, questionString, correctAnswer);


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
        System.out.print("L================");
        return questionType;
    }

    public String getQuestionString(){
        return questionString;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public String[] getFileList()
    {
        return fileList;

}

	public String getAnswerString2() {
		return null;
	}


}
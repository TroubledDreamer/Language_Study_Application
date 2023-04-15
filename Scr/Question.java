package Scr;

public class Question {

    public static int IDQuestion;
    private int difficultyLevel;
    private String language;
    private String questionType;
    private String nextID;

    public Question (int IDQuestion, int difficultyLevel, String language, String questionType)
    {
        this.IDQuestion = IDQuestion;
        this.difficultyLevel = difficultyLevel;
        this.language = language;
        this.questionType = questionType;





    }
    public int getQuestionID(){
        return IDQuestion;
    }

    public int getDifficultyLevel(){
        return difficultyLevel;
    }
    public String getLanguage(){
        return language;
    }
    public String getQuestiontype(){
        return questionType;
    }
}
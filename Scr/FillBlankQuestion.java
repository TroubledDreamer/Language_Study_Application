package Scr;

public class FillBlankQuestion extends Question {


    public FillBlankQuestion (String IDQuestion, String difficultyLevel, String language, String questionType){
        super(IDQuestion);
        
    }

    @Override
    public String getQuestionString() 
    {
        return super.getQuestionString();

    }

    @Override
    public String getCorrectAnswer()
    {
        return super.getCorrectAnswer();

    }

    public String[] questionSplitter()
    {
        return getQuestionString().split("_");

    }




    
}

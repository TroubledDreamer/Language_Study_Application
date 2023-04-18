package Scr;

public class FillBlankQuestion extends Question {


    public FillBlankQuestion (String IDQuestion, String difficultyLevel, String language, String questionType){
        super(IDQuestion);
        
    }

    public FillBlankQuestion (String IDQestion)
    {

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

    public String frontString ()
    {
        return questionSplitter()[0];
    }

    public String backString ()
    {
        return questionSplitter()[1];
    }




    
}

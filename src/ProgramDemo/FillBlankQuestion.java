package src.ProgramDemo;

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

    public String getFrontString ()
    {
        return questionSplitter()[0];
    }

    public String getBackString ()
    {
        return questionSplitter()[1];
    }




    
}

package Scr;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

    private ArrayList<String> options = new ArrayList<>();

    public MultipleChoiceQuestion  (String IDQuestion, String difficultyLevel, String language, String questionType){
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

    public ArrayList<String> getOptions()
    {
         
        for (String m : super.getFileList().get(2).split(","))
        {
            options.add(m);
        }
        return options;

    }

    


}

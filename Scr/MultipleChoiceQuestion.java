package scr;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private ArrayList<String> options = new ArrayList<>();
    public MultipleChoiceQuestion (String IDQestion)
    {

        super(IDQuestion);
        setOptions(getOptions());
    }

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
         
        String list = super.getFileList()[5].split("/")[1]; 
        for (String m : list.split(","))
        {
            options.add(m);
            System.out.println(m);
        }
        
        return options;

    }

    public void setOptions (ArrayList<String> options)
    {


    
        option1 = options.get(0);
        option2 = options.get(1);
        option3 = options.get(2);
        option4 = options.get(3);

    }

    public String getOption1 () {
        return option1;
    }

    public String getOption2 () {
        return option2;
    }

    public String getOption3 () {
        return option3;
    }

    public String getOption4 () {
        return option4;
    }

    


}

package scr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;


public class StatusUpdater {

    private int inputID;
    private String name;
    private int score;
    private int hrs_Learning;
    private int accuracy;
    private int checkID;
    private String questionID;

    private String[] spitter;
    private String[] fileList;
    private ArrayList<String> fileHolder = new ArrayList<>();

    


    //private ArrayList<String> fileList = new ArrayList<>();

    public StatusUpdater(){
        setID();
        
        coll();


   


        dataAssigner();

    }

    public void coll()
    {

        ArrayList<String> FileHolder = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("Status.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] spitter = line.split("-");
                try{
                if (checkID == Integer.parseInt(spitter[0]))
                {


                    fileList = spitter;
                    


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

    public void dataAssigner ()
    {
        /*
        InputID;
        Name;
        score;
        hrs_Learning;
        accuracy;
         */

       
          
        inputID = Integer.parseInt(fileList[1]);
        name = fileList[2];
        score = Integer.parseInt(fileList[3]);
        hrs_Learning = Integer.parseInt(fileList[4]);
        accuracy = Integer.parseInt(fileList[5]);
        questionID = fileList[6];
        




    }



    public void updater(){

        try {



            FileWriter fileWriter = new FileWriter("Status.txt", false);
            
            for (String m: fileHolder)
            {
                fileWriter.append(m + "\n");

            }
            fileHolder = null;
            fileWriter.close();
            

            FileWriter writer = new FileWriter("Status.txt", true);
            writer.append( inputID + "-" + inputID);
            writer.append("-" + name);
            writer.append("-" + score);
            writer.append("-" + hrs_Learning);
            writer.append("-" + accuracy);
            writer.append("-" + questionID + ",");
            writer.close();


            
            
        } catch (IOException e) {
            // TODO: handle exception
        }


    }

    public void setStatus(int inputID, String name, int score, int hrs_Learning, int accuracy)
    {
        this.inputID = inputID;
        this.score = score;
        this.name = name;
        this.hrs_Learning = hrs_Learning;
        questionID = questionID;
        updater();

    }


    public int getID()
    {
        return inputID;
    }

    public String getName()
    {
        return name;
    }

    public int getScore(){
        return score;
    }

    public int getHrs_Learning()
    {
        return hrs_Learning;
    }

    public int getAccuracy()
    {
        return accuracy;
    }

    
    
    public void setID()
    {


    try {
        BufferedReader user = new BufferedReader(new FileReader("user.txt"));
        checkID = Integer.parseInt(user.readLine());
        user.close();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e){
        e.printStackTrace();
    }
    }


    public void scoreUpdator(String difficulty, String questionID)
    {
        score +=  1 + Integer.parseInt(difficulty);
        this.questionID += questionID;
        updater(); 

    }

    public void addQuestionID(String questionID)
    {
        this.questionID += questionID;
        updater(); 


    }

    public String[] getQuestionID()
    {
        return questionID.split(",");
        
    }

    
    

    

}


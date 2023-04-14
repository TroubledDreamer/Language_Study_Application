package Scr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class StatusUpdater {

    private int inputID;
    private String name;
    private int score;
    private int hrs_Learning;
    private int accuracy;

    private ArrayList<String> fileList = new ArrayList<>();

    public StatusUpdater (){

        try {
            FileReader fileReader = new FileReader("Status.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                fileList.add(line);
            }

            reader.close();
            fileReader.close();
            
            
        } catch (IOException e) {
            // TODO: handle exception
        }


        dataAssigner();

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

        inputID = Integer.parseInt(fileList.get(0));
        name = fileList.get(1);
        score = Integer.parseInt(fileList.get(2));
        hrs_Learning = Integer.parseInt(fileList.get(3));
        accuracy = Integer.parseInt(fileList.get(4));



    }



    public void updater(){

        try {


            FileWriter fileWriter = new FileWriter("Status.txt", false);
            fileWriter.write("");
            fileWriter.close();

            FileWriter writer = new FileWriter("Status.txt", true);
            writer.append("" + inputID + "\n");
            writer.append("" + name + "\n");
            writer.append("" + score + "\n");
            writer.append("" + hrs_Learning + "\n");
            writer.append("" + accuracy + "\n");
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
        this.accuracy = accuracy;
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



    
}

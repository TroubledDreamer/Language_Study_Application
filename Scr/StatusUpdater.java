package Scr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class StatusUpdater {

    private int InputID;
    private int score;
    private String Name;
    private int hrs_Learning;
    private int accuracy;

    public StatusUpdater (){

        try {
            FileReader fileReader = new FileReader("Status.txt");
            
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            fileReader.close();
            
            
        } catch (IOException e) {
            // TODO: handle exception
        }


    }



    public void updater(){

        try {
            FileWriter writer = new FileWriter("Status.txt", true);
            writer.append("\n succ on these");
            writer.close();
            
            
        } catch (IOException e) {
            // TODO: handle exception
        }


    }

    
}

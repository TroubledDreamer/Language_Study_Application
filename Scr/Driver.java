
package scr;

import java.io.FileWriter;
import java.io.IOException;

public class Driver {
    /***
     * 
     * 
     * Work the code the the driver starting the project.
     */


    public static void main(String[] args) {


        Question question = new Question("10116");

        question.getQuestiontype();
        System.out.println( "hhhhh1" +  question.getDifficultyLevel());

        StatusUpdater statusUpdater = new StatusUpdater();

        statusUpdater.setStatus(620157742, "Carl long", 0, 0, 0);

        Login login = new Login();

        LoginScreen loginScreen = new LoginScreen(login.getLoginInfo());

        


    }
    
}

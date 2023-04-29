
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



        QuestionPageScreen sQScreen = new QuestionPageScreen("Spanish");


        Login login = new Login();

        LoginScreen loginScreen = new LoginScreen(login.getLoginInfo());

        


    }
    
}

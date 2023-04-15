package Scr;

import java.io.FileWriter;
import java.io.IOException;

public class Driver {


    public static void main(String[] args) {


     
        StatusUpdater statusUpdater = new StatusUpdater(620157742);

        System.out.println(statusUpdater.getAccuracy());

        statusUpdater.setStatus(620157742, "Carl long" , 0, 41, 0);

        System.out.println(statusUpdater.getAccuracy());
     

        Login login = new Login();

        LoginScreen loginScreen = new LoginScreen(login.getLoginInfo());

        
    }
    
}

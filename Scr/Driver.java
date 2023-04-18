package Scr;

import java.io.FileWriter;
import java.io.IOException;

public class Driver {


    public static void main(String[] args) {


     
       StatusUpdater statusUpdater = new StatusUpdater();


     
        Login login = new Login();

        LoginScreen loginScreen = new LoginScreen(login.getLoginInfo());

        


    }
    
}

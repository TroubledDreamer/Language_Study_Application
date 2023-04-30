
package scr;

public class Driver {
    /***
     * 
     * 
     * Work the code the the driver starting the project.
     */


    public static void main(String[] args) {


        Login login = new Login();

        LoginScreen loginScreen = new LoginScreen(login.getLoginInfo());

        

    }
    
}

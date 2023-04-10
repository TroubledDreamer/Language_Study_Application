package Scr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class LoginScreen extends JFrame{




    HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JLabel userLabel = new JLabel();
    JLabel passwordLabel = new JLabel();
    

    JTextField userText = new JTextField();
    JTextField PasswordText = new JTextField();

    JButton Login = new JButton("Login");
    JButton Reset = new JButton("Reset");




    public LoginScreen (HashMap<String, String> LoginInfo)
    {
        this.LoginInfo = LoginInfo;
        this.setSize(600,600);


            
        userLabel.setBounds(12,12,75,25);
        passwordLabel.setBounds(12,12,75,25);
        userText.setBounds(12,12,75,25);
        PasswordText.setBounds(12,12,75,25);
        Login.setBounds(12,12,75,25);
        Reset.setBounds(12,12,75,25);















        this.add(userLabel);
        this.add(passwordLabel);
        this.add(userText);
        this.add(PasswordText);
        this.add(Login);
        this.add(Reset);


        this.pack();
        this.setVisible(true);


    }


    
}

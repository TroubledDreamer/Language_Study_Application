package Scr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class LoginScreen extends JFrame{




    HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JPanel logiPanel = new JPanel();

    JLabel userLabel = new JLabel("UserName");
    JLabel passwordLabel = new JLabel("Password");
    

    JTextField userText = new JTextField(11);
    JTextField passwordText = new JTextField(11);

    JButton Login = new JButton("Login");
    JButton Reset = new JButton("Reset");




    public LoginScreen (HashMap<String, String> LoginInfo)
    {
        this.LoginInfo = LoginInfo;
        this.setSize(600,600);
        logiPanel.setSize(500,500);


            
        userLabel.setBounds(12,12,75,25);
        passwordLabel.setBounds(12,12,75,25);
        userText.setBounds(12,12,75,25);
        passwordText.setBounds(12,12,75,25);
        Login.setBounds(12,12,75,25);
        Reset.setBounds(12,12,75,25);


        Login.addActionListener(new loginAction());



        userLabel.setFocusable(false);















        logiPanel.add(userLabel);
        logiPanel.add(passwordLabel);
        logiPanel.add(userText);
        logiPanel.add(passwordText);
        logiPanel.add(Login);
        logiPanel.add(Reset);


        this.getContentPane().add(logiPanel);
        this.pack();
        this.setVisible(true);



    }

    public void visibleMethod(boolean b) 
    {
        this.setVisible(b);

    } 


    public void validInfo(String user, String password)
    {
        if (LoginInfo.containsKey(user)){
            if (LoginInfo.get(user).equals(password))
            {
                System.out.println("mim");
                visibleMethod(false);
                ProfileScreen profileScreen = new ProfileScreen();
            }
        }else
        {

            System.out.println("dfdfdf");
        }

    }

    private class loginAction implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            
            validInfo(userText.getText(), passwordText.getText());
            
        }

    
    }






    
}

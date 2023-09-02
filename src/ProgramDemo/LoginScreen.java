package src.ProgramDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame {

    HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JPanel logiPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel passPanel = new JPanel();
    JPanel buttonPanel = new JPanel();


    JLabel userLabel = new JLabel("UserName");
    JLabel passwordLabel = new JLabel("Password");

    //

    JTextField userText = new JTextField(11);
    JTextField passwordText = new JTextField(11);

    JButton Login = new JButton("Login");
    JButton Reset = new JButton("Reset");

    public LoginScreen(HashMap<String, String> LoginInfo) {
        this.LoginInfo = LoginInfo;
        

        this.setSize(800, 800);
        logiPanel.setSize(700, 500);

        userLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        userText.setPreferredSize(new Dimension(20, 30));
        passwordText.setPreferredSize(new Dimension(100, 30));

        userLabel.setFont(new Font( null, Font.PLAIN, 20));
        passwordLabel.setFont(new Font( null, Font.PLAIN, 20));



        //userText.setBackground(Color.white);
        //userText.setForeground(Color.WHITE);


        // TODO: Debug Remove in Production
        userText.setText("Carl long");
        passwordText.setText("12345678");

        Login.addActionListener(new loginAction());

        userPanel.setBackground(Color.decode("#00001a")); 
        passPanel.setBackground(Color.decode("#00001a")); 
        buttonPanel.setBackground(Color.decode("#181818")); 


        userPanel.add(userLabel);
        userPanel.add(userText);
        userPanel.setSize(200, 200);
        logiPanel.add(userPanel);



        passPanel.add(passwordLabel);
        passPanel.add(passwordText);
        logiPanel.add(passPanel);
        buttonPanel.add(Login);
        buttonPanel.add(Reset);
        logiPanel.add(buttonPanel);

       
        BoxLayout boxlayout = new BoxLayout(logiPanel, BoxLayout.Y_AXIS);
    
  
        // to set the box layout
        logiPanel.setLayout(boxlayout);
        logiPanel.setBorder(new EmptyBorder(new Insets(100, 350, 100, 350))); 

        setTitle("Language Study");

        logiPanel.setBackground(Color.decode("#1F1F1F")); 
        
        this.setLocationRelativeTo(null);
        this.add(logiPanel);
        this.pack();
        this.setVisible(true);

    }

    public void visibleMethod(boolean b) {
        this.setVisible(b);

    }

    public void validInfo(String user, String password) {
        System.out.println(password);
        String id = LoginInfo.get(user).split("/")[1];
        String infopassword = LoginInfo.get(user).split("/")[0];

        if (LoginInfo.containsKey(user)) {
            if (infopassword.equals(password)) {
                System.out.println("Login Success");
                visibleMethod(false);

                // create a file and save the user to it
                try {
                    //Files.write(Paths.get("user.txt"), user.getBytes());
                    Files.write(Paths.get("user.txt"), id.getBytes());


                    //loginInfo.put(user, password);
                    Files.write(Paths.get("loginInfo.txt"), LoginInfo.toString().getBytes());

                    System.out.println("User Saved");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("User Not Saved");

                }

                ProfileScreen profileScreen = new ProfileScreen(user, LoginInfo);
            }
        } else {

            System.out.println("Login Failed");
        }

    }

    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            validInfo(userText.getText(), passwordText.getText());

        }

    }

}
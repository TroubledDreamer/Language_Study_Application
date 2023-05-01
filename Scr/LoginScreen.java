package scr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.swing.*;

public class LoginScreen extends JFrame {

    HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JPanel logiPanel = new JPanel(new GridLayout(4,2));

    JLabel userLabel = new JLabel("UserName");
    JLabel passwordLabel = new JLabel("Password");

    //

    JTextField userText = new JTextField(11);
    JTextField passwordText = new JTextField(11);

    JButton Login = new JButton("Login");
    JButton Reset = new JButton("Reset");

    public LoginScreen(HashMap<String, String> LoginInfo) {
        this.LoginInfo = LoginInfo;
        this.setSize(600, 600);
        

        userLabel.setBounds(12, 12, 75, 25);
        passwordLabel.setBounds(12, 12, 75, 25);

        userText.setBounds(12, 12, 75, 25);
        passwordText.setBounds(12, 12, 75, 25);

        // TODO: Debug Remove in Production
        userText.setText("Carl long");
        passwordText.setText("12345678");

        Login.addActionListener(new loginAction());

        userLabel.setFocusable(false);

        logiPanel.setBackground(Color.CYAN);
        logiPanel.add(userLabel);
        logiPanel.add(userText);
        logiPanel.add(passwordLabel);
        logiPanel.add(passwordText);
        logiPanel.add(Login);
        logiPanel.add(Reset);

        setTitle("Language Study");
        this.getContentPane().add(logiPanel);
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
                    // TODO Auto-generated catch block
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
            // TODO Auto-generated method stub

            validInfo(userText.getText(), passwordText.getText());

        }

    }

}
package Scr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;



public class ProfileScreen extends JFrame{


    JLabel name = new JLabel();


    JLabel Spanish  = new JLabel("Spanish");
    JLabel French  = new JLabel("French");
    JLabel Chinese = new JLabel("Chinese");


    JButton Menu = new JButton("Menu");
    JButton Logout = new JButton("Logout");
    JButton Edit = new JButton("Edit");

    JProgressBar SpanishBar = new JProgressBar();
    JProgressBar FrenchBar = new JProgressBar();
    JProgressBar ChineseBar = new JProgressBar();



    JPanel ProfilePanel = new JPanel();


    String Name = new String();
    HashMap<String, String> LoginInfo = new HashMap<String, String>();






    public ProfileScreen (String Name, HashMap<String, String> LoginInfo){

        this.Name = Name;
        this.LoginInfo = LoginInfo;
        name.setText(Name);



        Logout.addActionListener(new logoutAction());
        Menu.addActionListener(new MenuBActionListener());


        ProfilePanel.add(name);
        ProfilePanel.add(Logout);
        ProfilePanel.add(Spanish);
        ProfilePanel.add(SpanishBar);

        ProfilePanel.add(French);
        ProfilePanel.add(FrenchBar);

        ProfilePanel.add(Chinese);
        ProfilePanel.add(ChineseBar);

        ProfilePanel.add(Menu);
        ProfilePanel.add(Edit);



        this.getContentPane().add(ProfilePanel);
        this.pack();
        this.setVisible(true);
    }

    
    public void visibleMethod(boolean b) 
    {
        this.setVisible(b);

    } 



    private class logoutAction implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            LoginScreen loginScreen = new LoginScreen(LoginInfo);
            visibleMethod(false);
        }

    }
    public class MenuBActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
                System.out.println("im in");
                visibleMethod(false);
                MenuScreen menuScreen = new MenuScreen(); 
            }

    }
    

}

package scr;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
public class ProfileScreen extends JFrame{
    JLabel name = new JLabel();
    //Labels
    JLabel Spanish  = new JLabel("Spanish");
    JButton S = new JButton("practice");
    JLabel French  = new JLabel("French");
    JButton F = new JButton("practice");
    JLabel Chinese = new JLabel("Chinese");
    JButton C = new JButton("practice");
    ImageIcon menuPic = new ImageIcon("pic.jpg");
    JLabel label = new JLabel(menuPic);
    
    JButton Menu = new JButton("Menu");
    JButton Logout = new JButton("Logout");
    JButton Edit = new JButton("Edit");
    JProgressBar SpanishBar = new JProgressBar(0,100);
    
    JProgressBar FrenchBar = new JProgressBar(0,100);
    JProgressBar ChineseBar = new JProgressBar(0,100);
    
   
    
    JPanel ProfilePanel = new JPanel(); //new GridLayout(2,2));
   JPanel profilePanel1 = new JPanel(new GridLayout(3,3));
   //JPanel profilePanel1 = new JPanel(new BorderLayout());   
    String Name = new String();
    HashMap<String, String> LoginInfo = new HashMap<String, String>();
    private StatusUpdater statusUpdater = new StatusUpdater();



    public ProfileScreen (String Name, HashMap<String, String> LoginInfo){
        SpanishBar.setValue(statusUpdater.getHrs_Learning());
        FrenchBar.setValue(statusUpdater.getScore());


        this.Name = Name;
        this.LoginInfo = LoginInfo;
        name.setText(Name);
        Logout.addActionListener(new logoutAction());
        Menu.addActionListener(new MenuBActionListener());
        S.addActionListener(new SActionListener());
        F.addActionListener(new FActionListener());
        //C.addActionListener(new);
        Edit.addActionListener(new EditActionListener());
        
        Color customColor = new Color(68, 65, 242);
        Color customColor1 = new Color(117, 115, 145);
        ProfilePanel.setBackground(customColor);
        profilePanel1.setBackground(customColor1);
        ProfilePanel.add(label);
        ProfilePanel.add(name);
        ProfilePanel.add(Logout);
        ProfilePanel.add(profilePanel1);
        
        profilePanel1.add(Spanish);
        profilePanel1.add(S);
        profilePanel1.add(SpanishBar);
        profilePanel1.add(French);
        profilePanel1.add(F);
        profilePanel1.add(FrenchBar);

        //profilePanel1.add(Chinese);
        //profilePanel1.add(C);
        //profilePanel1.add(ChineseBar);


        profilePanel1.add(Edit);
        setSize(800,400);
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
    
    private class FActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            ///edit to create new question screen
            QuestionFrame fQScreen = new QuestionFrame("French",Name ,LoginInfo);
            visibleMethod(false);
        }
    }
    private class SActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            QuestionFrame sQScreen = new QuestionFrame("Spanish",Name ,LoginInfo);
            visibleMethod(false);
        }
    }
    private class EditActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            EditScreen EQScreen = new EditScreen();
            visibleMethod(false);
        }
    }
/* 
    {
	@@ -183,7 +183,7 @@ public void actionPerformed(ActionEvent e) {
        }
    }
*/



}
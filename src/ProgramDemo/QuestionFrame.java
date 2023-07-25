package src.ProgramDemo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuestionFrame extends JFrame{
    JButton submit1 = new JButton("submit");
    JButton back = new JButton("back");
    QuestionPageScreen questionPageScreen;
    String language;

    String Name = new String();
    HashMap<String, String> LoginInfo = new HashMap<String, String>();
    
    public QuestionFrame(String language, String Name, HashMap<String, String> LoginInfo)
    {
        this.language = language;
        this.Name = Name;
        this.LoginInfo = LoginInfo;

        questionPageScreen = new QuestionPageScreen(language);

        newquesiton();


     
        
        submit1.addActionListener(new questionsub());
        back.addActionListener(new backer());
        
        setTitle("Study");
        questionPageScreen.setBackground(Color.decode("#1F1F1F")); 

        
        this.pack();
        this.setVisible(true);



    }

    public void newquesiton()
    {

        
        questionPageScreen.setVisible(false);
        questionPageScreen = new QuestionPageScreen(language);
        JPanel buttonHolder = new JPanel();
        buttonHolder.setBackground(Color.decode("#1F1F1F")); 
        buttonHolder.add(back);
        buttonHolder.add(submit1);
        questionPageScreen.add(buttonHolder);
        submit1.setBounds(300, 250, 100, 20);
        questionPageScreen.setVisible(true);
        this.add(questionPageScreen);

    }




    private class questionsub implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(questionPageScreen.isCorrect()){
                newquesiton();
            }
        }

    }

    private class backer implements ActionListener{

        public void actionPerformed(ActionEvent e){
            visibleMethod(false);

            ProfileScreen profileScreen = new ProfileScreen(Name, LoginInfo);


        }

    }

    public void visibleMethod(boolean b) 
    {
        this.setVisible(b);
    } 

}



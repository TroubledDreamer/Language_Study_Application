package scr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

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
        
        this.pack();
        this.setVisible(true);



    }

    public void newquesiton()
    {

        
        questionPageScreen.setVisible(false);
        questionPageScreen = new QuestionPageScreen(language);
        questionPageScreen.add(back);
        questionPageScreen.add(submit1);
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

            ProfileScreen profileScreen = new ProfileScreen(Name ,LoginInfo);

        }

    }

    public void visibleMethod(boolean b) 
    {
        this.setVisible(b);
    } 

}



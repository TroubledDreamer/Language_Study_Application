package src.ProgramDemo;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuScreen extends JPanel {
    JPanel mPanel = new JPanel();
    //Labels

    private JLabel proile;

    //Buttons


    
    public MenuScreen(){
    JLabel questions = new JLabel("Questions");
    JButton q = new JButton("practice");
    JLabel edit = new JLabel("Edit");
    JButton e = new JButton("enter");
    JButton p = new JButton("enter");

    mPanel.add(questions);
    mPanel.add(q);
    mPanel.add(edit);
    mPanel.add(e);
    mPanel.add(proile);
    mPanel.add(p);

    }
    
}

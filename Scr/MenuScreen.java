package Scr;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuScreen extends JPanel {
    JPanel mPanel = new JPanel();
    //Labels
    private JLabel questions;
    private JLabel edit;
    private JLabel proile;

    //Buttons
    private JButton q;
    private JButton p;
    private JButton e;

    
    public MenuScreen(){
    JLabel questions = new JLabel("Questions");
    JButton q = new JButton("practice");
    JLabel edit = new JLabel("Edit");
    JButton e = new JButton("enter");
    JLabel profile = new JLabel("Profile");
    JButton p = new JButton("enter");

    mPanel.add(questions);
    mPanel.add(q);
    mPanel.add(edit);
    mPanel.add(e);
    mPanel.add(proile);
    mPanel.add(p);

    }
    
}

package Scr;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import org.w3c.dom.events.EventException;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.naming.Context;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditScreen extends JFrame{


    JButton newQButton = new JButton("Create New Question");
    JButton editButton = new JButton("Edit Existing Question");
    JLabel idLabel = new JLabel("Question ID:");
    JTextField idTextField = new JTextField(10);
    JButton deleteButton = new JButton("Delete Question");
    JLabel questionLabel = new JLabel("Question:");
    JTextField questionTextField = new JTextField(20);
    JLabel difficultyLabel = new JLabel("Difficulty:");
    JTextField difficultyTextField = new JTextField(10);
    JLabel languageLabel = new JLabel("Language:");
    JTextField languageTextField = new JTextField(10);
    JLabel answerLabel = new JLabel("Answer:");
    JTextField answerTextField = new JTextField(20);

    
        //protected AbstractButton answerTextField;

        public  EditScreen() {
            JPanel mainPanel = new JPanel();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainPanel.setSize(400, 300);
    
            JPanel mainPanel1 = new JPanel();
            mainPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            mainPanel.add(mainPanel1);
            mainPanel1.add(idLabel);
            mainPanel1.add(idTextField);
            deleteButton.addActionListener(new DelAction());
            mainPanel1.add(deleteButton);
            mainPanel1.add(questionLabel);
            mainPanel1.add(questionTextField);
            mainPanel1.add(difficultyLabel);
            mainPanel1.add(difficultyTextField);
            mainPanel1.add(languageLabel);
            mainPanel1.add(languageTextField);
            mainPanel1.add(answerLabel);
            mainPanel1.add(answerTextField);
            editButton.addActionListener(new EditBAction());
            mainPanel1.add(editButton);
            newQButton.addActionListener(new NewQBAction());
            mainPanel1.add(newQButton);
    
            
            mainPanel1.setVisible(true);
        }
        private class DelAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                // Perform deletion of question using the ID
                // and other validations as needed
                JOptionPane.showMessageDialog(mainPanel, "Question with ID " + id + " deleted successfully.");

            }
        }
        private class NewQBAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
    
            }
        }
        private class EditBAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String question = questionTextField.getText();
                String difficulty = difficultyTextField.getText();
                String language = languageTextField.getText();
                String answer = answerTextField.getText();
                // Perform editing of existing question using the values in the fields
                // and other validations as needed
                JOptionPane.showMessageDialog(mainPanel, "Question with ID " + id + " edited successfully.");

    
            }
        }
        //public static void main(String[] args) {
            //new EditScreen();
        //}
}
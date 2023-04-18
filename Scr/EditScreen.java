package Scr;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditScreen extends JFrame {

    JButton newQButton = new JButton("Create New Question");
    JButton editButton = new JButton("Edit Existing Question");
    JLabel idLabel = new JLabel("Question ID:");
    JTextField idTextField = new JTextField(10);
    JButton deleteButton = new JButton("Delete Question");
    JLabel note = new JLabel("<html>(Please Note: enter question in format for MCQ question-optionA,OptionB,optionC,optionD<br>" +
    "and for fill in Blank question|answer<br>" +
    "To delete an existing question, just enter ID and click delete)</html>");
    JLabel questionLabel = new JLabel("Question:");
    JTextField questionTextField = new JTextField(10);
    JLabel qType = new JLabel("MCQ/Fill in Blank");
    JTextField qTypField = new JTextField(10);
    JLabel difficultyLabel = new JLabel("Difficulty:");
    JTextField difficultyTextField = new JTextField(10);
    JLabel languageLabel = new JLabel("Language:");
    JTextField languageTextField = new JTextField(10);
    JLabel answerLabel = new JLabel("Answer:");
    JTextField answerTextField = new JTextField(10);
    JLabel correctAnswer = new JLabel("CorrectAnswer");
    JTextField cAnswerField = new JTextField(10);


    JPanel mainPanel = new JPanel(); // Move the declaration of mainPanel outside of the constructor

    public EditScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setSize(400, 300);

        JPanel mainPanel1 = new JPanel();
        JPanel footerPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        mainPanel1.setLayout(new GridLayout(10,2));//FlowLayout(FlowLayout.CENTER, 10, 10));
        
        mainPanel.add(headerPanel);
        mainPanel.add(mainPanel1);
        mainPanel.add(footerPanel);
        headerPanel.add(note);
        mainPanel1.add(idLabel);
        mainPanel1.add(idTextField);
        deleteButton.addActionListener(new DelAction());
        mainPanel1.add(qType);
        mainPanel1.add(qTypField);
        mainPanel1.add(questionLabel);
        mainPanel1.add(questionTextField);
        mainPanel1.add(difficultyLabel);
        mainPanel1.add(difficultyTextField);
        mainPanel1.add(languageLabel);
        mainPanel1.add(languageTextField);
        mainPanel1.add(answerLabel);
        mainPanel1.add(answerTextField);
        mainPanel1.add(correctAnswer);
        mainPanel1.add(cAnswerField);
        footerPanel.add(deleteButton);
        editButton.addActionListener(new EditBAction());
        footerPanel.add(editButton);
        newQButton.addActionListener(new NewQBAction());
        footerPanel.add(newQButton);

        this.add(mainPanel); // Add mainPanel to the JFrame
        this.setSize(700, 500);
        this.setVisible(true);
    }


    private class DelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idTextField.getText();
            // Perform deletion of question using the ID
            // and other validations as needed
            JOptionPane.showMessageDialog(null, "Question with ID " + id + " deleted successfully.");
    
        }
    }
    

    private class NewQBAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement action for creating new question
            String IDQuestion = idTextField.getText();
            String questionString = questionTextField.getText();
            String difficultyLevel = difficultyTextField.getText();
            String language = languageTextField.getText();
            String answer = answerTextField.getText();
            String correctAnswer = cAnswerField.getText();
            String questionType = qTypField.getText();
            addQuestion(IDQuestion, difficultyLevel, language, questionType, questionString, correctAnswer);
            JOptionPane.showMessageDialog(null, "Question with ID " + IDQuestion + " edded successfully.");
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
            JOptionPane.showMessageDialog(null, "Question with ID " + id + " edited successfully.");
    }
    }
}
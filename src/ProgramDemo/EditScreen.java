package src.ProgramDemo;


import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.event.ActionListener;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/***
 * Allows the editting of pages
 */
public class EditScreen extends JFrame {

    /***
     * 
     * 
     * 
     * 
     */
  

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
    JLabel qType = new JLabel("Multi(MCQ)/Fill in Blank");
    JTextField qTypField = new JTextField(10);
    JLabel difficultyLabel = new JLabel("Difficulty:");
    JTextField difficultyTextField = new JTextField(10);
    JLabel languageLabel = new JLabel("Language:");
    JTextField languageTextField = new JTextField(10);
    JLabel answerLabel = new JLabel("Options:");
    JTextField answerTextField = new JTextField(10);
    JLabel correctAnswer = new JLabel("CorrectAnswer");
    JTextField cAnswerField = new JTextField(10);


    JPanel mainPanel = new JPanel(); // Move the declaration of mainPanel outside of the constructor

    public EditScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setSize(400, 300);

        questionLabel.setForeground(Color.WHITE);
        difficultyLabel.setForeground(Color.WHITE);
        languageLabel.setForeground(Color.WHITE);
        answerLabel.setForeground(Color.WHITE);
        correctAnswer.setForeground(Color.WHITE);
        idLabel.setForeground(Color.WHITE);
        note.setForeground(Color.WHITE);
        


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
        BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    
  
        // to set the box layout
        mainPanel.setLayout(boxlayout);
        headerPanel.setBackground(Color.decode("#000080")); 
        mainPanel1.setBackground(Color.decode("#1F1F1F")); 
        footerPanel.setBackground(Color.decode("#000080")); 
        this.setSize(700, 500);
        this.setVisible(true);
    }


    private class DelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idTextField.getText();
            Question question = new Question(id);
            question.removeHelper();
            // Perform deletion of question using the ID
            // and other validations as needed
    
        }
    }
    

    private class NewQBAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement action for creating new question
            String id = idTextField.getText();
            Question question = new Question();
            System.out.println("dfdfdf");
            String questiosn = questionTextField.getText();

            if (qTypField.getText().equals("Multi")){
                questiosn = questionTextField.getText() + "/" + answerTextField.getText();
            } 

            String difficulty = difficultyTextField.getText();
            String language = languageTextField.getText();

            question.addQuestion(id, difficulty, language, qTypField.getText(), questiosn, cAnswerField.getText());
            JOptionPane.showMessageDialog(null, "Question with ID " + id + " edded successfully.");
        }
    }

    private class EditBAction implements ActionListener {

        @Override
 
        public void actionPerformed(ActionEvent e) {
            String id = idTextField.getText();
            Question question = new Question(id);
            System.out.println("dfdfdf");
            String questiosn = questionTextField.getText();

            if (qTypField.getText().equals("Multi")){
                questiosn = questionTextField.getText() + "/" + answerTextField.getText();
            } 

            String difficulty = difficultyTextField.getText();
            String language = languageTextField.getText();


            question.editQuestion(id, difficulty, language, qTypField.getText(), questiosn, cAnswerField.getText());
            JOptionPane.showMessageDialog(null, "Question with ID " + id + " edited successfully.");
    }
    }
}
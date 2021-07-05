import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
This is a simple program that allows a user to type into a text field, and upon clicking a button, the text from the
text field is placed into a text area for saving the history of inputs and then a popup window is opened with the
title of the window being set as what the user put into the text field.
 */

public class Murdock_BonusGUI extends JFrame implements ActionListener {

    //These are used in the first frame
    private JTextField textField;
    private JTextArea textArea;
    private JButton button;

    //This is used in the pop up frame
    private JLabel label;

    //This stores what the user input into the textfield
    private String userInput;

    Murdock_BonusGUI(){
        //instantiating the components
        textField = new JTextField();
        textArea = new JTextArea();
        button = new JButton("Click Me");

        //Since the user is inputting into the textfield, i disabled the textarea
        textArea.setEditable(false);

        //making the button do something
        button.addActionListener(this);

        //Laying out the first frame
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        //Frame specifics
        setTitle("Bonus");
        setLocationRelativeTo(null);
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        userInput = textField.getText(); //Saving user input to variable
        textArea.append(userInput + "\n"); //Appending user input to textarea for history
        label = new JLabel("This is the " + userInput + " window."); //Just an added label for the popup
        JFrame popup = new JFrame(); //Creating a popup window
        popup.add(label);
        popup.setTitle(userInput); //Setting frame title equal to previous user input
        popup.setSize(300, 200);
        popup.setVisible(true);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

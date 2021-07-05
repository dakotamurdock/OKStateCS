import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
For the tic tac toe game I basically have a separate java class for each window/frame of the game. Main calls the start
frame, from the start frame the user picks to play as x or o which launches the main game frame and that class has all
the code to play the game and determine if it is over. If it is over, it launches the end game frame which asks the
user if they want to play again or quit. If they play again it creates a new start game frame.
 */

public class Murdock_TicTacToeStart extends JFrame implements ActionListener {

    private JButton b1;
    private JButton b2;
    private JLabel l1;
    public static char userSelection;

    public Murdock_TicTacToeStart() {
        JPanel p1 = new JPanel();

        //Setting up panels to arrange buttons and label to ask user if they want to be x or o
        p1.setLayout(new GridLayout(1, 2));
        b1 = new JButton("x");
        b2 = new JButton("o");
        l1 = new JLabel("Which would you like to play as?");

        //Make buttons do something
        b1.addActionListener(this);
        b2.addActionListener(this);

        //Adding buttons to panel 1 -- their own panel, separate from label
        p1.add(b1);
        p1.add(b2);

        //Making second panel and adding buttons and label
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(l1, BorderLayout.WEST);
        p2.add(p1, BorderLayout.EAST);

        //Adding second panel (buttons and label) to the frame
        add(p2, BorderLayout.CENTER);

        //Frame specifics
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setSize(400,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        //Action for button 1 which is user playing as x
        if (e.getSource() == b1){
            userSelection = 'x';
            Murdock_TicTacToeFrame frame2 = new Murdock_TicTacToeFrame(); //Launching tictactoe board frame
            dispose(); //Closing the frame asking x or o
        }
        //Action for button 2 which is user playing as o
        else if(e.getSource() == b2){
            userSelection = 'o';
            Murdock_TicTacToeFrame frame2 = new Murdock_TicTacToeFrame(); //Launching tictactoe board frame
            dispose();//Closing the frame asking x or o
        }
    }

    public static void main (String[] args){
        Murdock_TicTacToeStart frame = new Murdock_TicTacToeStart(); //Starting game
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Murdock_TicTacToeEndGame extends JFrame implements ActionListener {

    private JButton b1;
    private JButton b2;
    private JLabel l1;

    Murdock_TicTacToeEndGame() {
        //Creates the end game menu frame

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        b1 = new JButton("Play Again");
        b2 = new JButton("Quit");
        l1 = new JLabel(Murdock_TicTacToeFrame.winner + " won! Would you like to play again?");

        //Make the buttons do something
        b1.addActionListener(this);
        b2.addActionListener(this);

        //Adding buttons to panel
        p1.add(b1);
        p1.add(b2);

        //Laying out buttons and label in the same fashion as the start game frame
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(l1, BorderLayout.WEST);
        p2.add(p1, BorderLayout.EAST);

        add(p2, BorderLayout.CENTER);

        //Frame specifics
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setSize(500,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        //button 1 action if user wants to play again
        if (e.getSource() == b1){
            Murdock_TicTacToeFrame.winner = " ";
            Murdock_TicTacToeStart frame = new Murdock_TicTacToeStart(); //launches new start game frame
            dispose(); //close the end game menu frame
        }
        //button 2 action if user wants to quit the game
        else if(e.getSource() == b2){
            System.exit(0);
        }
    }

}

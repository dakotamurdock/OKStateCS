import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Murdock_TicTacToeFrame extends JFrame implements ActionListener{

    public char userSelection = Murdock_TicTacToeStart.userSelection; //Carrying over user selection from previous frame
    public char computerChar; //variable for the computers symbol 'x' or 'o'

    //winner used to tell program which symbol the winner was. Made a string instead of char for the case of a scratch
    public static String winner = " ";

    //These buttons will be the basis of the game board
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    //Storing the values (i.e. 'x' or 'o') in a 3x3 array for later use in checking if someone wins
    char board[][] = new char[3][3];

    Murdock_TicTacToeFrame() {

        //This is the frame that holds the game board

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 3));

        //Setting up board with buttons arranged 3x3
        b1 = new JButton("-");
        b2 = new JButton("-");
        b3 = new JButton("-");
        b4 = new JButton("-");
        b5 = new JButton("-");
        b6 = new JButton("-");
        b7 = new JButton("-");
        b8 = new JButton("-");
        b9 = new JButton("-");

        //Adding buttons to panel
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);

        //Making buttons do something
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        //Adding panel to frame
        add(p1, BorderLayout.CENTER);

        //Frame specifics
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Determine who goes first
        if(userSelection == 'o'){
            computerChar = 'x';
            computerMove();
        }
        else{
            computerChar = 'o';
        }
    }

    public void actionPerformed(ActionEvent e){
        /*
        The following routine is given to each button if clicked:

        Sets button text to user symbol,
        fills the corresponding array position with user char for scoring,
        disables the button since that space is no longer in play,
        checks to see if that move gave the user the win,
        and then tells the computer to make a move.
        */

        if (e.getSource() == b1) {
            b1.setText(Character.toString(userSelection));
            board[0][0] = userSelection;
            b1.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b2) {
            b2.setText(Character.toString(userSelection));
            board[0][1] = userSelection;
            b2.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b3) {
            b3.setText(Character.toString(userSelection));
            board[0][2] = userSelection;
            b3.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b4) {
            b4.setText(Character.toString(userSelection));
            board[1][0] = userSelection;
            b4.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b5) {
            b5.setText(Character.toString(userSelection));
            board[1][1] = userSelection;
            b5.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b6) {
            b6.setText(Character.toString(userSelection));
            board[1][2] = userSelection;
            b6.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b7) {
            b7.setText(Character.toString(userSelection));
            board[2][0] = userSelection;
            b7.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b8) {
            b8.setText(Character.toString(userSelection));
            board[2][1] = userSelection;
            b8.setEnabled(false);
            checkScore();
            computerMove();
        }
        if (e.getSource() == b9) {
            b9.setText(Character.toString(userSelection));
            board[2][2] = userSelection;
            b9.setEnabled(false);
            checkScore();
            computerMove();
        }
    }

    public void computerMove(){
        /*
        This is how the computer makes a move.

        First, we check if the user has already won. If not, it executes.

        It is not an artificial intelligence course, so the computer moves
        are pretty basic. Just find an open spot (based on array contents), and play there. There is an order to the
        moves. Not random. Take the center if available, then the corners, then the sides.

        Once the computer takes an open position, the button for that position takes the computer's symbol and the
        button becomes disabled.
        */

        if(winner.charAt(0) != userSelection) {
            if(board[1][1] == 0){
                board[1][1] = computerChar;
                b5.setText(Character.toString(computerChar));
                b5.setEnabled(false);
            }
            else if(board[0][0] == 0){
                board[0][0] = computerChar;
                b1.setText(Character.toString(computerChar));
                b1.setEnabled(false);
            }
            else if(board[0][2] == 0){
                board[0][2] = computerChar;
                b3.setText(Character.toString(computerChar));
                b3.setEnabled(false);
            }
            else if(board[2][0] == 0){
                board[2][0] = computerChar;
                b7.setText(Character.toString(computerChar));
                b7.setEnabled(false);
            }
            else if(board[2][2] == 0){
                board[2][2] = computerChar;
                b9.setText(Character.toString(computerChar));
                b9.setEnabled(false);
            }
            else if(board[0][1] == 0){
                board[0][1] = computerChar;
                b2.setText(Character.toString(computerChar));
                b2.setEnabled(false);
            }
            else if(board[1][0] == 0){
                board[1][0] = computerChar;
                b4.setText(Character.toString(computerChar));
                b4.setEnabled(false);
            }
            else if(board[1][2] == 0){
                board[1][2] = computerChar;
                b6.setText(Character.toString(computerChar));
                b6.setEnabled(false);
            }
            else if(board[2][1] == 0){
                board[2][1] = computerChar;
                b8.setText(Character.toString(computerChar));
                b8.setEnabled(false);
            }

            //Check to see if the computer move won the game
            checkScore();
        }
    }

    public void checkScore(){
        /*
        There are 8 combinations to win, each one is checked individually here.
        If one of the symbols won, the endGame method is called and the winning symbol is passed to it.
         */

        //Top row check
        if(board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x'){
            endGame("x");
        }
        else if(board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o'){
            endGame("o");
        }

        //Middle row check
        if(board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x'){
            endGame("x");
        }
        else if(board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o'){
            endGame("o");
        }

        //Bottom row check
        if(board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x'){
            endGame("x");
        }
        else if(board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o'){
            endGame("o");
        }

        //First column check
        if(board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x'){
            endGame("x");
        }
        else if(board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o'){
            endGame("o");
        }

        //Middle column check
        if(board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x'){
            endGame("x");
        }
        else if(board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o'){
            endGame("o");
        }

        //Last column check
        if(board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x'){
            endGame("x");
        }
        else if(board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o') {
            endGame("o");
        }

        //LR diagonal check
        if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x'){
            endGame("x");
        }
        else if(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o'){
            endGame("o");
        }

        //RL diagonal check
        if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x'){
            endGame("x");
        }
        else if(board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o'){
            endGame("o");
        }

        //Added these variables/loops/ifs below to check for a scratch
        int countPlayedSpaces = 0;

        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                if(board[i][j] != 0){
                    ++countPlayedSpaces;
                }
            }
        }

        if(countPlayedSpaces == 9){
            endGame("Nobody"); //scratch
        }
    }

    public void endGame(String x){
        //Method just launches the end game frame and closes the game board frame.

        winner = x; //Used in EndGame frame to announce who the winner is
        Murdock_TicTacToeEndGame frame = new Murdock_TicTacToeEndGame(); //launch frame announcing winner & ask to play again
        dispose(); //close frame
    }
}

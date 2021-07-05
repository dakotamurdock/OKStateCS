import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
I created a calculator by creating a GUI class extending JFrame and using action listener for user button clicks.
The calculator interface uses a series of panels to organize buttons and a screen. Action listeners determine what
button was clicked and contain the code to perform the necessary calculations. The calculator can handle up to 100
subsequent operations thanks to storing numbers and operators in arrays.
 */

public class Murdock_CalculatorGUI extends JFrame implements ActionListener {

    //These are all of the buttons on the calculator
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton decimal;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JButton clear;
    private JButton allClear;
    private JButton equals;

    //This is the "screen" of the calculator showing inputs and outputs
    private JTextField screen;

    //These are variables used to store various inputs, outputs, and calculations
    private String userInput = "";
    private String output;
    private Double prevUserInputNum;
    private int inputCount = 0;
    private Double calcValue = 0.0d;

    //These arrays store the history for handling more complicated calculations than a single operator
    private char operations[] = new char[100];
    private Double userInputsDoubles[] = new Double[100];

    Murdock_CalculatorGUI(){
        //Creating panels used to arrange components on the frame
        JPanel numbers = new JPanel();
        JPanel operators = new JPanel();
        JPanel screenPanel = new JPanel();
        JPanel buttons = new JPanel();
        JPanel p1 = new JPanel();

        //Using a specific font to have a bigger and bolder screen text
        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        //instantiating the buttons
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        decimal = new JButton(".");
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("x");
        divide = new JButton("/");
        clear = new JButton("C");
        allClear = new JButton("AC");
        equals = new JButton("=");

        //Calculator screen specifics
        screen = new JTextField(18);
        screen.setFont(font1);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEnabled(false);

        //Adding the screen to the screen panel
        screenPanel.add(screen);
        screenPanel.setPreferredSize(new Dimension(400, 100));

        //Adding the number buttons to the numbers panel and adding action listeners for them
        numbers.setLayout(new GridLayout(4, 3));
        numbers.add(seven);
        seven.addActionListener(this);
        numbers.add(eight);
        eight.addActionListener(this);
        numbers.add(nine);
        nine.addActionListener(this);
        numbers.add(four);
        four.addActionListener(this);
        numbers.add(five);
        five.addActionListener(this);
        numbers.add(six);
        six.addActionListener(this);
        numbers.add(one);
        one.addActionListener(this);
        numbers.add(two);
        two.addActionListener(this);
        numbers.add(three);
        three.addActionListener(this);
        numbers.add(zero);
        zero.addActionListener(this);
        numbers.add(decimal);
        decimal.addActionListener(this);
        numbers.add(clear);
        clear.addActionListener(this);
        numbers.setPreferredSize(new Dimension(300,400));

        //Adding the operator buttons to the operators panel and adding action listeners for them
        operators.setLayout(new GridLayout(5, 1));
        operators.add(divide);
        divide.addActionListener(this);
        operators.add(multiply);
        multiply.addActionListener(this);
        operators.add(subtract);
        subtract.addActionListener(this);
        operators.add(add);
        add.addActionListener(this);
        operators.add(equals);
        equals.addActionListener(this);
        operators.setPreferredSize(new Dimension(100, 500));

        //The all clear button gets set up here
        allClear.addActionListener(this);
        allClear.setPreferredSize(new Dimension(400, 100));

        //Putting numbers, operators, and all clear button into one panel
        buttons.add(numbers, BorderLayout.CENTER);
        buttons.add(operators, BorderLayout.EAST);
        buttons.add(allClear, BorderLayout.SOUTH);

        //Adding buttons and screen to final panel
        p1.setLayout(new BorderLayout(0, 0));
        p1.add(screenPanel, BorderLayout.NORTH);
        p1.add(buttons, BorderLayout.CENTER);

        //Adding final panel to the frame
        add(p1);

        //Frame specifics
        setTitle("Calculator");
        setLocationRelativeTo(null);
        setSize(450,750);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){

        //I use if statements to determine what button was clicked and have actions set forth for each button

        if (e.getSource() == one){
            //Input will be taken as a string and continuously concatenated with new inputs and screen will be updated
            userInput = userInput.concat("1");
            screen.setText(userInput);
            clear.setEnabled(true); //Needed to handle errors that developed with equals button
        }
        else if (e.getSource() == two){
            userInput = userInput.concat("2");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == three){
            userInput = userInput.concat("3");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == four){
            userInput = userInput.concat("4");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == five){
            userInput = userInput.concat("5");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == six){
            userInput = userInput.concat("6");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == seven){
            userInput = userInput.concat("7");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == eight){
            userInput = userInput.concat("8");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == nine){
            userInput = userInput.concat("9");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == zero){
            userInput = userInput.concat("0");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == decimal){
            userInput = userInput.concat(".");
            screen.setText(userInput);
            clear.setEnabled(true);
        }
        else if (e.getSource() == divide){
            //if-else handles if user's previous click was another operator instead of a number input (changes operator)
            if(userInput.equals("")){
                operations[inputCount - 1] = '/'; //Changes last operator to new one
                --inputCount; //Backs up the inputCount position for arrays
            }
            else{
                prevUserInputNum = Double.parseDouble(userInput); //Take string input and turn into a double number
                userInputsDoubles[inputCount] = prevUserInputNum; //Store previous number typed before the operator
                operations[inputCount] = '/'; //Store what operator was clicked
            }
            userInput = ""; //Clear the user input string to make ready for next user input
            ++inputCount; //Used for a loop in the equals button action
            clear.setEnabled(true);
        }
        else if (e.getSource() == multiply){
            if(userInput.equals("")){
                operations[inputCount - 1] = 'x';
                --inputCount;
            }
            else{
                prevUserInputNum = Double.parseDouble(userInput);
                userInputsDoubles[inputCount] = prevUserInputNum;
                operations[inputCount] = 'x';
            }
            userInput = "";
            ++inputCount;
            clear.setEnabled(true);
        }
        else if (e.getSource() == add){
            if(userInput.equals("")){
                operations[inputCount - 1] = '+';
                --inputCount;
            }
            else{
                prevUserInputNum = Double.parseDouble(userInput);
                userInputsDoubles[inputCount] = prevUserInputNum;
                operations[inputCount] = '+';
            }
            userInput = "";
            ++inputCount;
            clear.setEnabled(true);
        }
        else if (e.getSource() == subtract){
            if(userInput.equals("")){
                operations[inputCount - 1] = '-';
                --inputCount;
            }
            else{
                prevUserInputNum = Double.parseDouble(userInput);
                userInputsDoubles[inputCount] = prevUserInputNum;
                operations[inputCount] = '-';
            }
            userInput = "";
            ++inputCount;
            clear.setEnabled(true);
        }
        else if (e.getSource() == clear){
            userInput = ""; //Just clears the current user input string
            screen.setText(userInput);
        }
        else if (e.getSource() == allClear){
            //Next two lines just repeat what the regular clear button does
            userInput = "";
            screen.setText(userInput);

            //The following loops clear out all of the memory of previous number and operator inputs
            for(int i = 0; i < 20; ++i){
                userInputsDoubles[i] = null;
            }
            for(int j = 0; j < 20; ++j){
                operations[j] = (char)0;
            }

            //Disable basic clear button to avoid errors
            clear.setEnabled(false);
        }
        else if (e.getSource() == equals){
            //Collect last number entered before equals sign
            prevUserInputNum = Double.parseDouble(userInput);
            userInputsDoubles[inputCount] = prevUserInputNum;

            /*
            Loop to go through each item in operator history and the numbers on either side of it to perform the
            correct operation with the correct numbers. Each additional calc stores the most up to date total in
            calcValue
             */
            for(int i = 0; i < inputCount; ++i){
                if(operations[i] == 43) {
                    calcValue = userInputsDoubles[i] + userInputsDoubles[i + 1];
                    userInputsDoubles[i + 1] = calcValue;
                }
                else if(operations[i] == 45) {
                    calcValue = userInputsDoubles[i] - userInputsDoubles[i + 1];
                    userInputsDoubles[i + 1] = calcValue;
                }
                else if(operations[i] == 47) {
                    calcValue = userInputsDoubles[i] / userInputsDoubles[i + 1];
                    userInputsDoubles[i + 1] = calcValue;
                }
                else if(operations[i] == 120) {
                    calcValue = userInputsDoubles[i] * userInputsDoubles[i + 1];
                    userInputsDoubles[i + 1] = calcValue;
                }
            }

            //Clear out history
            for(int i = 0; i < 20; ++i){
                userInputsDoubles[i] = null;
            }
            for(int j = 0; j < 20; ++j){
                operations[j] = (char)0;
            }

            //Put the latest total calculation value into the first position of the array for further calculations
            userInput = Double.toString(calcValue);
            output = Double.toString(calcValue);

            //Output results to screen
            screen.setText(output);

            //Disable basic clear button to avoid errors
            clear.setEnabled(false);

        }

    }

}

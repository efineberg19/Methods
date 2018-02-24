import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*; //needed for ImageIcon, JFrame, JPanel, JLabel, etc.
import javax.swing.ImageIcon;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.Timer;
/**
 *  Class GUI
 *  Creates a graphical user interface skeleton for running methods
 *  
 * @author Beth Fineberg
 * @version 2.0
 */
public class GUI extends JFrame implements ActionListener
{
    int selectedMethod = 0;

    String[] methodNames;           //to be used in combobox for selections
    MyMethods methods = new MyMethods();
    JComboBox<String> methodSelector;  //pull down menu to select method

    //images for JOptionPanes
    ImageIcon factorIcon = new ImageIcon(GUI.class.getResource("bye.gif"));  
    ImageIcon factorIcon2 = new ImageIcon(GUI.class.getResource("babygif.gif"));
    
    //Panels are set up to hold other things and can be placed within the MasterPanel
    JPanel masterPanel;         //panel for all components of the display
    JPanel topPanel;            //this panel holds the buttonPanel and instructionsPanel
    JPanel buttonPanel;         //panel for the submit and quit buttons 
    JPanel instructionsPanel;   //panel for JLabel with instructions to user
    JPanel ioPanel;             //panel to hold both input and report output
    JPanel reportPanel;         //panel for JLabel for reporting on the text analysis

    JButton quitButton, submitButton, colorButton, partyButton, clearButton;
    JLabel instructions;        //label for instructions to user
    JTextArea report;           //area to show all results of analysis
    JTextField entry1, entry2, entry3, entry4, entry5, entry6, entry7;  //3 user input entry fields
    JScrollPane outputScroll;
   
    
    Font font = new Font("Comic Sans MS", Font.BOLD, 12);
    Timer timer;
    Timer exit;
    boolean partyOn;
    
    /**
     * GUI constructor
     */
    public GUI(String title)
    {
        masterPanel = (JPanel) this.getContentPane();  //master panel IS the whole window
        masterPanel.setLayout(new BorderLayout());
        /*
         * SET UP BUTTON PANEL:
         */
        //SUBMIT button: user clicks when ready to analyze text
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setActionCommand("submitButton"); 
        submitButton.setFont(font);

        //quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quitButton");
        quitButton.setFont(font);
        
        //color button
        colorButton = new JButton("Color");
        colorButton.addActionListener(this);
        colorButton.setActionCommand("colorButton");
        colorButton.setFont(font);
        
        //party button - allows colors to randomly flash
        partyButton = new JButton("Party");
        partyButton.addActionListener(this);
        partyButton.setActionCommand("partyButton");
        partyButton.setFont(font);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)));
                
        //creating timer
        timer = new Timer(25, this);
        timer.addActionListener(this);
        timer.setActionCommand("timer");
        timer.start();
       
        //clear button - erases user input and turns party mode off
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("clearButton");
        clearButton.setFont(font);

        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * TO ADD NEW METHODS, PUT THEIR NAMES IN methodsLst below:
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */
        //create methods selector pull-down menu    
        String[] methodsList ={"Home", "Four Sum to One", "In Order to Equal", 
            "Should Answer Cell", "Full Web", "String Number Sum", "Can Move",
            "Formula", "Get Ticket", "Get Ticket (Accurate)", "Elemental Family",
            "Three Points Info"};  //list of names of methods to show to user
        
        
        methodSelector = new JComboBox<String>(methodsList);  //create the pull-down menu object
        methodSelector.setSelectedIndex(0);                 //sets which one is selected by default
        methodSelector.addActionListener(this);             //this means we can react when a different one is selected
        methodSelector.setActionCommand("methodSelector");  //the command we reacdt to
        methodSelector.setFont(font);
        
        /*
         * SET UP ALL OTHER PANELS
         */
        //iINSTRUCTIONS PANEL
        instructionsPanel = new JPanel();
        instructionsPanel.setBackground(new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)));
        instructions = new JLabel("Use the drop down menu to pick a game to play. The"
            + " clear button will turn off Party Mode.");
        instructions.setFont(font);
            
        //set font and color
        instructions.setForeground(Color.blue);
        instructions.setFont(font); 
        instructionsPanel.add(instructions);   //put the JLabel into the panel

        //top panel holds buttons and instructions
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,2));
        topPanel.add(buttonPanel);
        topPanel.add(instructionsPanel);

        //Here's where some instructions are and where report will be shown
        report = new JTextArea("Welcome! Use the drop down menu to pick a game to play.", 50 , 30);  //30,30 is size of text area in chars
        report.setForeground(Color.red);
        Font font2 = new Font("Comic Sans MS", Font.BOLD, 18);
        report.setFont(font2);
        report.setEditable(false);
        report.setLineWrap(true);
        report.setWrapStyleWord(true);
        //add the report to a scroll pane, so if it gets big, it will scroll:
        outputScroll = new JScrollPane(report);
        //add the scroll pane to the overall panel:
        reportPanel = new JPanel();
        reportPanel.add(outputScroll);

        /*
         * SET UP TEXTFields FOR USER INPUT:
         */
        entry1 = new JTextField("", 15);  //15 is the number of characters width
        entry2 = new JTextField("", 5);
        entry3 = new JTextField("", 5);
        entry4 = new JTextField("", 5);
        entry5 = new JTextField("", 5);
        entry6 = new JTextField("", 5);
        entry7 = new JTextField("", 5);
        
        //makes all entries in Comic Sans
        entry1.setFont(font);
        entry2.setFont(font);
        entry3.setFont(font);
        entry4.setFont(font);
        entry5.setFont(font);
        entry6.setFont(font);
        entry7.setFont(font);

        //add the menu and three buttons to the button panel:
        buttonPanel.add(methodSelector);  //menu pull-down menu
        buttonPanel.add(submitButton);  
        buttonPanel.add(quitButton);
        buttonPanel.add(colorButton);
        buttonPanel.add(partyButton);
        buttonPanel.add(clearButton);
        //make a panel to add entry boxes and report to:
        ioPanel = new JPanel();
        ioPanel.add(entry1);
        ioPanel.add(entry2);
        ioPanel.add(entry3);
        ioPanel.add(entry4);
        ioPanel.add(entry5);
        ioPanel.add(entry6);
        ioPanel.add(entry7);
        ioPanel.add(reportPanel);
        ioPanel.setBackground(Color.BLACK);
        /*
         * Put the two panels into the master panel, i.e. the whole window:
         */
        masterPanel.add(topPanel, BorderLayout.NORTH);
        masterPanel.add(ioPanel, BorderLayout.CENTER);

        /* 
         * Wrap-up: set title and size of window and set to be visible in the JFrame
         */
        this.setTitle(title);     
        this.setSize(860, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Actionperformed: when a button is pressed, this is automatically called:
     */
    public void actionPerformed (ActionEvent e)
    {
        if(e.getActionCommand() == "methodSelector")
        {
            selectedMethod = methodSelector.getSelectedIndex();  //set the course number
            
            switch(selectedMethod)
            {
                /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 * TO ADD NEW METHODS, WRITE INSTRUCTIONS HERE:
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 */
                case 0: //home screen
                {
                    report.setText("Welcome! Use the drop down menu to pick a game to play.");
                    
                    entry1.setText("");
                }
                break;
                
                case 1:  //method1: Four Sum to One
                {
                    report.setText("Welcome to Four Sum to One!\n\nPlease enter 5 integers in" + 
                        " the first five boxes and I will tell you if one is equal to the sum" +
                        " of the rest of the numbers");
                        
                    entry1.setText("Enter your integers:");
                }
                break;
                
                case 2:  //method2: In Order to Equal
                {
                    report.setText("Welcome to Four Sum to One!\n\nPlease enter three integers"
                        + " and, \"yes\" or \"no\" in the boxes above. I will tell you if the numbers are in"
                        + " increasing order. If you enter \"yes\" in the third box I will" 
                        + "allow for equality.");
                    
                    entry1.setText("Enter your responses:");
                }
                break;
                
                case 3: //method3: Should Answer Cell
                {
                    report.setText("Welcome to Should Answer Cellphone. Please answer the following"
                        + " questions with a yes or no in the respective boxes above. \n\n 1) Is it morning?" +
                        "\n\n 2) Is it your mom? \n\n 3) Are you asleep?");
                    
                    entry1.setText("Enter your responses:");
                }
                break;
                
                case 4: //method4: Full Web
                {
                    report.setText("Welcome to Full URL. Please enter the URL of a website" +
                        " in the first box and I will make sure that it is complete.");
                    
                    entry1.setText("Enter the URL:");
                }
                break;
                
                case 5: //method5: String Number Sum
                {
                    report.setText("Welcome to String Number Sum. Please input" +
                        " a string with numbers in the first box. I will add" +
                        " up those numbers and display the sum.");
                    
                    entry1.setText("Enter string:");
                }
                break;
                
                case 6: //method6: Can Move
                {
                    report.setText("Welcome to Can Move. Please answer the" +
                        " following questions in their respective box to figure " 
                        + "out if your character can move. \n\nAre they" +
                        " blocked in the North? (yes/no) \n\nAre they "
                        + "blocked in the South? (yes/no) \n\nAre they"
                        + " blocked in the East? (yes/no) \n\nAre they"
                        + " blocked in the West? (yes/no) \n\nWhat is"
                        + " their power level? (integer) \n\nWhat direction"
                        + " are they moving in? (N, S, E, or W)");
                        
                    entry1.setText("Enter your responses:");
                }
                break;
                
                case 7: //method7: Formula
                {
                    report.setText("Welcom to Formula! Enter three integers"
                        + " into the boxes above. \n\nIf the first two integers"
                        + " are equal, I will double the sum of them. If "
                        + "the third integer is divisible by the first, I"
                        + " will multiply all three integers together. Otherwise, "
                        + "I will multiply the first number by 99, subtract "
                        + "10 times the second number, then add the third number.");
                    
                    entry1.setText("Enter 3 integers:");
                }
                break;
                
                case 8: //method8: Get Ticket
                {
                    report.setText("Welcome to Get Ticket. Depending upon "
                        + "your speed, I will give you a ticket based upon "
                        + "that value. \n\nPlease input your speed in the first "
                        + "box above. Then, enter \"yes\" or \"no\" if it is "
                        + "your birthday.");
                        
                    entry1.setText("Enter your speed:");
                }
                break;
                
                case 9: //method9: Get Ticket (Accurate)
                {
                    report.setText("Welcome to the accurate version of Get Ticket." 
                        + " This uses the actual laws of the RMV to find how much your " 
                        + "ticket will be (birthday doesn't matter). \n\nIn the first box "
                        + "enter your speed. \n\nIn the next box, enter the type of"
                        + " zone that you are in. Here are the options: School Zone, "
                        + "Bussiness, Undivided Highway, or Divided Highway.");
                    
                    entry1.setText("Enter your responses:");
                }
                break;
                
                case 10: //method10: Elemental Family
                {
                    report.setText("Welcome to Elemental Family. Please input the "
                        + "atomic number of an element in the first box. I will then"
                        + " tell you which family that element belongs to.");
                        
                    entry1.setText("Enter atomic number:");
                }
                break;
                
                case 11: //method11: Three Points Info
                {
                    report.setText("Welcome to Three Points Info. Enter the folowing "
                        + "vaues in the respective boxes. I will tell you the area of "
                        + "the triangle or greatest line segment formed by these points."
                        + "\n\n1) First x value \n\n2) First y value \n\n3) Second x value " 
                        + "\n\n4) Second y value \n\n5)Third x vale \n\n6) Third y value");
                        
                    entry1.setText("Enter your values:");
                }
                break;
                
                default:
                break;
            }
        }
        //SUBMIT BUTTON CLICKED:

        else if(e.getActionCommand().equals("submitButton"))
        {
            //GET ALL ANSWERS FROM USER: GETTEXT() CAN ONLY RETURN STRINGS, SO CONVERT LATER:
            String arg1 = entry2.getText();
            String arg2 = entry3.getText();
            String arg3 = entry4.getText();
            String arg4 = entry5.getText();
            String arg5 = entry6.getText();
            String arg6 = entry7.getText();

            String resultString; //use this for return values that are Strings
            int resultInt;       //use this for return values that are integers
            boolean resultBool;  //use this for return values that are booleans
            double resultDouble;

            switch(selectedMethod)
            {
                /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 * TO ADD NEW METHODS, CALL THE METHOD HERE, GET THE RESULTS, AND SET THE TEXT OF THE REPORT
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 */
                
                case 1:  //method1: fourSumToOne
                {
                    resultBool = methods.fourSumToOne(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3), Integer.parseInt(arg4), Integer.parseInt(arg5));
                    //set the display to show/explain the results
                    if (resultBool)
                    {
                        report.setText("One integer is equivalent to the sum of the rest");
                    }
                    else
                    {
                        report.setText("None of your integers are equivalent to the sum of the rest");
                    }
                }
                break;
                
                case 2: //method2: In Order To Equal
                {
                    boolean answer;
                    
                    if (arg4.toLowerCase().equals("yes"))
                    {
                       answer = true;
                    }
                    else
                    {
                        answer = false;
                    }
                    
                    resultBool = methods.inOrderToEqual(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3), answer);
                    
                    if (resultBool)
                    {
                        report.setText("Your integers are in increasing order");
                    }
                    else
                    {
                        report.setText("Your integers are not in increasing order");
                    }
                }
                break;
                
                case 3: //method3: Should Answer Cell
                {
                    boolean answer1;
                    boolean answer2;
                    boolean answer3;
                    
                    if (arg1.toLowerCase().equals("yes"))
                    {
                       answer1 = true;
                    }
                    else
                    {
                        answer1 = false;
                    }
                    
                    if (arg2.toLowerCase().equals("yes"))
                    {
                       answer2 = true;
                    }
                    else
                    {
                        answer2 = false;
                    }
                    
                    if (arg3.toLowerCase().equals("yes"))
                    {
                       answer3 = true;
                    }
                    else
                    {
                        answer3 = false;
                    }
                    
                    resultBool = methods.shouldAnswerCell(answer1, answer2, answer3);
                    
                    if(resultBool)
                    {
                        report.setText("You should answer your phone");
                    }
                    else
                    {
                        report.setText("You do not need to answer your phone");
                    }
                }
                break;
                
                //method4: Full Web
                case 4:
                {
                    resultString = methods.fullWeb(arg1);
                    
                    report.setText(resultString);
                }
                break;
                
                //method5: String Number Sum
                case 5:
                {
                    resultInt = methods.stringNumberSum(arg1);
                    
                    report.setText("The sum of the integers in: " + arg1 + " is: "
                        + resultInt);
                }
                break;
                
                //method6: Can Move
                case 6:
                {
                    boolean answer1, answer2, answer3, answer4;
                    
                    if (arg1.toLowerCase().equals("yes"))
                    {
                       answer1 = true;
                    }
                    else
                    {
                        answer1 = false;
                    }
                    
                    if (arg2.toLowerCase().equals("yes"))
                    {
                       answer2 = true;
                    }
                    else
                    {
                        answer2 = false;
                    }
                    
                    if (arg3.toLowerCase().equals("yes"))
                    {
                       answer3 = true;
                    }
                    else
                    {
                        answer3 = false;
                    }
                    
                    if (arg4.toLowerCase().equals("yes"))
                    {
                       answer4 = true;
                    }
                    else
                    {
                        answer4 = false;
                    }
                    
                    resultBool = methods.canMove(answer1, answer2, answer3, answer4, Integer.parseInt(arg5),
                        arg6.charAt(0));
                        
                    if (resultBool)
                    {
                        report.setText("Your character can move.");
                    }
                    else
                    {
                        report.setText("Your character can't move.");
                    }
                }
                break;
                
                //method7: Formula
                case 7:
                {
                    resultInt = methods.formula(Integer.parseInt(arg1), 
                        Integer.parseInt(arg2), Integer.parseInt(arg3));
                        
                    report.setText("The outcome of the fomula is: " + resultInt);
                }
                break;
                
                //method8: Get Ticket
                case 8:
                {
                    boolean answer;
                    
                    if (arg2.toLowerCase().equals("yes"))
                    {
                       answer = true;
                    }
                    else
                    {
                        answer = false;
                    }
                    
                    resultInt = methods.getTicket(Integer.parseInt(arg1), answer);
                    
                    report.setText("Your ticket will be for: $" + resultInt);
                }
                break;
                
                //method9: Get Ticket (Accurate)
                case 9:
                {
                    resultInt = methods.getTicketAccurate(Integer.parseInt(arg1), arg2);
                    
                    report.setText("Your ticket will be for: $" + resultInt);
                }
                break;
                
                //method10: Elemental Family
                case 10:
                {
                    resultString = methods.elementalFamily(Integer.parseInt(arg1));
                    
                    report.setText("The element is a(n): " + resultString);
                }
                break;
                
                //method11: Three Points Info
                case 11:
                {
                    resultDouble = methods.threePtsInfo(Integer.parseInt(arg1),
                        Integer.parseInt(arg2), Integer.parseInt(arg3),
                        Integer.parseInt(arg4), Integer.parseInt(arg5),
                        Integer.parseInt(arg6));
                    
                    report.setText("Your value is: " + resultDouble);
                }
                break;
                
                default:
                break;
            }
        }
        //QUIT BUTTON CLICKED:
        else if(e.getActionCommand().equals("quitButton")) 
        {
            JOptionPane.showMessageDialog(null,null, null,
                JOptionPane.PLAIN_MESSAGE, factorIcon2);
                
            JOptionPane.showMessageDialog(null,"Bye", "Bye",
                JOptionPane.PLAIN_MESSAGE, factorIcon);    
              
            System.exit(0);
        }
        else if(e.getActionCommand().equals("colorButton"))
        {
            buttonPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)).brighter());
            instructionsPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)).brighter());
            ioPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)).brighter());
        }
        //Party button clicked:
        else if(e.getActionCommand().equals("partyButton"))
        {
            partyOn = true;
        }
        else if(e.getActionCommand().equals("clearButton"))
        {
            entry2.setText("");
            entry3.setText("");
            entry4.setText("");
            entry5.setText("");
            entry6.setText("");
            
            partyOn = false;
        }
        //Causes color changes when party button clicked
        else if(e.getActionCommand().equals("timer"))
        {
            if (partyOn)
            {
                buttonPanel.setBackground(new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)).brighter());
                        
                instructionsPanel.setBackground(new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)).brighter());
                        
                ioPanel.setBackground(new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)).brighter());
                        
                report.setForeground(new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)).brighter());
                        
                instructions.setForeground(new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)).brighter());
            }
        }
        //YOU COULD ALSO MAKE A "CLEAR" BUTTON.  WHEN CLICKED, IT WOULD CLEAR THE REPORT AND/OR ENTERED TEXT
        //  LOOK EVERYWHERE THERE WAS A SUBMIT BUTTON, COPY AND PASTE TO DO THE SAME WITH A CLEAR BUTTON
    }
}


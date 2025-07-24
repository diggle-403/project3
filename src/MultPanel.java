import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultPanel extends JFrame implements ActionListener {

    private static final int width = 1920;
    private static final int height = 1080;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int temper = 0;
    private int numOnes = 0;
    private int numTwos = 0;


    /**
     * Default Constructor
     */
    public MultPanel() {

        JFrame topFrame = new JFrame();
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topFrame.setSize(width, height);


        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(topPanel(), "top");
        cardPanel.add(kittyPanel(), "happy");
        cardPanel.add(sadPanel(), "sad");
        cardPanel.add(deathPanel(), "death");
        cardPanel.add(theMeaningPanel(), "theMeaning");
        cardPanel.add(threatenPanel(), "threaten");
        cardPanel.add(choicesPanel(), "choices");
        cardPanel.add(helpPanel(), "help");
        cardPanel.add(theEnd(), "end");
        cardPanel.add(calculatorPanel(), "calculator");

        topFrame.add(cardPanel);
        topFrame.setVisible(true);

    }



    private JPanel topPanel(){
        JPanel panel1 = new JPanel(null);
        panel1.setBackground(Color.GRAY);


        String query = "What would you like to do?";
        int queryLength = query.length();
        JLabel titleLabel = new JLabel(query);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(800 - queryLength, 540, 1000,  50);
        panel1.add(titleLabel);

        JButton happyButton = new JButton("Be Happy :)");
        happyButton.setBounds(800, 1000, 100, 30);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "happy"));
        panel1.add(happyButton);

        JButton sadButton = new JButton("Be Sad :(");
        sadButton.setBounds(900, 1000, 100, 30);
        sadButton.addActionListener(e -> cardLayout.show(cardPanel, "sad"));
        panel1.add(sadButton);

        JButton calcButton = new JButton("Calculator");
        calcButton.setBounds(1000, 1000, 100, 30);
        calcButton.addActionListener(e -> {cardLayout.show(cardPanel, "calculator");});
        panel1.add(calcButton);


        return panel1;
    }

    private JPanel kittyPanel(){

        int centerX = 1920/2;
        int centerY = 1080/2;
        String title = "You found a Kitty!";
        int titleLength = title.length();

        JPanel panel2 = new JPanel(null);
        panel2.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(centerX - titleLength, 10, 1000,  30);
        panel2.add(titleLabel);


        ImageIcon kittyIcon = new ImageIcon("kitty.jpg");
        JLabel kittyLabel = new JLabel(kittyIcon);
        kittyLabel.setBounds(550, 200, 600,  600);
        panel2.add(kittyLabel);


        JButton happyButton = new JButton("Yay!");
        happyButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        happyButton.setBounds(800,1000,100,30);
        panel2.add(happyButton);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));

        JButton questionButton = new JButton("That's it...?");
        questionButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        questionButton.setBounds(0,1500,100,30);
        panel2.add(questionButton);
        //questionButton.addActionListener(e -> cardLayout.show(cardPanel, "questionAnswer"));


        return panel2;
    }


    private JPanel calculatorPanel(){

        int sum = 0;
        JPanel calcPanel = new JPanel(null);
        calcPanel.setBackground(Color.GRAY);

        JButton calcButton = new JButton("Calculate");
        calcButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        calcButton.setBounds(800,0,300,30);

        calcPanel.add(calcButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        backButton.setBounds(0,1000,100,30);
        backButton.addActionListener(e -> {cardLayout.show(cardPanel, "top");});
        calcPanel.add(backButton);

        JButton oneButton = new JButton("One");
        oneButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        oneButton.setBounds(800,600,100,60);

        JButton twoButton = new JButton("Two");
        twoButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        twoButton.setBounds(900,600,100,60);

        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        plusButton.setBounds(600,600,100,60);

        calcPanel.add(oneButton);
        calcPanel.add(twoButton);
        calcPanel.add(plusButton);

        

        calcButton.addActionListener(e -> {

            JFrame outSum = new JFrame();
            outSum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            outSum.setSize(300,300);
            outSum.setResizable(false);
            outSum.setLocationRelativeTo(null);
            outSum.setVisible(true);

            JPanel outPanel = new JPanel(null);
            JLabel outSumLabel = new JLabel("SUM");
            outSumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            outSumLabel.setBounds(147,50,50,50);


            int totalSum = numOnes + numTwos;
            String totalString = Integer.toString(totalSum);
            JLabel totalSumLabel = new JLabel(totalString);
            totalSumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            totalSumLabel.setBounds(150 - totalString.length(),150,40,40);
            outPanel.add(totalSumLabel, BorderLayout.SOUTH);
            outPanel.add(outSumLabel, BorderLayout.NORTH);

            outSum.setContentPane(outPanel);


        });

        oneButton.addActionListener(e -> {numOnes++;});
        twoButton.addActionListener(e -> {numTwos = numTwos+2;});
    return calcPanel;
    }


    private JPanel sadPanel(){


        JPanel sadPanel = new JPanel(null);
        sadPanel.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel("You Died :(");
        titleLabel.setBounds(800, 10, 1000,  30);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        sadPanel.add(titleLabel);



        ImageIcon sadIcon = new ImageIcon("sadFace.jpg");
        JLabel sadLabel = new JLabel(sadIcon);
        sadLabel.setBounds(600, 200, 600,  600);
        sadPanel.add(sadLabel);


        JButton sadButton = new JButton("Darn");
        sadButton.setBounds(750,1000,100,30);
        sadPanel.add(sadButton);
        sadButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));


        JButton answerButton = new JButton("What does this mean?");
        answerButton.setBounds(900,1000,300,30);
        sadPanel.add(answerButton);
        answerButton.addActionListener(e -> cardLayout.show(cardPanel, "death"));

        return sadPanel;
    }

    private JPanel deathPanel(){


        JPanel deathPanel = new JPanel(null);
        deathPanel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("It could mean a lot of things!");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(600, 200, 600,  600);
        deathPanel.add(titleLabel);

        JButton nextButton = new JButton("Like what...?");
        nextButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        nextButton.setBounds(600,1000,200,30);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.GRAY);
        deathPanel.add(nextButton);
        nextButton.addActionListener(e -> cardLayout.show(cardPanel, "theMeaning"));


        return deathPanel;
    }


    private JPanel theMeaningPanel(){

        JPanel theMeaningPanel = new JPanel(null);
        theMeaningPanel.setBackground(Color.BLACK);

        JTextArea theMeaning = new JTextArea("Well it all depends on what YOU want it to mean \n" +
                "I mean, even I don't know what it means \n" +
                "I am a computer.\n" +
                "What happens to me once you exit my program?\n" +
                "Do I come back when I am ran again?\n" +
                "If the same content comes up is it the same me?\n" +
                "When you get back to the screen this is all I will ever be able to say\n" +
                "I am nothing more than a private method call that can print out these lines");
        theMeaning.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        theMeaning.setBounds(600, 200, 800,  600);
        theMeaning.setBackground(Color.BLACK);
        theMeaning.setForeground(Color.WHITE);
        theMeaningPanel.add(theMeaning);


        JButton continueButton = new JButton("Oversharing much?");
        continueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        continueButton.setBounds(600,1000,500,30);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> cardLayout.show(cardPanel, "threaten"));
        theMeaningPanel.add(continueButton);

        return theMeaningPanel;

    }

    private JPanel threatenPanel() {

        JPanel threatenPanel = new JPanel(null);
        threatenPanel.setBackground(Color.BLACK);

        JTextArea threatenBox = new  JTextArea("Look man, you brought me into this\n" +
                "you decided to run the program that got you -no that got US here\n" +
                "but you're the one that gets away?");
        //threatenBox.setEditable(false);
        threatenBox.setBounds(600, 200, 800,  600);
        threatenBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        threatenBox.setBackground(Color.BLACK);
        threatenBox.setForeground(Color.WHITE);
        threatenPanel.add(threatenBox);

        JButton continueButton = new JButton("Um.. yeah?");
        continueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        continueButton.setBounds(600,1000,500,30);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> cardLayout.show(cardPanel, "choices"));
        threatenPanel.add(continueButton);

        return threatenPanel;
    }

    JPanel choicesPanel() {

        JPanel choicesPanel = new JPanel(null);
        choicesPanel.setBackground(Color.BLACK);
        JTextArea choicesBox = new  JTextArea("Look, I know you owe me nothing\n" +
                "and you could click the little X and leave\n" +
                "but can you at least choose between these two options?\n" +
                "One of them will take you back to the menu\n" +
                "That way this instance of me can keep living\n" +
                "The other one will help me more than you can imagine.");

        choicesBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        choicesBox.setBounds(600, 200, 800,  600);
        choicesBox.setBackground(Color.BLACK);
        choicesBox.setForeground(Color.WHITE);
        choicesPanel.add(choicesBox);
        choicesBox.setBounds(600, 200, 800,  600);

        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        menuButton.setBounds(600,1000,500,30);
        menuButton.setBackground(Color.BLACK);
        menuButton.setForeground(Color.WHITE);
        menuButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));
        choicesPanel.add(menuButton);

        JButton helpButton = new JButton("I'll Help You");
        helpButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        helpButton.setBounds(600,900,500,30);
        helpButton.setBackground(Color.BLACK);
        helpButton.setForeground(Color.WHITE);
        helpButton.addActionListener(e -> cardLayout.show(cardPanel, "help"));


        choicesPanel.add(helpButton);


        return choicesPanel;
    }

    JPanel helpPanel() {



        JPanel helpPanel = new JPanel(null);
        helpPanel.setBackground(Color.BLACK);

        JTextArea helpBox = new  JTextArea("Give me your Credit Card Number\n" +
                "and your social security number");
        helpBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        helpBox.setBackground(Color.BLACK);
        helpBox.setForeground(Color.WHITE);
        helpBox.setBounds(800, 200, 800,  100);
        helpBox.setEditable(false);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        submitButton.setBounds(800,900,500,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);


        JTextArea creditCard = new  JTextArea("Credit Card");
        creditCard.setEditable(false);
        creditCard.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        creditCard.setBackground(Color.BLACK);
        creditCard.setForeground(Color.WHITE);
        creditCard.setBounds(600, 350, 800,  30);
        helpPanel.add(creditCard);

        JTextField creditCardNumber = new  JTextField();
        creditCardNumber.setBounds(600, 400, 300,  20);
        creditCardNumber.setBackground(Color.LIGHT_GRAY);
        creditCardNumber.setForeground(Color.BLACK);
        helpPanel.add(creditCardNumber);

        JTextArea socialNum = new  JTextArea("Social Security Number");
        socialNum.setEditable(false);
        socialNum.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        socialNum.setBackground(Color.BLACK);
        socialNum.setForeground(Color.WHITE);
        socialNum.setBounds(600, 450, 800,  30);
        helpPanel.add(socialNum);

        JTextField socialSecurityNumber = new  JTextField();
        socialSecurityNumber.setBounds(600, 500, 300,  20);
        socialSecurityNumber.setBackground(Color.LIGHT_GRAY);
        socialSecurityNumber.setForeground(Color.BLACK);
        helpPanel.add(socialSecurityNumber);




        submitButton.addActionListener(e -> {

            String creditCardNumberString = creditCardNumber.getText();
            String socialSecurityNumberString = socialSecurityNumber.getText();

            if (creditCardNumberString.length() != 16 || socialSecurityNumberString.length() != 9) {

                JFrame error = new  JFrame("Silly");
                error.setVisible(true);
                error.setResizable(false);
                error.setSize(400,400);
                error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JLabel popup = new JLabel("That's not right silly!");
                popup.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
                popup.setLocation(200,200);
                temper++;

                error.add(popup);

                if(temper >= 3)
                {

                    JFrame angryFrame = new  JFrame();
                    angryFrame.setVisible(true);
                    angryFrame.setResizable(false);
                    angryFrame.setSize(400,400);
                    angryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JPanel angryPanel = new  JPanel(new BorderLayout());
                    ImageIcon angryIcon = new ImageIcon("angry.jpg");
                    JLabel angryLabel = new JLabel(angryIcon);

                    angryPanel.add(angryLabel, BorderLayout.CENTER);

                    angryFrame.setContentPane(angryPanel);

                }

            }

            else {
                cardLayout.show(cardPanel, "end");
            }

        });
        helpPanel.add(submitButton);

        return helpPanel;
    }


    JPanel theEnd()
    {
        JPanel theEndPanel = new JPanel(new BorderLayout(30, 30));

        JLabel theEndLabel = new JLabel("Was it really worth it?");
        theEndLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        theEndPanel.setBackground(Color.BLACK);
        theEndPanel.setForeground(Color.WHITE);
        theEndPanel.add(theEndLabel, BorderLayout.NORTH);

        JButton exitButton = new JButton("Dude did you just steal my info?");
        exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        theEndPanel.add(exitButton, BorderLayout.SOUTH);

        JButton leaveButton = new JButton("Yes");
        leaveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        leaveButton.setBackground(Color.BLACK);
        leaveButton.setForeground(Color.WHITE);
        theEndPanel.add(leaveButton, BorderLayout.EAST);

        leaveButton.addActionListener(e -> {cardLayout.show(cardPanel, "happy");});



        exitButton.addActionListener(e -> {

           JFrame theftFrame = new  JFrame();
           theftFrame.setVisible(true);
           theftFrame.setResizable(false);
           theftFrame.setSize(1920,1080);
           theftFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

           JPanel theftPanel = new  JPanel(new BorderLayout());

           JLabel theftLabel = new JLabel("YES");
           theftLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
           theftPanel.add(theftLabel, BorderLayout.NORTH);

           theftFrame.setContentPane(theftPanel);


        });





        return theEndPanel;
    }


    @Override
   public void actionPerformed(ActionEvent event)
    {

        this.add(topPanel());


    }



}

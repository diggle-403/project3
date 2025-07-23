import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultPanel extends JFrame implements ActionListener {

    private static final int width = 1920;
    private static final int height = 1080;
    private CardLayout cardLayout;
    private JPanel cardPanel;


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
        topFrame.add(cardPanel);
        topFrame.setVisible(true);

    }



    private JPanel topPanel(){
        JPanel panel1 = new JPanel(null);
        panel1.setBackground(Color.GRAY);

        JLabel titleLabel = new JLabel("What would you like to do?");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(800, 540, 1000,  20);
        panel1.add(titleLabel);

        JButton happyButton = new JButton("Be Happy :)");
        happyButton.setBounds(0, 1000, 100, 30);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "happy"));
        panel1.add(happyButton);

        JButton sadButton = new JButton("Be Sad :(");
        sadButton.setBounds(150, 1000, 100, 30);
        sadButton.addActionListener(e -> cardLayout.show(cardPanel, "sad"));
        panel1.add(sadButton);


        return panel1;
    }

    private JPanel kittyPanel(){

        int centerX = 1920/2;
        int centerY = 1080/2;

        JPanel panel2 = new JPanel(null);
        panel2.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel("You Found a Kitty!");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setBounds(centerX, 10, 1000,  20);
        panel2.add(titleLabel);


        ImageIcon kittyIcon = new ImageIcon("kitty.jpg");
        JLabel kittyLabel = new JLabel(kittyIcon);
        kittyLabel.setBounds(600, 200, 600,  600);
        panel2.add(kittyLabel);


        JButton happyButton = new JButton("Yay!");
        happyButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        happyButton.setBounds(0,1000,100,30);
        panel2.add(happyButton);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));

        JButton questionButton = new JButton("That's it...?");
        questionButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        questionButton.setBounds(0,1500,100,30);
        panel2.add(questionButton);
        //questionButton.addActionListener(e -> cardLayout.show(cardPanel, "questionAnswer"));


        return panel2;
    }




    private JPanel sadPanel(){


        JPanel sadPanel = new JPanel(null);
        sadPanel.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel("You Died :(");
        titleLabel.setBounds(960, 10, 1000,  20);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        sadPanel.add(titleLabel);



        ImageIcon sadIcon = new ImageIcon("sadFace.jpg");
        JLabel sadLabel = new JLabel(sadIcon);
        sadLabel.setBounds(600, 200, 600,  600);
        sadPanel.add(sadLabel);


        JButton sadButton = new JButton("Darn");
        sadButton.setBounds(0,1000,100,30);
        sadPanel.add(sadButton);
        sadButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));


        JButton answerButton = new JButton("What does this mean?");
        answerButton.setBounds(500,1000,300,30);
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
        nextButton.addActionListener(e -> cardLayout.show(cardPanel, "happy"));


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
                "I am nothing more than a private method call that can print out these lines of text");
        theMeaning.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        theMeaning.setBounds(600, 200, 600,  600);
        theMeaningPanel.add(theMeaning);




        return theMeaningPanel;

    }

    @Override
   public void actionPerformed(ActionEvent event)
    {

        this.add(topPanel());


    }



}

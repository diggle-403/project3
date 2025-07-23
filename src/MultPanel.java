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

        cardPanel.add(panel1(), "top");
        cardPanel.add(panel2(), "happy");
        cardPanel.add(panel3(), "sad");
        topFrame.add(cardPanel);
        topFrame.setVisible(true);

    }



    private JPanel panel1(){
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

    private JPanel panel2(){


        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel("You Found a Kitty!");
        panel2.add(titleLabel,  BorderLayout.NORTH);

        ImageIcon kittyIcon = new ImageIcon("kitty.jpg");
        JLabel kittyLabel = new JLabel(kittyIcon,  JLabel.CENTER);
        panel2.add(kittyLabel,  BorderLayout.CENTER);
        JButton happyButton = new JButton("Yay!");
        panel2.add(happyButton,  BorderLayout.SOUTH);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));
        return panel2;
    }




    private JPanel panel3(){


        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.GRAY);
        JLabel titleLabel = new JLabel("You Died :(");
        panel3.add(titleLabel,  BorderLayout.NORTH);

        ImageIcon kittyIcon = new ImageIcon("kitty.jpg");
        JLabel kittyLabel = new JLabel(kittyIcon,  JLabel.CENTER);
        panel3.add(kittyLabel,  BorderLayout.CENTER);
        JButton happyButton = new JButton("Darn");
        panel3.add(happyButton,  BorderLayout.SOUTH);
        happyButton.addActionListener(e -> cardLayout.show(cardPanel, "top"));
        return panel3;
    }


    @Override
   public void actionPerformed(ActionEvent event)
    {

        this.add(panel1());


    }



}
